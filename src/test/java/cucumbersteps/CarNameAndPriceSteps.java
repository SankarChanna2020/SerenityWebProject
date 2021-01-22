package cucumbersteps;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import net.thucydides.core.annotations.Steps;
import steps.CarWaleStep;

public class CarNameAndPriceSteps {
	
	@Steps
	CarWaleStep car;
	
	@And("^user find car name and price$")
	public void user_find_car_name_and_price() {
	    
		car.findNameAndPrice(); 
	}
	
	@And("^user update car name and price in file for each brand (.*)$")
	public void user_update_car_name_and_price_in_file_for_each_brand(String brandName) {
		
		car.updateCarPriceInFile(brandName);
	   
	}

	

}
