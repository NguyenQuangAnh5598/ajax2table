//package com.security;
//
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("anh").password("{roop}123").roles("User")
//                .and()
//                .withUser("em").password("{roop}123").roles("Admin");
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests().antMatchers("/").permitAll()
//                .and()
//                .authorizeRequests().antMatchers("/blog/home").hasRole("User")
//                .and()
//                .authorizeRequests().antMatchers("/admin**").hasRole("Admin")
//                .and()
//                .formLogin()
//                .and()
//                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
//    }
//}
