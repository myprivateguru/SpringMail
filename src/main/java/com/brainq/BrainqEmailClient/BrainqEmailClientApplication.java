package com.brainq.BrainqEmailClient;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.brainq.BrainqEmailClient.services.EmailSenderService;

@SpringBootApplication
@EnableScheduling
public class BrainqEmailClientApplication {
	@Autowired
	private EmailSenderService service;
	@Value("${fixedRate}")
private Long fixedRate;
	public static void main(String[] args) {
		SpringApplication.run(BrainqEmailClientApplication.class, args);	
	}
	@EventListener(ApplicationReadyEvent.class)
	@Scheduled(fixedDelayString ="${fixedRate}")
	public void triggerEmail() throws MessagingException {
		/*service.sendSimpleEmail(
				"brainqy@gmail.com",
				"this is just body", 
				"Hello Brainqies");*/
		
		service.sendEmailWithAttachment("dvsomwanshi@gmail.com", "Body",
				"Report by Dr BrokenLink", "C:\\Users\\hp\\Desktop\\Capture.PNG");
		
	}

}
