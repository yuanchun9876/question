package com.yuzo.question.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuzo.question.entity.SysUser;
import com.yuzo.question.entity.UserClassHistory;
import com.yuzo.question.entity.UserReplyList;
import com.yuzo.question.entity.UserUpdatePoints;
import com.yuzo.question.entity.UserUpdatePointsType;
import com.yuzo.question.entity.WorkList;
import com.yuzo.question.mapper.SysUserMapper;
import com.yuzo.question.mapper.UserClassHistoryMapper;
import com.yuzo.question.mapper.UserReplyListMapper;
import com.yuzo.question.mapper.UserUpdatePointsMapper;
import com.yuzo.question.mapper.UserUpdatePointsTypeMapper;
import com.yuzo.question.mapper.WorkListMapper;
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
	
	@Autowired
	private WorkListMapper wlMapper;
	

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
		// 查询 修改前的类型
		UserUpdatePointsType olduupt = uuptMapper.selectByPrimaryKey(olduuptId);
		
		int count = uupMapper.updateByPrimaryKeySelective(uup);
		
		if(count > 0) {
			
			UserUpdatePointsType uupt = uuptMapper.selectByPrimaryKey(uup.getUuptId());
			SysUser user = userMapper.selectByPrimaryKey(uup.getUserId());
			UserClassHistory uch = uchMapper.queryByUserId(uup.getUserId());
			Integer points = uch.getUcPoints();
			
			uch.setUcPoints(points - olduupt.getUuptPrimaryPoint() + uupt.getUuptPrimaryPoint());
			uchMapper.updateByPrimaryKeySelective(uch);
			
			// 如果 原来是团队的
			if("1".equals(olduupt.getUuptType())) {
				List<SysUser> tmList = userMapper.queryTmByUser(uup.getUserId());
				for (SysUser sysUser : tmList) {
					if(!user.getUserId().equals(sysUser.getUserId())) {
						// 恢复 团队其它成员扣的分
						UserClassHistory uch1 = uchMapper.queryByUserId(sysUser.getUserId());
						Integer points1 = uch1.getUcPoints();
						uch1.setUcPoints(points1 - olduupt.getUuptTeamPoint());
						uchMapper.updateByPrimaryKeySelective(uch1);
						
						// 删除原来的相关扣分记录
						uupMapper.delByRela(uup.getUupId());
					}
				}
			}
			
			
			// 如果 是 团队
			if ("1".equals(uupt.getUuptType())) {
				List<SysUser> tmList = userMapper.queryTmByUser(uup.getUserId());
				for (SysUser sysUser : tmList) {
					if(!user.getUserId().equals(sysUser.getUserId())) {
						// 团队其它队员扣分
						UserClassHistory uch1 = uchMapper.queryByUserId(sysUser.getUserId());
						Integer points1 = uch1.getUcPoints();
						uch1.setUcPoints(points1 - olduupt.getUuptTeamPoint() + uupt.getUuptTeamPoint());
						uchMapper.updateByPrimaryKeySelective(uch1);
						
						// 并 增加记录
						UserUpdatePoints uupUser = new UserUpdatePoints();
						uupUser.setUupId(UUID.randomUUID().toString());
						uupUser.setUserId(sysUser.getUserId());
						uupUser.setUupInfo("关联人:" + user.getNickName() );
						uupUser.setUuptId(uup.getUuptId());
						uupUser.setUupTime(new Date());
						uupUser.setWlId(uup.getWlId());
						uupUser.setRelationUupId(uup.getUupId());
						uupMapper.insertSelective(uupUser);
						
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
			UserUpdatePoints uup = uupMapper.selectByPrimaryKey(ids[i]);
			System.out.println("uup:" + uup);
			if(uup.getRelationUupId()!=null && !"".equals(uup.getRelationUupId())) {
				continue;
			}
			String uuptId = uup.getUuptId();
			// 查询 修改前的类型
			UserUpdatePointsType uupt = uuptMapper.selectByPrimaryKey(uuptId);
			
		
			SysUser user = userMapper.selectByPrimaryKey(uup.getUserId());
			UserClassHistory uch = uchMapper.queryByUserId(uup.getUserId());
			Integer points = uch.getUcPoints();
			
			uch.setUcPoints(points - uupt.getUuptPrimaryPoint());
			uchMapper.updateByPrimaryKeySelective(uch);
			
			// 如果 原来是团队的
			if("1".equals(uupt.getUuptType())) {
				List<SysUser> tmList = userMapper.queryTmByUser(uup.getUserId());
				for (SysUser sysUser : tmList) {
					if(!user.getUserId().equals(sysUser.getUserId())) {
						// 恢复 团队其它成员扣的分
						UserClassHistory uch1 = uchMapper.queryByUserId(sysUser.getUserId());
						Integer points1 = uch1.getUcPoints();
						uch1.setUcPoints(points1 - uupt.getUuptTeamPoint());
						uchMapper.updateByPrimaryKeySelective(uch1);
						
						// 删除原来的相关扣分记录
						uupMapper.delByRela(uup.getUupId());
					}
				}
			}
			
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
		
		if("4141803c-4be5-4233-81a3-e64c43f4785d".equals(uup.getUuptId())) {
			// 这类是 试题意见
		}
		
		
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
						
						UserUpdatePoints uupUser = new UserUpdatePoints();
						uupUser.setUupId(UUID.randomUUID().toString());
						uupUser.setUserId(sysUser.getUserId());
						uupUser.setUupInfo("关联人:" + user.getNickName() );
						uupUser.setUuptId(uup.getUuptId());
						uupUser.setUupTime(new Date());
						uupUser.setWlId(uup.getWlId());
						uupUser.setRelationUupId(uup.getUupId());
						uupMapper.insertSelective(uupUser);
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

	@Override
	public List<WorkList> queryWl() {
		// TODO Auto-generated method stub
		return wlMapper.queryAll();
	}

}
