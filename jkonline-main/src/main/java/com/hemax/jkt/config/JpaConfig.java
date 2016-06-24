package com.hemax.jkt.config;

import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.hemax.jkt.data.BaseRepositoryImpl;


/**
 * Created by liuhz on 15/12/10.
 */
@Configuration
@EntityScan("com.hemax.jkt")
@EnableJpaRepositories(basePackages = {"com.hemax.jkt"}, repositoryBaseClass = BaseRepositoryImpl.class)
public class JpaConfig {
    
}
