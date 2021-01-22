package chap01.crud;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import util.HibernateUtil;

public class DaoCommon<T> { //�������� Ŭ������ �ޱ����� ���ʸ�

	private SessionFactory factory;
	private Class clazz;
	private String clazzName;
	
	public DaoCommon(Class<?> clazz){
		factory = HibernateUtil.getSessionFactory();
		this.clazz = clazz; 
		this.clazzName = clazz.getSimpleName(); 
	}

	public void delete(T selected) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.delete(selected);
		session.getTransaction().commit();
		
	}
	public void update(T selected) {
		Session session = factory.getCurrentSession();
		session.beginTransaction(); 
		session.update(selected);
		session.getTransaction().commit(); 
	}
	public T selectById(int id) {
		Session session = factory.getCurrentSession();
		session.beginTransaction(); 
		T selected = (T) session.get(clazz, id);
		session.getTransaction().commit(); 
		return selected;
	}
	//Refactory->Extract
	public void insert(T inserted) {
		Session session = factory.getCurrentSession();
		session.beginTransaction(); //Start
		session.save(inserted);
		session.getTransaction().commit(); //commit
	}
	public List<T> selectList(){
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Query query = session.createQuery("from " + clazzName);
		List<T> list = query.list();
		session.getTransaction().commit();
		return list;
		
	}
}