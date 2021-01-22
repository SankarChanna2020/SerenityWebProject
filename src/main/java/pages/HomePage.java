package pages;


import base.BasePage;

public class HomePage extends BasePage{
	
	String newCarMenu = "xpath=//header/div[2]/div[1]/div[1]/nav[1]/ul[1]/li[1]/a[1]/span[1]";
	String findNewCar = "xpath=//span[contains(text(),'Search New Cars')]";
	
	
	public void navigateToNewcars() {
		
		 moveMouseTo(newCarMenu);
	}
	
	public SearchNewCarPage navigateToFindNewCars() {
		
         
          click(findNewCar);
          
          return this.switchToPage(SearchNewCarPage.class);
		
		
	}
	
	public void findUsedCars() {
		
		
	}
	
	public void doLogin() {
		
		
	}
	
	public void checkOnroadPrice() {
		
		
		
		
	}
	
	

}
