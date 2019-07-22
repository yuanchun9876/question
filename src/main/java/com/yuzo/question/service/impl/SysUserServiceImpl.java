package com.yuzo.question.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuzo.question.entity.SysRole;
import com.yuzo.question.entity.SysUser;
import com.yuzo.question.entity.SysUserRole;
import com.yuzo.question.entity.UserClassHistory;
import com.yuzo.question.entity.UserMyclass;
import com.yuzo.question.entity.UserTeam;
import com.yuzo.question.mapper.SysRoleMapper;
import com.yuzo.question.mapper.SysUserMapper;
import com.yuzo.question.mapper.SysUserRoleMapper;
import com.yuzo.question.mapper.UserClassHistoryMapper;
import com.yuzo.question.mapper.UserMyclassMapper;
import com.yuzo.question.mapper.UserTeamMapper;
import com.yuzo.question.page.SysUserPage;
import com.yuzo.question.service.ISysUserService;

@Service
public class SysUserServiceImpl implements ISysUserService {
	
	@Autowired
	private UserTeamMapper tmMapper;
	
	@Autowired
	private SysUserMapper mapper;
	
	@Autowired
	private UserMyclassMapper userMyclassMapper;

	@Autowired
	private UserClassHistoryMapper ucMapper;
	
	@Autowired
	private SysRoleMapper roleMapper;
	
	@Autowired
	private SysUserRoleMapper userRoleMapper;

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
	public int save(SysUser user, String mcId) {
		// TODO Auto-generated method stub
		String userId = UUID.randomUUID().toString();		
		user.setUserId(userId);
		user.setUserPass("123456");
		user.setUserInfo("/images/face/user1.png");
		
		int count = mapper.insertSelective(user);
		
		if(mcId!=null  &&  !"".equals(mcId)) {
			UserClassHistory uch = new UserClassHistory();
			uch.setUcId(UUID.randomUUID().toString());
			uch.setMcId(mcId);
			uch.setUserId(userId);
			uch.setUcPoints(0);
			uch.setUcInDate(new Date());
			uch.setUcState("1");
			int ucCount = ucMapper.insertSelective(uch);
			System.out.println("ucCount:" + ucCount);
		}
		return count;
	}



	@Override
	public List<UserTeam> querytm() {
		// TODO Auto-generated method stub
		return tmMapper.queryAll();
	}
	
	@Override
	public List<UserMyclass> querymc() {
		// TODO Auto-generated method stub
		return userMyclassMapper.queryAll();
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

	@Override
	public int updateUch(String userId, String mcId) {
		// TODO Auto-generated method stub
		// 先改
		int count = ucMapper.updateState(userId);
		System.out.println("修改:" + count);
		// 新添
		UserClassHistory uch = new UserClassHistory();
		uch.setUcId(UUID.randomUUID().toString());
		uch.setMcId(mcId);
		uch.setUserId(userId);
		uch.setUcPoints(0);
		uch.setUcInDate(new Date());
		uch.setUcState("1");
		
		int ucCount = ucMapper.insertSelective(uch);
		System.out.println("ucCount:" + ucCount);
//		SysUser user = new SysUser();

		
		return ucCount;
	}

	@Override
	public List<SysUser> queryTmByUser(String userId) {
		// TODO Auto-generated method stub
		return mapper.queryTmByUser(userId);
	}

	@Override
	public List<SysUser> queryByMcId(String mcId) {
		// TODO Auto-generated method stub
		return mapper.queryByMcId(mcId);
	}

	@Override
	public List<SysRole> queryRoleList() {
		// TODO Auto-generated method stub
		List<SysRole> roleList = new ArrayList<>();
		
		List<SysRole> list = roleMapper.queryAll();
		List<SysUserRole> urList = userRoleMapper.queryAll();
		
		for (SysRole role : list) {
			if("1".equals(role.getRoleState())) {
				for (SysUserRole sysUserRole : urList) {
					if(role.getRoleId().equals(sysUserRole.getRoleId())) {
						role.setRoleSelected("checked");
						break;
					}
				}
				roleList.add(role);
			}
		}
		
		return roleList;
	}

	@Override
	public int updateUserRole(String userId, String[] ids) {
		// TODO Auto-generated method stub
		// 先清空
		int c = userRoleMapper.delsByUserId(userId);
		
		// 再添加
		int count = 0;
		for (int i = 0; i < ids.length; i++) {
			SysUserRole ur = new SysUserRole();
			ur.setUrId(UUID.randomUUID().toString());
			ur.setRoleId(ids[i]);
			ur.setUserId(userId);
			count += userRoleMapper.insertSelective(ur);
		}
		return count;
	}



}
