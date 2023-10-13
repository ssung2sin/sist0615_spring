package spring.mvc.friday;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class InfoController {
	
	@Autowired
	InfoInter inter;
	
	@GetMapping("/info/list")
	public String list(Model model) {
		
		int count=inter.getTotalCount();
		List<InfoDto>list=inter.getAllDatas();
		
		model.addAttribute("list",list);
		model.addAttribute("count", count);
		
		return "info/infoList";
	}
	
	@GetMapping("/info/addform")
	public String add() {
		
		return "info/addForm";
	}
	
	@PostMapping("/info/insert")
	public String insert(@ModelAttribute InfoDto dto,
			@RequestParam MultipartFile upload,
			HttpSession session) {
		
		String path=session.getServletContext().getRealPath("/resources/image/");
		
		System.out.println(path);
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
		
		String photo="";
		
		//���������� ��������� no..
		if(upload.getOriginalFilename().equals("")) {
			photo="no";
		}else {
			String fName=upload.getOriginalFilename();
			fName=sdf.format(new Date())+"_"+fName;
			
			photo=fName;
			
			//���ε� �������� 1�� ���������� 2��
			try {
				upload.transferTo(new File(path+"/"+photo));
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//dto�� photo �ֱ�
		dto.setPhoto(photo);
		
		//insert
		inter.insertMyInfo(dto);
		
		return "redirect:list";
	}
	
	@GetMapping("/info/updateform")
	public String updateForm(Model model,@RequestParam String num) {
		
		InfoDto dto=inter.getData(num);
		
		model.addAttribute("dto",dto);
		
		return "info/updateForm";
	}
	
	@PostMapping("info/update")
	public String update(@ModelAttribute("dto")InfoDto dto,
			@RequestParam MultipartFile upload,
			HttpSession session) {
		
		String photo=inter.getData(dto.getNum()).getPhoto();
		System.out.println(photo);
		if(!photo.equals("no")) {
			String path=session.getServletContext().getRealPath("/resources/image/");
			
			File file=new File(path+"/"+photo);
			file.delete();
		}
		
		String path=session.getServletContext().getRealPath("/resources/image/");
		System.out.println(path);
		
		String photoName;
		
		if(upload.getOriginalFilename().equals("")) {
			photoName=null;
		}else {
			photoName=upload.getOriginalFilename();
			
			try {
				upload.transferTo(new File(path+"/"+photoName));
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//dto�� photo�� ���ε��� photoname �־��ֱ�
		dto.setPhoto(photoName);
		
		inter.updateMyifo(dto);
		
		return "redirect:list";
	}
	
	@GetMapping("info/delete")
	public String delete(@RequestParam String num,HttpSession session) {
		
		String photo=inter.getData(num).getPhoto();
		
		if(!photo.equals("no")) {
			String path=session.getServletContext().getRealPath("/resources/image/");
			
			File file=new File(path+"/"+photo);
			file.delete();
		}
		
		inter.deleteMyInfo(num);
		
		return "redirect:list";
	}
	
}