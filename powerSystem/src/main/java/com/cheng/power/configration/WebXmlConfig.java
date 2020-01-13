package com.cheng.power.configration;

import org.apache.struts2.dispatcher.filter.StrutsPrepareAndExecuteFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * 周刘成   2020-1-8
 */
@Configuration
public class WebXmlConfig {
    /**
     * 根据官网提供的方法我们可以通过以下的方法配置一个web里的过滤器。
     * 相当于在web文件中配置了一个过滤器叫StrutsPrepareAndExecuteFilter
     * <p>
     * 我们也可以直接返回StrutsPrepareAndExecuteFilter 这里默认拦截的就是所有。
     * <p>
     * 也可以直接返回一个过滤器
     *
     * @Bean public StrutsPrepareAndExecuteFilter filterRegistrationBean(){
     * return new StrutsPrepareAndExecuteFilter();
     * <p>
     * }
     */
    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean frgb = new FilterRegistrationBean();
        frgb.setFilter(new StrutsPrepareAndExecuteFilter());
        List list = new ArrayList();
        list.add("/*");
        list.add("*.action");
        frgb.setUrlPatterns(list);
        return frgb;
    }

}
