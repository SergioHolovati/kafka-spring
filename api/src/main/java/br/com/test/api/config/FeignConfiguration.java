package br.com.test.api.config;

import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = {"br.com.test.api.client"})
@ImportAutoConfiguration({FeignAutoConfiguration.class})
public class FeignConfiguration {

}
