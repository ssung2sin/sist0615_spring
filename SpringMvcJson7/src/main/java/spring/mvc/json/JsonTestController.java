package spring.mvc.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller /*json ó�� ���� ��Ʈ�ѷ�*/
public class JsonTestController {

	@GetMapping("/list1")
	@ResponseBody //json���� ó���ϰ� �������� ����ϴ� annotation
	public Map<String, String> list1(){
		Map<String, String>map=new HashMap<String, String>();
		
		map.put("name", "�����");
		map.put("hp", "010-222-3333");
		map.put("addr", "������ ��ȱ�");
		return map;
	}
	
	@GetMapping("/list3")
	@ResponseBody
	public List<PhotoDto> list3(){
		
		List<PhotoDto> list=new ArrayList<PhotoDto>();
		
		list.add(new PhotoDto("ī����Ƽ1", "b1.png"));
		list.add(new PhotoDto("ī����Ƽ2", "b3.png"));
		list.add(new PhotoDto("ī����Ƽ3", "b5.png"));
		list.add(new PhotoDto("ī����Ƽ4", "b7.png"));
		list.add(new PhotoDto("ī����Ƽ5", "b9.png"));
		
		return list;
	}
	
	
}
