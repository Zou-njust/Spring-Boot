package edu.njust.controller;

import edu.njust.api.CommonResult;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;

@RestController
@Scope("prototype")
@RequestMapping("/msg")
public class MsgController {

    @GetMapping(value = "/get")
    public CommonResult<String> getMessage() {
        String pathName = "udpData.txt";
        String msg = "";
        try (FileReader reader = new FileReader(pathName);
             BufferedReader br = new BufferedReader(reader)) {
            msg = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return CommonResult.success(msg);
    }
}