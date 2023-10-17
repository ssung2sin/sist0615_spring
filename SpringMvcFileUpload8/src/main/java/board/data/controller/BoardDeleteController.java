package board.data.controller;

import java.io.File;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import spring.mvc.reboard.BoardDao;

@Controller
public class BoardDeleteController {
	
	@Autowired
	BoardDao dao;
	
	@GetMapping("/board/deletepassform")
	public ModelAndView deleteform(@RequestParam int num,
			@RequestParam int currentPage) {
		ModelAndView mview=new ModelAndView();
		
		mview.addObject("num", num);
		mview.addObject("currentPage", currentPage);
	
		mview.setViewName("reboard/delPassForm");
		
		return mview;
	}
	
	@PostMapping("/board/delpass")
	public String delPass(@RequestParam String num,
			@RequestParam String pass,
			HttpSession session) {
		int intNum=Integer.parseInt(num);
		String photo=dao.getData(intNum).getPhoto();
		String path=session.getServletContext().getRealPath("/WEB-INF/photo");
		
		int check=dao.getCheckPass(num, pass);
		
		if(check==1) {
			dao.deleteReboard(num);
			String delPhoto[]=photo.split(",");
			for(int i=0;i<delPhoto.length;i++) {
				File file=new File(path+"/"+delPhoto[i]);
				file.delete();
			}
			return "redirect:list";
		}
		else {
			return "reboard/passFail";
		}
		
	}
}	
