package spring.di.ex3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SawonMain {

	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("appContext3.xml");
		
		Sawon sw=context.getBean("sawon", Sawon.class);
		sw.writeData();
	}
}
