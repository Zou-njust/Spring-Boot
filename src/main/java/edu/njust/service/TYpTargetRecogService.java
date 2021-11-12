package edu.njust.service;

import edu.njust.mapper.TYpTargetRecogMapper;
import edu.njust.model.TYpTargetRecog;
import edu.njust.model.TYpTargetRecogExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Random;

@Service
public class TYpTargetRecogService {

    @Resource
    private TYpTargetRecogMapper targetRecogMapper;

    public TYpTargetRecog getResult(String targetValue) {
        TYpTargetRecog targetRecog = new TYpTargetRecog();
//        Random random = new Random();
//        String str = "" + random.nextInt(100);
//        targetRecog.setId(str);
        targetRecog.setTargetName(targetValue);
        targetRecogMapper.insert(targetRecog);
        return targetRecog;
    }

    public List<TYpTargetRecog> get() {
        return targetRecogMapper.selectByExample(new TYpTargetRecogExample());
    }
}
