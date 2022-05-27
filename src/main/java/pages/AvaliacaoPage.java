package pages;

import org.openqa.selenium.By;

import core.PageObject;

public class AvaliacaoPage extends PageObject {

	public void setarNotaAvaliacaoDisciplinaProfessor(Integer pergunta, Integer nota) {
		Integer notaFinal = nota + 1;
		clickButton(By
				.xpath("//table[@class='table table-bordered table-striped'][1]/tbody/tr[" + pergunta + "]/td["+notaFinal+"]/input"));
	}

	public void setarNotaAvaliacaoIsntituicaoAtendimento(Integer pergunta, Integer nota) {
		nota = nota++;
			clickButton(By.xpath(
					"/html/body/div/div[1]/section[4]/div/div/div/form/div[2]/table/tbody/tr[" + pergunta + "]/td["+nota+"]/input"));
	}
	
	public void responderPerguntaTexto1(String texto) {
		enterTextField(By.xpath("/html/body/div/div[1]/section[4]/div/div/div/form/textarea[1]"), texto);
	}
	
	public void responderPerguntaTexto2(String texto) {
		enterTextField(By.xpath("/html/body/div/div[1]/section[4]/div/div/div/form/textarea[2]"), texto);
	}
	
	public void finalizarAvaliacao() {
		clickButton(By.xpath("//*[@id=\"btnFinalizarAvaliacao\"]"));
	}


}
