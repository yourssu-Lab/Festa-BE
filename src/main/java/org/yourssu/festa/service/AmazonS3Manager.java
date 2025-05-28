package org.yourssu.festa.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.*;

@Component
@RequiredArgsConstructor
@Slf4j
public class AmazonS3Manager {
    private final AmazonS3 amazonS3;

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    public List<String> upload(List<MultipartFile> multipartFiles) throws IOException {
        List<String> fileUrls = new ArrayList<>();

        for (MultipartFile multipartFile : multipartFiles) {
            String originalFilename = multipartFile.getOriginalFilename();

            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentLength(multipartFile.getSize());
            metadata.setContentType(multipartFile.getContentType());

            amazonS3.putObject(bucket, originalFilename, multipartFile.getInputStream(), metadata);
            String fileUrl = amazonS3.getUrl(bucket, originalFilename).toString();
            fileUrls.add(fileUrl);
        }

        return fileUrls;
    }
}
