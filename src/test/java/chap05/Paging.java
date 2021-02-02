package chap05;

import static org.junit.Assert.*;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.junit.Test;

import chap01.crud.DaoCommon;

public class Paging {

	@Test
	public void test() throws NumberFormatException, IOException, ParseException {
		DaoCommon<BoardArticle> daoBoard = new DaoCommon<BoardArticle>(BoardArticle.class);
		
		List<BoardArticle> list = FileReader_CVS.getArticles();
		for (BoardArticle boardArticle : list){
			daoBoard.insert(boardArticle);
		}
		List<BoardArticle> pagingList1 = (List<BoardArticle>) daoBoard.getPagingList(1);
		System.out.println("첫번째 페이지");
		for (BoardArticle boardArticle : pagingList1){
			System.out.println(boardArticle);
		}
		
		List<BoardArticle> pagingList2 = (List<BoardArticle>) daoBoard.getPagingList(2);
		System.out.println("두번째 페이지");
		for (BoardArticle boardArticle : pagingList1){
			System.out.println(boardArticle);
		}
	}

}
