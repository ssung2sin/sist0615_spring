package spring.mysql.mycar;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CarController {
	
	@Autowired // 이 안에있는 dao 메서드 호출하기위해
	MyCarDao dao;
	
	@GetMapping("/kakao/writeform")
	public String write() {
		
		return "car/writeForm";
	}
	
	@GetMapping("/kakao/list")
	public String list(Model model) {
		
		//dao에서 총개수 가져오기
		int totalCount=dao.getTotalCount();
		
		List<MyCarDto>list=dao.getAllCars();
		
		//request에 저장
		model.addAttribute("list",list);
		model.addAttribute("totalCount", totalCount);
		return "car/carList";
	}
	
	@PostMapping("kakao/write")
	public String reList(Model model,@ModelAttribute("dto") MyCarDto dto) {
		
		dao.insertCar(dto);
		
		return "redirect:list";
	}
	
	@GetMapping("kakao/delete")
	public String deleteCar(@RequestParam String num) {
		System.out.println(num);
		dao.deleteCar(num);
		
		return "redirect:list";
	}
	
	@GetMapping("kakao/updateform")
	public String updateform(Model model, @RequestParam String num) {
		
		MyCarDto dto=dao.getData(num);
		
		model.addAttribute("dto", dto);
		
		return "car/updateForm";
	}
	
	@PostMapping("kakao/update")
	public String update(@ModelAttribute("dto") MyCarDto dto) {
		dao.updateCar(dto);
		
		return "redirect:list";
	}
}
