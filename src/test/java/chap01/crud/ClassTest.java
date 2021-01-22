package chap01.crud;
import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

import chap04.BoardArticle;
import util.HibernateUtil;

public class ClassTest {
	
	SessionFactory factory = HibernateUtil.getSessionFactory();
	private Member selectedMember;
	
	@Test
	public void test() {
		
		Member member = new Member("admin", "Hi from now I'm King!");
		Member member1 = new Member("admin1", "Hi from now I'm King!");
		BoardArticle board = new BoardArticle("admin", "I'm back", new Date());
		
		DaoCommon<Member> memberClass = new DaoCommon<Member>(Member.class);
		DaoCommon<BoardArticle> boardClass = new DaoCommon<BoardArticle>(BoardArticle.class);
		
		memberClass.insert(member);
		memberClass.insert(member1);
		boardClass.insert(board);
		
		System.out.println(memberClass.selectById(1));
		
		member1 = new Member("admin3", "Hi from now I'm King!");
		memberClass.insert(member1);
		
	}
	
}
