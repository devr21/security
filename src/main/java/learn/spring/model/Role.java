package learn.spring.model;

import org.springframework.security.core.GrantedAuthority;

public class Role implements GrantedAuthority{

	private String role;
	
	public Role(String role) {
		this.role = role.toUpperCase();
	}

	public String getRole() {
		return role;
	}

	public String getAuthority() {
		return this.role;
	}
	
	
	
}
