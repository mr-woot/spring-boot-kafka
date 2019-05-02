package com.paisabazaar.kafka.service;

import com.paisabazaar.kafka.bean.Producer;
import com.paisabazaar.kafka.dao.ProducerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProducerServiceImp implements ProducerService{
	@Autowired
    ProducerDao producerDao;

	public List<Producer> getProducer() {
		return producerDao.getProducer();
	}

	public Producer findById(String id) {
		return producerDao.findById(id);
	}

	public void createProducer(Producer Producer) {
		producerDao.createProducer(Producer);
	}

	public void deleteProducerById(String id) {
		producerDao.delete(id);
	}

	@Override
	public Producer update(Producer Producer, String id) {
		return producerDao.update(Producer, id);
	}

}
