package com.yuzo.question.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuzo.question.entity.SysUser;
import com.yuzo.question.entity.UserMyclass;
import com.yuzo.question.entity.UserUpdatePoints;
import com.yuzo.question.entity.WorkList;
import com.yuzo.question.entity.WorkType;
import com.yuzo.question.mapper.SysUserMapper;
import com.yuzo.question.mapper.UserMyclassMapper;
import com.yuzo.question.mapper.UserUpdatePointsMapper;
import com.yuzo.question.mapper.WorkListMapper;
import com.yuzo.question.mapper.WorkTypeMapper;
import com.yuzo.question.service.IWorkListService;



@Service
public class WorkListServiceImpl implements IWorkListService{

	@Autowired
	private WorkListMapper mapper;
	
	@Autowired
	private WorkTypeMapper wtMapper;
	
	@Autowired
	private UserMyclassMapper userMyclassMapper;
	
	@Autowired
	private SysUserMapper userMapper;
	
	@Autowired
	private UserUpdatePointsMapper uupMapper;
	

	@Override
	public int save(WorkList entity) {
		// TODO Auto-generated method stub
//		WorkType wt = wtMapper.selectByPrimaryKey(entity.getWtId());
//		
//		String newName = wt.getWtCode() + "." + entity.getWlTitle();
//		entity.setWlTitle(newName);
		
		return mapper.insertSelective(entity);
	}

	@Override
	public WorkList queryById(String wlId) {
		// TODO Auto-generated method stub
		return mapper.selectByPrimaryKey(wlId);
	}

	@Override
	public List<WorkList> query() {
		// TODO Auto-generated method stub.
		return mapper.queryAll();
	}

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
	public int update(WorkList entity) {
		// TODO Auto-generated method stub
//		WorkType wt = wtMapper.selectByPrimaryKey(entity.getWtId());
//		
//		String newName = wt.getWtCode() + "." + entity.getWlTitle();
//		entity.setWlTitle(newName);
		
		return mapper.updateByPrimaryKeySelective(entity);
	}

	@Override
	public List<WorkType> queryWt() {
		// TODO Auto-generated method stub
		return wtMapper.queryAll();
	}

	@Override
	public List<UserMyclass> queryMc() {
		// TODO Auto-generated method stub
		return userMyclassMapper.queryAll();
	}

	@Override
	public List<Map<String, Object>> queryByMc(String mcId) {
		// TODO Auto-generated method stub
		List<WorkList> wlList = mapper.queryAll();
		List<SysUser>  userlist = userMapper.queryByMcId(mcId);
		List<Map<String, Object>> list = new ArrayList<>();
		for (WorkList wl : wlList) {
			Map<String, Object> map = new HashMap<>();
			map.put("wlTitle",wl.getWtName() + "." + wl.getWlTitle());
			List<Integer> proints = new ArrayList<>();
			List<String> levels = new ArrayList<>();
			for (SysUser sysUser : userlist) {
//				System.out.println(sysUser.getNickName());
				UserUpdatePoints uup = uupMapper.queryByUserAndWl(sysUser.getUserId(), wl.getWlId());
				Integer p = uup==null?0:uup.getUuptPrimaryPoint();
				proints.add(p);
				switch (p) {
				case 3:
					levels.add("<button type=\"button\" class=\"btn btn-primary btn-xs\">优秀</button>");
					break;
				case 5:
					levels.add("<button type=\"button\" class=\"btn btn-primary btn-xs\">优秀</button>");
					break;
				case 1:
					levels.add("<button type=\"button\" class=\"btn btn-info btn-xs\">一般</button>");
					break;
				case 2:
					levels.add("<button type=\"button\" class=\"btn btn-info btn-xs\">一般</button>");
					break;
				case 0:
					levels.add("<button type=\"button\" class=\"btn  btn-xs\">无</button>");
					break;
				case -1:
					levels.add("<button type=\"button\" class=\"btn btn-warning btn-xs\">不完整</button>");
					break;
				case -2:
					levels.add("<button type=\"button\" class=\"btn btn-danger btn-xs\">未完成</button>");
					break;

				default:
					levels.add("<button type=\"button\" class=\"btn  btn-xs\">无</button>");
					break;
				}
			}
			map.put("proints", proints);
			map.put("levels", levels);
			list.add(map);
		}
			
		return list;
	}

	@Override
	public List<SysUser> queryUserByMc(String mcId) {
		// TODO Auto-generated method stub
		return userMapper.queryByMcId(mcId);
	}
}
