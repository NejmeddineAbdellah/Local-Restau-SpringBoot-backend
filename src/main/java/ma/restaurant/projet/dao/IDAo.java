package ma.restaurant.projet.dao;

import java.util.List;

public interface IDAo<T> {

	T save(T o);

	List<T> findAll();

	T findById(int id);

	void update(T o);

	void delete(T o);

}
