package board.data.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import answer.data.AnswerDao;
import spring.mvc.reboard.BoardDao;
import spring.mvc.reboard.BoardDto;

@Controller
public class BoardListController {
	
	@Autowired
	BoardDao dao;
	
	@Autowired
	AnswerDao adao;
	
	@GetMapping("board/list")
	public String list(Model model, @RequestParam(value="currentPage", defaultValue = "1")int currentPage) {
		
		
		//페이징 처리에 필요한 변수처리
		int totalCount=dao.getTotalCount(); //전체객수
		int totalPage; //총 페이지수
		int startPage; //각블럭에서 보여질 시작페이지
		int endPage; //각블럭에서 보여질 끝페이지
		int startNum; //db에서 가져올 글의 시작번호(mysql은 첫글이 0,오라클은 1)
		int perPage=3; //한페이지당 보여질 글의 갯수
		int perBlock=5; //한블럭당 보여질 페이지 개수	     
		     
		//총페이지수 구하기
		//총글의 갯수/한페이지당 보여질 개수로 나눔(7/5=1)
		//나머지가 1이라도 있으면 무조건 1페이지 추가(1+1=2페이지가 필요)
		totalPage=totalCount/perPage+(totalCount%perPage==0?0:1);
		 
		//각블럭당 보여야할 시작페이지
		//perBlock=5일경우는 현재페이지 1~5 시작:1 끝:5
		//현재페이지 13  시작:11  끝:15
		startPage=(currentPage-1)/perBlock*perBlock+1;
		     
		endPage=startPage+perBlock-1;
		    
		 // 총페이지가 23일경우 마지막블럭은 25가아니라 23이다   
		if(endPage>totalPage)
			endPage=totalPage;
		     
		//각페이지에서 보여질 시작번호
		//1페이지: 0,2페이지:5 3페이지:10....
		startNum=(currentPage-1)*perPage;
			
		//System.out.println(endPage);
		//각페이지당 출력할 시작번호 구하기 no
		//총글개수가 23이면 1페이지 23,2페이지는 18,3페이지 13.....
		//출력시 1씩 감소하며 출력
			
		//각 페이지에서 필요한 게시글 가져오기
		List<BoardDto>list=dao.getPerPagingList(startNum, perPage);
		
		//List의 각 글애 댓글갯수 표시
		for(BoardDto d:list) {
			d.setAcount(adao.getAnswerList(d.getNum()).size());
		}
		
		//각 페이지에 출력할 시작번호
		int no=totalCount-(currentPage-1)*perPage;
		
		model.addAttribute("totalCount",totalCount);
		model.addAttribute("list", list);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("no", no);
		model.addAttribute("currentPage", currentPage);
		
		return "reboard/boardList";
	}

}
