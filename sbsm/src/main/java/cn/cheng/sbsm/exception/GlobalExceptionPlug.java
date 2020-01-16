//package cn.cheng.sbsm.exception;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
//
//import java.util.Properties;
//
///**
// * 周刘成   2020-1-16
// * 通过SimpleMappingExceptionResolver做全局异常处理
// */
//@Configuration
//public class GlobalExceptionPlug {
//
//    @Bean
//    public SimpleMappingExceptionResolver getSimpleMappingExceptionResolver() {
//        SimpleMappingExceptionResolver resolver = new SimpleMappingExceptionResolver();
//        Properties properties = new Properties();
//        /**
//         * 参数一：异常的类型，注意必须是异常类型的全名
//         * 参数二：视图名称
//         */
//        properties.put("java.lang.ArithmeticException", "error1");
//        properties.put("java.lang.NullPointerException", "error2");
//        resolver.setExceptionMappings(properties);
//        return resolver;
//    }
//
//}
