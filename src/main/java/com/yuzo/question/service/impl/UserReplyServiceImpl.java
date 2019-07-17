package com.yuzo.question.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuzo.question.entity.Question;
import com.yuzo.question.entity.SysUser;
import com.yuzo.question.entity.TestPlan;
import com.yuzo.question.entity.UserClassHistory;
import com.yuzo.question.entity.UserMyclass;
import com.yuzo.question.entity.UserReplyList;
import com.yuzo.question.mapper.QuestionMapper;
import com.yuzo.question.mapper.SysUserMapper;
import com.yuzo.question.mapper.TestPlanMapper;
import com.yuzo.question.mapper.UserClassHistoryMapper;
import com.yuzo.question.mapper.UserMyclassMapper;
import com.yuzo.question.mapper.UserReplyListMapper;
import com.yuzo.question.service.IUserReplyService;

@Service
public class UserReplyServiceImpl implements IUserReplyService{
	
	@Autowired
	private TestPlanMapper planMapper;
	
	@Autowired
	private UserMyclassMapper userMyclassMapper;

	@Autowired
	private QuestionMapper qstnMapper;
	
	@Autowired
	private UserReplyListMapper urMapper;
	
	@Autowired
	private SysUserMapper userMapper;
	
	@Autowired
	private UserClassHistoryMapper ucMapper;
	
	@Override
	public List<TestPlan> querytp() {
		// TODO Auto-generated method stub
		return planMapper.queryAll();
	}

	@Override
	public List<UserMyclass> querymc() {
		// TODO Auto-generated method stub
		return userMyclassMapper.queryAll();
	}

	@Override
	public List<Question> queryQstnByTp(String tpId) {
		// TODO Auto-generated method stub
		return qstnMapper.queryQstnByTpId(tpId);
	}

	@Override
	public UserMyclass queryMcById(String mcId) {
		// TODO Auto-generated method stub
		return userMyclassMapper.selectByPrimaryKey(mcId);
	}

	@Override
	public void updatePoints(String qstnId, String replyType, String userId) {
		// TODO Auto-generated method stub
		UserReplyList ur = new UserReplyList();
		ur.setUrId(UUID.randomUUID().toString());
		ur.setQstnId(qstnId);
		ur.setUrInfo("1");
		ur.setUrTime(new Date());
		ur.setUserId(userId);
		
		SysUser user = userMapper.selectByPrimaryKey(userId);
		UserClassHistory uch = ucMapper.queryByUserId(userId);
		int points = uch.getUcPoints();
		if ("a".equals(replyType)) {
			ur.setUrFlag(3);
			uch.setUcPoints(points + 3);
		} else if("b".equals(replyType)){
			ur.setUrFlag(1);
			uch.setUcPoints(points + 1);
		}else {
			ur.setUrFlag(-2);
			uch.setUcPoints(points -2);
		}
		ucMapper.updateByPrimaryKeySelective(uch);
		urMapper.insertSelective(ur);
		
		
		List<SysUser> list = userMapper.queryTmByUser(userId);
		for (SysUser sysUser : list) {
			if(!userId.equals(sysUser.getUserId())) {
				
				UserReplyList ur2 = new UserReplyList();
				ur2.setUrId(UUID.randomUUID().toString());
				ur2.setQstnId(qstnId);
				ur2.setUrInfo("0");
				ur2.setUrTime(new Date());
				ur2.setUserId(userId);
								
				UserClassHistory uch2 = ucMapper.queryByUserId(sysUser.getUserId());
				int points2 = uch2.getUcPoints();
				if ("a".equals(replyType)) {
					ur2.setUrFlag(3);
					uch2.setUcPoints(points2 + 1);
				} else if("b".equals(replyType)){
					ur2.setUrFlag(1);
					uch2.setUcPoints(points2 + 0);
				}else {
					ur2.setUrFlag(-2);
					uch2.setUcPoints(points2 -1);
				}
				ucMapper.updateByPrimaryKeySelective(uch2);
				urMapper.insertSelective(ur2);
			}
		}
	}

	
}
