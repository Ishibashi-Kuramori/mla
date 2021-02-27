package jp.ken.mla.dao;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import jp.ken.mla.entity.Rental;

public class RentalDAOImpl implements RentalDAO<Rental> {

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public List<Rental> getByMemberId(int id) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("FROM Rental WHERE member_id=?");
		query.setParameter(0, id);
		@SuppressWarnings("unchecked")
		List<Rental> rentalList = query.list();
		session.close();
		return rentalList;
	}
	
	@Override
	public List<Integer> getByRentalItemIds(int id) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("FROM Rental WHERE member_id=?");
		query.setParameter(0, id);
		@SuppressWarnings("unchecked")
		List<Rental> rentalList = query.list();
		List<Integer> retList = new ArrayList<Integer>();
		for(int i = 0; i < rentalList.size(); i++) {
			Rental rental = rentalList.get(i);
			retList.add(rental.getItem_id());
		}
		session.close();
		return retList;
	}
	
	@Override
	public Rental getByItemMemberId(int item_id, int member_id) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("FROM Rental WHERE item_id=? AND member_id=?");
		query.setParameter(0, item_id);
		query.setParameter(1, member_id);
		Rental rental = (Rental)query.uniqueResult();
		session.close();
		return rental;
	}

	@Override
	public boolean insertRentalData(Rental rental) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		rental.setHope_order(1);
		rental.setSend_flag(0);
		rental.setReturn_flag(0);
		rental.setOrder_date(new Date());
		rental.setMake_date(new Date());
		rental.setUpdate_date(new Date());

		try {
			session.saveOrUpdate(rental);
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
	public boolean updateRentalData(Rental rental) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		rental.setUpdate_date(new Date());

		try {
			session.saveOrUpdate(rental);
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
	public boolean deleteRentalData(Rental rental) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			session.delete(rental);
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
