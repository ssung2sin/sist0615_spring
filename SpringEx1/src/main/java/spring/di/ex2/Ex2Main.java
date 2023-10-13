package spring.di.ex2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ex2Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context=new ClassPathXmlApplicationContext("appContext2.xml");
		
		Myinfo my1=(Myinfo)context.getBean("my");
		
		System.out.println(my1);
		System.out.println(my1.toString());
		
		//Person
		Person per1=context.getBean("person", Person.class);
		per1.writeData();
	}

}
