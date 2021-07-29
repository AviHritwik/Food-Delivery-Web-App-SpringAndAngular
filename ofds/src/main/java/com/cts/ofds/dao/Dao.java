package com.cts.ofds.dao;

import java.util.List;
import java.util.Optional;

public interface Dao<T,ID> {
	List<T> list();
	
	Optional<T> get(ID id);
	
	int update(T t,ID id);
	
	int add(T t);
	
	int delete(ID id);
}
