package com.example.demo.exception;

import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

//@Component // 스프링 부트가 제공하는 기본 오류 메커니즘을 사용하도록 주석처리
public class WebServerCustomizer implements WebServerFactoryCustomizer<ConfigurableWebServerFactory>{

	@Override
	public void customize(ConfigurableWebServerFactory factory) {
		ErrorPage errorPage404 = new ErrorPage(HttpStatus.NOT_FOUND, "/error-page/404");
		ErrorPage errorPage500 = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error-page/500");

		ErrorPage errorPageEx = new ErrorPage(RuntimeException.class, "/error-page/500");
		
		factory.addErrorPages(errorPage404, errorPage500, errorPageEx);
		
		/*
		 * response.sendError(404) : errorPage404 호출
		 * response.sendError(500) : errorPage500 호출
		 * RuntimeException 또는 그 자식 타입의 예외: errorPageEx 호출
		 */
	}

}
