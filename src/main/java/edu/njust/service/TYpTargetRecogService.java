package edu.njust.service;

import edu.njust.mapper.TYpTargetRecogMapper;
import edu.njust.model.TYpTargetRecog;
import edu.njust.model.TYpTargetRecogExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TYpTargetRecogService {

    @Resource
    private TYpTargetRecogMapper targetRecogMapper;

    public TYpTargetRecog getResult(String targetValue) {
        TYpTargetRecog targetRecog = new TYpTargetRecog();
        targetRecog.setTargetName(targetValue);
        targetRecogMapper.insert(targetRecog);
        return targetRecog;
    }
}
