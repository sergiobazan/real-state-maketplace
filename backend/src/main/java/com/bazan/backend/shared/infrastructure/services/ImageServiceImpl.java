package com.bazan.backend.shared.infrastructure.services;

import com.bazan.backend.shared.aplication.abstractions.ImageService;
import com.bazan.backend.shared.domain.abstractions.Error;
import com.bazan.backend.shared.domain.abstractions.Result;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

@Service
@Slf4j
class ImageServiceImpl implements ImageService {
    private final static String S3_DIRECTORY = "real_state_marketplace";
    private final static String S3_REGION = "us-east-1";

    @Value("${aws.s3.accessKey}")
    private String accessKey;

    @Value("${aws.s3.secretKey}")
    private String secretKey;

    @Value("${aws.s3.bucketName}")
    private String bucketName;

    private S3Client s3Client;

    @PostConstruct
    private void init() {
        s3Client = S3Client.builder()
                .region(Region.US_EAST_1)
                .credentialsProvider(StaticCredentialsProvider.create(
                        AwsBasicCredentials.create(accessKey, secretKey)
                ))
                .build();
    }

    @Override
    public Result<String> uploadImage(MultipartFile file) {
        try {
            String filePath = S3_DIRECTORY + "/" + file.getOriginalFilename();

            var objectRequest = PutObjectRequest
                    .builder()
                    .bucket(bucketName)
                    .key(filePath)
                    .contentType(file.getContentType())
                    .contentLength(file.getSize())
                    .build();

            var requestBody = RequestBody.fromBytes(file.getBytes());

            s3Client.putObject(objectRequest, requestBody);

            String imageUrl = "https://" + bucketName + ".s3." + S3_REGION + ".amazonaws.com/" + filePath;

            return Result.success(imageUrl);
        } catch (Exception e) {
            log.error("Error occurred: {}", e.getMessage());
            return Result.failure(new Error("AWS.S3", "Error uploading image to AWS S3 Bucket"));
        }
    }
}
