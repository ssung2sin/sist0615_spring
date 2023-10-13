package spring.anno.ex4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("logic") //id="logic"
public class LogicController {
	
	@Autowired
	//정확한 bean의 아이디로 주입_모호성이 없는 경우에는 @resource(name="정확한이름(ex.myDao)")
	DaoInter daoInter;
	
	public LogicController(MyDao dao) {
		this.daoInter=dao;
	}
	
	//insert
	public void insert(String str) {
		daoInter.insertData(str);
	}
	
	//delete
	public void delete(String num) {
		daoInter.deleteData(num);
	}
}
