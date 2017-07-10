package test.pojo;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;

public class User implements Serializable{
	private String id;
	private String name;
	private Student student;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + "]";
	}
	
}
