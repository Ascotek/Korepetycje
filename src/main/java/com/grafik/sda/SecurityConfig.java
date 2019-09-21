package com.grafik.sda;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails owner = User.withDefaultPasswordEncoder()
                .username("owner")
                .password("owner")
                .roles("OWNER")
                .build();

        UserDetails students = User.withDefaultPasswordEncoder()
                .username("students")
                .password("students123")
                .roles("STUDENTS")
                .build();

        return new InMemoryUserDetailsManager(owner, students);
    }

    protected void configure (HttpSecurity http) throws Exception{
    http.httpBasic().and().authorizeRequests()
            .antMatchers("/").permitAll()
            .and()
            .authorizeRequests().antMatchers("/console/**").permitAll()
            .and()
            .authorizeRequests()
            .antMatchers(HttpMethod.GET, "/Student/all").permitAll()
            .antMatchers(HttpMethod.POST, "/Student").hasRole("OWNER")
            .antMatchers(HttpMethod.PUT, "/Student").hasRole("OWNER")
            .antMatchers(HttpMethod.DELETE, "Student").hasRole("OWNER")
            .anyRequest().permitAll()
            .and()
            .formLogin().permitAll()
            .and()
            .logout().permitAll()
            .and()
            .csrf().disable();
        http.headers().frameOptions().disable();

    }


}
