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
		
		
		//����¡ ó���� �ʿ��� ����ó��
		int totalCount=dao.getTotalCount(); //��ü����
		int totalPage; //�� ��������
		int startPage; //�������� ������ ����������
		int endPage; //�������� ������ ��������
		int startNum; //db���� ������ ���� ���۹�ȣ(mysql�� ù���� 0,����Ŭ�� 1)
		int perPage=3; //���������� ������ ���� ����
		int perBlock=5; //�Ѻ��� ������ ������ ����	     
		     
		//���������� ���ϱ�
		//�ѱ��� ����/���������� ������ ������ ����(7/5=1)
		//�������� 1�̶� ������ ������ 1������ �߰�(1+1=2�������� �ʿ�)
		totalPage=totalCount/perPage+(totalCount%perPage==0?0:1);
		 
		//������ �������� ����������
		//perBlock=5�ϰ��� ���������� 1~5 ����:1 ��:5
		//���������� 13  ����:11  ��:15
		startPage=(currentPage-1)/perBlock*perBlock+1;
		     
		endPage=startPage+perBlock-1;
		    
		 // ���������� 23�ϰ�� ���������� 25���ƴ϶� 23�̴�   
		if(endPage>totalPage)
			endPage=totalPage;
		     
		//������������ ������ ���۹�ȣ
		//1������: 0,2������:5 3������:10....
		startNum=(currentPage-1)*perPage;
			
		//System.out.println(endPage);
		//���������� ����� ���۹�ȣ ���ϱ� no
		//�ѱ۰����� 23�̸� 1������ 23,2�������� 18,3������ 13.....
		//��½� 1�� �����ϸ� ���
			
		//�� ���������� �ʿ��� �Խñ� ��������
		List<BoardDto>list=dao.getPerPagingList(startNum, perPage);
		
		//List�� �� �۾� ��۰��� ǥ��
		for(BoardDto d:list) {
			d.setAcount(adao.getAnswerList(d.getNum()).size());
		}
		
		//�� �������� ����� ���۹�ȣ
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
