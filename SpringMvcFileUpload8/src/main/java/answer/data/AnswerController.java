package answer.data;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import spring.mvc.reboard.BoardDaoInter;

@Controller
public class AnswerController {
	
	@Autowired
	AnswerDao dao;
	
	@Autowired
	BoardDaoInter binter;
	
	@PostMapping("/board/ainsert")
	public String insert(@ModelAttribute("dto")AnswerDto dto,
			@RequestParam int currentPage) {
		
		dao.insertAnswer(dto);
		binter.minusReadcount(dto.getNum());
		
		return "redirect:content?num="+dto.getNum()+"&currentPage="+currentPage;
	}
	
	@GetMapping("/board/delCheck")
	@ResponseBody
	public Map<String, Integer> answerDelete(@RequestParam String check, 
			@RequestParam int num,@RequestParam String idx) {
		
		Map<String, String>map=new HashMap<String, String>();
		
		map.put("idx", idx);
		map.put("check", check);
		int res=dao.passCheck(map);
		if(res==1) {
			dao.deleteAnswer(idx);
			binter.minusReadcount(num);
		}
		Map<String, Integer>resMap=new HashMap<String, Integer>();
		
		resMap.put("count", res);
		
		return resMap;
	}
	
}
