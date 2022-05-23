package edu.njust.service.impl;

import edu.njust.service.TrainTargetModelService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

@Service
public class TrainTargetModelServiceImpl implements TrainTargetModelService {
    @Override
    public boolean trainTargetModel(String csvName){
        final boolean[] flag = {false};
        final CountDownLatch latch=new CountDownLatch(1);
        try{
//          String path="C:\\\\Users\\\\70213\\\\Desktop\\\\学习文件\\\\毕业设计\\\\从头开始\\\\python_file\\\\uploadDemo.py";
            String name=csvName.substring(0,csvName.lastIndexOf('.'));
            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyyMMddHHmmss");
            String timeString=simpleDateFormat.format(new Date());
            Process process=Runtime.getRuntime().exec("python C:\\Users\\70213\\Desktop\\学习文件\\毕业设计\\从头开始\\python_file\\uploadDemo.py "+name+" "+timeString);
            System.out.println(csvName);
            new Thread() {
                @Override
                public void run(){
                    String line;
                    try {
                        BufferedReader stderr = new BufferedReader(new InputStreamReader(process.getErrorStream(),"GBK"));
                        while ((line = stderr.readLine()) != null) {
                            System.out.println("stderr:" + line);
                        }
                    }
                    catch (Exception e) {
                    }
                }
            }.start();
            new Thread() {
                @Override
                public void run() {
                    super.run();
                    String line;
                    try {
                        BufferedReader stdout = new BufferedReader(new InputStreamReader(process.getInputStream(),"GBK"));
                        while ((line = stdout.readLine()) != null) {
                            System.out.println("stdout:" + line);
                            if(line.equals("complete")) {
                                System.out.println("train complete");
//                                flag[0] = true;
                                  latch.countDown();
                            }
                        }
                    }
                    catch (Exception e) {

                    }
                }
            }.start();

//            InputStreamReader ir=new InputStreamReader(process.getInputStream());
//            LineNumberReader input=new LineNumberReader(ir);
//            input.close();
//            ir.close();
        }catch(IOException e){
            e.printStackTrace();
            return false;
        }
//        while(!flag[0]){
//
//        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("完成");
        return true;
    }

    @Override
    public Object upload(MultipartFile multipartFile){
        InputStream inputStream=null;
        BufferedOutputStream bos=null;
        try{
            final String name=multipartFile.getOriginalFilename();
            inputStream=multipartFile.getInputStream();
            bos=new BufferedOutputStream(new FileOutputStream("C:\\Users\\70213\\Desktop\\学习文件\\毕业设计\\从头开始\\python_file\\dataset\\"+name));
            byte[] bytes=new byte[1024];
            int len;
            while((len= inputStream.read(bytes))!=-1){
                bos.write(bytes,0,len);
            }
            File file=new File("C:\\Users\\70213\\Desktop\\学习文件\\毕业设计\\从头开始\\python_file\\dataset\\"+name);
            final String absolutePath=file.getAbsolutePath();
            return "上传完成";
        }catch(IOException e){
            return "上传失败"+e.getMessage();
        }finally {
            try{
                assert bos!=null;
                bos.close();
                inputStream.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean delete(String name){
        String path="C:\\Users\\70213\\Desktop\\学习文件\\毕业设计\\从头开始\\python_file\\";
        File pbFile=new File(path+"pb\\"+name+".pb");
        File h5File=new File(path+"model\\"+name+".h5");
        File jsonFile=new File(path+"model\\"+name+".json");
        if(h5File.exists()){
            h5File.delete();
        }
        if(jsonFile.exists()){
            jsonFile.delete();
        }
        if(pbFile.exists()){
            pbFile.delete();
            return true;
        }
        return false;
    }
}
