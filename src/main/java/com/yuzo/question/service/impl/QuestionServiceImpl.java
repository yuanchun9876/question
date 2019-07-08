package com.yuzo.question.service.impl;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.yuzo.question.entity.Answer;
import com.yuzo.question.entity.QstnFromType;
import com.yuzo.question.entity.Question;
import com.yuzo.question.entity.QuestionType;
import com.yuzo.question.entity.SubjSection;
import com.yuzo.question.entity.SubjUnit;
import com.yuzo.question.entity.SubjectCourse;
import com.yuzo.question.mapper.AnswerMapper;
import com.yuzo.question.mapper.QstnFromTypeMapper;
import com.yuzo.question.mapper.QuestionMapper;
import com.yuzo.question.mapper.QuestionTypeMapper;
import com.yuzo.question.mapper.SubjSectionMapper;
import com.yuzo.question.mapper.SubjUnitMapper;
import com.yuzo.question.mapper.SubjectCourseMapper;
import com.yuzo.question.page.QuestionPage;
import com.yuzo.question.page.SubjSectionPage;
import com.yuzo.question.service.IQuestionService;





@Service
public class QuestionServiceImpl implements IQuestionService{

	@Autowired
	private QuestionMapper qstnMapper;
	
	@Autowired
	private QstnFromTypeMapper qstnFromMapper;
	
	@Autowired
	private QuestionTypeMapper qstnTypeMapper;
	
	@Autowired
	private SubjSectionMapper sctnMapper;
	
	@Autowired
	private SubjUnitMapper unitMapper;
	
	@Autowired
	private SubjectCourseMapper subjMapper;
	
	@Autowired
	private AnswerMapper ansMapper;

	@Override
	public List<QstnFromType> queryQstnFrom() {
		// TODO Auto-generated method stub
		return qstnFromMapper.queryAll();
	}

	@Override
	public List<QuestionType> queryQstnType() {
		// TODO Auto-generated method stub
		return qstnTypeMapper.queryAll();
	}

	@Override
	public List<SubjSection> querySubjSctn() {
		// TODO Auto-generated method stub
		return sctnMapper.queryAll(null);
	}

	@Override
	public List<SubjectCourse> querySubj() {
		// TODO Auto-generated method stub
		return subjMapper.queryAll();
	}

	@Override
	public List<SubjUnit> querySubjUnit() {
		// TODO Auto-generated method stub
		return unitMapper.queryAll();
	}

	@Override
	public JSONObject uploadSimditorImg(MultipartFile file, String type) {
		// TODO Auto-generated method stub
		JSONObject json = new JSONObject();
		try {
			File filePath=new File(ResourceUtils.getURL("classpath:").getPath());
			if(!filePath.exists()  ){
				filePath=new File("");
			}
			
			String picRootPath = filePath.getAbsolutePath()+"\\static\\upload\\";
			
			File upload=new File(picRootPath);
			if (!upload.exists()) {
				upload.mkdirs();
			}
			
			File typePath=new File(picRootPath + type + "\\");
			if(!typePath.exists()  ){
				typePath.mkdirs();
			}
			
	        String picPath = new Date().getTime() + file.getOriginalFilename();	         
	        File rsrcLogoUrlFile = new File(picRootPath + type + "/" + picPath);
	        
	        file.transferTo(rsrcLogoUrlFile);      
	        
	    	json.put("success", true);
        	json.put("file_path", "/upload/" + type + "/" + picPath);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			json.put("success", false);
		} 
		System.out.println("json:" + json);
        return json;
	}

	@Override
	public int save(Question qstn) {
		// TODO Auto-generated method stub
		return qstnMapper.insertSelective(qstn);
	}

	@Override
	public List<Question> queryAll(QuestionPage page) {
		// TODO Auto-generated method stub
		return qstnMapper.queryAll(page);
	}

	@Override
	public Question queryById(String id) {
		// TODO Auto-generated method stub
		return qstnMapper.selectByPrimaryKey(id);
	}

	@Override
	public SubjSection querySctnBySctnId(String subjSctnId) {
		// TODO Auto-generated method stub
		return sctnMapper.selectByPrimaryKey(subjSctnId);
	}

	@Override
	public SubjUnit queryUnitByUnitId(String subjUnitId) {
		// TODO Auto-generated method stub
		return unitMapper.selectByPrimaryKey(subjUnitId);
	}

	@Override
	public List<Answer> queryAnswersByQstnId(String qstnId) {
		// TODO Auto-generated method stub
		return ansMapper.queryByQstnId(qstnId);
	}

	@Override
	public int update(Question qstn) {
		// TODO Auto-generated method stub
		
		
		return qstnMapper.updateByPrimaryKeySelective(qstn);
	}

	@Override
	public int dels(String[] ids) {
		// TODO Auto-generated method stub
		int count = 0;
		for (int i = 0; i < ids.length; i++) {
			count += qstnMapper.deleteByPrimaryKey(ids[i]);
		}
		return count;
	}
}
