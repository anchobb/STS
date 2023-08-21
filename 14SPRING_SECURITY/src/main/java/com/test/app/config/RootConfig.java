package com.test.app.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.test.app.domain.mapper")
public class RootConfig {

}
