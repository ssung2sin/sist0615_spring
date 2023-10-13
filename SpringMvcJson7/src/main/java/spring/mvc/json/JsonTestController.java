package spring.mvc.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller /*json 처리 전용 컨트롤러*/
public class JsonTestController {

	@GetMapping("/list1")
	@ResponseBody //json으로 처리하고 브라우저로 출력하는 annotation
	public Map<String, String> list1(){
		Map<String, String>map=new HashMap<String, String>();
		
		map.put("name", "장순영");
		map.put("hp", "010-222-3333");
		map.put("addr", "수원시 장안구");
		return map;
	}
	
	@GetMapping("/list3")
	@ResponseBody
	public List<PhotoDto> list3(){
		
		List<PhotoDto> list=new ArrayList<PhotoDto>();
		
		list.add(new PhotoDto("카톡임티1", "b1.png"));
		list.add(new PhotoDto("카톡임티2", "b3.png"));
		list.add(new PhotoDto("카톡임티3", "b5.png"));
		list.add(new PhotoDto("카톡임티4", "b7.png"));
		list.add(new PhotoDto("카톡임티5", "b9.png"));
		
		return list;
	}
	
	
}
