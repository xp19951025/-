package com.xp.utils;
/*
 * 断言；进行数据判断
 */
public class ThisAsser {

	public static void getThisException(final String message) throws MyException{
		throw new MyException(message);
	}
	
	//Ages 需要判断的参数  message 提示信息
	public static String getIsNotNull(String arges, final String message )throws MyException{
		if(arges == null || (arges=arges.trim()).length() == 0){
			getThisException(message);
		}			
		return arges;
	}
	
	//为空
	@SuppressWarnings("null")
	public static String getIsNull(String arges, final String message )throws MyException{
		if(arges != null || (arges=arges.trim()).length() > 0){
			getThisException(message);
		}			
		return arges;
	}
	
	
	
	//返回有数据，有查询到数据		
	public static boolean getIsNumber(Integer arges,final String message)throws MyException{
		if(arges == 0 || arges == null){
			getThisException(message);			
		}
		return true;
	}
	
			
	public static boolean getNumber(Integer arges,final String message)throws MyException{
		if(arges > 0 ){
			getThisException(message);			
		}
		return true;
	}
	
	//断言对象是否有数据
	public static Object getIsObject(Object arges,final String message)throws MyException{
		if(arges == null){
			getThisException(message);			
		}
		return arges;
	}
	
}
