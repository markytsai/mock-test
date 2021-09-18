package top.mochoong.mocktest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author tsai
 */
@SpringBootApplication
@EnableFeignClients(basePackages = "top.mochoong.mocktest")
@EnableDiscoveryClient
public class MockTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(MockTestApplication.class, args);
    }

}
