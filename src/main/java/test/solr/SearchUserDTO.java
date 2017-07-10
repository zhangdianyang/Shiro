package test.solr;

import org.apache.solr.client.solrj.beans.Field;

public class SearchUserDTO {
	@Field
	private String custNo;
	@Field
	private String username;
	@Field
	private String email;
	@Field
	private int age;
	
	public String getCustNo() {
		return custNo;
	}
	public void setCustNo(String custNo) {
		this.custNo = custNo;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	} 
}
