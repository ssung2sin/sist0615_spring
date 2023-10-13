package spring.mysql.carmember;

import java.util.List;

public interface CarMemberInter {
	public int getTotalCount();
	//insert
	public void insert(CarMemberDto dto);
	//allselect
	public List<CarMemberDto> allSelect();
	//getdata
	public CarMemberDto getData(String num);
	
	public void update(CarMemberDto dto);
	
	public void delete(String num);
}
