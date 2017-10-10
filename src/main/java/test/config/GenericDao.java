package test.config;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<T extends BaseModel> {

	void save(T entity);
	void update(T entity);
	void remove(T entity);
	void removeById(long id);
	T getById(long id);
	List<T> getAllUsers();
	
	
}
