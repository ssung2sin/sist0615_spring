package spring.anno.ex4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("logic") //id="logic"
public class LogicController {
	
	@Autowired
	//��Ȯ�� bean�� ���̵�� ����_��ȣ���� ���� ��쿡�� @resource(name="��Ȯ���̸�(ex.myDao)")
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
