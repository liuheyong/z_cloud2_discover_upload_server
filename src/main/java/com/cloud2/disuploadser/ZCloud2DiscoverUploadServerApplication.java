package com.cloud2.disuploadser;

import com.cloud2.commons.constants.Constants;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class ZCloud2DiscoverUploadServerApplication {

    @RestController
    public class UploadController {

        @PostMapping(value = Constants.CLOUD2 + "/uploadFile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
        public String handleFileUpload(@RequestPart(value = "file") MultipartFile file) {
            return file.getName();
        }

    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(ZCloud2DiscoverUploadServerApplication.class).web(true).run(args);
    }

}
