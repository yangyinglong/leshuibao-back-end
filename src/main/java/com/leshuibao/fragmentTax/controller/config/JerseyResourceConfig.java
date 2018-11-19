//package com.leshuibao.fragmentTax.controller.config;
//
//        import org.glassfish.jersey.server.ResourceConfig;
//        import org.glassfish.jersey.server.spring.scope.RequestContextFilter;
//        import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
//        import org.springframework.core.type.filter.AnnotationTypeFilter;
//        import org.springframework.util.ClassUtils;
//
//        import javax.ws.rs.Path;
//        import javax.ws.rs.ext.Provider;
//        import java.util.stream.Collectors;
//
///**
// * 继承ResourceConfig,并添加一些配置信息
// *
// */
//public class JerseyResourceConfig extends ResourceConfig {
//    public JerseyResourceConfig() {
//        register(RequestContextFilter.class);
//        // 配置那个包下面的会被Jersey扫描
//        packages("com.leshuibao.fragmentTax.controller");
//    }
//}
//
