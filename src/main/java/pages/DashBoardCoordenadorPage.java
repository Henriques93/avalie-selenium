package pages;

import org.openqa.selenium.By;

import core.PageObject;

public class DashBoardCoordenadorPage extends PageObject {

	public void clickMenuUsuario() {
		clickButton(By.xpath("//p[contains(text(),'Usuario')]"));
	}
	
	public void clickMenuCurso() {
		clickButton(By.xpath("//a[contains(@class,'nav-link')]//p[contains(text(),'Cursos')]"));
	}
	
	public void clickMenuTurma() {
		clickButton(By.xpath("//a[contains(@class,'nav-link')]//p[contains(text(),'Turmas')]"));
	}
	
	public void clickMenuDisciplina() {
		clickButton(By.xpath("//a[contains(@class,'nav-link')]//p[contains(text(),'Disciplinas')]"));
	}
	
	public void clicMenuAvaliacao() {
		clickButton(By.xpath("//p[contains(text(),'Avaliação')]"));
	}
}
