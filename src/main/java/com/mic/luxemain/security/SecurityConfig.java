package com.mic.luxemain.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    AdminDetailService adminDetailService;

    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(adminDetailService)
                .passwordEncoder(encoder());


    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/item/**" , "/type/**", "/daily/**", "res/**")
               // .antMatchers("/item/read")
                .access("hasRole('ROLE_ADMIN')")
                .antMatchers("/" , "/**")
                .permitAll()

                .and()
                .formLogin()
                    .loginPage("/login")
                    .defaultSuccessUrl("/item/read")

                    //.failureUrl("/login?error")

                .and()
                    .logout()
                    .logoutSuccessUrl("/home")


                .and()
                .csrf()
                .ignoringAntMatchers("/h2-console/**")


            // Allow pages to be loaded in frames from the same origin; needed for H2-Console
                .and()
                    .headers()
                    .frameOptions()
                    .sameOrigin();

    }
}
