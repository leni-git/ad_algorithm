package test;
 
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

import com.mysql.fabric.xmlrpc.base.Array;

public class test2 {
	public static void main (String[] args) throws java.lang.Exception
	{
		String inData = "23four5six7";
		String result = solution(inData);
		System.out.println("test==========================="+result);		
	}
  
	public int solution(String s) {
		// String result = s+"END";
		String result = s;
		String[] alpa = {"zero","one","two","three","four","five","six","seven","eight","nine"};

		for(int i = 0; i < alpa.length; i++) {
			result = result.replaceAll(alpa[i], Integer.toString(i));
			//	result = String.join(Integer.toString(i) , result.split(alpa[i]))+Integer.toString(i);
		}
		//result = result.split("END")[0];
		//System.out.println(result);
		return Integer.parseInt(result);
	}

}


