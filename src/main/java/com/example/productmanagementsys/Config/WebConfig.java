package com.example.productmanagementsys.Config;

import com.example.productmanagementsys.interceptor.LoggingInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * The type Web config.
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // Register the interceptor to apply it to all routes
        registry.addInterceptor(new LoggingInterceptor())
                .addPathPatterns("/api/**");
    }

    /**
     * Logging interceptor logging interceptor.
     *
     * @return the logging interceptor
     */
    @Bean
    public LoggingInterceptor loggingInterceptor() {
        return new LoggingInterceptor();
    }

}
