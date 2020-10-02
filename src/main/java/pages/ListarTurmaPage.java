package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import core.PageObject;

public class ListarTurmaPage extends PageObject{

	public void clickCadastrarTurma() {
		clickButton(By.xpath("//a[@class='btn btn-success float-right']"));
	}
	
	public boolean verificarTurmaCadastrado(String colunaBusca, String valor) {
		return verificarCadastro(colunaBusca, valor, "//table[@id='table']");
	}
	
	public void editarTurma(String colunaBusca, String valor) {
		WebElement celula = clicarBotaoTabela(colunaBusca, valor, "Ações", "//table[@id='table']");
		celula.findElement(By.xpath(".//a[1]")).click();
	}

	public void deletarTurma(String colunaBusca, String valor) {
		WebElement celula = clicarBotaoTabela(colunaBusca, valor, "Ações", "//table[@id='table']");
		celula.findElement(By.xpath(".//a[2]")).click();
		clickConfirmDialog();
	}
}
