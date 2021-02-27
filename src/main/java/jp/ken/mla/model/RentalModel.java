package jp.ken.mla.model;

import java.io.Serializable;

public class RentalModel implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int item_id;

	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
}
