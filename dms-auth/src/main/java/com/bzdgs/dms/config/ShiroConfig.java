package com.bzdgs.dms.config;

import com.bzdgs.dms.auth.CustomReal;
import com.bzdgs.dms.auth.FilterChainDefinitionMapFactory;
import com.bzdgs.dms.auth.MyAuthenFilter;
import com.bzdgs.dms.auth.MySessionManager;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.filter.DelegatingFilterProxy;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig  {
    /**
     * @ConditionalOnMissingBean 如果容器中不存在 DefaultAdvisorAutoProxyCreator，则创建一个交给容器
     * @return
     */
    @Bean
    @ConditionalOnMissingBean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator(){
        DefaultAdvisorAutoProxyCreator autoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        autoProxyCreator.setProxyTargetClass(true);
        return autoProxyCreator;
    }

    /**
     * 配置密码匹配规则
     * @return
     */
    @Bean("credentialsMatcher")
    public HashedCredentialsMatcher getCredentialsMatcher(){
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashIterations(10);
        hashedCredentialsMatcher.setHashAlgorithmName("MD5");
        return hashedCredentialsMatcher;
    }
    /**
     * 将自定义的Realm交给容器管理
     * @return
     */
    @Bean
    public CustomReal getCustomRealm(){

        CustomReal customReal = new CustomReal();
        //将加密规则配置到自定义
        customReal.setCredentialsMatcher(getCredentialsMatcher());
        return customReal;
    }

    @Bean
    public MySessionManager getSessionManager(){
        return new MySessionManager();
    }
    /**
     * 配置自定义Realm到安全管理器
     * @return
     */
    @Bean
    public SecurityManager securityManager(){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(getCustomRealm());
        securityManager.setSessionManager(getSessionManager());
        return securityManager;
    }

    @Bean
    public MyAuthenFilter getAuthenFilter(){
        return new MyAuthenFilter();
    }

    @Bean
    public FilterChainDefinitionMapFactory  getFilterChainDefinitionMapFactory(){
        return new FilterChainDefinitionMapFactory();
    }
    /**
     * 配置过滤器
     * @param securityManager
     * @return
     */
    @Bean("shiroFilter")
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //配置securityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //配置过滤map
        FilterChainDefinitionMapFactory factory = getFilterChainDefinitionMapFactory();
        Map<String, String> map = factory.getMap();
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        //配置自定义授权过滤
        Map<String, Filter> filterMap = new LinkedHashMap<>();
        filterMap.put("myAuth",getAuthenFilter());
        shiroFilterFactoryBean.setFilters(filterMap);
        System.out.println("Shiro拦截器工厂类注入成功");
        return shiroFilterFactoryBean;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor getAuthorizationAttributeSourceAdvisor(SecurityManager securityManager){
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

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


}
