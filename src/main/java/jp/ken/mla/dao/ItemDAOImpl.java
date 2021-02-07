package jp.ken.mla.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import jp.ken.mla.entity.Item;

public class ItemDAOImpl implements ItemDAO<Item> {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Item> allList() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("FROM Item");
		List<Item> itemList = query.list();
		session.close();
		return itemList;
	}
}
