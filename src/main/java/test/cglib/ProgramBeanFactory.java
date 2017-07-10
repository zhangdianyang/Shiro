package test.cglib;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

public class ProgramBeanFactory{
	
	public static void main(String[] args) {
		ClassPathResource resource = new ClassPathResource("/spring/spring-test.xml");
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions(resource);
		Person person = factory.getBean("person",Person.class);
		person.info();
	}
	
	/*public static void main(String[] arge) {
		ApplicationContext context = new FileSystemXmlApplicationContext("classpath:/spring/spring-*.xml");
		SecurityManager securityManager = context.getBean("securityManager",SecurityManager.class);
	
	}*/
}

