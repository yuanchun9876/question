package com.yuzo.question.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuzo.question.entity.QstnFromType;
import com.yuzo.question.entity.QuestionType;
import com.yuzo.question.entity.SubjSection;
import com.yuzo.question.entity.SubjUnit;
import com.yuzo.question.entity.SubjectCourse;
import com.yuzo.question.entity.TestPlan;
import com.yuzo.question.entity.TestPlanDetailed;
import com.yuzo.question.mapper.AnswerMapper;
import com.yuzo.question.mapper.QstnFromTypeMapper;
import com.yuzo.question.mapper.QuestionMapper;
import com.yuzo.question.mapper.QuestionTypeMapper;
import com.yuzo.question.mapper.SubjSectionMapper;
import com.yuzo.question.mapper.SubjUnitMapper;
import com.yuzo.question.mapper.SubjectCourseMapper;
import com.yuzo.question.mapper.TestPlanDetailedMapper;
import com.yuzo.question.mapper.TestPlanMapper;
import com.yuzo.question.service.ITestPlanService;

@Service
public class TestPlanServiceImpl implements ITestPlanService {

	@Autowired
	private TestPlanMapper planMapper;
	
	@Autowired
	private TestPlanDetailedMapper planDtdMapper;

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
	public List<TestPlan> queryAll() {
		// TODO Auto-generated method stub
		return planMapper.queryAll();
	}

	@Override
	public int save(TestPlan plan) {
		// TODO Auto-generated method stub
		return planMapper.insertSelective(plan);
	}

	@Override
	public TestPlan queryById(String tpId) {
		// TODO Auto-generated method stub
		return planMapper.selectByPrimaryKey(tpId);
	}

	@Override
	public int update(TestPlan plan) {
		// TODO Auto-generated method stub
		return planMapper.updateByPrimaryKeySelective(plan);
	}

	@Override
	public int dels(String[] ids) {
		// TODO Auto-generated method stub
		int count = 0;
		for (int i = 0; i < ids.length; i++) {
			count += planMapper.deleteByPrimaryKey(ids[i]);
		}
		return count;
	}

	@Override
	public int saveSet(String tpId, String[] typeIds, Integer[] typeNums, Integer[] typePns, String[] fromIds,
			Integer[] fromNums, String[] subjIds, Integer[] subjNums, String[] unitIds, Integer[] unitNums,
			String[] sctnIds, Integer[] sctnNums) {
		int count = 0;
		for (int i = 0; i < typeIds.length; i++) {
			TestPlanDetailed planDtd = new TestPlanDetailed();
			planDtd.setTpDtdId(UUID.randomUUID().toString());
			planDtd.setTpId(tpId);
			planDtd.setQstnTypeId(typeIds[i]);
			if (typeNums[i]==null) {
				planDtd.setTypeNum(100);
			} else {
				planDtd.setTypeNum(typeNums[i]);
			}
			if (typePns[i]==null) {
				planDtd.setTypePoints(5);
			} else {
				planDtd.setTypePoints(typePns[i]);
			}
			planDtd.setTpDtdType("1");
			count += planDtdMapper.insertSelective(planDtd);
		}
		
		for (int i = 0; i < fromIds.length; i++) {
			TestPlanDetailed planDtd = new TestPlanDetailed();
			planDtd.setTpDtdId(UUID.randomUUID().toString());
			planDtd.setTpId(tpId);
			planDtd.setQstnFromTypeId(fromIds[i]);
			if (fromNums[i]==null) {
				planDtd.setFromNum(100);
			} else {
				planDtd.setFromNum(fromNums[i]);
			}
			planDtd.setTpDtdType("2");
			count += planDtdMapper.insertSelective(planDtd);
		}
		
		for (int i = 0; i < subjIds.length; i++) {
			TestPlanDetailed planDtd = new TestPlanDetailed();
			planDtd.setTpDtdId(UUID.randomUUID().toString());
			planDtd.setTpId(tpId);
			planDtd.setSubjId(subjIds[i]);
			if (subjNums[i]==null) {
				planDtd.setSubjNum(100);
			} else {
				planDtd.setSubjNum(subjNums[i]);
			}
			planDtd.setTpDtdType("3");
			count += planDtdMapper.insertSelective(planDtd);
		}
		
		if(unitIds!=null) {
			
			for (int i = 0; i < unitIds.length; i++) {
				TestPlanDetailed planDtd = new TestPlanDetailed();
				planDtd.setTpDtdId(UUID.randomUUID().toString());
				planDtd.setTpId(tpId);
				planDtd.setSubjId(unitIds[i]);
				if (unitNums[i]==null) {
					planDtd.setUnitNum(100);
				} else {
					planDtd.setUnitNum(unitNums[i]);
				}
				planDtd.setTpDtdType("4");
				count += planDtdMapper.insertSelective(planDtd);
			}
		}
		
		if(sctnIds!=null) {
			
			for (int i = 0; i < unitIds.length; i++) {
				TestPlanDetailed planDtd = new TestPlanDetailed();
				planDtd.setTpDtdId(UUID.randomUUID().toString());
				planDtd.setTpId(tpId);
				planDtd.setSubjId(sctnIds[i]);
				if (sctnNums[i]==null) {
					planDtd.setSctnNum(100);
				} else {
					planDtd.setSctnNum(sctnNums[i]);
				}
				planDtd.setTpDtdType("5");
				count += planDtdMapper.insertSelective(planDtd);
			}
		}
		return count;
	}
	
	
}
