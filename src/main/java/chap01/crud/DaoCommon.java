package chap01.crud;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import util.HibernateUtil;

public class DaoCommon<T> { //여러개의 클래스를 받기위한 제너릭

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
	
	//Paging
	private static  int numPerPage = 10;
    
    public List<?> getPagingList(int requestPage){
        Session session = factory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        Query query = (Query) session.createQuery("from "+clazzName+" order by id asc");
 
        query.setFirstResult((requestPage-1)*numPerPage); //numPerPage = 페이지당 게시글 수  
        query.setMaxResults(numPerPage); 
         
        List<?> members = query.list();
        tx.commit();
        return members;
    }
}
