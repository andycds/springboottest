package br.unip.springboottest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import br.unip.springboottest.interceptor.LoginInterceptor;
import br.unip.springboottest.model.Calculadora;

@Configuration
public class AppConfig implements WebMvcConfigurer {
	@Bean
	public Calculadora getCalculadora() {
		return new Calculadora();
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**").excludePathPatterns("/login", "/",
				"/fazerLogin");
	}
}
