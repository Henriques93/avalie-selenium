package tests;

import org.junit.Test;

import core.AbstractTest;
import pages.CadastrarTurmaPage;
import pages.DashBoardCoordenadorPage;
import pages.ListarTurmaPage;
import pages.ListarUsuarioPage;

public class ModuloCoordenadorTest extends AbstractTest {

	DashBoardCoordenadorPage dashCoordenador = new DashBoardCoordenadorPage();
	ListarUsuarioPage listarUsuarioPage = new ListarUsuarioPage();
	ListarTurmaPage listarTurmaPage = new ListarTurmaPage();
	CadastrarTurmaPage cadastrarTurmaPage = new CadastrarTurmaPage();
	
	@Test
	public void teste() {
		dashCoordenador.clickMenuTurma();
		listarTurmaPage.clickCadastrarTurma();
		cadastrarTurmaPage.selecionarCurso("Administração");
	}
}
