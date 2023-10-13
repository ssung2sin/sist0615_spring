package spring.anno.ex6;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ex6Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ApplicationContext app=new ClassPathXmlApplicationContext("annoContext4.xml");
		
		MysqlController my1=app.getBean("mysql", MysqlController.class);
		my1.insert("全己版");
		my1.delete("3");
		my1.select("价林康");
	}

}
