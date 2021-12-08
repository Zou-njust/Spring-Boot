package edu.njust.udp;

import edu.njust.udp.udpmodel.IdentityModel;
import edu.njust.udp.udpmodel.IntentionModel;
import edu.njust.udp.udpmodel.TrackModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UdpResultData {

    public List<Byte> head;
    public List<Byte> body;
    public List<Byte> tail;

    // 创建帧头
    public void createHead(int length, short sender, short receiver, byte mID, long timestamp){
        head = new ArrayList<>();
        // 1
        head.add((byte)0x55);
        head.add((byte)0x55);
        head.add((byte)0x55);
        head.add((byte)0x55);
        // 2:164
        byte[] d2;
        d2 = int2Byte(length);
        head.add(d2[0]);
        head.add(d2[1]);
        head.add(d2[2]);
        head.add(d2[3]);
        // 3 4
        byte[] d3,d4;
        d3 = short2Byte(sender);
        d4 = short2Byte(receiver);
        head.add(d3[0]);
        head.add(d3[1]);
        head.add(d4[0]);
        head.add(d4[1]);
        // 5
        head.add(mID);
        // 6
        byte[] d6;
        d6 = long2Byte(timestamp);
        for(int i=0; i<8; i++){
            head.add(d6[i]);
        }
    }
    // 创建文件体1
    public void createIdentityBody(
            String mbNumber,
            String wayPoint,
            byte number,
            IdentityModel[] modelList
    ){
        body = new ArrayList<>();
        body.addAll(enlargeArray(mbNumber.getBytes(), 20));
        body.addAll(enlargeArray(wayPoint.getBytes(), 20));
        body.add(number);
        for(IdentityModel model: modelList){
            body.add(model.mbType);
            body.addAll(enlargeArray(model.mbID.getBytes(), 20));
            body.addAll(enlargeArray(model.mbName.getBytes(), 50));
            body.addAll(enlargeArray(model.airport.getBytes(), 20));
            body.addAll(enlargeArray(model.country.getBytes(), 5));
            body.add(model.method);
            body.add(model.probability);
        }
    }
    // 创建文件体2
    public void createTrackBody(
            String mbNumber,
            String wayPoint,
            byte number,
            TrackModel[] modelList
    ){
        body = new ArrayList<>();
        body.addAll(enlargeArray(mbNumber.getBytes(), 20));
        body.addAll(enlargeArray(wayPoint.getBytes(), 20));
        body.add(number);
        for(TrackModel model: modelList){
            body.add(model.hxType);
            body.addAll(enlargeArray(model.hxID.getBytes(), 20));
            body.add(model.method);
            body.add(model.probability);
        }
    }
    // 创建文件体3
    public void createIntentionBody(
            String mbNumber,
            String wayPoint,
            byte number,
            IntentionModel[] modelList
    ){
        body = new ArrayList<>();
        body.addAll(enlargeArray(mbNumber.getBytes(), 20));
        body.addAll(enlargeArray(wayPoint.getBytes(), 20));
        body.add(number);
        for(IntentionModel model: modelList){
            body.addAll(enlargeArray(model.mbTask.getBytes(), 20));
            body.add(model.probability);
        }
    }
    // 创建文件体4
    public void createThreatAssessBody(
            String mbNumber,
            String wayPoint,
            byte type,
            byte platform,
            byte weapon,
            byte attr,
            byte spaceTime,
            byte general,
            byte level
    ){
        body = new ArrayList<>();
        body.addAll(enlargeArray(mbNumber.getBytes(), 20));
        body.addAll(enlargeArray(wayPoint.getBytes(), 20));
        body.add(type);
        body.add(platform);
        body.add(weapon);
        body.add(attr);
        body.add(spaceTime);
        body.add(general);
        body.add(level);
    }
    // 创建文件体5
    public void createThreatWarnBody(
            String mbNumber,
            String wayPoint,
            byte type,
            String form,
            String message
    ){
        body = new ArrayList<>();
        body.addAll(enlargeArray(mbNumber.getBytes(), 20));
        body.addAll(enlargeArray(wayPoint.getBytes(), 20));
        body.add(type);
        body.addAll(enlargeArray(form.getBytes(), 10));
        body.addAll(enlargeArray(message.getBytes(), 100));
    }
    // 创建帧尾
    public void createTail(){
        tail = new ArrayList<>();
        tail.add((byte)0xaa);
        tail.add((byte)0xaa);
        tail.add((byte)0xaa);
        tail.add((byte)0xaa);
    }


    //int转byte
    public byte[] int2Byte(int intValue) {
        byte[] b = new byte[4];
        for (int i = 0; i < 4; i++) {
            b[i] = (byte) (intValue >> 8 * (3 - i) & 0xFF);
        }
        return b;
    }
    //short转byte
    public byte[] short2Byte(short s) {
        byte[] b = new byte[2];
        for(int i = 0; i < 2; i++){
            int offset = 16 - (i+1)*8; //因为byte占4个字节，所以要计算偏移量
            b[i] = (byte)((s >> offset)&0xff); //把16位分为2个8位进行分别存储
        }
        return b;
    }
    //long转byte
    public byte[] long2Byte(long num) {
        byte[] byteNum = new byte[8];
        for (int ix = 0; ix < 8; ++ix) {
            int offset = 64 - (ix + 1) * 8;
            byteNum[ix] = (byte) ((num >> offset) & 0xff);
        }
        return byteNum;
    }
    //扩充数组成指定字节数
    public List<Byte> enlargeArray(byte[] byteValue, int length){
        byte[] newArray = new byte[length];
        System.arraycopy(byteValue, 0, newArray, 0, byteValue.length);
        List<Byte> list = new ArrayList<>();
        for (byte b: newArray){
            list.add(b);
        }
        return list;
    }

    //组装字节流
    public byte[] assembleByte(){
        List<Byte> mylist = new ArrayList<>();
        mylist.addAll(head);
        mylist.addAll(body);
        mylist.addAll(tail);
        byte[] myArray = new byte[mylist.size()];
        for(int i=0; i<mylist.size(); i++){
            myArray[i] = mylist.get(i);
        }
        return myArray;
    }

    public static void main(String[] args) {
        UdpResultData udp = new UdpResultData();
        udp.createHead(164, (short)18000, (short)18001, (byte)1, new Date().getTime());
        udp.createIdentityBody(...);
        udp.createTail();
        UdpSender sender = new UdpSender();
        sender.send(udp.assembleByte());

    }
}
