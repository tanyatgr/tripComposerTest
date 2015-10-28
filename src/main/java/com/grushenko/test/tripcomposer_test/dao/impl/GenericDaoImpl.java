package com.grushenko.test.tripcomposer_test.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;


import com.grushenko.test.tripcomposer_test.dao.GenericDao;

public abstract class GenericDaoImpl<T> implements GenericDao<T> {

	@PersistenceContext
	protected EntityManager em;

	private Class<T> type;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public GenericDaoImpl() {
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		type = (Class) pt.getActualTypeArguments()[0];
	}

	@Override
	public T save(final T t) {
		this.em.persist(t);
		return t;
	}

	@Override
	public void remove(final Object id) {
		this.em.remove(this.em.getReference(type, id));
	}

	@Override
	public T findById(final Object id) {
		return (T) this.em.find(type, id);
	}

	@Override
	public T update(final T t) {
		return this.em.merge(t);
	}

}
