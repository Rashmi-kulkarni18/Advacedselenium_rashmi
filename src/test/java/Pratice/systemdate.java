package Pratice;

import java.util.Date;

public class systemdate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date d = new Date();
		
		String date = d.toString().replace(" ", "-").replace(":", "-");
		System.out.println(date);	
	}

}
