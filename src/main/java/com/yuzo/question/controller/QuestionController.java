package com.yuzo.question.controller;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yuzo.question.entity.Answer;
import com.yuzo.question.entity.QstnFromType;
import com.yuzo.question.entity.Question;
import com.yuzo.question.entity.QuestionFeedback;
import com.yuzo.question.entity.QuestionType;
import com.yuzo.question.entity.SubjSection;
import com.yuzo.question.entity.SubjUnit;
import com.yuzo.question.entity.SubjectCourse;
import com.yuzo.question.entity.SysUser;
import com.yuzo.question.page.QuestionPage;
import com.yuzo.question.service.IQuestionService;

@Controller
@RequestMapping("qstn")
@SessionAttributes("qstnpage")
public class QuestionController {
	
	private static final Logger logger = LoggerFactory.getLogger(QuestionController.class);
	
	@Autowired
	private IQuestionService qstnService;
	
	/**
	 * 初始化分页对象,并放到model里
	 */
	@ModelAttribute("qstnpage")
	public QuestionPage initPage() {
		return new QuestionPage();
	}

	@RequestMapping("query")
	public String query(@ModelAttribute("qstnpage")QuestionPage page, Model model,String clearpage) {
		if (clearpage != null) {
			BeanUtils.copyProperties(new QuestionPage(), page);
		}
		//	
		logger.debug("page:" + page);
		
		model.addAttribute("page", page);
		
		PageHelper.startPage(page.getPageNum(), page.getPageSize());		
		List<Question> list = qstnService.queryAll(page);
		PageInfo<Question> pageInfo = new PageInfo<Question>(list);
        model.addAttribute("pageInfo",pageInfo);
       // System.out.println("pageInfo: " + pageInfo);
        
        // 用于条件查询
		List<QstnFromType> qstnFromList = qstnService.queryQstnFrom();
		model.addAttribute("qstnFromList", qstnFromList);
		List<QuestionType> qstnTypeList = qstnService.queryQstnType();
		model.addAttribute("qstnTypeList", qstnTypeList);
		
		List<SubjectCourse> subjList = qstnService.querySubj();
		model.addAttribute("subjList", subjList);
		List<SubjUnit> subjUnitList = qstnService.querySubjUnit();
		model.addAttribute("subjUnitList", subjUnitList);
		List<SubjSection> subjSctnList = qstnService.querySubjSctn();
		model.addAttribute("subjSctnList", subjSctnList);
        
        
		return "qstn/list_qstn";
	}
	
	@RequestMapping("selectQstn")
	public String selectQstn(@ModelAttribute("qstnpage")QuestionPage page, Model model,String clearpage) {
		if (clearpage != null) {
			BeanUtils.copyProperties(new QuestionPage(), page);
		}
		//	
		System.out.println("selectQstn:page: " + page);
		
		model.addAttribute("page", page);
		
		PageHelper.startPage(page.getPageNum(), page.getPageSize());		
		List<Question> list = qstnService.queryAll(page);
		PageInfo<Question> pageInfo = new PageInfo<Question>(list);
		model.addAttribute("pageInfo",pageInfo);
		// System.out.println("pageInfo: " + pageInfo);
		
		// 用于条件查询
		List<QstnFromType> qstnFromList = qstnService.queryQstnFrom();
		model.addAttribute("qstnFromList", qstnFromList);
		List<QuestionType> qstnTypeList = qstnService.queryQstnType();
		model.addAttribute("qstnTypeList", qstnTypeList);
		
		List<SubjectCourse> subjList = qstnService.querySubj();
		model.addAttribute("subjList", subjList);
		List<SubjUnit> subjUnitList = qstnService.querySubjUnit();
		model.addAttribute("subjUnitList", subjUnitList);
		List<SubjSection> subjSctnList = qstnService.querySubjSctn();
		model.addAttribute("subjSctnList", subjSctnList);
		
		
		return "qstn/list_sel_qstn";
	}
	@RequestMapping("setState") 
	public String setState(String id, Model model){
		int count = qstnService.setState(id);
		return "redirect:query";
	}
	
	@RequestMapping("addPage")
	public String addPage(Model model){
		
		List<QstnFromType> qstnFromList = qstnService.queryQstnFrom();
		model.addAttribute("qstnFromList", qstnFromList);
		List<QuestionType> qstnTypeList = qstnService.queryQstnType();
		model.addAttribute("qstnTypeList", qstnTypeList);
		
		List<SubjectCourse> subjList = qstnService.querySubj();
		model.addAttribute("subjList", subjList);
		List<SubjUnit> subjUnitList = qstnService.querySubjUnit();
		model.addAttribute("subjUnitList", subjUnitList);
		List<SubjSection> subjSctnList = qstnService.querySubjSctn();
		model.addAttribute("subjSctnList", subjSctnList);
				
		return "qstn/add_qstn";
	}
	
	
	@RequestMapping("/addCode")
	@ResponseBody
	public String addCode(){
		System.out.println("addCode");
		int count = qstnService.addCode();
	
		System.out.println("addCode:" + count );
		return count + "";
	}
	@RequestMapping("/totalCount")
	@ResponseBody
	public String totalCount(){
		
		System.out.println("totalCount");
		qstnService.totalCount();

		return "ok";
	}
	@RequestMapping("/includeInfoCount")
	@ResponseBody
	public String includeInfoCount(String oldId, String newId){
		
		System.out.println("includeInfoCount");
		int count = qstnService.includeInfoCount(oldId, newId);
		
		return "" + count;
	}
	
	
	

	@RequestMapping("addSave")
	public String addSave(Question qstn, Model model, HttpSession session){
		qstn.setQstnId(UUID.randomUUID().toString());
		qstn.setQstnInputTime(new Date());
		
		SysUser user = (SysUser)session.getAttribute("user");
		qstn.setUserId(user.getUserId());
		qstn.setNickName(user.getNickName());
		
		int count = qstnService.save(qstn);
		logger.debug("count:" + count);
		return "redirect:query";
	}
	
	@RequestMapping("editPage")
	public String editPage(String id,Model model){
		
		Question qstn = qstnService.queryById(id);
		System.out.println("qstn:" + qstn);
		model.addAttribute("qstn", qstn);
		List<QstnFromType> qstnFromList = qstnService.queryQstnFrom();
		model.addAttribute("qstnFromList", qstnFromList);
		List<QuestionType> qstnTypeList = qstnService.queryQstnType();
		model.addAttribute("qstnTypeList", qstnTypeList);
		List<SubjectCourse> subjList = qstnService.querySubj();
		model.addAttribute("subjList", subjList);
		List<SubjUnit> subjUnitList = qstnService.querySubjUnit();
		model.addAttribute("subjUnitList", subjUnitList);
		List<SubjSection> subjSctnList = qstnService.querySubjSctn();
		model.addAttribute("subjSctnList", subjSctnList);
		
		SubjSection sctn = qstnService.querySctnBySctnId(qstn.getSubjSctnId());
		String subjUnitId = sctn.getSubjUnitId();
		model.addAttribute("subjUnitId", subjUnitId );
		SubjUnit unit = qstnService.queryUnitByUnitId(subjUnitId);
		String subjId = unit.getSubjId();
		model.addAttribute("subjId", subjId );
		
		return "qstn/edit_qstn";
	}
	@RequestMapping("showAnswer")
	public String showAnswer(String qstnId,String type ,Model model){
		
		Question qstn = qstnService.queryById(qstnId);
		model.addAttribute("qstn", qstn);
		
		if("4".equals(type)) {
			List<Answer> ansList4 = qstnService.queryAnswer4(qstnId);
			model.addAttribute("ansList4", ansList4);
			return "qstn/show_ans4";
		}
		return "qstn/qstn/show_ans4";
	}
	

	@RequestMapping("/editSave")
	public String editSave(Question qstn, Model model){
		//qstn.setQstnId(UUID.randomUUID().toString());
		qstn.setQstnInputTime(new Date());
	
		int count = qstnService.update(qstn);
		logger.debug("count:" + count);
		return "redirect:query";
	}
	
	@RequestMapping("/dels")
	public String dels(String[] ids) {		
		int count = qstnService.dels(ids);
		System.out.println("��ɾ��:" + count);
		return "redirect:query";
	}
	


	
	
	
	
	@RequestMapping("/uploadSimditorImg")
	@ResponseBody
	public JSONObject uploadSimditorImg(MultipartFile file, String type, HttpServletRequest request) {
		JSONObject json = new JSONObject();
		try {
		
			json = qstnService.uploadSimditorImg(file,  type );
		} catch (Exception e) {
			logger.debug("异常:" + e);
		}
		logger.debug("json:" + json);
		return json;
	}
	
	//------------------------------------------------------------------
	
	@RequestMapping("/setfd")
	public String setfd(String qstnId, Model model) {		
		Question qstn = qstnService.queryById(qstnId);
		System.out.println("��ɾ��:" + qstn);
		model.addAttribute("qstn", qstn);
		List<Answer> ansList = qstnService.queryAnswersByQstnId(qstnId);
		model.addAttribute("ansList", ansList);
		return "feedback/add_fdbk";
	}
	
	@RequestMapping("/fdbkSave")
	@ResponseBody
	public JSONObject fdbkSave(QuestionFeedback qtfd, HttpSession session) {
		JSONObject json = new JSONObject();
		SysUser user = (SysUser) session.getAttribute("user");
		qtfd.setUserId(user.getUserId());
		System.out.println("fdbkSave:" + qtfd);
		int count = qstnService.fdbkSave(qtfd);
		return null;
	}
	
	@RequestMapping("/checkQstn")
	public String checkQstn(String qstnId, String type, Model model) {
		Question qstn = qstnService.queryById(qstnId);
		model.addAttribute("qstn", qstn);
		List<Answer> ansList = qstnService.queryAnswersByQstnId(qstnId);
		model.addAttribute("ansList", ansList);
		model.addAttribute("type", type);
		
		return "qstn/check_qstn";
	}

	
	@RequestMapping("/queryQtfb")
	public String queryQtfb( Model model) {		
		List<QuestionFeedback> list = qstnService.queryQtfb();
		model.addAttribute("list", list );
		return "feedback/list_fdbk";
	}
	@RequestMapping("/okfbPage")
	public String okfbPage(String qtfbId) {		
		int count = qstnService.okfbPage(qtfbId);
		return "redirect:queryQtfb";
	}
	
}
