package com.cpcnet.component.componentrpc.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Contract;
import feign.codec.Decoder;
import feign.codec.Encoder;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.springframework.cloud.openfeign.FeignFormatterRegistrar;
import org.springframework.cloud.openfeign.support.SpringMvcContract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.DateFormatter;

import java.util.TimeZone;

/**
 * @author Ebon Zheng
 */
@Configuration
public class FeignClientConfig implements FeignFormatterRegistrar {

    private static final String DATE_PATTERN = "yyyy-MM-dd HH:mm:ss,SSS";

    @Override
    public void registerFormatters(FormatterRegistry registry) {
        DateFormatter dateFormatter = new DateFormatter(DATE_PATTERN);
        dateFormatter.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        registry.addFormatter(dateFormatter);
    }

    @Bean
    public Contract FeignContract() {
        return new SpringMvcContract();
    }

    @Bean
    public Encoder FeignEncoder(ObjectMapper objectMapper) {
        return new JacksonEncoder(objectMapper);
    }

    @Bean
    public Decoder FeignDecoder(ObjectMapper objectMapper) {
        return new JacksonDecoder(objectMapper);
    }
}
