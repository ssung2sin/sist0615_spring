package spring.mvc.start;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResultController {
	
	@GetMapping("/apple/list.do") //list�ڿ� .do�� �ٸ� Ȯ���ڸ� ������ �� ȣ���� ��
	public String result1(Model model) {
		
		model.addAttribute("myname", "�̼���");
		model.addAttribute("myaddr", "��⵵ �����");
		
		return "result1";
	}
	
	@GetMapping("/banana/insert")
	public ModelAndView banana() {
		//ModelAndView�� request�� �����ϱ� ���� model��
		//������ �ϱ����� view�� ���ĳ��� Ŭ���� �Դϴ�.
		ModelAndView mview=new ModelAndView();
		
		mview.addObject("java", 88);
		mview.addObject("spring", 99);
		
		//�������� jsp���� ����
		mview.setViewName("result2");
		
		return mview;
	}
	
	@GetMapping(" ")
	public ModelAndView delbanana() {
		ModelAndView delView=new ModelAndView();
		
		delView.addObject("fruit", "���");
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
