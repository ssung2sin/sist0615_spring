package spring.mvc.friday;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

@Repository
public class InfoDao implements InfoInter {
	
	@Autowired
	SqlSession session;
	
	@Override
	public int getTotalCount() {
		// TODO Auto-generated method stub
		return session.selectOne("selectTotalCountOfMyInfo");
	}

	@Override
	public void insertMyInfo(InfoDto dto) {
		// TODO Auto-generated method stub
		session.insert("insertOfmyInfo",dto);
	}

	@Override
	public List<InfoDto> getAllDatas() {
		// TODO Auto-generated method stub
		return session.selectList("selectAllOfMyInfo");
	}

	@Override
	public InfoDto getData(String num) {
		// TODO Auto-generated method stub
		return session.selectOne("getDataOfMyInfo", num);
	}

	@Override
	public void updateMyifo(InfoDto dto) {
		// TODO Auto-generated method stub
		session.update("updateOfMyInfo",dto);
		
	}

	@Override
	public void deleteMyInfo(String num) {
		// TODO Auto-generated method stub
		session.delete("deleteOfMyInfo",num);
		
	}

}
