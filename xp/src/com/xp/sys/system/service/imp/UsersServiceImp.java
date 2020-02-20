package com.xp.sys.system.service.imp;

import java.util.ArrayList;
import java.util.List;

import com.xp.pojo.Menu;
import com.xp.pojo.Users;
import com.xp.sys.system.dao.IUsersDao;
import com.xp.sys.system.dao.imp.UsersDaoImp;
import com.xp.sys.system.service.IUsersService;

import static com.xp.utils.StaticCode.*;

import static com.xp.utils.ThisAsser.*;

public class UsersServiceImp implements IUsersService {

	//Dao
	IUsersDao dao = new UsersDaoImp();
	@Override
	public boolean addUsers(Users users) throws Exception {
		// TODO Auto-generated method stub
		//断言
		getIsNotNull(users.getUsersName(), "用户名不能为空！");
		getIsNotNull(users.getUsersAccount(), "账号不能为空！");
		getIsNotNull(users.getUsersPwd(), "密码不能为空！");
				
		
		//后台断言
		int checkUsersAcc = dao.checkUsersAcc(users.getUsersAccount());	
		getNumber(checkUsersAcc, "当前账号不可用");
		
		int addUsers = dao.addUsers(users);
		if(addUsers>0){
			return true;
		}else{		
		return false;
		}
	}

	@Override
	public boolean updateUsers(Users users) throws Exception {
		// TODO Auto-generated method stub
		return dao.updateUsers(users);
	}

	@Override
	public boolean delUsers(Users users) throws Exception {
		// TODO Auto-generated method stub
		
		return dao.delUsers(users);
	}

	@Override
	public List<Users> queryUsers(Users users) throws Exception {
		// TODO Auto-generated method stub
		ArrayList<Users> arrayList = new ArrayList<>();
		
		List<Users> queryUsers = dao.queryUsers(users);
		for(Users users2 : queryUsers){			
			if(STAFF_CODE_NUMBER == users2.getRoleId()){
				users2.setRoleName(STAFF_CODE);
			}
			if(MANAGEER_CODE_NUMBER == users2.getRoleId()){
				users2.setRoleName(MANAGEER_CODE);
			}
			if(FINAN_CODE_NUMBER == users2.getRoleId()){
				users2.setRoleName(FINAN_CODE);
			}
			if(ADMIN_CODE_NUMBER == users2.getRoleId()){
				users2.setRoleName(ADMIN_CODE);
			}
			arrayList.add(users2);
			
		}
				
		return arrayList;
	}

	@Override
	public boolean checkUsersAcc(String acc) throws Exception {
		// TODO Auto-generated method stub
		//断言
		getIsNotNull(acc, "用户名不能为空");
		int checkUsersAcc = dao.checkUsersAcc(acc);
//		if(checkUsersAcc>0){
//			return true;
//		}
		return getNumber(checkUsersAcc, "当前账号不可用");
		
	}

	@Override
	public Users doLoginUsers(Users users) throws Exception {
		// TODO Auto-generated method stub
		
		getIsNotNull(users.getUsersAccount(), "账号不能为空");
		getIsNotNull(users.getUsersPwd(), "密码不能为空");
				
		Users doLoginUsers = dao.doLoginUsers(users);
		//再次断言是否有数据
		getIsObject(doLoginUsers, "账号与密码不匹配");
		
		return doLoginUsers;
	}

	@Override
	public List<Menu> queryMenu(Integer id) throws Exception {
		// TODO Auto-generated method stub
		getIsNumber(id,"非法登录");
		
		return dao.queryMenu(id);
	}

	@Override
	public boolean updateUsersInfo(Users users) throws Exception {
		// TODO Auto-generated method stub
		return dao.updateUsersInfo(users);
	}
}
