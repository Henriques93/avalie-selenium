package pages;

import org.openqa.selenium.By;

import core.PageObject;

public class CadastrarTurmaPage extends PageObject {

	public void selecionarCurso(String curso) {
		clickButton(By.xpath("//span[@class='select2-selection__arrow']"));
		clickButton(By.xpath("//li[contains(text(),'" + curso + "')]"));
	}

	public void setNomeTurma(String nome) {
		enterTextField(By.xpath("//input[@name='nome']"), nome);
	}

	public void setAno(String ano) {
		enterTextField(By.xpath("//input[@name='ano']"), ano);
	}

	public void setPrimeiroSemestre() {
		clickButton(By.xpath("//label[contains(text(),'1° Semestre')]"));
	}

	public void setSegundoSemestre() {
		clickButton(By.xpath("//label[contains(text(),'2° Semestre')]"));
	}

	public void setTurnoManha() {
		clickButton(By.xpath("//label[contains(text(),'Manhã')]"));
	}

	public void setTurnoTarde() {
		clickButton(By.xpath("//label[contains(text(),'Tarde')]"));
	}

	public void setTurnoNoite() {
		clickButton(By.xpath("//label[contains(text(),'Noite')]"));
	}
	
	public void clickCadastrarTurma() {
		clickButton(By.xpath("//button[@class='btn btn-success']"));
	}
	
	public void clickCancelar() {
		clickButton(By.xpath("//a[@class='btn btn-danger']"));
	}

}
