package jp.ken.mla.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mla_plan_mst")
public class Plan {

	@Id
	private int plan_id; // プランID
	
	private String plan_name; // プラン名
	private String plan_color; // プラン配色(Bootstrap準拠)
	private int monthly; // 月額
	private int limit_cnt; // 上限レンタル枚数(1000以上は無制限扱い)
	
	public int getPlan_id() {
		return plan_id;
	}
	public void setPlan_id(int plan_id) {
		this.plan_id = plan_id;
	}
	public String getPlan_name() {
		return plan_name;
	}
	public String getPlan_color() {
		return plan_color;
	}
	public void setPlan_color(String plan_color) {
		this.plan_color = plan_color;
	}
	public void setPlan_name(String plan_name) {
		this.plan_name = plan_name;
	}
	public int getMonthly() {
		return monthly;
	}
	public void setMonthly(int monthly) {
		this.monthly = monthly;
	}
	public int getLimit_cnt() {
		return limit_cnt;
	}
	public void setLimit_cnt(int limit_cnt) {
		this.limit_cnt = limit_cnt;
	}
}
