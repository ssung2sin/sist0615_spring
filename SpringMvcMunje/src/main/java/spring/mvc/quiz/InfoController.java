package spring.mvc.quiz;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import spring.data.dto.InfoDto;

@Controller
public class InfoController {
	
	@GetMapping("info/form")
	public String from() {
		
		return "infoForm";
	}
	
	@PostMapping("info/result")
	public ModelAndView write(@ModelAttribute("dto") InfoDto dto) {
		ModelAndView model=new ModelAndView();
		
		model.setViewName("infoWrite");
		
		return model;
	}
}
