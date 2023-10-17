package board.data.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import spring.mvc.reboard.BoardDaoInter;
import spring.mvc.reboard.BoardDto;

@Controller
public class BoardContentController {

	@Autowired
	BoardDaoInter inter;
	
	@GetMapping("/board/content")
	public ModelAndView content(@RequestParam int num,
			@RequestParam int currentPage) {
		
		ModelAndView mview=new ModelAndView();
		
		inter.updateReadcount(num);
		BoardDto dto=inter.getData(num);
		
		mview.addObject("num", num);
		mview.addObject("currentPage", currentPage);
		mview.addObject("dto", dto);
		
		mview.setViewName("reboard/content");
		
		return mview;
	}
}
