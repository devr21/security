package test.config;

import java.io.Serializable;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public class BaseJPADao<T extends BaseModel> extends AbstractJPADao<T>{

	private Class<T> clazz;
	
	public void setClazz(Class<T> clazz) {
		this.clazz = clazz;
	}
	
	public void save(T entity) {
		initTransaction();
		em.persist(entity);
		closeTransaction();
	}

	public void update(T entity) {
		initTransaction();
		em.merge(entity);
		closeTransaction();
	}

	public void remove(T entity) {
		initTransaction();
		em.remove(entity);
		closeTransaction();
	}

	public void removeById(long id) {
		initTransaction();
		String query = "DELETE From "+this.clazz.getName()+" clas where clas.id="+id;
		em.createQuery(query).executeUpdate();
		closeTransaction();
	}

	public T getById(long id) {
		initTransaction();
		T entity = em.find(this.clazz, id);
		closeTransaction();
		return entity;
	}

	public List<T> getAllUsers() {
		initTransaction();
		List<T> entities = em.createQuery("From "+clazz.getName()).getResultList();
		closeTransaction();
		return entities;
	}
	
}
