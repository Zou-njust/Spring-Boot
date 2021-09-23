package edu.njust.controller;

import edu.njust.algorithm.ThreatAnalysis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/threat")
@CrossOrigin
public class ThreatController {
    @Autowired
    private ThreatAnalysis threatAnalysis;

    @PostMapping("/threat_bn")
    public Map<String, float[]> threatBN(@RequestParam("type") int type, @RequestBody Map<String, Object> rcvData){
        threatAnalysis.setType(type);

        Map<String, Object> data = (Map<String, Object>)rcvData.get("data");
        List<Float> intention = new ArrayList<>();

        List<Double> tmp = (List<Double>)rcvData.get("intention");
        for (Double d : tmp){
            intention.add(d.floatValue());
        }

        return threatAnalysis.analyze(data, intention);
    }

    @PostMapping("/bn_train")
    public void bnTrain(@RequestParam("type") int type, @RequestBody List<Map<String, Integer>> data){
        threatAnalysis.setType(type);

        threatAnalysis.train(data);
    }

    @PostMapping("/get_bn_model")
    public List getBNModel(@RequestParam("type") int type){
        threatAnalysis.setType(type);

        return threatAnalysis.getNodeAndLink();
    }
}
