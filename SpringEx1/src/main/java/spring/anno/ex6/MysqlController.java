package spring.anno.ex6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("mysql")
public class MysqlController {
	
	@Autowired
	TestDao tdao;
	
	public void insert(String irum) {
		tdao.insert(irum);
	}
	public void delete(String no) {
		tdao.delete(no);
	}
	public void select(String irum) {
		tdao.select(irum);
	}
}
