package com.paisabazaar.kafka.service;


import com.paisabazaar.kafka.bean.Producer;

import java.util.List;

public interface ProducerService {
	Producer createProducer(Producer producer);
	List<Producer> getProducer();
	Producer findById(String id);
	Producer update(Producer producer, String id);
	void deleteProducerById(String id);
}
