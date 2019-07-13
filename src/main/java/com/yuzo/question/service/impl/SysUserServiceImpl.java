package com.yuzo.question.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuzo.question.entity.SysUser;
import com.yuzo.question.entity.UserTeam;
import com.yuzo.question.mapper.SysUserMapper;
import com.yuzo.question.mapper.UserTeamMapper;
import com.yuzo.question.page.SysUserPage;
import com.yuzo.question.service.ISysUserService;

@Service
public class SysUserServiceImpl implements ISysUserService {
	
	@Autowired
	private UserTeamMapper tmMapper;
	
	@Autowired
	private SysUserMapper mapper;


	@Override
	public int dels(String[] ids) {
		// TODO Auto-generated method stub
		int count = 0;
		for (int i = 0; i < ids.length; i++) {
			count += mapper.deleteByPrimaryKey(ids[i]);
		}
		return count;
	}

	@Override
	public int update(SysUser tm) {
		// TODO Auto-generated method stub
		return mapper.updateByPrimaryKeySelective(tm);
	}

	@Override
	public SysUser queryById(String tmId) {
		// TODO Auto-generated method stub
		return mapper.selectByPrimaryKey(tmId);
	}

	@Override
	public int save(SysUser tm) {
		// TODO Auto-generated method stub
		tm.setUserId(UUID.randomUUID().toString());
		return mapper.insertSelective(tm);
	}



	@Override
	public List<UserTeam> querytm() {
		// TODO Auto-generated method stub
		return tmMapper.queryAll();
	}

	@Override
	public List<SysUser> queryPage(SysUserPage page) {
		// TODO Auto-generated method stub
		return mapper.queryPage(page);
	}



	@Override
	public List<SysUser> queryAll() {
		// TODO Auto-generated method stub
		return mapper.queryAll();
	}

}
