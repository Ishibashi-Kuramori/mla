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

	@Override
	@SuppressWarnings("unchecked")
	public List<Item> top5List(int new_old) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("FROM Item WHERE new_old = ? ORDER BY can_rental_date DESC");
		query.setParameter(0, new_old);
		query.setMaxResults(5);
		List<Item> itemList = query.list();
		session.close();
		return itemList;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Item> searchList(String word) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("FROM Item WHERE item_name LIKE ?");
		query.setParameter(0, "%" + word + "%");
		List<Item> itemList = query.list();
		session.close();
		return itemList;
	}
}
