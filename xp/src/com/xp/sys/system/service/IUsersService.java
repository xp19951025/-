package com.xp.sys.system.service;

import java.util.List;

import com.xp.pojo.Menu;
import com.xp.pojo.Users;

public interface IUsersService {

	//添加数据
	boolean addUsers(Users users)throws Exception;
	
	//修改
	boolean updateUsers(Users users)throws Exception;
	boolean updateUsersInfo(Users users)throws Exception;
	
	//删除
	boolean delUsers(Users users)throws Exception;	
	
	//查询所有
	List<Users> queryUsers(Users users)throws Exception;
	
	//验证账号
	boolean checkUsersAcc(String acc)throws Exception;
	
	//查询返回对象
	Users doLoginUsers(Users users)throws Exception;
	
	//查询权限 id角色编号
	List<Menu> queryMenu(Integer id)throws Exception;
	
}
