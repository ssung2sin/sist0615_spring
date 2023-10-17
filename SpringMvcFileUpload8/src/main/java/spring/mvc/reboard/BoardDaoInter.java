package spring.mvc.reboard;

import java.util.List;

public interface BoardDaoInter {
	
	public int getTotalCount();
	
	public int getMaxNum();
	
	public void updateRestep(int regroup,int restep);
	
	public void insertReboard(BoardDto dto);

	public List<BoardDto> getPerPagingList(int start,int perPage);
	
	public BoardDto getData(int num);
	
	public void updateReadcount(int num);
	
	public int getCheckPass(String num,String pass);
	
	public void updateReboard(BoardDto dto);
	
	public void deleteReboard(String num);
}