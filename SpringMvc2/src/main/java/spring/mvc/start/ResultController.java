package spring.mvc.start;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResultController {
	
	@GetMapping("/apple/list.do") //list뒤에 .do나 다른 확장자를 붙히던 다 호출이 됨
	public String result1(Model model) {
		
		model.addAttribute("myname", "이성신");
		model.addAttribute("myaddr", "경기도 시흥시");
		
		return "result1";
	}
	
	@GetMapping("/banana/insert")
	public ModelAndView banana() {
		//ModelAndView는 request에 저장하기 위한 model과
		//포워드 하기위한 view를 합쳐놓은 클래스 입니다.
		ModelAndView mview=new ModelAndView();
		
		mview.addObject("java", 88);
		mview.addObject("spring", 99);
		
		//포워드할 jsp파일 지정
		mview.setViewName("result2");
		
		return mview;
	}
	
	@GetMapping(" ")
	public ModelAndView delbanana() {
		ModelAndView delView=new ModelAndView();
		
		delView.addObject("fruit", "사과");
		delView.addObject("price", 3000);
		delView.addObject("color", "red");
		
		delView.setViewName("result3");
		
		return delView;
	}
	
	@GetMapping("/shop/detail")
	public String resImage() {
		
		return "result4";
	}
	
	@GetMapping("/board/insert/data")
	public String webImage() {
		
		return "result5";
	}
}
