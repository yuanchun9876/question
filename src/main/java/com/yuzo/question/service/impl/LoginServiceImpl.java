package com.yuzo.question.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuzo.question.entity.SysMenu;
import com.yuzo.question.entity.SysUser;
import com.yuzo.question.mapper.SysMenuMapper;
import com.yuzo.question.mapper.SysUserMapper;
import com.yuzo.question.service.ILoginService;

@Service
public class LoginServiceImpl implements ILoginService {

	@Autowired
	private SysUserMapper userMapper;
	
	@Autowired
	private SysMenuMapper menuMapper;

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
}
