package spring.mvc.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController /*json 처리 전용 컨트롤러*/
public class JsonTest2Controller {
	
	@GetMapping("/list2")
	public Map<String, String>list2(){
		Map<String, String>map=new HashMap<String, String>();
		
		map.put("kind", "과일");
		map.put("sangpum", "사과");
		map.put("price", "3000");
		map.put("cnt","5");
		
		return map;
	}
	
	@GetMapping("/list4")
	public Map<String, Object> list4(@RequestParam String name){
		Map<String, Object>map=new HashMap<String, Object>();
		
		List<PhotoDto> list=new ArrayList<PhotoDto>();
		
		list.add(new PhotoDto("카톡임티1", "b1.png"));
		list.add(new PhotoDto("카톡임티2", "b3.png"));
		list.add(new PhotoDto("카톡임티3", "b5.png"));
		list.add(new PhotoDto("카톡임티4", "b7.png"));
		list.add(new PhotoDto("카톡임티5", "b9.png"));
		map.put("name", "없는 이름");
		map.put("photo", "no.png");
		
		for(PhotoDto dto:list) {
			if(name.equals(dto.getName())) {
				map.put("name", dto.getName());
				map.put("photo", dto.getPhoto());
			}
		}
		
		return map;
	}
}
