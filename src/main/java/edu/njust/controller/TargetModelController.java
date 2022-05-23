package edu.njust.controller;

import edu.njust.api.CommonResult;
import edu.njust.service.TrainTargetModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@Scope("prototype")
@RequestMapping("/TargetModel")
@CrossOrigin

public class TargetModelController {

    @Autowired
    private TrainTargetModelService trainService;

    @GetMapping("/train")
    public CommonResult trainTargetModel(@RequestParam(value="csvName") String csvName){
        return CommonResult.success(trainService.trainTargetModel(csvName));
    }

    @RequestMapping("/upload")
    public CommonResult upload(@RequestParam("lbf-file-upload") MultipartFile multipartFile){
        final Object upload=trainService.upload(multipartFile);
        return CommonResult.success(upload,multipartFile.getOriginalFilename()+"上传成功");
    }

    @DeleteMapping("/delete")
    public CommonResult delete(@RequestParam("name") String name){

        return CommonResult.success(trainService.delete(name));
    }
}
