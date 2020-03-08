package com.whackon.itrip;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * <b>爱旅行-主业务模块生产者启动类</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@MapperScan("com.whackon.itrip.dao")
@EnableEurekaClient
@SpringBootApplication
public class BizProviderStarter {
	public static void main(String[] args) {
		SpringApplication.run(BizProviderStarter.class, args);
	}
}
