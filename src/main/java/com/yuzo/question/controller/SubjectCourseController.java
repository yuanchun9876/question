package com.yuzo.question.controller;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yuzo.question.entity.SubjectCourse;
import com.yuzo.question.service.ISubjectCourseService;

@Controller
@RequestMapping("/subj")
public class SubjectCourseController {

	@Autowired
	private ISubjectCourseService  subjectCourseService;
	
	@RequestMapping("/query")
	public String query(HttpSession session, Model model) {
		
		List<SubjectCourse> list = subjectCourseService.query();
		System.out.println(list);
		model.addAttribute("list", list);		
		return "subj/list_subj";
	}
	
	@RequestMapping("addPage")
	public String addPage(HttpSession session, Model model) {
		return "jsp/subj/add_subj";
	}
	
	@RequestMapping("addSave")
	public String addSave(
						SubjectCourse subj
//						,@RequestParam("subjPicUrl")CommonsMultipartFile picFile
						, HttpSession session
					) throws IllegalStateException, IOException {
		// �ϴ�logoͼƬ
		ServletContext app = session.getServletContext();
//		if(picFile != null) {
//			System.out.println("picFile-fileName��" + picFile.getOriginalFilename());
//			String picRootPath = app.getRealPath("/upload/subj/pic/");
//	        String picPath = new Date().getTime() + picFile.getOriginalFilename();	         
//	        File sctnPicFile = new File(picRootPath + picPath);
//	        //ͨ��CommonsMultipartFile�ķ���ֱ��д�ļ���ע�����ʱ��
//	        picFile.transferTo(sctnPicFile);
//	        subj.setSubjLogoUrl("/upload/subj/pic/" + picPath);
//		}
	
		subj.setSubjId(UUID.randomUUID().toString());
		int count = subjectCourseService.save(subj);
		
		System.out.println("sctn:" + count);
		
		return "redirect:query.action";
	}
	
	@RequestMapping("editPage")
	public String editPage(String subjId,HttpSession session, Model model) {
		
		SubjectCourse subj = subjectCourseService.queryById(subjId);
		model.addAttribute("subj", subj);
		
		return "jsp/subj/edit_subj";
	}
	@RequestMapping("/dels")
	public String dels(String[] ids) {		
		int count = subjectCourseService.dels(ids);
		System.out.println("��ɾ��:" + count);
		return "redirect:query.action";
	}
	
}
