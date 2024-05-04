package ite.computer_management.dao;

import java.util.ArrayList;

import ite.computer_management.model.Computer;

public interface DAOInterface<T> {
	int insert(T t);
	int delete(T t);
	int update(T t);
	ArrayList<T> selectAll();
	T selectById(T t);
	ArrayList<T> selectByCondition(String condition);
	int update(T t, String condition);
	
	
}
