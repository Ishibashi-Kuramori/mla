package jp.ken.mla.dao;

import java.util.List;

import jp.ken.mla.entity.Pay;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class PayDAOImpl implements PayDAO<Pay> {

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Pay> allList() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("FROM Pay");
		List<Pay> payList = query.list();
		session.close();
		return payList;
	}
}
