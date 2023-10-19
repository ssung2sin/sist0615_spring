package answer.data;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AnswerDao implements AnswerDaoInter {
	
	@Autowired
	private SqlSession session;
	
	@Override
	public List<AnswerDto> getAnswerList(int num) {
		// TODO Auto-generated method stub
		return session.selectList("selectNumOfReanswer",num);
	}

	@Override
	public void insertAnswer(AnswerDto dto) {
		// TODO Auto-generated method stub
		session.insert("insertOfReanswer",dto);
	}

	@Override
	public void deleteAnswer(String idx) {
		// TODO Auto-generated method stub
		session.delete("deleteOfReanswer",idx);
		
	}

	@Override
	public int passCheck(Map<String, String> map) {
		// TODO Auto-generated method stub
		System.out.println(map.get("idx")+","+map.get("check")); 
		return session.selectOne("checkPassOfReanswer",map);
		
	}

}
