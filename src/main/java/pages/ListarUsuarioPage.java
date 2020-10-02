package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import core.PageObject;

public class ListarUsuarioPage extends PageObject{
	
	public void cadastrarUsuario() {
		clickButton(By.xpath("//a[@class='btn btn-success float-right']"));
	}
	
	public boolean verificarUsuarioCadastrado(String colunaBusca, String valor) {
		return verificarCadastro(colunaBusca, valor, "//table[@id='table']");
	}
	
	public void editarUsuario(String colunaBusca, String valor) {
		WebElement celula = clicarBotaoTabela(colunaBusca, valor, "Ações", "//table[@id='table']");
		celula.findElement(By.xpath(".//a[1]")).click();
	}

	public void deletarUsuario(String colunaBusca, String valor) {
		WebElement celula = clicarBotaoTabela(colunaBusca, valor, "Ações", "//table[@id='table']");
		celula.findElement(By.xpath(".//a[2]")).click();
		clickConfirmDialog();
	}
}
