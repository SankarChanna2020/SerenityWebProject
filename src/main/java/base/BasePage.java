package base;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;


import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class BasePage extends PageObject {
	
	
	/**********************Common Functionality*************************/
	
	
	//finding single element
	public WebElementFacade getElement(String locator) {
		
		try {
			
			return find(getBy(locator));
			
		}catch(NoSuchElementException e) {
			
		   e.getMessage();
			
		}
		
		return null;
			
	}
	
	//finding multiple elements
	public List<WebElementFacade> getElements(String locator) {
		
		try {
			
			return findAll(getBy(locator));
			
		}catch(NoSuchElementException e) {
			
			e.getMessage();
			
		}
			
		return null;
	}
	

	
	//@get BY method
	private By getBy(String locator) {
		
		
		By by = null;
		
		try {
			
			if(locator.startsWith("id=")) {
				
				 locator=locator.substring(3);
				 by = By.id(locator);
			}
			else if(locator.startsWith("xpath=")){
				
				locator=locator.substring(6);
				 by = By.xpath(locator);
				
			}
            else if(locator.startsWith("css=")){
				
				locator=locator.substring(4);
				by = By.cssSelector(locator);
				
			}
            else if(locator.startsWith("name=")){
				
				locator=locator.substring(5);
				by = By.name(locator);
				
			}
            else if(locator.startsWith("link=")){
				
				locator=locator.substring(5);
				by = By.linkText(locator);
				
			}
			
			return by;
			
			
		}
		catch(Throwable t) {
			
			t.getMessage();
			
		}
		
		
		return null;
	}
	
	public void click(String locator) {
		
		waitFor(getElement(locator)).click();
		
	}
	
	public void type(String locator,String value) {
		
		waitFor(getElement(locator)).sendKeys(value);
		
	}
	
	public String getText(String locator) {
		
		return waitFor(getElement(locator)).getText();
		
	}
	
	public void moveMouseTo(String locator) {
		
		WebElement moveTo = waitFor(getElement(locator));
		withAction().moveToElement(moveTo).perform();
		
	}
	
	
	/*************Business Specific Commom Functionality*****************/
	
	String headingText ="xpath=/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/section[1]/h1[1]";
	
	public String getCarPageHeading() {
		
		return getText(headingText);
		
	}
	
	String carBrandName = "xpath=//div[@class='gsc_col-sm-12 gsc_col-xs-12 gsc_col-md-8 listView holder ']/h3/a";
	String carPrice ="xpath=//div[@class='gsc_col-sm-12 gsc_col-xs-12 gsc_col-md-8 listView holder ']/div[@class='price']";
	
	
    ArrayList<String> list = new ArrayList<String>();
	
	public void getCarNameAndPrice() {
		
		
		List<WebElementFacade> carNames = getElements(carBrandName);
		
		List<WebElementFacade> carprice = getElements(carPrice);
		
		for(int i=0;i<carNames.size();i++) {
			
			System.out.println(carNames.get(i).getText()+"Price is"+carprice.get(i).getText());
			String text = carNames.get(i).getText()+"Price is"+carprice.get(i).getText();
			list.add(text);
		}
		
	}
	
	public void updateCarPriceInFile(String filename) {
		
		String info = filename+"Car Brand Name and Price\n";
		
		File file = new File(filename);
		
		try {
			
			FileWriter fw = new FileWriter(file,true);
			
			fw.write(info);
			String lineSeperator = System.getProperty("line.separator");
			
			for(int i=0;i<list.size();i++) {
				
				fw.write(list.get(i));
				fw.write(lineSeperator);
			}
			
			fw.flush();
			fw.close();
			
			FileUtils.copyFile(file, new File(".//carprice//"+filename+".txt"));
			FileUtils.deleteQuietly(file);

		}
		catch (IOException e) {
			
			e.printStackTrace();
			
		}
		
		
	}
	
	

}
