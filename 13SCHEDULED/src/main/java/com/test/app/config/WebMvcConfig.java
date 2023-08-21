package com.test.app.config;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.BeanNameUrlHandlerMapping;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.test.app.handler.CustomHandler;
import com.test.app.interceptor.MemoInterceptor;
import com.test.app.listener.CustomContextRefreshedListener;
import com.test.app.listener.RequestHandledEventListener;

//<beans:bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
//<beans:property name="prefix" value="/WEB-INF/views/" />
//<beans:property name="suffix" value=".jsp" />
//</beans:bean>

@Configuration
@EnableWebMvc
@ComponentScans({ //servlet-context.xml에 있던 것들(component-scan)을 config로 옮기기
	@ComponentScan("com.test.app.controller"),
	@ComponentScan("com.test.app.restcontroller")
	
})
public class WebMvcConfig implements WebMvcConfigurer{

	@Bean
	public MultipartResolver multipartResolver() {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setMaxUploadSize(20971520);			//20MB (전체 업로드 허용 사이즈)
		multipartResolver.setMaxUploadSizePerFile(20971520);	//20MB (파일 한개당 허용가능한 업로드 사이즈)
		multipartResolver.setMaxInMemorySize(20971520);			//20MB (캐시 공간)
		return multipartResolver;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	
	//ViewResolver
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/"); //view page 경로
		viewResolver.setSuffix(".jsp"); //확장자명
		return viewResolver;
	}

	//Interceptor Added..
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new MemoInterceptor())
		.addPathPatterns("/memo/**") //메모의 하위경로 모두 포함
		.excludePathPatterns("/resources/**"); //resources 하위경로 모두 제외
	}
	
	//Listener Added
	@Bean
	public CustomContextRefreshedListener customContextRefreshedListener() {
		return new CustomContextRefreshedListener();
	}
	
	//RequestHandledEventListener add
	@Bean
	public RequestHandledEventListener requestHandledEventListener() {
		return new RequestHandledEventListener();
	}
	
	//HANDLER MAPPING ADDED
	//BeanNameUrlHandlerMapping : 요청 URL을 동일한 이름을 가진 빈에 매핑
	@Bean
	BeanNameUrlHandlerMapping beanNameUrlHandlerMapping() {
		return new BeanNameUrlHandlerMapping();
	}
	
	@Bean("/custom01")
	public CustomHandler handlerTest1() {
		return new CustomHandler();
	}
	
	//SimpleUrlHandlerMapping : 개발자가 직접 매핑정보를 설정, 정적자원에 대한 매핑정보 설정 기본값
	@Bean
	SimpleUrlHandlerMapping simpleUrlHandlerMapping() {
		
		SimpleUrlHandlerMapping handlerMapping = new SimpleUrlHandlerMapping();
		Map<String,Object> urlMap = new HashMap();
		urlMap.put("/custom02", new CustomHandler());
		handlerMapping.setUrlMap(urlMap);
		
		return handlerMapping;
	}
	
	@Bean
	RequestMappingHandlerMapping requestMappingHandlerMapping() throws NoSuchMethodException, SecurityException {
		
		RequestMappingHandlerMapping handlerMapping = new RequestMappingHandlerMapping();
		//Reflection으로 Method찾기
		Method method = CustomHandler.class.getMethod("WOW",null);
		System.out.println("methods[0] : "+method.getName());
		
		
		//요청매핑정보 구성
		RequestMappingInfo mappingInfo = RequestMappingInfo
										.paths("/custom03")
										.methods(RequestMethod.GET)
										.build();
		
		//요청매핑, 핸들러, 함수 등록
		
		handlerMapping.registerMapping(mappingInfo, new CustomHandler(), method);
		
		return handlerMapping;
	}
}
