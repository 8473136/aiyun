package com.aifyun.aiyun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author 84731
 */
@SpringBootApplication
@MapperScan("com.aifyun.aiyun.mapper")
public class AiyunApplication {

    public static void main(String[] args) {
        SpringApplication.run(AiyunApplication.class, args);
    }

}
