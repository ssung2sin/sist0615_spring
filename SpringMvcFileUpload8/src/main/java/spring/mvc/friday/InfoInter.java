package spring.mvc.friday;

import java.util.List;

public interface InfoInter {

	public int getTotalCount();
	
	public void insertMyInfo(InfoDto dto);
	
	public List<InfoDto> getAllDatas();
	
	public InfoDto getData(String num);
	
	public void updateMyifo(InfoDto dto);
	
	public void deleteMyInfo(String num);
}
