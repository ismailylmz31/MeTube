package main.java.com.programming.metube.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    String upload(MultipartFile file);

    void deleteFile(String fileName);
}
