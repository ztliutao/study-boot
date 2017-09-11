package com;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RestController;

import com.common.ServletContextHolder;

@RestController
@Configuration
@EnableAutoConfiguration
@SpringBootApplication
@EnableTransactionManagement // 启用事务
public class StudyWebRun extends SpringBootServletInitializer {
	
	@Bean
	public ServletContextInitializer servletContextInitializer() {
		return new ServletContextInitializer() {
			public void onStartup(ServletContext servletContext) throws ServletException {
				ServletContextHolder.setServletContext(servletContext);
			}
		};
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		builder.bannerMode(Banner.Mode.OFF);
		return builder.sources(StudyWebRun.class); // 以 war 包形式发布时需要此设置
	}
	public static void main(String[] args) throws IOException {
		SpringApplication.run(StudyWebRun.class, args);
	}
}
