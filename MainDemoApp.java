package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
	
		//read spring config java class
		AnnotationConfigApplicationContext context = new
				AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get bean from container
		AccountDAO theAccountDAO = context.getBean("accountDAO",AccountDAO.class);
		
		//call business method
		Account myAccount = new Account();
		boolean vipFlag = true;
		theAccountDAO.addAccount(myAccount, vipFlag);
		theAccountDAO.doWork();
		
		//Get membershipDAO object
		MembershipDAO theMembershipDAO = context.getBean("membershipDAO",MembershipDAO.class);
		theMembershipDAO.goToSleep();
		
		//call membership business method
		theMembershipDAO.addMemberAccount();
		
		//close context
		context.close();

	}

}
