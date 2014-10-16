package EnumInjection;

import org.springframework.stereotype.Service;

@Service
public class Dao {

	public void save(){
		System.out.println("save successfully");
	}
}
