package test.cglib;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class Test {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-aop.xml");
		BeanFactory bf = new XmlBeanFactory(new ClassPathResource("spring/spring-aop.xml"));
        Hello hello = (Hello) context.getBean("hello");
        hello.say("zhang","234");
	}
}
