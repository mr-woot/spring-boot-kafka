package com.paisabazaar.kafka.dao;

import com.paisabazaar.kafka.bean.Producer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
		@SuppressWarnings("unchecked")
		List<Producer> list= session.createCriteria(Producer.class).list();
		return list;
	}

	@Override
	public Producer findById(String id) {
		Session session = sessionFactory.getCurrentSession();
		Producer producer=(Producer) session.get(Producer.class,id);
		return producer;
	}

	@Override
	public Producer update(Producer val, String id) {
		Session session = sessionFactory.getCurrentSession();
		Producer producer =(Producer)session.get(Producer.class, id);
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
