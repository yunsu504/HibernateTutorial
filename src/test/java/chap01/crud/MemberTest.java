package chap01.crud;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

import util.HibernateUtil;

public class MemberTest {
	
	SessionFactory factory = HibernateUtil.getSessionFactory();
	private Member selectedMember;
	
	@Test
	public void test() {
		
		//Insert1
		Member member = new Member("yunsu", "Hello hibernate");
		insert(member);
		Member member1 = new Member("binna", "Hello hibernate");
		insert(member1);
		Member member2 = new Member("yunko", "Hello hibernate");
		insert(member2);
		//Select
		Member selectedMember = selectById(1);
		assertEquals("yunsu", selectedMember.getName());
		//Update
		selectedMember.setMessage("Hello world");
		update(selectedMember);
		Member updatedMember = selectById(1);
		assertEquals("Hello world", updatedMember.getMessage());
		//Delete
		delete(selectedMember);
		//Member deleteMember = selectById(2);
		//assertNull(deleteMember);*/
		//getList
		System.out.println(selectList());
		
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
		System.out.println(selectedMember.toString());
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
