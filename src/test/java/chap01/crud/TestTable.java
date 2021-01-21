package chap01.crud;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TestTable {
	@Id
	@GeneratedValue
	private int tableSeq;

	public TestTable() {
		
	}
	
	
}
