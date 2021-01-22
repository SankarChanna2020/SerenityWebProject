package pages;

import base.BasePage;

public class SearchNewCarPage extends BasePage {
	
	public void chooseCarBrand(String brandName) {
		
		click("link="+brandName);
		
		
	}
	
	

}
