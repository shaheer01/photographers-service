package com.photographers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;

import java.time.Duration;

@Slf4j
@SpringBootApplication
@EnableAutoConfiguration
@EnableJpaAuditing
@ComponentScan("com.photographers.*")
@EnableCaching
//@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class PhotographersApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(PhotographersApplication.class, args);
    }

    @Override
    public void run(String... args) {
        try {
            log.info("---------APPLICATION STARTED---------");

        } catch (Exception e) {
            log.error("Unable to process request", e);
        }
    }

    @Bean
    public RedisCacheManager cacheManager(RedisConnectionFactory connectionFactory) {
        RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig() //
            .prefixCacheNameWith(this.getClass().getPackageName() + ".") //
            .entryTtl(Duration.ofHours(1)) //
            .disableCachingNullValues();

        return RedisCacheManager.builder(connectionFactory) //
            .cacheDefaults(config) //
            .build();
    }
}
