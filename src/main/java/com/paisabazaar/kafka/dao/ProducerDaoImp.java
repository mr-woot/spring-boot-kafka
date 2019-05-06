package com.paisabazaar.kafka.dao;

import com.paisabazaar.kafka.bean.Producer;
import com.paisabazaar.kafka.utils.ApplicationUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Repository
public class ProducerDaoImp implements ProducerDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private ApplicationUtils utils;

    @Override
    public Producer createProducer(Producer producer) {
        producer.setProducerId(UUID.randomUUID().toString());
        sessionFactory.getCurrentSession().save(producer);
        return producer;
    }

    @Override
    public List<Producer> getProducer() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Producer> cq = cb.createQuery(Producer.class);
        Root<Producer> root = cq.from(Producer.class);
        cq.select(root);
        Query<Producer> query = session.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public Producer findById(String id) {
        return sessionFactory.getCurrentSession().get(Producer.class, id);
    }

    @Override
    public Producer update(Producer currentProducer, String id) {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaUpdate<Producer> criteria = builder.createCriteriaUpdate(Producer.class);
        Root<Producer> root = criteria.from(Producer.class);
        criteria.set(root.get("updatedAt"), new Date());
        // criteria.set("", "");
        criteria.where(builder.equal(root.get("producerId"), id));
        session.createQuery(criteria).executeUpdate();
        return currentProducer;
    }

    public void delete(String id) {
        Session session = sessionFactory.getCurrentSession();
        Producer book = session.byId(Producer.class).load(id);
        session.delete(book);
    }

}
