package cn.cheng.sbsm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
//在springBoot启动时会扫描@WebServlet，并将该类实例化
@ServletComponentScan
public class SbsmApplication {

    public static void main(String[] args) {
        SpringApplication.run(SbsmApplication.class, args);
    }

//    第二种方式：启动注册的方法  去除@ServletComponentScan注解 以及在servlet类上的@@WebServlet注解
    /*@Bean
    public ServletRegistrationBean getServletRegistrationBean(){
        ServletRegistrationBean bean = new ServletRegistrationBean(new SecondServlet());
        bean.addUrlMappings("/second");
        return bean;
    }*/

}
