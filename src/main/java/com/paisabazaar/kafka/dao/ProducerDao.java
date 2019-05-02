package com.paisabazaar.kafka.dao;


import com.paisabazaar.kafka.bean.Producer;

import java.util.List;

public interface ProducerDao {
	Producer createProducer(Producer producer);
	List<Producer> getProducer();
	Producer findById(String id);
	Producer update(Producer producer, String id);
	void delete(String id);
}
