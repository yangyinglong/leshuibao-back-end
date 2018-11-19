package com.leshuibao.fragmentTax.controller.config;

import com.leshuibao.fragmentTax.controller.endpoint.AuthorizeController;
import com.leshuibao.fragmentTax.controller.endpoint.SupplementController;
import com.leshuibao.fragmentTax.controller.endpoint.TradingHallAddController;
import com.leshuibao.fragmentTax.controller.endpoint.TradingHallShowController;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;

/**
 * 配置Jersey
 *
 */
@Component
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {

	public JerseyConfig() {
		register(AuthorizeController.class);
		register(TradingHallShowController.class);
		register(TradingHallAddController.class);
		register(MultiPartFeature.class);
		register(SupplementController.class);
	}
//
//	@Bean
//	public ServletRegistrationBean jerseyServlet() {
//		ServletRegistrationBean registration = new ServletRegistrationBean(new ServletContainer(), "/api/*");
//		// our rest resources will be available in the path /rest/*
//		registration.addInitParameter(ServletProperties.JAXRS_APPLICATION_CLASS, JerseyResourceConfig.class.getName());
//		return registration;
//	}
}
