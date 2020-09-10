package pages;

import org.openqa.selenium.By;

import core.PageObject;

public class LoginPage extends PageObject {
	
	public void acessarAdmin() {
		clickButton(By.xpath("//a[@class='btn btn-block btn-primary btn-xs']"));
	}
	
	public void inserirPin(String pin) {
		enterTextField(By.xpath("//input[@id='pin']"), pin);
	}
	
	public void iniciarSessao() {
		clickButton(By.xpath("//button[@class='btn btn-primary btn-block']"));
	}
	
	public void setarLogin(String login) {
		enterTextField(By.xpath("//input[@placeholder='Email']"), login);
	}
	
	public void setarSenha(String senha) {
		enterTextField(By.xpath("//input[@placeholder='Password']"), senha);
	}
	
	public void clicarAcessar() {
		clickButton(By.xpath("//button[@class='btn btn-primary btn-block']"));
	}
	
	public boolean verificarMensagemErro() {
		return isMessagePresent("Os dados informados não conferem");
	}

	public void loginCompleto(String login, String senha) {
		setarLogin(login);
		setarSenha(senha);
		clicarAcessar();
	}
}
