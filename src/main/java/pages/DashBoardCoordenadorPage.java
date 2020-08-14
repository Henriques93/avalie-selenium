package pages;

import org.openqa.selenium.By;

import core.PageObject;

public class DashBoardCoordenadorPage extends PageObject {

	public void clickUsuario() {
		clickButton(By.xpath("//p[contains(text(),'Usuario')]"));
	}
}
