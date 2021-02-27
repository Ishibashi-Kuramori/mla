package jp.ken.mla.dao;

import java.util.List;

import jp.ken.mla.entity.Rental;

public interface RentalDAO<T> {
	public List<T> getByMemberId(int id);
	public List<Integer> getByRentalItemIds(int id);
	public T getByItemMemberId(int item_id, int member_id);
	
	public boolean insertRentalData(Rental rental);
	public boolean updateRentalData(Rental rental);
	public boolean deleteRentalData(Rental rental);
}
