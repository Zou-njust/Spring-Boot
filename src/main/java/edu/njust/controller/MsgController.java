package edu.njust.controller;

//import edu.njust.api.CommonResult;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

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