package pages;

import org.openqa.selenium.By;

import core.PageObject;

public class CadastroCursoPage extends PageObject {

	public void setNome(String nome) {
		enterTextField(By.xpath("//input[@name='nome']"), nome);
	}
	
	public void clickCadastrarCurso() {
		clickButton(By.xpath("//button[@class='btn btn-success']"));
	}
	
	public void clickCancelar() {
		clickButton(By.xpath("//a[@class='btn btn-danger']"));
	}
}
