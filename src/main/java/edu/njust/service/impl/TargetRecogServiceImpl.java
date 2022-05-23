package edu.njust.service.impl;

import com.sun.scenario.effect.impl.sw.java.JSWColorAdjustPeer;
import edu.njust.entity.PbMsg;
import org.tensorflow.*;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLOutput;
import java.util.*;

import edu.njust.dto.BasicAttributes;
import edu.njust.dto.RecogResult;
import edu.njust.model.UdpDataModel;
import edu.njust.service.TargetRecogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.ParseException;

@Service
public class TargetRecogServiceImpl implements TargetRecogService {
    private final String[] typeList={"B-1B","MQ-9","F-16","C-130"};

    @Override
    public RecogResult finalRecog(List<RecogResult> resultSet) {
        // 调用权值要素输出综合研判结果
        return null;
    }

    @Override
    public RecogResult typeRecog(BasicAttributes params,String pbModel) throws Exception{
        // 调用目标飞机基本属性匹配算法输出基本属性研判概率
        RecogResult res=new RecogResult();
//        不能直接赋值，地址搞相同就一起改了
        String[] typeResult=typeList.clone();
        try (Graph graph = new Graph()) {
            graph.importGraphDef(Files.readAllBytes(Paths.get(
                    "C:\\Users\\70213\\Desktop\\学习文件\\毕业设计\\从头开始\\python_file\\pb\\"+pbModel+".pb"
            )));
            try (Session sess = new Session(graph)) {
                // 自己构造一个输入
                float[][] input = {{params.getLongitude(), params.getLatitude(), params.getHeight(), params.getSpeed()}};
                System.out.println(Arrays.toString(input[0]));
                try (Tensor x = Tensor.create(input);
                     // input是输入的name，output是输出的name
                     Tensor y = sess.runner().feed("Input", x).fetch("Identity").run().get(0)) {
                    float[][] result = new float[1][Math.toIntExact(y.shape()[1])];
                    y.copyTo(result);
                    System.out.println(y);
                    System.out.println(Arrays.toString(result[0]));
                    for(int i=0;i<typeResult.length-1;i++){
                        for(int j=0;j<typeResult.length-1-i;j++){
                            if(result[0][j]<result[0][j+1]){
                                float temp=result[0][j];
                                result[0][j]=result[0][j+1];
                                result[0][j+1]=temp;
                                String tempStr=typeResult[j];
                                typeResult[j]=typeResult[j+1];
                                typeResult[j+1]=tempStr;
                            }
                        }
                    }
                    res.setType(typeResult);
                    res.setPro(result[0]);
                }
            }
        }
        return res;
    }

    /**
     * 判断udp数据是否为空情态势数据
     * @param dataModelList udp数据
     * @return boolean
     */
    @Override
    public boolean isBasisInfo(List<UdpDataModel> dataModelList) {
        return false;
    }

    /**
     * 提取有效字段，转换为性能参数数据结构
     * @param dataModelList udp数据
     * @return 目标性能参数
     */
    @Override
    public List<BasicAttributes> transferModel(List<UdpDataModel> dataModelList) throws ParseException {
        List<BasicAttributes> targetList = new ArrayList<>();
        for(UdpDataModel model : dataModelList){

            BasicAttributes item = new BasicAttributes();

            String targetId =  model.getOrigin().substring(52, 74);
            item.setTargetID(targetId);
            String pointId = model.getOrigin().substring(75, 76);
            item.setPointID(pointId);
            // 截取经度字段
            String longtitudeStr = model.getOrigin().substring(77, 78);
            // 字符串转换为double
            double longtitude = Double.parseDouble(longtitudeStr);
            item.setLongitude((float)longtitude);
            double latitude = Double.parseDouble(model.getOrigin().substring(79, 80));
            item.setLatitude((float)latitude);
            double height = Double.parseDouble(model.getOrigin().substring(81, 82));
            item.setHeight((float)height);
            double speed = Double.parseDouble(model.getOrigin().substring(88, 92));
            item.setSpeed((float)speed);
            String startPlace = model.getOrigin().substring(93, 99);
            item.setTargetID(startPlace);
            String countryCode = model.getOrigin().substring(100, 110);
            item.setCountryCode(countryCode);
            // 截取更新时间字段
            String dateStr = model.getOrigin().substring(112, 119);
            DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG);
            Date date = dateFormat.parse(dateStr);
            item.setUpdateTime(date);
            targetList.add(item);
        }
        return targetList;
    }

    /**
     * 调用性能参数匹配算法
     * @return 概率结果
     */
//    @Override
//    public RecogResult basicRecog(List<BasicAttributes> basicParams) {
//        RecogResult result = new RecogResult();
//        return result;
//    }

    @Override
    public List<PbMsg> getPbList(int pageNum){
        String path= "C:\\Users\\70213\\Desktop\\学习文件\\毕业设计\\从头开始\\python_file\\pb";
        File file=new File(path);
        File[] array=file.listFiles();
        List<PbMsg> PbList=new ArrayList<>();
        List<PbMsg> res=new ArrayList<>();
        for(int i=0;i< array.length;i++){
            if(array[i].isFile()){
                String name=array[i].getName().substring(0,array[i].getName().lastIndexOf('-'));
                String timeString=array[i].getName().substring(array[i].getName().lastIndexOf('-')+1,array[i].getName().lastIndexOf('.'));
                PbMsg pbMsg=new PbMsg(name,timeString);
                PbList.add(pbMsg);
            }
        }
        int pageStart=pageNum==1?0:(pageNum-1)*4;
        int pageEnd= Math.min(PbList.size(), pageNum * 4);
        if(PbList.size()>0){
            res=PbList.subList(pageStart,pageEnd);
        }
        return res;
    }

    @Override
    public int getTotal(){
        String path= "C:\\Users\\70213\\Desktop\\学习文件\\毕业设计\\从头开始\\python_file\\pb";
        File file=new File(path);
        File[] array=file.listFiles();
        return array.length;
    }
}
