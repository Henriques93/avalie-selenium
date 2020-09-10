package tests;

import org.junit.Test;

import core.AbstractTest;
import core.Properties;
import pages.CadastrarTurmaPage;
import pages.DashBoardCoordenadorPage;
import pages.ListarTurmaPage;
import pages.ListarUsuarioPage;
import pages.LoginPage;

public class ModuloCoordenadorTest extends AbstractTest {

	LoginPage loginPage = new LoginPage();
	DashBoardCoordenadorPage dashCoordenador = new DashBoardCoordenadorPage();
	ListarUsuarioPage listarUsuarioPage = new ListarUsuarioPage();
	ListarTurmaPage listarTurmaPage = new ListarTurmaPage();
	CadastrarTurmaPage cadastrarTurmaPage = new CadastrarTurmaPage();
	
	@Test
	public void teste() {
		loginPage.acessarAdmin();
		loginPage.loginCompleto(Properties.USER_EMAIL, Properties.USER_PASSWORD);
		dashCoordenador.clickMenuTurma();
		listarTurmaPage.clickCadastrarTurma();
		cadastrarTurmaPage.selecionarCurso("Administração");
	}
}
