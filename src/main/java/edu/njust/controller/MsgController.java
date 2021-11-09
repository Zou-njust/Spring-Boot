package edu.njust.controller;

//import edu.njust.api.CommonResult;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

import com.alibaba.fastjson.JSONObject;
import java.io.*;
import java.util.Map;

@RestController
@Scope("prototype")
@RequestMapping("/msg")
@CrossOrigin
public class MsgController {

    @GetMapping(value = "/get")
    public String getMessage() {
        String pathName = "udpData.txt";
        String msg = "1";
        try(FileReader reader = new FileReader(pathName);
            BufferedReader br = new BufferedReader(reader)) {
            msg = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return msg;
    }
    @PostMapping(value = "/json")
    public String recJson(@RequestBody Map<String, String> data) {
//        JSONObject object = new JSONObject(data);
        // json转字符串输出
        return data.toString();
    }
    @PostMapping(value = "/write")
    public void writeText(@RequestBody Map<String, String> set) {
//        String line = "hello";
        try {
            File writeName = new File("udpData.txt");
            if(!writeName.isFile()) {
                writeName.createNewFile();
            }
            BufferedWriter bw = new BufferedWriter(new FileWriter(writeName));
            bw.write(set.get("line")+"\r\n");
            bw.flush();
            bw.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}