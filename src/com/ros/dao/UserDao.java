package com.ros.dao;

import java.util.List;

import org.apache.catalina.realm.UserDatabaseRealm;

import com.ros.entity.UserBasicInfo;
import com.ros.entity.UserBean;
import com.ros.entity.UserDetailInfo;
import com.ros.util.PageData;

/**
 * UserDao 接口
 */
public interface UserDao {

	public boolean register(String userName);// 用户注册方法（判断）

	UserBasicInfo login(String userName, String userPwd);// 用户登录方法

	public boolean insertUser(UserBasicInfo ub);// 注册成功时进行插入

	boolean upatePwd(String userName, String updateTime, String newPwd);// 用户修改密码

	public UserBasicInfo getUserBasicInfoByUserName(String userName);// 根据用户名查询出用户信息

	public boolean insertUserDetail(UserDetailInfo uDI);// 注册成功时同时插入用户详情表

	/**
	 * @Title: queryUsersBean
	 * @Description: TODO(后台用户信息展示)
	 * @return List<UserBean> 返回类型
	 */
	List<UserBean> queryUsersBean();

	/**
	 * @Title: queryUserBeanByPage
	 * @Description: TODO(后台用户管理分页)
	 * @param page
	 * @param pageSize
	 * @param keywords
	 * @return PageData<UserBean> 返回类型
	 */
	PageData<UserBean> queryUserBeanByPage(int page, int pageSize, String keywords);

	public boolean addUsers(UserBasicInfo ubi);// 后台添加用户

}
