package com.lxy.basic;

import java.util.Scanner;
/*
 * 理解有点问题!
 * 样例输入
　　2
　　39
　　123ABC

样例输出
　　71
　　4435274
 */

/*
 *通过该类对象调用ChangToBit(char c)方法可返回2进制表示的字符串 
 */
class Hexadecimal{
	String[] hex={
		"0000","0001","0010","0011","0100","0101","0110","0111",
		"1000","1001","1010","1011","1100","1101","1110","1111"
	};
	public String ChangeToBit(char c){
		if(c>='0'&&c<='9'){
			return hex[c-'0'];
		}
		else return hex[c-'A'+10];
	}
}

/*
 * 通过调用该类对象的changeToOex(String astring)方法可返回该3位2进制串的8进制数值
 */
class Oex{
	String[] oex={
			"000","001","010","011","100","101","110","111"
	};
	public int changeToOex(String astring){
		for(int i=0;i<8;i++){
			if(oex[i].equals(astring)==true){
				return i;
			}
		}
		return 0;
	}
}

public class Main12_HexToOct {
	/**
	 * @param args
	 */
	static Hexadecimal hex=new Hexadecimal();
	static Oex oex=new Oex();
	
	//将aString的位数在字符串开头补全为3的倍数，返回补全后的字符串
	public static String BuQuanSanWei(String aString){
		String ret="";
		if(aString.length()%3==0) return aString;
		if((aString.length()+1)%3==0){
			ret+="0";
			ret+=aString;
			return ret;
		}
		ret+="00";
		ret+=aString;
		return ret;
	}
	
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int N=scan.nextInt();
		while(N--!=0){
			String aString=scan.next();
			
			//必须用StringBuilder建立2进制字符串，否则由于需建立的字符太长会超时
			StringBuilder bitStringbuilder=new StringBuilder();
			for(int i=0;i<aString.length();i++){
				bitStringbuilder.append(hex.ChangeToBit(aString.charAt(i)));
			}
			
			//补全位数为3的倍数
			String bitString=BuQuanSanWei(bitStringbuilder.toString());
			
			//标记是否有输出
			int hasOut=0;
			
			for(int i=0;i<bitString.length()-2;i+=3){
				String nowCun="";
				nowCun+=bitString.charAt(i);
				nowCun+=bitString.charAt(i+1);
				nowCun+=bitString.charAt(i+2);
				int Num=oex.changeToOex(nowCun);
				if(i==0&&Num==0) continue;
				hasOut=1;
				System.out.print(Num);
			}
			
			if(hasOut==0) System.out.print("0");
			
			System.out.println();
		}
		scan.close();
	}
}