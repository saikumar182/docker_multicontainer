package com.example.Twilio;

import com.twilio.Twilio;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TwilioApplication {



	private final static String ACCOUNT_SID = "AC5e9a1e59d0f9c3e4133dde9263ed298";
	private final static String AUTH_ID = "377484b8f289e6f73d34b24be8a8f464";


//	static {
//		Twilio.init(ACCOUNT_SID, AUTH_ID);
//	}
	public static void main(String[] args) {
		SpringApplication.run(TwilioApplication.class, args);
	}

}
