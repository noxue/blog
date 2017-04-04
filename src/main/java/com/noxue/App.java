package com.noxue;

import com.noxue.utils.AuthInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication // same as @Configuration @EnableAutoConfiguration @ComponentScan
public class App extends WebMvcConfigurerAdapter
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AuthInterceptor());
    }
}
