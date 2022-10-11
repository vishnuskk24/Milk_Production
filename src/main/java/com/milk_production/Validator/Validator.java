package com.milk_production.Validator;

import java.time.LocalDateTime;

import com.milk_production.Model.Session;

public class Validator {

	public static Session getSession() {
		LocalDateTime ldt  = LocalDateTime.now();
		if(ldt.getHour()>12) {
			return Session.Evening;
			
		}else {
			return Session.Morning;
		}
	}
}
