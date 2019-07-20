package com.yuzo.question.service;

import java.util.List;

import com.yuzo.question.entity.SysMenu;
import com.yuzo.question.entity.SysUser;

public interface ILoginService {

	List<SysUser> queryUserByName(String name);

	List<SysMenu> queryParMenu(String userId);

	List<SysMenu> queryChdMenu(String userId);

}
