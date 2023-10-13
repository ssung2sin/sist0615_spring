package spring.mvc.lss;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import spring.data.dto.FormDto;

@Controller
public class FormController {
	
	@GetMapping("/data/myform")
	public String myform() {
		return "myforms";
	}
	
	//read1_get방식폼 전송
	@GetMapping("/data/read1")
	public ModelAndView read1(@RequestParam(value = "myname") String name,@RequestParam(value = "myage") int age,
			@RequestParam(value = "msg",defaultValue = "hello") String msg) {
		ModelAndView read1=new ModelAndView();

		read1.addObject("name", name);
		read1.addObject("age", age);
		read1.addObject("msg", msg);
		read1.setViewName("process1");
		return read1;
	}
	
	@PostMapping("/data/read2")
	public ModelAndView read2(@ModelAttribute FormDto dto) {
		ModelAndView read2=new ModelAndView();
		
		read2.addObject("dto",dto);
		read2.setViewName("process2");
		return read2;
	}
	
	@PostMapping("data/read3")
	public ModelAndView read3(@RequestParam Map<String, String> map) {
		ModelAndView read3=new ModelAndView();
		
		String sang=map.get("sang");
		String price=map.get("price");
		String data=sang+"의 가격은"+price+"입니다.";
		
		read3.addObject("data",data);
		
		read3.setViewName("process3");
		return read3;
	}
}
