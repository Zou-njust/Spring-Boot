package edu.njust.service;

import org.springframework.web.multipart.MultipartFile;

public interface TrainTargetModelService {
    public boolean trainTargetModel(String csvName);
    public Object upload(MultipartFile multipartFile);
    public boolean delete(String name);
}
