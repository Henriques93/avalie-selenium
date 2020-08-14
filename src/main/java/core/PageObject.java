package core;

import static core.DriverFactory.getDriver;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class PageObject {
	
	protected WebDriverWait wait = new WebDriverWait(getDriver(), Properties.WAIT_TIME);

	public PageObject() {
		super();
//		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("iron-router-progress")));
//		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@@class='loadingtemplate fa fa-circle-o-notch fa-spin']")));
	}

	/********* TextField e TextArea ************/
	
	public void enterTextField(By by, String value) {
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
		WebElement element = getDriver().findElement(by);
		wait.until(ExpectedConditions.visibilityOf(element));
		element.clear();
		element.sendKeys(value);
	}
	
	public void enterTextFieldNoClear(By by, String value) {
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
		WebElement element = getDriver().findElement(by);
		wait.until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(" "+value);
	}

	/********* Link ************/
	
	public void clickLink(By by) {
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
		wait.until(ExpectedConditions.elementToBeClickable(by));
		getDriver().findElement(by).click();
	}

	
	/********* Button ************/
	
	public void clickButton(By by) {
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
		wait.until(ExpectedConditions.elementToBeClickable(by));
		WebElement element = getDriver().findElement(by);
		wait.until(ExpectedConditions.visibilityOf(element));
		element.click();
		//		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("iron-router-progress")));
		//		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@@class='loadingtemplate fa fa-circle-o-notch fa-spin']")));
	}
	
	public void clickMouseButton(By item){
		Actions acao = new Actions(DriverFactory.getDriver());
		wait.until(ExpectedConditions.visibilityOfElementLocated(item));
		acao.moveToElement(DriverFactory.getDriver().findElement(item));
		acao.click();
		acao.perform();
	}
	
	
	/********* Select ************/
	
	public void chooseSelectOption(By by, int index) {
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
		wait.until(ExpectedConditions.elementToBeClickable(by));
		WebElement element = getDriver().findElement(by);
		Select combo = new Select(element);
		combo.selectByIndex(index);
	}
	
	/******* Message *************/
	
	public String getText(By by) {
		String message = null;
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(by));
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		} catch (Exception e) {
		}
		try {
			message = getDriver().findElement(by).getText();
		} catch (Exception e) {
		}
		return message;
	}
	
	public boolean isMessagePresent(By by) {
		String result = getText(by);
		if (result != null) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isMessagePresent(String message) {
		return isMessagePresent(By.xpath("//*[contains(text(),'" + message + "')]"));
	}

	public boolean isMessageNotPresent(By by) {
		try {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
			return true;
		} catch (Exception e) {
		}
		String result = null;
		try {
			result = getDriver().findElement(by).getText();
		} catch (Exception e) {
		}
		if (result == null || result.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isMessageNotPresent(String message) {
		return isMessageNotPresent(By.xpath("//*[contains(text(),'" + message + "')]"));
	}
	
		/******** Wait ************/
	public void wait(int seconds) {
		try {
			Thread.sleep(seconds*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/*********** Menu *************/
	
	public void selectMenu(By by, By item){
		Actions acao = new Actions(DriverFactory.getDriver());
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		acao.moveToElement(DriverFactory.getDriver().findElement(by));
		acao.moveToElement(DriverFactory.getDriver().findElement(item));
		acao.click();
		acao.perform();
	}
	
	/**************** JS **************/
	
	public Object executJS(String comando, Object... param) {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		return js.executeScript(comando, param);
	}
	
	public void scroll(By by){
		WebElement element = DriverFactory.getDriver().findElement(by);
		executJS("window.scrollBy(0, arguments[0])", element.getLocation().y);
	}

	/************** Tabela *************/
	
	public boolean verificarCadastro(String colunaBusca, String valor, String idTabela) {
		WebElement tabela = getDriver().findElement(By.xpath(idTabela));
		int idColuna = obterIndiceColuna(colunaBusca, tabela);
		int idLinha = obterIndiceLinha(valor, tabela, idColuna);
		if (idLinha != -1) {
			return true;
		}
		return false; 
	}
	
	
	public WebElement clicarBotaoTabela(String colunaBusca, String valor, String colunaBotao, String idTabela) {
		WebElement tabela = getDriver().findElement(By.xpath(idTabela));
		int idColuna = obterIndiceColuna(colunaBusca, tabela);
		int idLinha = obterIndiceLinha(valor, tabela, idColuna);
		int idColunaBtn = obterIndiceColuna("Ações", tabela);
		WebElement celula = tabela.findElement(By.xpath(".//tbody/tr["+idLinha+"]/td["+idColunaBtn+"]"));
		return celula;
		
	}
	
	protected int obterIndiceColuna(String coluna, WebElement tabela) {
		List<WebElement> colunas = tabela.findElements(By.xpath(".//th"));
		int idColuna = -1;
		for(int i = 0; i < colunas.size(); i++) {
			if(colunas.get(i).getText().equals(coluna)) {
				idColuna = i+1 ;
				break;
			}
		}
		return idColuna;
	}

	protected int obterIndiceLinha(String valor, WebElement tabela, int idColuna) {
		int condicaoParada = 1;
		int idLinha = -1;
		int controle = -1;
		String numeroProcediemnto = "";
		do{
			wait(1);
			List<WebElement> linhas = tabela.findElements(By.xpath("/tbody/tr/td["+idColuna+"]"));
			for(int i = 0; i < linhas.size(); i++) {
				if(linhas.get(i).getText().equals(valor)) {
					idLinha = i + 1;
					break;
				}
				if(i == linhas.size()-1){
					controle = i;
				}
			}
			if(idLinha == -1){
				if(linhas.get(controle).getText().equals(numeroProcediemnto)){
					condicaoParada = 0;
				}else{
					numeroProcediemnto = linhas.get(controle).getText();
				}
				try{
					clickButton(By.xpath("//li[@id='table_next']"));
				}catch (Exception e) {
					condicaoParada = 0;
				}
			}else{
				condicaoParada = 0;
			}
		}while(condicaoParada != 0);
		return idLinha;
	}
		
		
		/**************** janela ********************/
		
		public void trocarJanela() {
			System.out.println(getDriver().getWindowHandles());
			getDriver().switchTo().window((String)getDriver().getWindowHandles().toArray()[1]);
		}
		
		/************ Obtertexto ********************/
		
		public WebElement verificarElemento(By by){
			return getDriver().findElement(by);
		}
		
		/************** dialog ************/
		

		public String alertaObterTextoAceitar() {
			Alert alert = getDriver().switchTo().alert();
			String msg = alert.getText();
			alert.accept();
			return msg;
		}
		
		public boolean verificarMensagem(By by, String msg){
			WebElement element = getDriver().findElement(by);
			if(element.getText().contains(msg)){
				return true;
			}
			return false;
		}
		
		public void clickConfirmDialog(){
			 Alert alert = getDriver().switchTo().alert();
			    alert.accept(); // for OK
		}
		
		/**************** Imagens *******************/
		
		public void uploadAttachments(By by, String value) throws AWTException {
			clickButton(by);
			StringSelection ss = new StringSelection(value);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
			Robot robot = new Robot();
			robot.setAutoDelay(500);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		}

}
