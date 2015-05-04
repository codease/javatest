package com.centling.demo.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.centling.demo.base.BaseHibernateDAO;
import com.centling.demo.entity.Person;

@Repository("personDAO")
@Transactional
public class PersonDAOImpl extends BaseHibernateDAO implements PersonDAO {

	@Override
	public List<Person> findAll() {
		try {
			String queryString = "from Person";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			throw re;
		}
	}

	@Override
	public void add(Person person) {
		this.getSession().save(person);
	}

	@Override
	public void deleteById(String id) {
		try {
			String hql = "delete Person p where p.id=?";
			Query queryObject = getSession().createQuery(hql);
			queryObject.setParameter(0, id);
			queryObject.executeUpdate();
		} catch (RuntimeException re) {
			throw re;
		}
	}

}
