package com.xp.sys.system.dao.imp;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;

import com.xp.pojo.Menu;
import com.xp.pojo.Users;
import com.xp.sys.system.dao.IUsersDao;
import com.xp.utils.C3p0Util;
import com.xp.utils.StaticCode;
import com.xp.utils.ThisAsser;

public class UsersDaoImp implements IUsersDao {

	@Override
	public int addUsers(Users users) throws Exception {
		// TODO Auto-generated method stub
		//添加数据
		String sql="insert into  t_users  (roleId,usersName,usersSex,usersAge,usersPhone,usersAccount,usersPwd,usersSalsy) "
				+"  values (?,?,?,?,?,?,?,?)";
		
		return C3p0Util.update(sql, users.getRoleId(),users.getUsersName(),users.getUsersSex(),users.getUsersAge(),users.getUsersPhone()
				,users.getUsersAccount(),users.getUsersPwd(),users.getUsersSalsy());
	}

	@Override
	public boolean updateUsers(Users users) throws Exception {
		// TODO Auto-generated method stub
		String sql = "update t_users set usersName = ?, usersAge = ?, usersSex = ?, usersPhone = ?, roleId = ? ,usersPwd = ?, usersSalsy = ?, usersAccount = ? where usersId = ?";
		
		int update = C3p0Util.update(sql, users.getUsersName(),users.getUsersAge(),users.getUsersSex(),users.getUsersPhone(),users.getRoleId(),users.getUsersPwd(), users.getUsersSalsy(), users.getUsersAccount(), users.getUsersId());
				
		return ThisAsser.getIsNumber(update, "用户信息修改失败");
	}

	@Override
	public boolean delUsers(Users users) throws Exception {
		// TODO Auto-generated method stub
		//事务 假删除
		Connection conn = C3p0Util.getConn();
		int update = 0;
		try{
			String sql = "update t_users set usersMark = ? where usersId = ?";
			conn.setAutoCommit(false);
			
			QueryRunner queryRunner = new QueryRunner();
			Integer[] ids = users.getIds();
			
			for (int i = 0; i < ids.length; i++) {
				update = queryRunner.update(conn,sql,StaticCode.EXIT_CODE,ids[i]);
				
			}
			conn.commit();
			conn.setAutoCommit(true);
			
		}catch(Exception e){
			e.printStackTrace();
			
			conn.rollback();
		}
		
		return ThisAsser.getIsNumber(update, "用户删除失败");
	}

	@Override
	public List<Users> queryUsers(Users users) throws Exception {
		// TODO Auto-generated method stub
		
		StringBuffer sql = new StringBuffer("SELECT * from t_users where usersMark = ? ");
		
		ArrayList<Object> list = new ArrayList<>();
		list.add(StaticCode.OBJ_CODE);
		
		if(users.getUsersId() != null && users.getUsersId()!=0){
			sql.append(" and usersId = ? ");
			list.add(users.getUsersId());
		}
		
		if(users.getUsersName() != null && !"".equals(users.getUsersName())){
			sql.append(" and usersName like ? ");	
			list.add("%"+users.getUsersName()+"%");
		}
		return C3p0Util.queryList(sql.toString(), Users.class, list.toArray());
	}
	
	@Override
	public int checkUsersAcc(String acc) throws Exception {
		// TODO Auto-generated method stub
		String sql ="Select COUNT(usersId) from t_users where usersAccount = ? ";
		
		return C3p0Util.queryNumber(sql, Long.class, acc).intValue();
		
	}

	@Override
	public Users doLoginUsers(Users users) throws Exception {
		// TODO Auto-generated method stub
		String sql = "select * from t_users where usersAccount = ? and usersPwd = ? and usersMark = ?";
				
		return C3p0Util.queryOne(sql, Users.class, users.getUsersAccount(),users.getUsersPwd(),StaticCode.OBJ_CODE);
	}

	@Override
	public List<Menu> queryMenu(Integer id) throws Exception {
		// TODO Auto-generated method stub
		String  sql="select * from  t_role_menu  trm inner join  t_menu  tm on trm.menuId  = tm.menuId  where  trm.roleId  = ? ";
		return C3p0Util.queryList(sql,Menu.class, id);
	}

	@Override
	public boolean updateUsersInfo(Users users) throws Exception {
		// TODO Auto-generated method stub
		String sql = "update t_users set usersName = ?, usersAge = ?, usersSex = ?, usersPhone = ?, usersPwd = ? where usersId = ?";
		
		int update = C3p0Util.update(sql, users.getUsersName(),users.getUsersAge(),users.getUsersSex(),users.getUsersPhone(),users.getUsersPwd(),users.getUsersId());
		
		return ThisAsser.getIsNumber(update, "用户信息修改失败");
		
	}

}
