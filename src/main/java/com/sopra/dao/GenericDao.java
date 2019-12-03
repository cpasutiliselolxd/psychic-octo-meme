package com.sopra.dao;

	import java.util.List;

	public interface GenericDao<T,K> {
	List<T> findAll();
	T findByKey(K id);
	void update(T obj);
	void deleteByKey(K key);
	T insert(T obj);
	}


