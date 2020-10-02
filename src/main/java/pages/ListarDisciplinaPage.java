package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import core.PageObject;

public class ListarDisciplinaPage extends PageObject {

	public void clickCadastrarDisciplina() {
		clickButton(By.xpath("//a[@class='btn btn-success float-right']"));
	}
	
	public boolean verificarDisciplinaCadastrado(String colunaBusca, String valor) {
		return verificarCadastro(colunaBusca, valor, "//table[@id='table']");
	}
	
	public void editarDisciplina(String colunaBusca, String valor) {
		WebElement celula = clicarBotaoTabela(colunaBusca, valor, "Ações", "//table[@id='table']");
		celula.findElement(By.xpath(".//a[1]")).click();
	}

	public void deletarDisciplina(String colunaBusca, String valor) {
		WebElement celula = clicarBotaoTabela(colunaBusca, valor, "Ações", "//table[@id='table']");
		celula.findElement(By.xpath(".//a[2]")).click();
		clickConfirmDialog();
	}
}
