package jcs.practice.service;

import java.util.List;

import jcs.practice.entity.User;

public interface DemoService {

    public String getString(int id);

    public String saveString(String s);

    public String updateString(int id, String s);

    public String deleteString(int id);

	public User getUser(int id);
	
	public User saveUser(User user);
	
	public boolean deleteUser(int id);

	public List<User> getAllUsers();
	
}
