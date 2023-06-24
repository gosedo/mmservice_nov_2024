package com.mmsystem.property.security;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mmsystem.property.model.MmsUser;
import com.mmsystem.property.model.MmsUserRole;
import com.mmsystem.property.repo.UserRepository;
import com.mmsystem.property.service.MmsUserService;

//public class CustomUserDetailsService {
@Service
public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	private MmsUserService userService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	
	public boolean saveUser(MmsUser user) {
		String passwd= user.getUserPassword();
		String encodedPasswod = passwordEncoder.encode(passwd);
		user.setUserPassword(encodedPasswod);
		//user = userRepo.save(user);
		return userService.saveUser(user);
	}
	
	@Override
	public UserDetails loadUserByUsername(String email) 
			throws UsernameNotFoundException {
		
		Optional<MmsUser> opt = Optional.of(userService.getByEmail(email));
		List<MmsUserRole> roleList = new ArrayList<MmsUserRole>();
		//roleList.addAll(opt.get().getUserRoles());
		roleList.addAll(opt.get().getUserRoles());
						
		if(opt.isEmpty())
				throw new UsernameNotFoundException("User with email: " +email +" not found !");
		else {
			MmsUser user = opt.get();
			return new org.springframework.security.core.userdetails.User(
					user.getUserEmail(),
					passwordEncoder.encode(user.getUserPassword()),//user.getUserPassword(),
					roleList
					.stream()
					.map(role -> new SimpleGrantedAuthority(role.getUsrRoleCode()))
					.collect(Collectors.toSet())
		    );
		}
		
	}
}