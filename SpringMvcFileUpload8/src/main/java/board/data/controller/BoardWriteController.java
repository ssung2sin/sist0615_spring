package board.data.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import spring.mvc.reboard.BoardDao;
import spring.mvc.reboard.BoardDto;

@Controller
public class BoardWriteController {
	
	@Autowired
	BoardDao dao;
	
	@GetMapping("board/writeform")
	public String insertForm(Model model,@RequestParam Map<String, String> map) {
		
		//요 5개는 답글일 경우에만 넘어온다(새 글일 경우 넘어오지 않는다)
		String currentPage=map.get("currentPage");
		String num=map.get("num");
		String regroup=map.get("regroup");
		String restep=map.get("restep");
		String relevel=map.get("relevel");
		
		System.out.println(currentPage+","+num+","+regroup+","+restep+","+relevel);
		
		//입력폼에 hidden으로 넣어줘야함.. 답글일때 대비
		model.addAttribute("currentPage", currentPage==null?"1":currentPage);
		model.addAttribute("num",num==null?"0":num);
		model.addAttribute("regroup",regroup==null?"0":regroup);
		model.addAttribute("restep",restep==null?"0":restep);
		model.addAttribute("relevel",relevel==null?"0":relevel);	
		
		//0으로 넣어야 dao에서 새 글로 인식
		//폼이 답글,새글 공용이므로
		
		return "reboard/writeForm";
	}
	
	@PostMapping("/board/insert")
	public String insert(@ModelAttribute BoardDto dto,
			@RequestParam ArrayList<MultipartFile> uimage,
			HttpSession session, @RequestParam int currentPage) {
		
		//실제경로
		String path=session.getServletContext().getRealPath("/WEB-INF/photo");
		System.out.println(path);
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
		int maxNum=dao.getMaxNum();
		String photo="";
		
		if(uimage.get(0).getOriginalFilename().equals("")) {
			photo="no";
		}else {
			for(MultipartFile f:uimage) {
				String fName=sdf.format(new Date())+"_"+f.getOriginalFilename();
				
				photo+=fName+",";
				
				try {
					f.transferTo(new File(path+"\\"+fName));
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			//photo에서 마지막 컴마제거
			photo=photo.substring(0,photo.length()-1);
		}
		
		
		//dto의 photo에 넣기
		dto.setPhoto(photo);
		
		dao.insertReboard(dto);
		
		return "redirect:content?num="+maxNum+"&currentPage="+currentPage; //content없으니까 일단 목록으로
	}
}
