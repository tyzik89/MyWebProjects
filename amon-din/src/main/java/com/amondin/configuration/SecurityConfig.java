package com.amondin.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    @Qualifier("UserDetailsServiceImpl")
    private UserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    //Configuration of authentication user
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(encoder());
    }

    //Конфигурация аутентификационных правил и доступа на страницы
    //К "/rest/bells" имеют доступ только зарегистрированные юзеры с ролью ROLE_USER
    //Порядок antMatchers ВАЖЕН! Первые указанные имеют больший приоритет
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/h2-console/", "/h2-console/**")
                    .permitAll()
                .antMatchers("rest/bells")
                    .permitAll()//hasRole("ROLE_USER")
                .antMatchers("/", "/**")
                    .permitAll()

            //Adding custom login page
            //.and() it's new section of configuration
            .and()
                .formLogin()
                    .loginPage("/login")
                    /*
                    //Change standard parameters of login: url for request, username and password attributes.
                    .loginProcessingUrl("/authenticate")
                    .usernameParameter("user")
                    .passwordParameter("pwd")
                    //Changes default page after successfully log, a second param of defaultSuccessUrl - set True
                    // if i force the user to the design page after login
                    .defaultSuccessUrl("/design")
                    */

            //This sets up a security filter that intercepts POST requests to /logout.
            .and()
                .logout()
                    .logoutSuccessUrl("/");
/*            //It's disable CSRF protection but it's bad.
            // <input type="hidden" name="_csrf" th:value="${_csrf.token}"/>
            // this include hidden field into the page for CSRF token
            .and()
                .csrf()
                .disable()*/
    }
}
