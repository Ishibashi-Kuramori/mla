package jp.ken.mla.model;

import java.io.Serializable;
import java.util.Date;

//import org.hibernate.validator.constraints.NotEmpty;

import jp.ken.mla.entity.Plan;

//import org.hibernate.validator.constraints.Email;

public class LoginModel implements Serializable {
	private static final long serialVersionUID = 1L;

	private int member_id = 0;

//	@NotEmpty(message="名前は必須入力です。")
	private String name = "Guest User";

//	@NotEmpty(message="Emailは必須入力です。")
//	@Email(message="Emailの形式に誤りがあります。")
	private String email;

//	@NotEmpty(message="Passwordは必須入力です。")
	private String password;

	private int admin = 0;
	private int plan_id = 0;
	private int pay_id = 0;
	private int total_point = 0;
	private int icon_idx = 0;
	private Date join_date;
	private Date make_date;
	private Date update_date;
	private Plan plan;

	public Plan getPlan() {
		return plan;
	}
	public void setPlan(Plan plan) {
		this.plan = plan;
	}
	public int getMember_id() {
		return member_id;
	}
	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAdmin() {
		return admin;
	}
	public void setAdmin(int admin) {
		this.admin = admin;
	}
	public int getPlan_id() {
		return plan_id;
	}
	public void setPlan_id(int plan_id) {
		this.plan_id = plan_id;
	}
	public int getPay_id() {
		return pay_id;
	}
	public void setPay_id(int pay_id) {
		this.pay_id = pay_id;
	}
	public int getTotal_point() {
		return total_point;
	}
	public void setTotal_point(int total_point) {
		this.total_point = total_point;
	}
	public int getIcon_idx() {
		return icon_idx;
	}
	public void setIcon_idx(int icon_idx) {
		this.icon_idx = icon_idx;
	}
	public Date getJoin_date() {
		return join_date;
	}
	public void setJoin_date(Date join_date) {
		this.join_date = join_date;
	}
	public Date getMake_date() {
		return make_date;
	}
	public void setMake_date(Date make_date) {
		this.make_date = make_date;
	}
	public Date getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(Date update_date) {
		this.update_date = update_date;
	}
}
