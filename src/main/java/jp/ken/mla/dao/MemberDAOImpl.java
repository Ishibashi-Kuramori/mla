package jp.ken.mla.dao;

import java.util.List;
import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import jp.ken.mla.entity.Member;

public class MemberDAOImpl implements MemberDAO<Member> {

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Member getById(int id) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("FROM Member WHERE member_id=?");
		query.setParameter(0, id);
		Member member = (Member)query.uniqueResult();
		session.close();
		return member;
	}
	
	@Override
	public List<Member> getByLogin(String email, String password) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("FROM Member WHERE email=? AND password=?");
		query.setParameter(0, email);
		query.setParameter(1, password);
		@SuppressWarnings("unchecked")
		List<Member> memberList = query.list();
		session.close();
		return memberList;
	}
	
	public List<Member> getByMail(String email) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("FROM Member WHERE email=?");
		query.setParameter(0, email);
		@SuppressWarnings("unchecked")
		List<Member> memberList = query.list();
		session.close();
		return memberList;
	}
	
	@Override
	public boolean insertMemberData(Member member) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		member.setJoin_date(new Date());
		member.setMake_date(new Date());
		member.setUpdate_date(new Date());

		try {
			session.saveOrUpdate(member);
			tx.commit();
			return true;
		} catch(HibernateException e) {
			tx.rollback();
			return false;
		} finally {
			session.close();
		}		
	}
	
	@Override
	public boolean updateMemberData(Member member) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		member.setUpdate_date(new Date());

		try {
			session.saveOrUpdate(member);
			tx.commit();
			return true;
		} catch(HibernateException e) {
			tx.rollback();
			return false;
		} finally {
			session.close();
		}		
	}

	@Override
	public boolean deleteMemberData(Member member) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			session.delete(member);
			tx.commit();
			return true;
		} catch(HibernateException e) {
			tx.rollback();
			return false;
		} finally {
			session.close();
		}		
	}
	
}
