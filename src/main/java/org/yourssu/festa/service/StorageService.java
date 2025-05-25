package org.yourssu.festa.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.yourssu.festa.dto.ImageResponse;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StorageService {
    private final AmazonS3Manager amazonS3Manager;

    @Transactional
    public ImageResponse upload(List<MultipartFile> multipartFiles) throws IOException {
        List<String> imageUrls = amazonS3Manager.upload(multipartFiles);
        return ImageResponse.of(imageUrls);
    }
}
