package spring.mvc.samsung;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import spring.data.dto.ShopDto;

@Controller
@RequestMapping("/shop")
public class ShopController {
	
	@GetMapping("/list")
	public String result3() {
		
		
		return "shop/list";
	}
	
	@GetMapping("/form2")
	public String form2() {
		
		return "shop/shopForm";
	}
	
	@PostMapping("/process2")
	public String process2(@ModelAttribute("dto") ShopDto dto) {
		
		
		return "shop/shopResult";
	}
	
	@GetMapping("/form3")
	public String form3() {
		return "shop/mapForm";
	}
	
	@PostMapping("/process3")
	public ModelAndView process3(@RequestParam Map<String, String> map) {
		ModelAndView mView=new ModelAndView();
		
		mView.addObject("name", map.get("name"));
		mView.addObject("java", map.get("java"));
		mView.addObject("spring", map.get("spring"));
		mView.addObject("jquery", map.get("jquery"));
		
		mView.setViewName("shop/mapResult");
		
		return mView;
	}
}
