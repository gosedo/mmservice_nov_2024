package com.mmsystem.property.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.server.resource.web.BearerTokenAuthenticationEntryPoint;
import org.springframework.security.oauth2.server.resource.web.access.BearerTokenAccessDeniedHandler;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class CustomSecurityConfig {

    @Autowired
    private AuthenticationConfiguration authenticationConfiguration;
    
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
	    return new BCryptPasswordEncoder();
	}
	
	@Bean
    public AuthenticationManager authManager() throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
	
   @Bean
    public CustomTokenFilter customFilter() throws Exception {
        return new CustomTokenFilter(authManager());
    }
   //testing
    @Bean
    public SecurityFilterChain filterChain1(HttpSecurity http) throws Exception {

    	// Enable CORS and disable CSRF
        http.cors().and().csrf().disable();

        // Set session management to stateless
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        
     // Set unauthorized requests exception handler
        http.exceptionHandling(
            (exceptions) ->
                exceptions
                    .authenticationEntryPoint(new BearerTokenAuthenticationEntryPoint())
                    .accessDeniedHandler(new BearerTokenAccessDeniedHandler()));
       
        http   
        .authorizeHttpRequests(authorize -> authorize.requestMatchers("api/auth/signin").authenticated()
                .requestMatchers("api/auth/signup").authenticated());
        
        http
        //.authorizeHttpRequests().anyRequest().permitAll();
        .authorizeHttpRequests(authorize -> authorize.requestMatchers("api/issue/mmsissue").permitAll()
        		.requestMatchers("api/issue/mmsissue-list").authenticated()
        		.requestMatchers("/issue/mmsissue-save").authenticated());
        
          
//            .authorizeHttpRequests(authorize -> authorize.requestMatchers("/issue/mmsissue-list").permitAll()
//                    .requestMatchers("/issue/mmsissue-save").authenticated())
//
//            .authorizeHttpRequests(authorize -> authorize.requestMatchers("/users").hasRole("ADMIN")
//                                                     .requestMatchers("/items").hasAnyRole("ADMIN", "USER")
//            )
//            ;
           
        //http.httpBasic();
        //http.addFilterBefore( new CustomTokenFilter(authenticationConfiguration.getAuthenticationManager()), UsernamePasswordAuthenticationFilter.class);    // OK ---
        http.addFilterBefore( customFilter(), UsernamePasswordAuthenticationFilter.class);    // OK ---

        return http.build();
    } 

}
