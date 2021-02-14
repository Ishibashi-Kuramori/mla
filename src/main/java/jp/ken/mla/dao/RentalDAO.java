package jp.ken.mla.dao;

import java.util.List;

//import jp.ken.mla.entity.Rental;

public interface RentalDAO<T> {
	public List<T> getByMemberId(int id);	
}
