package steps;

import org.junit.Assert;

import net.thucydides.core.annotations.Step;
import pages.HomePage;
import pages.SearchNewCarPage;

public class CarWaleStep {
	
	HomePage home;
	SearchNewCarPage newCar;
	
	@Step
	public CarWaleStep navigate() {
		
		home.open();
		return this;
	}
	
	@Step("Navigate to New car menu")
	public void navigateToNewcars() {
		
		home.navigateToNewcars();
	}
	
	@Step("Navigate to Find New car menu")
	public void navigateToFindNewcar() {
		
		home.navigateToFindNewCars();
	}
	
	
	
	@Step("Finding brand name")
	public void findNewCars(String brandName) { 
		
		newCar.chooseCarBrand(brandName);
		Assert.assertTrue(home.getCarPageHeading().contains(brandName));
	}
	
	
	@Step("Validating Brand Name")
	public boolean validateBrandName(String brandName) {
		
		
		return home.getCarPageHeading().contains(brandName);
		
	}
	
	
	@Step("Finding car name and price")
	public void findNameAndPrice() {
		
		home.getCarNameAndPrice();
	}
	
	@Step("Update car price in a file")
	public void updateCarPriceInFile(String filename) {
		
		home.updateCarPriceInFile(filename);
	}

}
