package learn.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import learn.spring.dao.SuperUserDaoImpl;
import learn.spring.model.UserInfo;

@Service
public class MyUserDetailsService implements UserDetailsService{

	@Autowired
	private SuperUserDaoImpl<UserInfo> userRepo;
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserDetails u = userRepo.getUserByUsername(username);
		if(u == null) {
			throw new UsernameNotFoundException("Username "+username+" not found");
		}
		return u;
	}

	
	
}
