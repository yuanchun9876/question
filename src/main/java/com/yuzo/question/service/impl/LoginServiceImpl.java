package com.yuzo.question.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuzo.question.entity.QuestionFeedback;
import com.yuzo.question.entity.StuLevel;
import com.yuzo.question.entity.SysMenu;
import com.yuzo.question.entity.SysUser;
import com.yuzo.question.mapper.QuestionFeedbackMapper;
import com.yuzo.question.mapper.StuLevelMapper;
import com.yuzo.question.mapper.SysMenuMapper;
import com.yuzo.question.mapper.SysUserMapper;
import com.yuzo.question.service.ILoginService;

@Service
public class LoginServiceImpl implements ILoginService {

	@Autowired
	private SysUserMapper userMapper;
	
	@Autowired
	private SysMenuMapper menuMapper;
	
	@Autowired
	private StuLevelMapper slMapper;
	
	@Autowired
	private QuestionFeedbackMapper questionFeedbackMapper;

	@Override
	public List<SysUser> queryUserByName(String name) {
		// TODO Auto-generated method stub
		return userMapper.queryByName(name);
	}

	@Override
	public List<SysMenu> queryParMenu(String userId) {
		// TODO Auto-generated method stub
		return menuMapper.queryParMenu(userId);
	}

	@Override
	public List<SysMenu> queryChdMenu(String userId) {
		// TODO Auto-generated method stub
		List<SysMenu> plist = this.queryParMenu(userId);
		for (SysMenu sysMenu : plist) {
			List<SysMenu> chdList = menuMapper.queryChdMenu(userId, sysMenu.getMenuId());
			sysMenu.setChdList(chdList);
		}
		
		return plist;
	}

	@Override
	public int queryUserPoints(SysUser uu) {
		// TODO Auto-generated method stub
		
		return 0;
	}

	@Override
	public String queryUserCrse(SysUser uu) {
		// TODO Auto-generated method stub
		StuLevel userLevel = slMapper.selectByPrimaryKey(uu.getUserId());
		//System.out.println("userLevel:" + userLevel);
		return userLevel.getCrseNum();
	}

	@Override
	public int queryUserFeedback(SysUser uu) {
		// TODO Auto-generated method stub
		List<QuestionFeedback> list = questionFeedbackMapper.queryByUserId(uu.getUserId());
		
		return (list!=null && list.size()>0)?list.size():0;
	}

	@Override
	public int userTp(SysUser uu) {
		// TODO Auto-generated method stub
		return 0;
	}
}
