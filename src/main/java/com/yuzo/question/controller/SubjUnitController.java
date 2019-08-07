package com.yuzo.question.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yuzo.question.entity.SubjSection;
import com.yuzo.question.entity.SubjUnit;
import com.yuzo.question.entity.SubjectCourse;
import com.yuzo.question.entity.Teacher;
import com.yuzo.question.page.SubjSectionPage;
import com.yuzo.question.page.SubjUnitPage;
import com.yuzo.question.service.ISubjUnitService;

@Controller
@RequestMapping("subjUnit")
@SessionAttributes("unitpage")
public class SubjUnitController {
	//SubjUnitPage
	static Logger logger = Logger.getLogger(SubjUnitController.class);
	
	@Autowired
	private ISubjUnitService  subjUnitService;
	
	/**
	 * 初始化分页对象,并放到model里
	 */
	@ModelAttribute("unitpage")
	public SubjUnitPage initPage() {
		return new SubjUnitPage();
	}
	
	
	@RequestMapping("query")
	public String query(@ModelAttribute("unitpage")SubjUnitPage page, Model model,String clearpage) {
		if (clearpage != null) {
			BeanUtils.copyProperties(new SubjUnitPage(), page);
		}
		
		model.addAttribute("page",page);
		//	
		PageHelper.startPage(page.getPageNum(), page.getPageSize());		
		List<SubjUnit> list = subjUnitService.queryPage(page);//queryByTchId(tchId);
		PageInfo<SubjUnit> pageInfo = new PageInfo<SubjUnit>(list);
		//System.out.println(list.size());
        model.addAttribute("pageInfo",pageInfo);
        
        
    	List<SubjectCourse> subjList = subjUnitService.querySubjectCourse();
		model.addAttribute("subjList", subjList);
		
		return "subjunit/list_unit";
	}
	
	
	@RequestMapping("/selectSubj")
	@ResponseBody
	public List<SubjUnit> selectSubj(String subjId) {
		logger.debug("subjId:" + subjId);
		List<SubjUnit> list = subjUnitService.queryUnitBySubj(subjId);//queryByTchId(tchId);
		
		return list;
	}
	
	@RequestMapping("/selectUnitsBySubjs")
	@ResponseBody
	public List<SubjUnit> selectUnitsBySubjs(@RequestParam("subjIds[]")  String[] subjIds) {
		System.out.println("subjIds:" + Arrays.toString(subjIds));
		List<SubjUnit> list = subjUnitService.queryUnitsBySubjs(subjIds);
		
		return list;
	}
	
	@RequestMapping("addPage")
	public String addPage(HttpSession session, Model model) {
		Teacher tch = (Teacher) session.getAttribute("tch");
		String tchId = "1"; // tch.getTchId()
		model.addAttribute("tchId", tchId);
		List<SubjectCourse> subjList = subjUnitService.querySubjectCourse();
		model.addAttribute("subjList", subjList);
		return "subjunit/add_unit";
	}
	
	@RequestMapping("addSave")
	public String addSave(
					SubjUnit unit
					//,@RequestParam("unitPicUrl")CommonsMultipartFile picFile
					, HttpSession session
				) throws IllegalStateException, IOException {
		// �ϴ�logoͼƬ
		ServletContext app = session.getServletContext();

		unit.setSubjUnitId(UUID.randomUUID().toString());
		int count = subjUnitService.save(unit);
		
		System.out.println("unit:" + count);
		
		return "redirect:query";
	}
	
	@RequestMapping("/singleUnitCode")
	@ResponseBody
	public String singleUnitCode(String unitCode) {
		
		List<SubjUnit> unitList = subjUnitService.queryByCode(unitCode);
		if (unitList!=null && unitList.size()>0) {
			return "no";
		} else {
			return "yes";
		}
	}
	
	@RequestMapping("/editPage")
	public String editPage(String subjUnitId,HttpSession session, Model model) {
		
		SubjUnit unit = subjUnitService.queryById(subjUnitId);
		model.addAttribute("unit", unit);	
		Teacher tch = (Teacher) session.getAttribute("tch");
		String tchId = "1"; // tch.getTchId()
		model.addAttribute("tchId", tchId);
		List<SubjectCourse> subjList = subjUnitService.querySubjectCourse();
		model.addAttribute("subjList", subjList);
		return "subjunit/edit_unit";
	}
	
	@RequestMapping("/editSave")
	public String editSave(SubjUnit unit) {		
		
		int count = subjUnitService.update(unit);
		System.out.println("��ɾ��:" + count);
		return "redirect:query";
	}
	
	@RequestMapping("/dels")
	public String dels(String[] ids) {		
		System.out.println("ids:" + Arrays.toString(ids));
		int count = subjUnitService.dels(ids);
		System.out.println("��ɾ��:" + count);
		return "redirect:query";
	}
}
