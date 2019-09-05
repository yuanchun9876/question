package com.yuzo.question.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
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
import com.yuzo.question.util.SmsUtil;

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

		//int updateuc = ucMapper.updateBeforeClass(userId, mcId);
		
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
	public List<SysRole> queryRoleList(List<SysUserRole> urList) {
		// TODO Auto-generated method stub
		List<SysRole> roleList = new ArrayList<>();
		
		List<SysRole> list = roleMapper.queryAll();
		//List<SysUserRole> urList = userRoleMapper.queryAll();
		
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

	@Override
	public List<SysUser> queryByName(String userName) {
		// TODO Auto-generated method stub
		return mapper.queryByName(userName);
	}

	@Override
	public List<SysUserRole> queryUserRole(String userId) {
		// TODO Auto-generated method stub
		return userRoleMapper.queryByUser(userId);
	}

	@Override
	public JSONObject checkCustomertTel(String tel, HttpSession session) {
		// TODO Auto-generated method stub
		JSONObject obj = new JSONObject();
		if(mapper.checkTel(tel)>0) {
			obj.put("result", "fail");
			obj.put("message", "该手机号已被占用!");
			
		}else {
			
			obj.put("result", "success");
			obj.put("message", "验证通过");
		}
		return obj;
	}


	@Override
	public JSONObject sendCode(String tel, HttpSession session) {
		// TODO Auto-generated method stub
		//得到客户建档发送验证码模板
		JSONObject obj = new JSONObject();
		try {
			
			//生成6位随机验证码
			String code = SmsUtil.getRandNum(6);
			System.out.println(code);
			
			SendSmsResponse response = SmsUtil.sendSms(tel, "code", code, "SMS_155571050");//SMS_155571050  SMS_164150336 
			if(response!=null && "OK".equals(response.getCode())) {
				obj.put("result", "success");
				obj.put("message", "验证码发送成功!");
				//存储短信记录
				//Session session = SecurityUtils.getSubject().getSession();
				
				//得到短信内容
				String info = "感谢您成为我们的一员，您的验证码为：${code}，该验证码3分钟内有效，请勿泄露给他人。";
				String smsInfo = info.replace("${code}", code);

				//将验证码存入session中
				session.setAttribute("SESSION_CHECKCODE", code);
				
				//开一个定时线程，3分钟后清空session中的验证码
				Timer timer=new Timer();
				timer.schedule(new TimerTask() {
					@Override public void run() { 
						session.removeAttribute("SESSION_CHECKCODE"); 
						timer.cancel(); 
					} 
				},3*60*1000);
			}else {
				obj.put("result", "fail");
				obj.put("message", "验证码发送失败，请重试!");
			}
			return obj;
			
		
		} catch (ClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}

	
	@Override
	public JSONObject checkSMSCode(String smsCode, HttpSession session) {
		// TODO Auto-generated method stub
		System.out.println("smsCode:" + smsCode);
		JSONObject obj = new JSONObject();
		String checkCode = (String) session.getAttribute("SESSION_CHECKCODE");
		System.out.println("checkCode:" + checkCode);
		if(checkCode == null) {
			obj.put("result", "fail");
			obj.put("message", "验证码已过期，请重新发送!");
		}else if(!checkCode.equals(smsCode)){
			obj.put("result", "fail");
			obj.put("message", "验证码不正确!");
		}else {
			obj.put("result", "success");
			obj.put("message", "验证通过");
		}
		return obj;
	}

	@Override
	public JSONObject registerUser(SysUser user, HttpSession session) {
		JSONObject obj = new JSONObject();
		
		String userId = UUID.randomUUID().toString();
		
		user.setUserId(userId);
		user.setUserPhone(user.getUserName());
		user.setUserInfo("/images/face/user1.png");
		user.setTmId("0");
		user.setUserState("0");
		int count = mapper.insertSelective(user);
		
		// f39376b6-316f-4a8f-acc1-1db8cf6d27d3  学生角色
		SysUserRole ur = new SysUserRole();
		ur.setRoleId("f39376b6-316f-4a8f-acc1-1db8cf6d27d3");
		ur.setUserId(userId);
		ur.setUrId(UUID.randomUUID().toString());
		int urcount = userRoleMapper.insertSelective(ur);
		
		// 0 新生待分配
		UserClassHistory uch = new UserClassHistory();
		uch.setUcId(UUID.randomUUID().toString());
		uch.setMcId("0");
		uch.setUcInDate(new Date());
		uch.setUcPoints(0);
		uch.setUcState("1");
		uch.setUserId(userId);
		int ucCount = ucMapper.insertSelective(uch);
		
		if((count + urcount + ucCount) > 1) {
			obj.put("result", "success");
			obj.put("message", "保存成功");
		}else if(urcount < 1){
			obj.put("result", "fail");
			obj.put("message", "角色设置失败!");
		}else if(count < 1){
			obj.put("result", "fail");
			obj.put("message", "保存失败!");
		}else if(ucCount < 1){
			obj.put("result", "fail");
			obj.put("message", "分班失败!");
		}else {
			obj.put("result", "fail");
			obj.put("message", "失败!");
		}
		return obj;
	}

	@Override
	public int setName(String userId) {
		// TODO Auto-generated method stub
		SysUser user = this.queryById(userId);
		user.setUserState("1");
		return mapper.updateByPrimaryKeySelective(user);
	}
}
