package com.shiro.shiro_00.config;

import com.sun.org.apache.regexp.internal.RE;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    /*
    * ShiroFilerFactoryBean 为shiro过滤器
    * */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        bean.setSecurityManager(securityManager);
        Map<String, String> map = new LinkedHashMap<>();
        //配置不会拦截的URL，顺序判断   anon链接可以匿名登录
        map.put("/static/**", "anon");
        //当登出过滤器其中的具体的登出的代码shiro已经实现了
        map.put("/logout", "logout");
        //过滤链定   执行顺序是从上往下执行  所以一般将/**放在最后面
        //authc是所有的URL都需要认证过后才可以访问
        map.put("/**", "authc");
        //登录页面
        bean.setLoginUrl("/login");
        //等成功需要跳转的页面
        bean.setSuccessUrl("/index");
        //错误页面
        bean.setUnauthorizedUrl("/403");
        //将执行链放到过滤器工厂中
        bean.setFilterChainDefinitionMap(map);
        return bean;
    }
    /*
    * 安全管理器
    * */
    @Bean
    public SecurityManager securityManager() {
        //默认的web安全管理器
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        //将realm放到安全管理器中
        manager.setRealm(realm());
        return manager;
    }
    /*
    * 自定义的realm
    * */
    @Bean
    public MyShiroRealm realm() {
        MyShiroRealm realm = new MyShiroRealm();
        realm.setCredentialsMatcher(matcher());
        return realm;
    }
    /*
    * 加密算法
    * */
    @Bean
    public HashedCredentialsMatcher matcher() {
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
        matcher.setHashAlgorithmName("md5");
        matcher.setHashIterations(2);
        return matcher;
    }
}
