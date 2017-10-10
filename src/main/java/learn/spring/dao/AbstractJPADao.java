package learn.spring.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import learn.spring.model.BaseModel;

@Transactional
public abstract class AbstractJPADao<T extends BaseModel> implements GenericDao<T>{

	@Autowired
	private EntityManagerFactory emf;
	
	protected EntityManager em;
	
	protected void initTransaction() {
		if(em == null) {
			em = emf.createEntityManager();
		}
		em.getTransaction().begin();
	}
	
	protected void closeTransaction() {
		em.flush();
		em.getTransaction().commit();
	}
	
}