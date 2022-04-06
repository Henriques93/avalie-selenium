package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import core.PageObject;

public class ListarCursoPage extends PageObject{

	public void clickCadastrarCurso() {
		clickButton(By.xpath("//a[@class='btn btn-success float-right']"));
	}
	
	public boolean verificarCursoCadastrado(String colunaBusca, String valor) {
		return verificarCadastro(colunaBusca, valor, "//table[@id='table']");
	}
	
	public void editarCurso(String colunaBusca, String valor) {
		WebElement celula = clicarBotaoTabela(colunaBusca, valor, "Ações", "//table[@id='table']");
		celula.findElement(By.xpath(".//a[1]")).click();
	}

	public void deletarCurso(String colunaBusca, String valor) {
		WebElement celula = clicarBotaoTabela(colunaBusca, valor, "Ações", "//table[@id='table']");
		celula.findElement(By.xpath(".//a[2]")).click();
		clickConfirmDialog();
	}
	
}
