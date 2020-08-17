package pages;

import org.openqa.selenium.By;

import core.PageObject;

public class CadastrarUsuarioPage extends PageObject {

	public void setNome(String nome) {
		enterTextField(By.xpath("//input[@name='nome']"), nome);
	}
	
	public void setEmail(String email) {
		enterTextField(By.xpath("//input[@name='email']"), email);
	}
	
	public void setSenha(String senha) {
		enterTextField(By.xpath("//input[@name='senha']"), senha);
	}
	
	public void selectTipoUsuarioProfessor() {
		clickButton(By.xpath("//span[@class='select2-selection__arrow']"));
		clickButton(By.xpath("//li[@id='select2-tipoUsuario-yr-result-znlj-P']"));
	}
	
	public void selectTipoUsuarioCoordenador() {
		clickButton(By.xpath("//span[@class='select2-selection__arrow']"));
		clickButton(By.xpath("//li[@id='select2-tipoUsuario-yr-result-2l9j-C']"));
	}
	
	public void clicarCadastrarUsuario() {
		clickButton(By.xpath("//button[@class='btn btn-success']"));
	}
	
	public void clicarCancelar() {
		clickButton(By.xpath("//a[@class='btn btn-danger']"));
	}
	
	public boolean verificarMensagemErro(String mensagem) {
		return isMessagePresent(mensagem);
	}
}
