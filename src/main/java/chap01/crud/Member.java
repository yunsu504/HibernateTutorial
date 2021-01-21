package chap01.crud;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity //Member Class는 Member Table로 매핑이 된다.
public class Member {
	
		@Id //Primary key로 만듬
		@GeneratedValue //자동으로 값이 올라간다. 
		private int id;
		
		private String name;
		private String message;
		
		public Member(){
		
		} //하이버네이트에서는 디폴트 생성자가 있어야함

		public Member(String name, String message) {
			super();
			this.name = name;
			this.message = message;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		@Override
		public String toString() {
			return "Member [id=" + id + ", name=" + name + ", message=" + message + "]";
		}
		
		
}
