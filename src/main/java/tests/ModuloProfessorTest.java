package tests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import core.AbstractTest;
import core.Properties;
import pages.CadastrarDisciplinaPage;
import pages.CadastrarTurmaPage;
import pages.CadastrarUsuarioPage;
import pages.CadastroCursoPage;
import pages.DashBoardProfessorPage;
import pages.ListarCursoPage;
import pages.ListarDisciplinaPage;
import pages.ListarTurmaPage;
import pages.ListarUsuarioPage;
import pages.LoginPage;

public class ModuloProfessorTest extends AbstractTest {

	LoginPage loginPage = new LoginPage();
	DashBoardProfessorPage dashProfessor = new DashBoardProfessorPage();
	ListarUsuarioPage listarUsuarioPage = new ListarUsuarioPage();
	CadastrarUsuarioPage cadastrarUsuarioPage = new CadastrarUsuarioPage();
	ListarCursoPage listarCursoPage = new ListarCursoPage();
	CadastroCursoPage cadastroCursoPage = new CadastroCursoPage();
	ListarDisciplinaPage listarDisciplinaPage = new ListarDisciplinaPage();
	CadastrarDisciplinaPage cadastrarDisciplinaPage = new CadastrarDisciplinaPage();
	ListarTurmaPage listarTurmaPage = new ListarTurmaPage();
	CadastrarTurmaPage cadastrarTurmaPage = new CadastrarTurmaPage();
	
	@Test
	public void caso001() {
		loginPage.acessarAdmin();
		loginPage.loginCompleto(Properties.PROFESSOR_EMAIL, Properties.PROFESSOR_PASSWORD);
		assertTrue(dashProfessor.verificarLoginSucesso());
	}
	
	@Test
	public void caso002() {
		loginPage.acessarAdmin();
		loginPage.loginCompleto("Teste", Properties.PROFESSOR_PASSWORD);
		assertTrue(loginPage.verificarMensagemErro());
	}
	
	@Test
	public void caso003() {
		loginPage.acessarAdmin();
		loginPage.loginCompleto(Properties.PROFESSOR_EMAIL, "abc");
		assertTrue(loginPage.verificarMensagemErro());
	}
	
	@Test
	public void caso004() {
		loginPage.acessarAdmin();
		loginPage.loginCompleto(Properties.PROFESSOR_EMAIL, Properties.PROFESSOR_PASSWORD);
		assertTrue(dashProfessor.verificarLoginSucesso());
		dashProfessor.clickMenuUsuario();
		listarUsuarioPage.cadastrarUsuario();
		cadastrarUsuarioPage.setNome("Professor Teste");
		cadastrarUsuarioPage.setSenha("123456");
		cadastrarUsuarioPage.setEmail("professorteste@gmail.com");
		cadastrarUsuarioPage.selectTipoUsuarioProfessor();
		cadastrarUsuarioPage.clicarCadastrarUsuario();
		assertTrue(listarUsuarioPage.verificarUsuarioCadastrado("Usuário", "Professor Teste"));
	}
	
	public void caso005() {
		loginPage.acessarAdmin();
		loginPage.loginCompleto(Properties.PROFESSOR_EMAIL, Properties.PROFESSOR_PASSWORD);
		assertTrue(dashProfessor.verificarLoginSucesso());
		dashProfessor.clickMenuUsuario();
		listarUsuarioPage.cadastrarUsuario();
		cadastrarUsuarioPage.setNome("Professor Teste");
		cadastrarUsuarioPage.setSenha("123456");
		cadastrarUsuarioPage.setEmail("coordenadorteste@gmail.com");
		cadastrarUsuarioPage.selectTipoUsuarioProfessor();
		cadastrarUsuarioPage.clicarCadastrarUsuario();
		assertTrue(listarUsuarioPage.verificarUsuarioCadastrado("Usuário", "Professor Teste"));
	}
	
	@Test
	public void caso006() {
		loginPage.acessarAdmin();
		loginPage.loginCompleto(Properties.PROFESSOR_EMAIL, Properties.PROFESSOR_PASSWORD);
		assertTrue(dashProfessor.verificarLoginSucesso());
		dashProfessor.clickMenuUsuario();
		listarUsuarioPage.cadastrarUsuario();
		cadastrarUsuarioPage.setSenha("123456");
		cadastrarUsuarioPage.setEmail("professorteste@gmail.com");
		cadastrarUsuarioPage.selectTipoUsuarioProfessor();
		cadastrarUsuarioPage.clicarCadastrarUsuario();
		assertTrue(cadastrarUsuarioPage.verificarMensagemErro("Erro!"));
	}
	
	@Test
	public void caso007() {
		loginPage.acessarAdmin();
		loginPage.loginCompleto(Properties.PROFESSOR_EMAIL, Properties.PROFESSOR_PASSWORD);
		assertTrue(dashProfessor.verificarLoginSucesso());
		dashProfessor.clickMenuUsuario();
		listarUsuarioPage.cadastrarUsuario();
		cadastrarUsuarioPage.setNome("Professor Teste");
		cadastrarUsuarioPage.setEmail("professorteste@gmail.com");
		cadastrarUsuarioPage.selectTipoUsuarioProfessor();
		cadastrarUsuarioPage.clicarCadastrarUsuario();
		assertTrue(cadastrarUsuarioPage.verificarMensagemErro("Erro!"));
	}
	
	public void caso008() {
		loginPage.acessarAdmin();
		loginPage.loginCompleto(Properties.PROFESSOR_EMAIL, Properties.PROFESSOR_PASSWORD);
		assertTrue(dashProfessor.verificarLoginSucesso());
		dashProfessor.clickMenuUsuario();
		listarUsuarioPage.cadastrarUsuario();
		cadastrarUsuarioPage.setNome("Professor Teste");
		cadastrarUsuarioPage.setSenha("123456");
		cadastrarUsuarioPage.selectTipoUsuarioProfessor();
		cadastrarUsuarioPage.clicarCadastrarUsuario();
		assertTrue(cadastrarUsuarioPage.verificarMensagemErro("Erro!"));
	}
	
	@Test
	public void caso009() {
		loginPage.acessarAdmin();
		loginPage.loginCompleto(Properties.PROFESSOR_EMAIL, Properties.PROFESSOR_PASSWORD);
		assertTrue(dashProfessor.verificarLoginSucesso());
		dashProfessor.clickMenuUsuario();
		
		listarUsuarioPage.cadastrarUsuario();
		cadastrarUsuarioPage.setNome("Editar Teste2");
		cadastrarUsuarioPage.setSenha("123456");
		cadastrarUsuarioPage.setEmail("editarteste2@gmail.com");
		cadastrarUsuarioPage.selectTipoUsuarioProfessor();
		cadastrarUsuarioPage.clicarCadastrarUsuario();
		
		listarUsuarioPage.editarUsuario("Usuário", "Editar Teste2");
		cadastrarUsuarioPage.setNome("Editar Teste");
		cadastrarUsuarioPage.clicarCadastrarUsuario();
		assertTrue(listarUsuarioPage.verificarUsuarioCadastrado("Usuário", "Editar Teste"));
	}
	
	@Test
	public void caso010() {
		loginPage.acessarAdmin();
		loginPage.loginCompleto(Properties.PROFESSOR_EMAIL, Properties.PROFESSOR_PASSWORD);
		assertTrue(dashProfessor.verificarLoginSucesso());
		dashProfessor.clickMenuUsuario();
		
		listarUsuarioPage.cadastrarUsuario();
		cadastrarUsuarioPage.setNome("Editar Email Teste");
		cadastrarUsuarioPage.setSenha("123456");
		cadastrarUsuarioPage.setEmail("editaremailteste@gmail.com");
		cadastrarUsuarioPage.selectTipoUsuarioProfessor();
		cadastrarUsuarioPage.clicarCadastrarUsuario();
		
		listarUsuarioPage.editarUsuario("Usuário", "Editar Email Teste");
		cadastrarUsuarioPage.setEmail("editaremail@gmail.com");
		cadastrarUsuarioPage.clicarCadastrarUsuario();
		assertTrue(listarUsuarioPage.verificarUsuarioCadastrado("Email", "editaremail@gmail.com"));
	}
	
	@Test
	public void caso011() {
		loginPage.acessarAdmin();
		loginPage.loginCompleto(Properties.PROFESSOR_EMAIL, Properties.PROFESSOR_PASSWORD);
		assertTrue(dashProfessor.verificarLoginSucesso());
		dashProfessor.clickMenuUsuario();
		
		listarUsuarioPage.cadastrarUsuario();
		cadastrarUsuarioPage.setNome("Editar Tipo Teste");
		cadastrarUsuarioPage.setSenha("123456");
		cadastrarUsuarioPage.setEmail("editartipoteste@gmail.com");
		cadastrarUsuarioPage.selectTipoUsuarioProfessor();
		cadastrarUsuarioPage.clicarCadastrarUsuario();
		
		listarUsuarioPage.editarUsuario("Usuário", "Editar Email Teste");
		cadastrarUsuarioPage.selectTipoUsuarioProfessor();
		cadastrarUsuarioPage.clicarCadastrarUsuario();
		assertTrue(listarUsuarioPage.verificarUsuarioCadastrado("Tipo de Usuário", "Professor"));
	}
	
	@Test
	public void caso012() {
		loginPage.acessarAdmin();
		loginPage.loginCompleto(Properties.PROFESSOR_EMAIL, Properties.PROFESSOR_PASSWORD);
		assertTrue(dashProfessor.verificarLoginSucesso());
		dashProfessor.clickMenuCurso();
		
		listarCursoPage.clickCadastrarCurso();
		cadastroCursoPage.setNome("Psicologia");
		cadastroCursoPage.clickCadastrarCurso();
		
		assertTrue(listarUsuarioPage.verificarUsuarioCadastrado("Curso", "Psicologia"));
	}
	
	@Test
	public void caso013() {
		loginPage.acessarAdmin();
		loginPage.loginCompleto(Properties.PROFESSOR_EMAIL, Properties.PROFESSOR_PASSWORD);
		assertTrue(dashProfessor.verificarLoginSucesso());
		dashProfessor.clickMenuCurso();
		
		listarCursoPage.clickCadastrarCurso();
		cadastroCursoPage.clickCadastrarCurso();
		
		assertTrue(cadastroCursoPage.isMessagePresent("Erro!"));
	}
	
	@Test
	public void caso014() {
		loginPage.acessarAdmin();
		loginPage.loginCompleto(Properties.PROFESSOR_EMAIL, Properties.PROFESSOR_PASSWORD);
		assertTrue(dashProfessor.verificarLoginSucesso());
		dashProfessor.clickMenuCurso();
		
		listarCursoPage.clickCadastrarCurso();
		cadastroCursoPage.clickCancelar();;
		
		assertTrue(listarCursoPage.isMessagePresent("Listar Curso"));
	}
	
	@Test
	public void caso015() {
		loginPage.acessarAdmin();
		loginPage.loginCompleto(Properties.PROFESSOR_EMAIL, Properties.PROFESSOR_PASSWORD);
		assertTrue(dashProfessor.verificarLoginSucesso());
		dashProfessor.clickMenuCurso();
		
		listarCursoPage.clickCadastrarCurso();
		cadastroCursoPage.setNome("Ecologis");
		cadastroCursoPage.clickCadastrarCurso();
		
		listarCursoPage.editarCurso("Curso", "Ecologis");
		cadastroCursoPage.setNome("Ecologia");
		cadastroCursoPage.clickCadastrarCurso();
		
		assertTrue(listarUsuarioPage.verificarUsuarioCadastrado("Curso", "Ecologia"));
	}
	
	@Test
	public void caso016() {
		loginPage.acessarAdmin();
		loginPage.loginCompleto(Properties.PROFESSOR_EMAIL, Properties.PROFESSOR_PASSWORD);
		assertTrue(dashProfessor.verificarLoginSucesso());
		dashProfessor.clickMenuCurso();
		
		listarCursoPage.deletarCurso("Curso", "Ecologia");
		
		assertTrue(!listarUsuarioPage.verificarUsuarioCadastrado("Curso", "Ecologia"));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
