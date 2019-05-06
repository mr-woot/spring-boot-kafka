package com.paisabazaar.kafka.service;

import com.paisabazaar.kafka.bean.Producer;
import com.paisabazaar.kafka.dao.ProducerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ProducerServiceImp implements ProducerService{
	@Autowired
    ProducerDao producerDao;

	@Override
	public List<Producer> getProducer() {
		return producerDao.getProducer();
	}

	@Override
	public Producer findById(String id) {
		return producerDao.findById(id);
	}

	@Transactional
	@Override
	public Producer createProducer(Producer Producer) {
		return producerDao.createProducer(Producer);
	}

	@Transactional
	@Override
	public void deleteProducerById(String id) {
		producerDao.delete(id);
	}

	@Transactional
	@Override
	public Producer update(Producer producer, String id) {
		return producerDao.update(producer, id);
	}

}
