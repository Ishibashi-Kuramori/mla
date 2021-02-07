package jp.ken.mla.dao;

import java.util.List;

public interface PlanDAO<T> {
	public List<T> allList();
	
	public T getById(int id);
}
