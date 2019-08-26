package com.yuzo.question.service;

import java.util.List;
import java.util.Map;

import com.yuzo.question.entity.SysUser;
import com.yuzo.question.entity.UserMyclass;
import com.yuzo.question.entity.WorkList;
import com.yuzo.question.entity.WorkType;

public interface IWorkListService {

	List<WorkList> query();

	int save(WorkList wl);

	WorkList queryById(String wlId);

	int update(WorkList wl);

	int dels(String[] ids);

	List<WorkType> queryWt();

	List<UserMyclass> queryMc();

	List<Map<String, Object>> queryByMc(String mcId);

	List<SysUser> queryUserByMc(String mcId);

	Map<String, Object> classPointlist(String mcId);

}
