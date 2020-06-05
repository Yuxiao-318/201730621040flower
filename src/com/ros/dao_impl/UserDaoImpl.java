package com.ros.dao_impl;

import java.util.ArrayList;
import java.util.List;

import com.ros.dao.UserDao;
import com.ros.entity.UserBasicInfo;
import com.ros.entity.UserBean;
import com.ros.entity.UserDetailInfo;
import com.ros.util.BaseDao;
import com.ros.util.MD5Util;
import com.ros.util.PageData;;

/**
 * 自定义UserDao接口的实现类：UserDaoImpl
 * 
 * @author Administrator
 *
 */
public class UserDaoImpl implements UserDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ros.dao.UserDao#register()
	 */

	@Override
	/*
	 * 用户注册方法
	 * 
	 * @para userName 用户名
	 */
	public boolean register(String userName) {
		// TODO Auto-generated method stub
		String sql = "select * from user_basicinfo where userName=?";
		ArrayList<UserBasicInfo> list = (ArrayList<UserBasicInfo>) BaseDao.select(sql, UserBasicInfo.class, userName);
		if (list.size() > 0) {
			return false;
		} else {
			return true;
		}

	}

	/**
	 * 用户登录方法
	 * 
	 * @param userName
	 *            用户名
	 * @param userPwd
	 *            用户密码 return UserBasicInfo类
	 */
	@Override
	public UserBasicInfo login(String userName, String userPwd) {
		String sql = "select * from user_basicinfo where userName=? and userPwd=?";
		ArrayList<UserBasicInfo> list = (ArrayList<UserBasicInfo>) BaseDao.select(sql, UserBasicInfo.class, userName,
				userPwd);
		if (list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}

	}

	/*
	 * 
	 * 用户注册判断成功时，进行用户基本表的插入
	 */
	@Override
	public boolean insertUser(UserBasicInfo ub) {
		// TODO Auto-generated method stub
		String sql = "insert into user_basicinfo(userName,userPwd,createTime,updateTime) values (?,?,?,?)";

		return BaseDao.execute(sql, ub.getUserName(), ub.getUserPwd(), ub.getCreateTime(), ub.getUpdateTime()) > 0;
	}

	/**
	 * 用户修改密码方法
	 * 
	 * @param
	 * @param userName
	 *            用户名
	 * @param oldPwd
	 *            旧密码
	 * @param updateTime
	 *            修改时间
	 * 
	 * @param newPwd
	 *            新密码 return boolean true/修改密码成功 false/修改密码失败
	 */
	@Override
	public boolean upatePwd(String userName, String updateTime, String newPwd) {
		String sql = "update user_basicinfo set userPwd=? ,updateTime=? where userName=?";

		return BaseDao.execute(sql, newPwd, updateTime, userName) > 0;
	}

	/**
	 * 根据传入的用户名得出用户的所有基本信息
	 * 
	 * @param UserName
	 *            用户名
	 * @return 用户的基本信息
	 * @see com.ros.dao.UserDao#getUserBasicInfoByUserName(java.lang.String)
	 */
	@Override
	public UserBasicInfo getUserBasicInfoByUserName(String userName) {
		// TODO Auto-generated method stub
		String sql = "select * from user_basicinfo where userName=?";
		ArrayList<UserBasicInfo> list = (ArrayList<UserBasicInfo>) BaseDao.select(sql, UserBasicInfo.class, userName);
		if (list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}

	}

	/**
	 * <p>
	 * Title: insertUserDetail
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param uDI
	 * @return
	 * @see com.ros.dao.UserDao#insertUserDetail(com.ros.entity.UserDetailInfo)
	 */
	@Override
	public boolean insertUserDetail(UserDetailInfo uDI) {
		// TODO Auto-generated method stub
		String sql = "insert into user_detailsinfo(userId,userTel,createTime,updateTime) values(?,?,?,?)";
		boolean flag = BaseDao.execute(sql, uDI.getUserId(), uDI.getUserTel(), uDI.getCreateTime(),
				uDI.getUpdateTime()) > 0;

		return flag;
	}
	/**
	 * 后台用户信息展示
	 */
	@Override
	public List<UserBean> queryUsersBean() {
		// TODO Auto-generated method stub
		String sql = "select * from user_basicinfo a INNER JOIN user_detailsinfo b on a.userId=b.userId";
		return (List<UserBean>) BaseDao.select(sql, UserBean.class);
	}
	/**
	 * 后台用户管理分页
	 */
	@Override
	public PageData<UserBean> queryUserBeanByPage(int page, int pageSize, String keywords) {
		// TODO Auto-generated method stub
		String sql = "select b.userId,a.userName,b.name,b.userTel,b.userEmail from user_basicinfo a INNER JOIN user_detailsinfo b on a.userId=b.userId where userName like ?";
		PageData<UserBean> pd = BaseDao.getPage(sql, page, pageSize, UserBean.class, "%" + keywords + "%");
		return pd;
	}
	/**
	 * 后台添加用户
	 */
	@Override
	public boolean addUsers(UserBasicInfo ubi) {
		// TODO Auto-generated method stub
		String sql = "insert into user_basicinfo(userName,userPwd,createTime,updateTime) values (?,?,?,?)";
		return BaseDao.execute(sql, ubi.getUserName(),ubi.getUserPwd(),ubi.getCreateTime(),ubi.getUpdateTime())>0;
	}
}
