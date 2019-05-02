package com.paisabazaar.kafka.service;


import com.paisabazaar.kafka.bean.User;

import java.util.List;

public interface ProducerService {
	public void createUser(User user);
	public List<User> getUser();
	public User findById(int id);
	public User update(User user, int id);
	public void deleteUserById(int id);
	public User updatePartially(User user, int id);
}