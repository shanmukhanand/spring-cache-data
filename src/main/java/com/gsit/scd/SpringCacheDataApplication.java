package com.gsit.scd;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableCaching
public class SpringCacheDataApplication  extends SpringBootServletInitializer {
	
	@Bean
	public CacheManager cacheManager() {
		Cache cache = new ConcurrentMapCache("findByIsbn");
		SimpleCacheManager manager = new SimpleCacheManager();
		manager.setCaches(Arrays.asList(cache));
		return manager;
	}
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringCacheDataApplication.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SpringCacheDataApplication.class, args);
    }

	/*public static void main(String[] args) {
		SpringApplication.run(SpringCacheDataApplication.class, args);
	}*/
}
