package test.config;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import learn.spring.model.UserInfo;
import learn.spring.services.MyUserDetailsService;

public class Test {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		
		ctx.scan(new String[] {"test.config","learn.spring.dao","learn.spring.model","learn.spring.services"});
		ctx.refresh();
		MyUserDetailsService service = ctx.getBean(MyUserDetailsService.class);
		
		try {
			UserInfo user1 = new UserInfo("first","firstpass","Role_Anonymous");
			UserInfo user2 = new UserInfo("second","firstpass","Role_ADMin");
			UserInfo user3 = new UserInfo("third","firstpass","Role_User");
			
/*			service.saveUser(user1);
			service.saveUser(user2);
			user1.setUsername("changedfirst");
			List<UserInfo> users =service.getAllUsers();
			for(UserInfo user:users)
			System.out.println("username: "+user.getUsername());
			service.update(user1);

			service.delete(user1);
			service.getUserById(3);*/
		}
		catch(Exception e) {
			
		}
		
		
	}
	
}
