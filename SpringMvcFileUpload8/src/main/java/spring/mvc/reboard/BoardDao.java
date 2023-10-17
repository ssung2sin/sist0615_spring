package spring.mvc.reboard;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDao implements BoardDaoInter{

	@Autowired
	private SqlSession session;
	
	@Override
	public int getTotalCount() {
		// TODO Auto-generated method stub
		return session.selectOne("getTotalCountOfReboard");
	}

	@Override
	public int getMaxNum() {
		// TODO Auto-generated method stub
		return session.selectOne("maxNumOfReboard");
	}

	@Override
	public void updateRestep(int regroup, int restep) {
		// TODO Auto-generated method stub
		HashMap<String, Integer>map=new HashMap<String, Integer>();
		map.put("regroup", regroup);
		map.put("restep", restep);
		session.update("updateStepOfReboard",map);
		
	}

	@Override
	public void insertReboard(BoardDto dto) {
		// TODO Auto-generated method stub
		int num=dto.getNum();
		int regroup=dto.getRegroup();
		int restep=dto.getRestep();
		int relevel=dto.getRelevel();
		
		if(num==0) {	//새 글
			regroup=getMaxNum()+1;
			restep=0;
			relevel=0;
		}else {
			//같은 그룹중 전달받은 restep보다 큰 글들은 모두 +1
			this.updateRestep(regroup, restep);
			
			//전달받은 step과 level모두 +1
			restep++;
			relevel++;
			
		}
		
		dto.setRegroup(regroup);
		dto.setRestep(restep);
		dto.setRelevel(relevel);
		
		session.insert("insertOfReboard",dto);
	}

	@Override
	public List<BoardDto> getPerPagingList(int start, int perPage) {
		// TODO Auto-generated method stub
		Map<String, Integer>map=new HashMap<String, Integer>();
		
		map.put("start", start);
		map.put("perPage", perPage);
		
		
		return session.selectList("selectPagingOfReboard", map);
	}
	
	@Override
	public BoardDto getData(int num) {
		// TODO Auto-generated method stub
		return session.selectOne("getDateOfReboard", num);
	}

	@Override
	public void updateReadcount(int num) {
		// TODO Auto-generated method stub
		session.update("readcountPlusOfReboard",num);
	}

	@Override
	public int getCheckPass(String num, String pass) {
		// TODO Auto-generated method stub
		HashMap<String, String>map=new HashMap<String, String>();
		
		map.put("num", num);
		map.put("pass", pass);
		
		return session.selectOne("checkPassOfReboard",map);
	}

	@Override
	public void updateReboard(BoardDto dto) {
		// TODO Auto-generated method stub
		session.update("updateOfReboard",dto);
	}

	@Override
	public void deleteReboard(String num) {
		// TODO Auto-generated method stub
		session.delete("deleteOfReboard",num);
	}

}
