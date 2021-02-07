package jp.ken.mla.dao;

import java.util.List;

import jp.ken.mla.entity.Member;
import jp.ken.mla.entity.Plan;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class PlanDAOImpl implements PlanDAO<Plan> {

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Plan> allList() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("FROM Plan");
		List<Plan> planList = query.list();
		session.close();
		return planList;
	}
	
	@Override
	public Plan getById(int id) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("FROM Plan WHERE plan_id=?");
		query.setParameter(0, id);
		Plan plan = (Plan)query.uniqueResult();
		session.close();
		return plan;
	}
}
