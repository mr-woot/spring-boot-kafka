package com.paisabazaar.kafka.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;

@Component
public class CRUDUtils {
    private EntityManagerFactory entityManagerFactory;

    public Session getSession() {
        Session session = entityManagerFactory.unwrap(SessionFactory.class).openSession();
        return session;
    }

    public CriteriaBuilder getCriteriaBuilder() {
        CriteriaBuilder builder = this.getSession().getCriteriaBuilder();
        return builder;
    }
}
