package com.humana.dhp.eventproc.service.catalogservice.config;

import com.azure.spring.autoconfigure.aad.AADAppRoleStatelessAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@RequiredArgsConstructor
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final AADAppRoleStatelessAuthenticationFilter aadAuthFilter;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();

        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER);

        http.authorizeRequests()
                .antMatchers("/", "/index.html", "/public").permitAll()
                .anyRequest().authenticated();
        http.addFilterBefore(aadAuthFilter,
                UsernamePasswordAuthenticationFilter.class);

    }
}