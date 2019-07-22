package com.yuzo.question.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SessionConfiguraction implements WebMvcConfigurer {
    //配置拦截器
    public void addInterceptors(InterceptorRegistry registry){
        //registry.addInterceptor此方法添加拦截器
    	InterceptorRegistration interceptor = registry.addInterceptor(this.sessionInterceptor());
          
        interceptor.addPathPatterns("/**");
        
        // 排除不拦截的，包括自己登录的页面不用拦截   WebMvcConfigurationSupport
        interceptor.excludePathPatterns("/static/**");
        interceptor.excludePathPatterns("/bower_components/**");
        interceptor.excludePathPatterns("/dist/**");
        interceptor.excludePathPatterns("/plugins/**");
        interceptor.excludePathPatterns("/images/**");
        interceptor.excludePathPatterns("/simditor/**");
        interceptor.excludePathPatterns("/");     
      
    }
    

	/**
	 * 不拦截的资源
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		
		//将templates目录下的CSS、JS文件映射为静态资源，防止Spring把这些资源识别成thymeleaf模版
        registry.addResourceHandler("/templates/**.js").addResourceLocations("classpath:/templates/");
        registry.addResourceHandler("/templates/**.css").addResourceLocations("classpath:/templates/");
    	registry.addResourceHandler("/templates/**").addResourceLocations("classpath:/templates/");
    	
        //其他静态资源
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        
    	registry.addResourceHandler("/bower_components/**").addResourceLocations("classpath:/static/bower_components/");
		registry.addResourceHandler("/dist/**").addResourceLocations("classpath:/static/dist/");
		registry.addResourceHandler("/plugins/**").addResourceLocations("classpath:/static/plugins/");
		registry.addResourceHandler("/images/**").addResourceLocations("classpath:/static/images/");
		registry.addResourceHandler("/simditor/**").addResourceLocations("classpath:/static/simditor/");
	
		
	}

	
    @Bean
    public SessionInterceptor sessionInterceptor() {
    	return new SessionInterceptor();
    }
  
}
