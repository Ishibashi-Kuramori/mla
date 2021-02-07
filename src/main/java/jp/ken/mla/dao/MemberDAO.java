package jp.ken.mla.dao;

import java.util.List;

import jp.ken.mla.entity.Member;

public interface MemberDAO<T> {

	public T getById(int id);
	
	public List<T> getByLogin(String email, String password);

	public List<T> getByMail(String email);

	public boolean insertMemberData(Member member);
	public boolean updateMemberData(Member member);
	public boolean deleteMemberData(Member member);
}
