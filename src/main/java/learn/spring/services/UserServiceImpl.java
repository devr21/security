package learn.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import learn.spring.dao.GenericDao;
import learn.spring.dao.SuperUserDaoImpl;
import learn.spring.model.BaseModel;
import learn.spring.model.UserInfo;

@Service
public class UserServiceImpl {

	@Autowired
	@Qualifier("superUserDaoImpl")
	private GenericDao<BaseModel> userDao;

	public UserDetails getUserByUsername(String username) {
		
		 UserDetails ud =(UserInfo) ((SuperUserDaoImpl<UserInfo>)userDao).getUserByUsername(username);
		return ud;
	}
	
public void saveUser(UserInfo user) {
			userDao.save(user);
	}
	
	public void update(UserInfo user) {
		userDao.update(user);
	}
	public void deleteById(long id) {
		userDao.removeById(id);
	}
	public void delete(UserInfo user) {
		userDao.remove(user);
	}
	
	public List<BaseModel> getAllUsers(){
		return userDao.getAllUsers();
	}
	public BaseModel getUserById(long id) {
		return userDao.getById(id);
	}
	
}
