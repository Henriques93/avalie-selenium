package pages;

import org.openqa.selenium.By;

import core.PageObject;

public class DashBoardProfessorPage extends PageObject {

	public void home() {
		clickButton(By.xpath("//i[@class='fas fa-home nav-icon']"));
	}

	public void clickMenuUsuario() {
		clickButton(By.xpath("//p[contains(text(),'Cadastros')]"));
		clickButton(By.xpath("//p[contains(text(),'Usuario')]"));
	}
	
	public void clickMenuCurso() {
		clickButton(By.xpath("//p[contains(text(),'Cadastros')]"));
		clickButton(By.xpath("//a[contains(@class,'nav-link')]//p[contains(text(),'Cursos')]"));
	}
	
	public void clickMenuTurma() {
		clickButton(By.xpath("//p[contains(text(),'Cadastros')]"));
		clickButton(By.xpath("//a[contains(@class,'nav-link')]//p[contains(text(),'Turmas')]"));
	}
	
	public void clickMenuDisciplina() {
		clickButton(By.xpath("//p[contains(text(),'Cadastros')]"));
		clickButton(By.xpath("//a[contains(@class,'nav-link')]//p[contains(text(),'Disciplinas')]"));
	}
	
	public void clickMenuAvaliacao() {
		clickButton(By.xpath("//p[contains(text(),'Avalia��o')]"));
	}
	
	public void clickRelatorioResultados() {
		clickButton(By.xpath("//p[contains(text(),'Relat�rios')]"));
		clickButton(By.xpath("//p[contains(text(),'Resultados')]"));
	}
	
	public void clickRelatorioCompararAvaliacoes() {
		clickButton(By.xpath("//p[contains(text(),'Relat�rios')]"));
		clickButton(By.xpath("//p[contains(text(),'Comparar Avalia��es')]"));
	}
	
	public boolean verificarLoginSucesso() {
		return isMessagePresent("Seja bem vindo");
	}
}
