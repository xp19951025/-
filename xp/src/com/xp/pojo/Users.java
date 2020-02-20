package com.xp.pojo;

public class Users {
	/**
	 * @Fields usersId : TODO(用户编号)
	 */
	private  Integer  usersId; //int  
	/**
	 * @Fields roleId : TODO(编号)
	 */
	private  Integer  roleId; //int  

	/**
	 * @Fields userName : TODO(用户名称)
	 */
	private  String  usersName; //int  
	/**
	 * @Fields usersSex : TODO(用户性别)
	 */
	private  String  usersSex; //int  
	/**
	 * @Fields usersAge : TODO(用户年龄)
	 */
	private  Integer  usersAge; //int  
	/**
	 * @Fields usersPhone : TODO(用户的手机号)
	 */
	private  String  usersPhone; //int  
	/**
	 * @Fields usersId : TODO(用户账号)
	 */
	private  String  usersAccount; //int
	
	/**
	 * @Fields usersPwd : TODO(用户密码)
	 */
	private  String  usersPwd; //int  
	/**
	 * @Fields usersSalsy : TODO(用户底薪)
	 */
	private  Float  usersSalsy; //int  
	/**
	 * @Fields usersMark : TODO(用户标示)
	 */
	private  String  usersMark; //int
	
	private String roleName;
	
	private String ck;
	
	private Integer[] ids;
	
	public Integer[] getIds() {
		return ids;
	}
	public void setIds(Integer[] ids) {
		this.ids = ids;
	}
	public String getCk() {
		ck="<input type='checkbox' name='ids' value='"+this.getUsersId()+"'  />";
		return ck;
	}
	public void setCk(String ck) {
		this.ck = ck;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public Integer getUsersId() {
		return usersId;
	}
	public void setUsersId(Integer usersId) {
		this.usersId = usersId;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public String getUsersName() {//usersName
		return usersName;
	}
	public void setUsersName(String usersName) {
		this.usersName = usersName;
	}
	public String getUsersSex() {
		return usersSex;
	}
	public void setUsersSex(String usersSex) {
		this.usersSex = usersSex;
	}
	public Integer getUsersAge() {
		return usersAge;
	}
	public void setUsersAge(Integer usersAge) {
		this.usersAge = usersAge;
	}
	public String getUsersPhone() {
		return usersPhone;
	}
	public void setUsersPhone(String usersPhone) {
		this.usersPhone = usersPhone;
	}
	public String getUsersAccount() {
		return usersAccount;
	}
	public void setUsersAccount(String usersAccount) {
		this.usersAccount = usersAccount;
	}
	public String getUsersPwd() {
		return usersPwd;
	}
	public void setUsersPwd(String usersPwd) {
		this.usersPwd = usersPwd;
	}
	public Float getUsersSalsy() {
		return usersSalsy;
	}
	public void setUsersSalsy(Float usersSalsy) {
		this.usersSalsy = usersSalsy;
	}
	public String getUsersMark() {
		return usersMark;
	}
	public void setUsersMark(String usersMark) {
		this.usersMark = usersMark;
	}
	@Override
	public String toString() {
		return "Users [usersId=" + usersId + ", roleId=" + roleId + ", usersName=" + usersName + ", usersSex="
				+ usersSex + ", usersAge=" + usersAge + ", usersPhone=" + usersPhone + ", usersAccount=" + usersAccount
				+ ", usersPwd=" + usersPwd + ", usersSalsy=" + usersSalsy + ", usersMark=" + usersMark + ", roleName="
				+ roleName + "]";
	}
		
	
}
