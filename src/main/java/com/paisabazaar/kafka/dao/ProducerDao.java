package com.paisabazaar.kafka.dao;


import com.paisabazaar.kafka.bean.Producer;

import java.util.List;

public interface ProducerDao {
	public void createProducer(Producer producer);
	public List<Producer> getProducer();
	public Producer findById(String id);
	public Producer update(Producer producer, String id);
	public void delete(String id);
}
