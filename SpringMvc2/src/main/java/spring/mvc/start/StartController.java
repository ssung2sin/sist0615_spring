package spring.mvc.start;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StartController {
	
	//start.jsp�� �������� �޼���(������)
	
	@GetMapping("/")
	public String start(Model model) {
		
		//Model: request�� �����͸� �����ϱ� ���� �������̽�
		//�������� �ϴ� request.setAttribute �� ����
		model.addAttribute("name", "�迵ȯ");
		model.addAttribute("addr", "����� ������");
		return "start";
	}
}
