package beanPostProcessor;

import org.springframework.stereotype.Service;


@Service
public class GreetingService {
	@RunningLog
	public void sayHello(){
		System.out.println("hello post processor");
	}
}
