package jp.ken.mla.dao;

import java.util.List;
//import java.util.Date;

//import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;

import jp.ken.mla.entity.Rental;

public class RentalDAOImpl implements RentalDAO<Rental> {

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public List<Rental> getByMemberId(int id) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("FROM Rental WHERE member_id=?");
		query.setParameter(0, id);
		@SuppressWarnings("unchecked")
		List<Rental> rentalList = query.list();
		session.close();
		return rentalList;
	}
}
