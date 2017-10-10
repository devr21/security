package learn.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import learn.spring.dao.UserDao;
import learn.spring.model.UserInfo;
import test.config.GenericDao;

@Service
public class MyUserDetailsService implements UserDetailsService{

	@Autowired
	private UserServiceImpl userService;
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserDetails u = userService.getUserByUsername(username);
		if(u == null) {
			throw new UsernameNotFoundException("Username "+username+" not found");
		}
		return u;
	}

	
	
}
