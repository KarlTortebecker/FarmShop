package org.casjedcem.FarmShop.spring;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.context.request.RequestContextListener;

@Configuration
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer {

    public MvcConfig(){
        super();
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/index.html");

    }

    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry){
        registry.addResourceHandler(
                "/images/**",
                "/css/**",
                "/js/**",
                "/fonts/**",
                "/vendor/**"
        ).addResourceLocations(
                "classpath:/static/images/",
                "classpath:/static/js/",
                "classpath:/static/css/",
                "classpath:/static/fonts/",
                "classpath:/static/vendor/"
        );
    }


    @Bean
    @ConditionalOnMissingBean(RequestContextListener.class)
    public RequestContextListener requestContextListener() {
        return new RequestContextListener();
    }

    }

