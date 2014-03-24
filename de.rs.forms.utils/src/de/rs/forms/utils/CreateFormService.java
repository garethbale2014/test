package de.rs.forms.utils;

public class CreateFormService implements ICreateFormService {

	static ICreateFormService formService = new CreateFormService() ;
	
	public static  ICreateFormService getInstance(){
		if(formService != null)
			return formService;
		else{
			formService = new CreateFormService();
			return formService;
		}
		
		
	}
}
