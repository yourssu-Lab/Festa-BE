package org.yourssu.festa.service;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.yourssu.festa.common.code.BoothErrorCode;
import org.yourssu.festa.config.AmazonConfig;
import org.yourssu.festa.exception.CustomException;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

@Component
@RequiredArgsConstructor
@Slf4j
public class AmazonS3Manager {
    private final AmazonS3Client amazonS3Client;
    private final AmazonConfig amazonConfig;

    public List<String> upload(List<MultipartFile> multipartFiles) throws IOException{
        List<String> uploadImageUrls = new ArrayList<>();
        String dirName =  amazonConfig.getReviewPath();
        for (MultipartFile multipartFile : multipartFiles){
            File uploadFile = convert(multipartFile)
                    .orElseThrow(() -> new CustomException(BoothErrorCode.BOOTH_UPLOAD_IMAGE_FAILED));
            String uploadImageUrl = upload(uploadFile, dirName);
            uploadImageUrls.add(uploadImageUrl);
        }
        return uploadImageUrls; // 업로드된 파일들의 S3 URL 주소 리스트 반환
    }

    private String upload(File uploadFile, String dirName){
        String uuid = UUID.randomUUID().toString();
        String fileName = dirName + "/" + uuid + uploadFile.getName();
        String uploadImageUrl = putS3(uploadFile, fileName);
        removeNewFile(uploadFile);  // 로컬에 생성된 File 삭제 (MultipartFile -> File 전환 하며 로컬에 파일 생성됨)
        return uploadImageUrl;
    }

    private String putS3(File uploadFile, String fileName) {
        amazonS3Client.putObject(
                new PutObjectRequest(amazonConfig.getBucket(), fileName, uploadFile)
                        .withCannedAcl(CannedAccessControlList.PublicRead) // PublicRead 권한으로 업로드 됨
        );
        return amazonS3Client.getUrl(amazonConfig.getBucket(), fileName).toString();
    }

    private void removeNewFile(File targetFile) {
        if (targetFile.delete()) {
            log.info("파일이 삭제되었습니다.");
        } else {
            log.info("파일이 삭제되지 못했습니다.");
        }
    }

    private Optional<File> convert(MultipartFile file) throws IOException {
        File convertFile = new File(Objects.requireNonNull(file.getOriginalFilename()));
        if (convertFile.createNewFile()) {
            try (FileOutputStream fos = new FileOutputStream(convertFile)) {
                fos.write(file.getBytes());
            }
            return Optional.of(convertFile);
        }
        return Optional.empty();
    }
}
