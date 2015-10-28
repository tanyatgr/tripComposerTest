package com.grushenko.test.tripcomposer_test.dao;

public interface GenericDao<T> {
	T save(T t);
	void remove(Object id);
	T findById(Object id);
	T update(T t);

}
