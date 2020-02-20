package com.xp.utils;

public class StaticCode {

	
	/**
	 * OBJ_CODE 在职/未删除
	 * EXIT_CODE 离职/删除
	 * STAFF_CODE  普通员工
	 * MANAGEER_CODE  部门经理
	 * FINAN_CODE 财务人员
	 * ADMIN_CODE 超级管理员
	 */
	public static final String OBJ_CODE="0",EXIT_CODE="1",STAFF_CODE="普通员工",
			MANAGEER_CODE="部门经理",FINAN_CODE="财务人员",ADMIN_CODE="超级管理员";
	
	
	/**
	 * STAFF_CODE_NUMBER  普通员工
	 * MANAGEER_CODE_NUMBER  部门经理
	 * FINAN_CODE_NUMBER 财务人员
	 * ADMIN_CODE_NUMBER 超级管理员
	 */
	public static final Integer STAFF_CODE_NUMBER = 1,
			MANAGEER_CODE_NUMBER = 2,FINAN_CODE_NUMBER = 3,ADMIN_CODE_NUMBER = 4;
	
	public static final String MANAGEER_AUOT_OK_CODE="经理审核通过"
			,FINAN_AUOT_OK_CODE="财务审核通过"
			,FINAN_AUOT_ON_CODE="财务审核未通过"
			,MANAGEER_AUOT_ON_CODE="经理审核未通过"
			,MANAGEER_AUOT_STAY_CODE="待经理审核通过";	

	public static final String MANAGEER_AUOT_OK_CODE_NUMBER = "4"
							   ,FINAN_AUOT_OK_CODE_NUMBER = "2"
							   ,FINAN_AUOT_ON_CODE_NUMBER = "1"
							   ,MANAGEER_AUOT_ON_CODE_NUMBER = "3"
							   ,AUOT_STAY_CODE = "0";
}
