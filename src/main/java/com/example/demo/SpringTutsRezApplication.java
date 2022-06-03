package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import javax.jws.soap.SOAPBinding;

@SpringBootApplication
public class SpringTutsRezApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringTutsRezApplication.class, args);


		User user = context.getBean(User.class) ;
		user.setName("Abdullah");
		user.userInfo();

		User mUser = context.getBean(User.class) ;
		//mUser.setName("Munna");
		mUser.userInfo();






	}

}
