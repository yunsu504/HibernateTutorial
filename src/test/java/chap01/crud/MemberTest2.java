package chap01.crud;
//DAO로 분리! 하지만  Member에만 종속 BoardArticle 생성
import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

import util.HibernateUtil;

public class MemberTest2 {
	
	SessionFactory factory = HibernateUtil.getSessionFactory();
	private Member selectedMember;
	
	@Test
	public void test() {
		
	
		Member member = new Member("admin", "Hi from now I'm King!");
		Member member1 = new Member("admin1", "Hi from now I'm King!");
		DaoMember daoMember = new DaoMember();
		daoMember.insert(member);
		selectedMember = daoMember.selectById(1);
		selectedMember.setMessage("Hello world");
		daoMember.update(selectedMember);
		daoMember.delete(selectedMember);
		daoMember.selectList();
		System.out.println(daoMember.selectList());
	}
	

}
