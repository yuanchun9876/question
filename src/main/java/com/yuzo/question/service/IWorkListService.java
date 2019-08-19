package com.yuzo.question.service;

import java.util.List;

import com.yuzo.question.entity.WorkList;

public interface IWorkListService {

	List<WorkList> query();

	int save(WorkList wl);

	WorkList queryById(String wlId);

	int update(WorkList wl);

	int dels(String[] ids);

}
