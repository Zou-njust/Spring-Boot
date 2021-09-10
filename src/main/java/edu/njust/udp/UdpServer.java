package edu.njust.udp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.Filter;
import org.springframework.integration.annotation.Router;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.ip.dsl.Udp;
import org.springframework.integration.ip.udp.UnicastReceivingChannelAdapter;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;

import java.util.Map;

public class UdpServer {

    @Bean
    public UnicastReceivingChannelAdapter getUnicastReceivingChannelAdapter() {
        UnicastReceivingChannelAdapter adapter = new UnicastReceivingChannelAdapter(8081);//实例化一个udp 8081端口
        adapter.setOutputChannelName("udp");
        System.out.println(adapter);
        return adapter;
    }

    @Transformer(inputChannel="udp",outputChannel="udpString")
    public String transformer(Message<?> message) {
        //把接收的数据转化为字符串
        String s = new String((byte[])message.getPayload());
        System.out.println(s);
        return s;
    }

    @Filter(inputChannel="udpString",outputChannel="udpFilter")
    public boolean filter(String message) {
        return message.startsWith("#");//如果接收数据开头不是#直接过滤掉
    }

    @Router(inputChannel="udpFilter")
    public String routing(String message) {
        if(message.contains("1")) {//当接收数据包含数字1时
            return "udpRoute1";
        }
        else {
            return "udpRoute2";
        }
    }

    @ServiceActivator(inputChannel="udpRoute1")
    public void udpMessageHandle(String message) {
        System.out.println("udp1:" +message);
    }

    @ServiceActivator(inputChannel="udpRoute2")
    public void udpMessageHandle2(String message) {
        System.out.println("udp2:" +message);
    }
}
