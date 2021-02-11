package jp.ken.mla.dao;

import java.util.List;

public interface ItemDAO<T> {
	public List<T> allList();
	public List<T> top5List(int new_old);
	public List<T> searchList(String word);
}
