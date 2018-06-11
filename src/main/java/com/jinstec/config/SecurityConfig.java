package com.jinstec.config;

import com.jinstec.security.LoginSuccessHandler;
import com.jinstec.security.LogoutSuccessHandler;
import com.jinstec.security.MyAccountService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author jins
 * @date on 2018/4/16.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http)throws Exception{
        loginSuccessHandler().setDefaultTargetUrl("/page/statistical-data");
        logoutSuccessHandler().setDefaultTargetUrl("/login");
        http.headers().frameOptions().disable();
        http.authorizeRequests()
                .antMatchers("/login")
                .permitAll();
        http.formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/j_spring_security_check")
                .usernameParameter("username")
                .passwordParameter("password")
                .failureUrl("/login?error=true")
                .permitAll()
                .successHandler(loginSuccessHandler())
                .and().logout().logoutUrl("/login?logout=true")
                .logoutSuccessHandler(logoutSuccessHandler())
                .and().sessionManagement().maximumSessions(1).expiredUrl("/login?expired=false");
        http.csrf().disable();
    }

    @Override
    public void configure(WebSecurity web){
        web.ignoring().antMatchers("/css/**","fonts/**","/img/**","/js/**");
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService(){
        return new MyAccountService();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
        auth.eraseCredentials(false);
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(4);
    }

    /**
     * 登录成功处理器
     *
     * @return LoginSuccessHandler
     */
    @Bean
    public LoginSuccessHandler loginSuccessHandler(){
        return new LoginSuccessHandler();
    }

    /**
     * 退出处理器
     *
     * @return LoginSuccessHandler
     */
    @Bean
    public LogoutSuccessHandler logoutSuccessHandler(){
        return new LogoutSuccessHandler();
    }

    /**
     * session 注册器
     * @return
     */
    @Bean
    public SessionRegistry getSessionRegistry(){
        return new SessionRegistryImpl();
    }

}
