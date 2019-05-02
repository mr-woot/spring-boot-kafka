package com.paisabazaar.kafka.service;


import com.paisabazaar.kafka.bean.Producer;

import java.util.List;

public interface ProducerService {
	public void createProducer(Producer producer);
	public List<Producer> getProducer();
	public Producer findById(int id);
	public Producer update(Producer producer, int id);
	public void deleteProducerById(int id);
}
