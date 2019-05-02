package com.paisabazaar.kafka.dao;

import com.paisabazaar.kafka.bean.Producer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class ProducerDaoImp implements ProducerDao{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void createProducer(Producer producer) {
		 Session session = sessionFactory.getCurrentSession();
		 session.save(producer);
	}

	@Override
	public List<Producer> getProducer() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Producer> criteria = builder.createQuery(Producer.class);
		Root<Producer> root = criteria.from(Producer.class);
		criteria.select(root);
		Query<Producer> query = session.createQuery(criteria);
		return query.getResultList();
	}

	@Override
	public Producer findById(String id) {
		Session session = sessionFactory.getCurrentSession();
		// Create CriteriaBuilder
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Producer> criteria = builder.createQuery(Producer.class);
		Root<Producer> root = criteria.from(Producer.class);
		criteria.select(root).where(builder.equal(root.get("id"), id));
		Query<Producer> query = session.createQuery(criteria);
		return query.getSingleResult();
	}

	@Override
	public Producer update(Producer val, String id) {
		// ## Need to change it using CriteriaBuilder method.
		Session session = sessionFactory.getCurrentSession();
		Producer producer = session.get(Producer.class, id);
		// Set producer values here.
		// producer.setBuName(val.getBuName());
		session.update(producer);
		return producer;
	}

	public void delete(String id) {
		Session session = sessionFactory.getCurrentSession();
		Producer producer = findById(id);
		session.delete(producer);
	}

}
