package pages;

import org.openqa.selenium.By;

import core.PageObject;

public class CadastrarDisciplinaPage extends PageObject {

	public void selectProfessor(String professor) {
		clickButton(By.xpath("//span[@id='select2-professor-l5-container']"));
		clickButton(By.xpath("//li[contains(text(),'" + professor + "')]"));
	}
	
	public void selectTurma(String turma) {
		clickButton(By.xpath("//span[@id='select2-turma-uh-container']"));
		clickButton(By.xpath("//li[contains(text(),'" + turma + "')]"));
	}
	
	public void setNomeDisciplina(String nome) {
		enterTextField(By.xpath("//input[@name='nome']"), nome);
	}
	
	public void clickCadastrarDisciplina() {
		clickButton(By.xpath("//button[@class='btn btn-success']"));
	}
	
	public void clickCancelar() {
		clickButton(By.xpath("//a[@class='btn btn-danger']"));
	}
	
}
