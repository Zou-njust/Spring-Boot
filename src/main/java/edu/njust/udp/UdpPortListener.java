package edu.njust.udp;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.concurrent.ConcurrentHashMap;

@WebListener
public class UdpPortListener implements ServletContextListener {

    //限制最大数据量
    public static final int MAX_UDP_DATA_SIZE = 4096;
    //监听端口8081
    public static final int UDP_PORT = 8081;
    //接收的数据报
    public DatagramPacket dgPacket = null;
    //连接的套接字
    public DatagramSocket dgSocket = null;

    //初始化服务
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            System.out.println("======= 启动一个线程，监听UDP数据报PORT: " + UDP_PORT + " ======");
            // 启动一个线程，监听UDP数据报
            new Thread(new UDPProcess(UDP_PORT)).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    class UDPProcess implements Runnable {
        public UDPProcess(final int port) throws SocketException {
            // 创建服务器端DatagramSocket，指定端口
            dgSocket = new DatagramSocket(port);
        }
        @Override
        public void run() {
            System.out.println("======= 创建数据报，用于接收客户端发送的数据 ======");
            while (true) {
                byte[] buffer = new byte[MAX_UDP_DATA_SIZE];
                dgPacket = new DatagramPacket(buffer, buffer.length);
                try {
                    System.out.println("======= 此方法在接收到数据报之前会一直阻塞 ======");
                    dgSocket.receive(dgPacket);
                    new Thread(new Process(dgPacket)).start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class Process implements Runnable {
        public Process(DatagramPacket packet) throws UnsupportedEncodingException {
            System.out.println("======= 接收到的UDP信息 ======");
            byte[] buffer = packet.getData();// 接收到的UDP信息，然后解码GBK、UTF-8、ISO-8859-1
            String srt = new String(buffer, "UTF-8").trim();
            System.out.println("======= " + srt + " ======");
        }
        @Override
        public void run() {
            System.out.println("======= 过程运行 ======");
            try {
                System.out.println("======= 向客户端响应数据 ======");
                //1.定义客户端的地址、端口号、数据
                InetAddress address = dgPacket.getAddress();
                int port = dgPacket.getPort();
                byte[] data2 = "{'request':'ok','errcode':'0'}".getBytes();
                //2.创建数据报，包含响应的数据信息
                System.out.println(address + " " + port);
                DatagramPacket packet2 = new DatagramPacket(data2, data2.length, address, port);
                //3.响应客户端
                dgSocket.send(packet2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("======= UDPListener摧毁 ======");
    }

}

