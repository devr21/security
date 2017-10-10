package learn.spring.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import learn.spring.model.BaseModel;
import learn.spring.model.UserInfo;

@Repository
@Transactional
public class SuperUserDaoImpl<T extends BaseModel> extends BaseJPADao<BaseModel>{
	
	@PostConstruct
	public void init() {
		UserInfo user1 = new UserInfo("user","password","Role_user");
		UserInfo user2 = new UserInfo("admin","admin","role_admin");
		initTransaction();
			em.persist(user1);
			em.persist(user2);
		closeTransaction();
	}
	
	public BaseModel getUserByUsername(String user) {
		initTransaction();
		List<UserInfo> users = em.createQuery("From UserInfo where username=:user").setParameter("user", user).getResultList();
		closeTransaction();
		if(users.isEmpty())
			return null;
		return users.iterator().next();
	}

}
