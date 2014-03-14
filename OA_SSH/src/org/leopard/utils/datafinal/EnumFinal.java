package org.leopard.utils.datafinal;

public enum EnumFinal {
	VALIDATE_ERROR(1),
	USSERNAME_ERROR(2),
	PASSWORD_ERROR(3);
	private int flag;  
	EnumFinal(int flag){
		this.flag = flag;
	}
	public int getFlag(){
		return flag;
		
	}
}
