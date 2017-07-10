package test.cglib;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class Hello {
	@MyComponent(value = 33,address = "44",name="55")
	public void say(String name,String id){
		System.out.println("hello      "+name+"       your num is    "+id);
	}
	@MyComponent(value = 33,address = "44",name="55")
	public void sad(){
		System.out.println("sad");
	}
	
}
