package main.java.com.programming.metube.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UploadVideoResponse {
    private String videoId;
    private String fileName;
}
