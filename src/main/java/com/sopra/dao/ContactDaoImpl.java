package com.sopra.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.sopra.dao.utils.Context;
import com.sopra.model.Contact;
import com.sopra.model.Contact;

public class ContactDaoImpl implements ContactDao{

	EntityManager em = Context.getInstance().getEmf().createEntityManager();

	@Override
	public List findAll() {
		Query q = em.createQuery("from Contact");
		return q.getResultList();
	}

	@Override
	public Contact insert(Contact obj) {
		try {
			em.getTransaction().begin();
			em.persist(obj);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public Contact findByKey(Integer key) {
		Contact a = em.find(Contact.class, key);
		return a;
	}

	@Override
	public void update(Contact obj) {
		Contact a = null;
		try {
			em.getTransaction().begin();
			a = em.merge(obj);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
	}

	@Override
	public void deleteByKey(Integer key) {
		Contact a = em.find(Contact.class, key);
		try {
			em.getTransaction().begin();
			if (a != null) {
				em.remove(a);
			}
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
	}

}
