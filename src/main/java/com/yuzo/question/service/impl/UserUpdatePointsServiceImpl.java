package com.yuzo.question.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuzo.question.entity.SysUser;
import com.yuzo.question.entity.UserClassHistory;
import com.yuzo.question.entity.UserReplyList;
import com.yuzo.question.entity.UserUpdatePoints;
import com.yuzo.question.entity.UserUpdatePointsType;
import com.yuzo.question.mapper.SysUserMapper;
import com.yuzo.question.mapper.UserClassHistoryMapper;
import com.yuzo.question.mapper.UserReplyListMapper;
import com.yuzo.question.mapper.UserUpdatePointsMapper;
import com.yuzo.question.mapper.UserUpdatePointsTypeMapper;
import com.yuzo.question.service.IUserUpdatePointsService;

@Service
public class UserUpdatePointsServiceImpl implements IUserUpdatePointsService {

	@Autowired
	private UserReplyListMapper urMapper;
	
	@Autowired
	private UserUpdatePointsMapper uupMapper;
	
	@Autowired
	private UserUpdatePointsTypeMapper uuptMapper;
	
	@Autowired
	private SysUserMapper userMapper;
	
	@Autowired
	private UserClassHistoryMapper uchMapper;
	

	@Override
	public UserUpdatePointsType queryById(String uuptId) {
		// TODO Auto-generated method stub
		return uuptMapper.selectByPrimaryKey(uuptId);
	}

	@Override
	public int update(UserUpdatePoints uup) {
		// TODO Auto-generated method stub
		
		UserUpdatePoints olduup = uupMapper.selectByPrimaryKey(uup.getUupId());
		String olduuptId = olduup.getUuptId();
		UserUpdatePointsType olduupt = uuptMapper.selectByPrimaryKey(olduuptId);
		
		int count = uupMapper.updateByPrimaryKeySelective(uup);
		
		if(count > 0) {
			UserUpdatePointsType uupt = uuptMapper.selectByPrimaryKey(uup.getUuptId());
			SysUser user = userMapper.selectByPrimaryKey(uup.getUserId());
			UserClassHistory uch = uchMapper.queryByUserId(uup.getUserId());
			Integer points = uch.getUcPoints();
			
			uch.setUcPoints(points - olduupt.getUuptPrimaryPoint() + uupt.getUuptPrimaryPoint());
			uchMapper.updateByPrimaryKeySelective(uch);
			
			if ("1".equals(uupt.getUuptType())) {
				List<SysUser> tmList = userMapper.queryTmByUser(uup.getUserId());
				for (SysUser sysUser : tmList) {
					if(!user.getUserId().equals(sysUser.getUserId())) {
						UserClassHistory uch1 = uchMapper.queryByUserId(sysUser.getUserId());
						Integer points1 = uch1.getUcPoints();
						uch1.setUcPoints(points1 - olduupt.getUuptTeamPoint() + uupt.getUuptTeamPoint());
						uchMapper.updateByPrimaryKeySelective(uch1);
					}
				}
			} else if("1".equals(olduupt.getUuptType())) {
				List<SysUser> tmList = userMapper.queryTmByUser(uup.getUserId());
				for (SysUser sysUser : tmList) {
					if(!user.getUserId().equals(sysUser.getUserId())) {
						UserClassHistory uch1 = uchMapper.queryByUserId(sysUser.getUserId());
						Integer points1 = uch1.getUcPoints();
						uch1.setUcPoints(points1 - olduupt.getUuptTeamPoint());
						uchMapper.updateByPrimaryKeySelective(uch1);
					}
				}
			}
		}
		return count;
	}

	@Override
	public int dels(String[] ids) {
		// TODO Auto-generated method stub
		int count = 0;
		for (int i = 0; i < ids.length; i++) {
			count += uupMapper.deleteByPrimaryKey(ids[i]);
		}	
		return count;
	}

	@Override
	public List<UserReplyList> queryReplyByUserId(String userId) {
		// TODO Auto-generated method stub
		return urMapper.queryByUser(userId);
	}

	@Override
	public List<UserUpdatePoints> queryUupByUserId(String userId) {
		// TODO Auto-generated method stub
		return uupMapper.queryByUser(userId);
	}

	@Override
	public List<UserUpdatePointsType> queryUupt() {
		// TODO Auto-generated method stub
		return uuptMapper.queryAll();
	}

	@Override
	public int save(UserUpdatePoints uup) {
		// TODO Auto-generated method stub
		uup.setUupTime(new Date());
		int count = uupMapper.insertSelective(uup);
		if(count > 0) {
			UserUpdatePointsType uupt = uuptMapper.selectByPrimaryKey(uup.getUuptId());
			SysUser user = userMapper.selectByPrimaryKey(uup.getUserId());
			UserClassHistory uch = uchMapper.queryByUserId(uup.getUserId());
			Integer points = uch.getUcPoints();
			uch.setUcPoints(points + uupt.getUuptPrimaryPoint());
			uchMapper.updateByPrimaryKeySelective(uch);
			
			if ("1".equals(uupt.getUuptType())) {
				List<SysUser> tmList = userMapper.queryTmByUser(uup.getUserId());
				for (SysUser sysUser : tmList) {
					if(!user.getUserId().equals(sysUser.getUserId())) {
						UserClassHistory uch1 = uchMapper.queryByUserId(sysUser.getUserId());
						Integer points1 = uch1.getUcPoints();
						uch1.setUcPoints(points1 + uupt.getUuptTeamPoint());
						uchMapper.updateByPrimaryKeySelective(uch1);
					}
				}
			} 
		}
		
		return count;
	}

	@Override
	public UserUpdatePoints queryUupById(String uupId) {
		// TODO Auto-generated method stub
		return uupMapper.selectByPrimaryKey(uupId);
	}

}
