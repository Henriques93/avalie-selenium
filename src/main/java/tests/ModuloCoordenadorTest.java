package tests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import core.AbstractTest;
import core.Properties;
import pages.CadastrarTurmaPage;
import pages.CadastrarUsuarioPage;
import pages.DashBoardCoordenadorPage;
import pages.ListarTurmaPage;
import pages.ListarUsuarioPage;
import pages.LoginPage;

public class ModuloCoordenadorTest extends AbstractTest {

	LoginPage loginPage = new LoginPage();
	DashBoardCoordenadorPage dashCoordenador = new DashBoardCoordenadorPage();
	ListarUsuarioPage listarUsuarioPage = new ListarUsuarioPage();
	CadastrarUsuarioPage cadastrarUsuarioPage = new CadastrarUsuarioPage();
	ListarTurmaPage listarTurmaPage = new ListarTurmaPage();
	CadastrarTurmaPage cadastrarTurmaPage = new CadastrarTurmaPage();
	
	@Test
	public void caso001() {
		loginPage.acessarAdmin();
		loginPage.loginCompleto(Properties.COORDENADOR_EMAIL, Properties.COORDENADOR_PASSWORD);
		assertTrue(dashCoordenador.verificarLoginSucesso());
	}
	
	@Test
	public void caso002() {
		loginPage.acessarAdmin();
		loginPage.loginCompleto("Teste", Properties.COORDENADOR_PASSWORD);
		assertTrue(loginPage.verificarMensagemErro());
	}
	
	@Test
	public void caso003() {
		loginPage.acessarAdmin();
		loginPage.loginCompleto(Properties.COORDENADOR_EMAIL, "abc");
		assertTrue(loginPage.verificarMensagemErro());
	}
	
	@Test
	public void caso004() {
		loginPage.acessarAdmin();
		loginPage.loginCompleto(Properties.COORDENADOR_EMAIL, Properties.COORDENADOR_PASSWORD);
		assertTrue(dashCoordenador.verificarLoginSucesso());
		dashCoordenador.clickMenuUsuario();
//		listarUsuarioPage.cadastrarUsuario();
//		cadastrarUsuarioPage.setNome("Teste2 da Silva");
//		cadastrarUsuarioPage.setSenha("123456");
//		cadastrarUsuarioPage.setEmail("testeSilva2@gmail.com");
//		cadastrarUsuarioPage.selectTipoUsuarioCoordenador();
//		cadastrarUsuarioPage.clicarCadastrarUsuario();
		assertTrue(listarUsuarioPage.verificarUsuarioCadastrado("Usuário", "Teste2 da Silva"));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
