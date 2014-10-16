package EnumInjection;

import org.springframework.stereotype.Service;

@Service
public class PersonService {


	public void foo(){
		ChangeType.CNL.getDao().save();
	}
}
