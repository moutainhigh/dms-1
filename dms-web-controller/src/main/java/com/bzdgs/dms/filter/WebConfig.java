package com.bzdgs.dms.filter;

import com.bzdgs.dms.auth.MyAuthenFilter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


import javax.servlet.Filter;

/**
 * web全局过滤器配置
 * @author YCWB0118
 */
@Configuration
public class WebConfig {

    @Bean
    @ConditionalOnMissingBean
    public MyAuthenFilter getAuthenFilter(){
        return new MyAuthenFilter();
    }
    /**
     * 注册shiro代理过滤器
     * @return
     */
    @Bean
    public DelegatingFilterProxy getDelegatingFilterProxy(){
        DelegatingFilterProxy delegatingFilterProxy = new DelegatingFilterProxy(getAuthenFilter());
        delegatingFilterProxy.setTargetFilterLifecycle(true);
        delegatingFilterProxy.setTargetBeanName("shiroFilter");
        return delegatingFilterProxy;
    }

    @Bean
    public FilterRegistrationBean delegatingFilterProxy(){
        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(getDelegatingFilterProxy());
        filterRegistrationBean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return filterRegistrationBean;
    }

    @Bean
    public CorsFilter getCorsFilter(){
        return new CorsFilter();
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean<Filter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
        filterFilterRegistrationBean.setFilter(getCorsFilter());
        filterFilterRegistrationBean.addUrlPatterns("/**");
        filterFilterRegistrationBean.setName("corsFilter");
        filterFilterRegistrationBean.setOrder(Ordered.LOWEST_PRECEDENCE);
        System.out.println("======注入跨域过滤器成功");
        return filterFilterRegistrationBean;
    }

}
