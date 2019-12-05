package cn.itstudies.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

/**
 * @author Farewell is well
 * @date 2019-12-01 17:27
 * Eureka注册中心使用httpBasic安全验证
 */
@Configuration
@EnableWebSecurity
public class EurekaSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //SpringSecurity将不会创建新的Session
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER);
        //禁用Cross Site Request Forgery跨站请求伪造
        http.csrf().disable();
        //配置所有请求均使用HTTP基本身份验证方式
        http.authorizeRequests().anyRequest().authenticated().and().httpBasic();
    }
}
