package chap01.crud;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import util.HibernateUtil;

public class DaoMember {

	private SessionFactory factory;
		
	public DaoMember(){
		factory = HibernateUtil.getSessionFactory();
	}
	
	public void delete(Member selectedMember) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.delete(selectedMember);
		session.getTransaction().commit();
		
	}
	public void update(Member selectedMember) {
		Session session = factory.getCurrentSession();
		session.beginTransaction(); 
		session.update(selectedMember);
		session.getTransaction().commit(); 
	}
	public Member selectById(int id) {
		Session session = factory.getCurrentSession();
		session.beginTransaction(); 
		Member selectedMember = (Member) session.get(Member.class, id);
		session.getTransaction().commit(); 
		return selectedMember;
	}
	//Refactory->Extract
	public void insert(Member member) {
		Session session = factory.getCurrentSession();
		session.beginTransaction(); //Start
		session.save(member);
		session.getTransaction().commit(); //commit
	}
	public List<Member> selectList(){
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Query query = session.createQuery("from Member");
		List<Member> list = query.list();
		session.getTransaction().commit();
		return list;
		
	}
}
