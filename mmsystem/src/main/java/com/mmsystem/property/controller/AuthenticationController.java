package com.mmsystem.property.controller;

import java.time.Instant;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mmsystem.property.dto.MmsUserCredential;
import com.mmsystem.property.model.MmsUser;
import com.mmsystem.property.security.SecurityConstants;
import com.mmsystem.property.security.TokenUtils;
import com.mmsystem.property.service.MmsUserService;

import jakarta.validation.Valid;
import static java.util.stream.Collectors.joining;


@RestController
@RequestMapping(path = "api/auth")
public class AuthenticationController {
	
	 private final Log logger = LogFactory.getLog(getClass());

	    @GetMapping(value = "/signin")
	    public ResponseEntity<String> signIn(jakarta.servlet.http.HttpServletResponse response)  {

	        try {

	            String uname = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    
	            logger.info("Principal/Username obtained from SecurityContextHolder: " + uname);
	            logger.info("Is Authenticated? : " + SecurityContextHolder.getContext().getAuthentication().isAuthenticated());
	    
	            String msg = "OK " + uname + " ! You have been Logged In!";
	            String token = TokenUtils.generateJWTUserToken(uname);  
	            logger.info("Generated JWT Token: " + token);

	            response.addHeader(SecurityConstants.AUTH_HEADER, SecurityConstants.BEARER_TOKEN_PREFIX + token);
	            return new ResponseEntity<>(msg, HttpStatus.OK);    

	        } catch (Exception ex) {
	            logger.info("Exception error: " + ex.getMessage()); 
	            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
	        }
	    }
//
//	  @PostMapping("register")
//	  public MmsUser register(@RequestBody @Valid MmsUser request) {
//	     userService.saveUser(request);
//	    
//	    return request;
//	  }

}
