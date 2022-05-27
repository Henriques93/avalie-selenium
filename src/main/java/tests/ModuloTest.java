package tests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import core.AbstractTest;
import core.Properties;
import pages.AvaliacaoPage;
import pages.CadastrarDisciplinaPage;
import pages.CadastrarTurmaPage;
import pages.CadastrarUsuarioPage;
import pages.CadastroCursoPage;
import pages.DashBoardCoordenadorPage;
import pages.ListarCursoPage;
import pages.ListarDisciplinaPage;
import pages.ListarTurmaPage;
import pages.ListarUsuarioPage;
import pages.LoginPage;

public class ModuloTest extends AbstractTest {

	LoginPage loginPage = new LoginPage();
	DashBoardCoordenadorPage dashCoordenador = new DashBoardCoordenadorPage();
	ListarUsuarioPage listarUsuarioPage = new ListarUsuarioPage();
	CadastrarUsuarioPage cadastrarUsuarioPage = new CadastrarUsuarioPage();
	ListarCursoPage listarCursoPage = new ListarCursoPage();
	CadastroCursoPage cadastroCursoPage = new CadastroCursoPage();
	ListarDisciplinaPage listarDisciplinaPage = new ListarDisciplinaPage();
	CadastrarDisciplinaPage cadastrarDisciplinaPage = new CadastrarDisciplinaPage();
	ListarTurmaPage listarTurmaPage = new ListarTurmaPage();
	CadastrarTurmaPage cadastrarTurmaPage = new CadastrarTurmaPage();
	AvaliacaoPage avaliacaoPage = new AvaliacaoPage();
	
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
		loginPage.loginCompleto(Properties.COORDENADOR_EMAIL, Properties.COORDENADOR_PASSWORD);
		assertTrue(dashCoordenador.verificarLoginSucesso());
		dashCoordenador.clickMenuUsuario();
		listarUsuarioPage.cadastrarUsuario();
		cadastrarUsuarioPage.setNome("Coordenador Teste");
		cadastrarUsuarioPage.setSenha("123456");
		cadastrarUsuarioPage.setEmail("coordenadorteste@gmail.com");
		cadastrarUsuarioPage.selectTipoUsuarioCoordenador();
		cadastrarUsuarioPage.clicarCadastrarUsuario();
		assertTrue(listarUsuarioPage.verificarUsuarioCadastrado("Usuário", "Coordenador Teste"));
	}
	
	@Test
	public void caso006() {
		loginPage.acessarAdmin();
		loginPage.loginCompleto(Properties.COORDENADOR_EMAIL, Properties.COORDENADOR_PASSWORD);
		assertTrue(dashCoordenador.verificarLoginSucesso());
		dashCoordenador.clickMenuUsuario();
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
		loginPage.loginCompleto(Properties.COORDENADOR_EMAIL, Properties.COORDENADOR_PASSWORD);
		assertTrue(dashCoordenador.verificarLoginSucesso());
		dashCoordenador.clickMenuUsuario();
		listarUsuarioPage.cadastrarUsuario();
		cadastrarUsuarioPage.setNome("Professor Teste");
		cadastrarUsuarioPage.setEmail("professorteste@gmail.com");
		cadastrarUsuarioPage.selectTipoUsuarioProfessor();
		cadastrarUsuarioPage.clicarCadastrarUsuario();
		assertTrue(cadastrarUsuarioPage.verificarMensagemErro("Erro!"));
	}
	
	public void caso008() {
		loginPage.acessarAdmin();
		loginPage.loginCompleto(Properties.COORDENADOR_EMAIL, Properties.COORDENADOR_PASSWORD);
		assertTrue(dashCoordenador.verificarLoginSucesso());
		dashCoordenador.clickMenuUsuario();
		listarUsuarioPage.cadastrarUsuario();
		cadastrarUsuarioPage.setNome("Coordenador Teste");
		cadastrarUsuarioPage.setSenha("123456");
		cadastrarUsuarioPage.selectTipoUsuarioCoordenador();
		cadastrarUsuarioPage.clicarCadastrarUsuario();
		assertTrue(cadastrarUsuarioPage.verificarMensagemErro("Erro!"));
	}
	
	@Test
	public void caso009() {
		loginPage.acessarAdmin();
		loginPage.loginCompleto(Properties.COORDENADOR_EMAIL, Properties.COORDENADOR_PASSWORD);
		assertTrue(dashCoordenador.verificarLoginSucesso());
		dashCoordenador.clickMenuUsuario();
		
		listarUsuarioPage.cadastrarUsuario();
		cadastrarUsuarioPage.setNome("Editar Teste2");
		cadastrarUsuarioPage.setSenha("123456");
		cadastrarUsuarioPage.setEmail("editarteste2@gmail.com");
		cadastrarUsuarioPage.selectTipoUsuarioCoordenador();
		cadastrarUsuarioPage.clicarCadastrarUsuario();
		
		listarUsuarioPage.editarUsuario("Usuário", "Editar Teste2");
		cadastrarUsuarioPage.setNome("Editar Teste");
		cadastrarUsuarioPage.clicarCadastrarUsuario();
		assertTrue(listarUsuarioPage.verificarUsuarioCadastrado("Usuário", "Editar Teste"));
	}
	
	@Test
	public void caso010() {
		loginPage.acessarAdmin();
		loginPage.loginCompleto(Properties.COORDENADOR_EMAIL, Properties.COORDENADOR_PASSWORD);
		assertTrue(dashCoordenador.verificarLoginSucesso());
		dashCoordenador.clickMenuUsuario();
		
		listarUsuarioPage.cadastrarUsuario();
		cadastrarUsuarioPage.setNome("Editar Email Teste");
		cadastrarUsuarioPage.setSenha("123456");
		cadastrarUsuarioPage.setEmail("editaremailteste@gmail.com");
		cadastrarUsuarioPage.selectTipoUsuarioCoordenador();
		cadastrarUsuarioPage.clicarCadastrarUsuario();
		
		listarUsuarioPage.editarUsuario("Usuário", "Editar Email Teste");
		cadastrarUsuarioPage.setEmail("editaremail@gmail.com");
		cadastrarUsuarioPage.clicarCadastrarUsuario();
		assertTrue(listarUsuarioPage.verificarUsuarioCadastrado("Email", "editaremail@gmail.com"));
	}
	
	@Test
	public void caso011() {
		loginPage.acessarAdmin();
		loginPage.loginCompleto(Properties.COORDENADOR_EMAIL, Properties.COORDENADOR_PASSWORD);
		assertTrue(dashCoordenador.verificarLoginSucesso());
		dashCoordenador.clickMenuUsuario();
		
		listarUsuarioPage.cadastrarUsuario();
		cadastrarUsuarioPage.setNome("Editar Tipo Teste");
		cadastrarUsuarioPage.setSenha("123456");
		cadastrarUsuarioPage.setEmail("editartipoteste@gmail.com");
		cadastrarUsuarioPage.selectTipoUsuarioCoordenador();
		cadastrarUsuarioPage.clicarCadastrarUsuario();
		
		listarUsuarioPage.editarUsuario("Usuário", "Editar Email Teste");
		cadastrarUsuarioPage.selectTipoUsuarioProfessor();
		cadastrarUsuarioPage.clicarCadastrarUsuario();
		assertTrue(listarUsuarioPage.verificarUsuarioCadastrado("Tipo de Usuário", "Professor"));
	}
	
	@Test
	public void caso012() {
		loginPage.acessarAdmin();
		loginPage.loginCompleto(Properties.COORDENADOR_EMAIL, Properties.COORDENADOR_PASSWORD);
		assertTrue(dashCoordenador.verificarLoginSucesso());
		dashCoordenador.clickMenuCurso();
		
		listarCursoPage.clickCadastrarCurso();
		cadastroCursoPage.setNome("Psicologia");
		cadastroCursoPage.clickCadastrarCurso();
		
		assertTrue(listarUsuarioPage.verificarUsuarioCadastrado("Curso", "Psicologia"));
	}
	
	@Test
	public void caso013() {
		loginPage.acessarAdmin();
		loginPage.loginCompleto(Properties.COORDENADOR_EMAIL, Properties.COORDENADOR_PASSWORD);
		assertTrue(dashCoordenador.verificarLoginSucesso());
		dashCoordenador.clickMenuCurso();
		
		listarCursoPage.clickCadastrarCurso();
		cadastroCursoPage.clickCadastrarCurso();
		
		assertTrue(cadastroCursoPage.isMessagePresent("Erro!"));
	}
	
	@Test
	public void caso014() {
		loginPage.acessarAdmin();
		loginPage.loginCompleto(Properties.COORDENADOR_EMAIL, Properties.COORDENADOR_PASSWORD);
		assertTrue(dashCoordenador.verificarLoginSucesso());
		dashCoordenador.clickMenuCurso();
		
		listarCursoPage.clickCadastrarCurso();
		cadastroCursoPage.clickCancelar();;
		
		assertTrue(listarCursoPage.isMessagePresent("Listar Curso"));
	}
	
	@Test
	public void caso015() {
		loginPage.acessarAdmin();
		loginPage.loginCompleto(Properties.COORDENADOR_EMAIL, Properties.COORDENADOR_PASSWORD);
		assertTrue(dashCoordenador.verificarLoginSucesso());
		dashCoordenador.clickMenuCurso();
		
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
		loginPage.loginCompleto(Properties.COORDENADOR_EMAIL, Properties.COORDENADOR_PASSWORD);
		assertTrue(dashCoordenador.verificarLoginSucesso());
		dashCoordenador.clickMenuCurso();
		
		listarCursoPage.deletarCurso("Curso", "Ecologia");
		
		assertTrue(!listarUsuarioPage.verificarUsuarioCadastrado("Curso", "Ecologia"));
	}
	
	@Test
	public void caso053() {
		loginPage.inserirPin("YQF453");
		loginPage.iniciarSessao();
		avaliacaoPage.setarNotaAvaliacaoDisciplinaProfessor(1,8);
		avaliacaoPage.setarNotaAvaliacaoDisciplinaProfessor(2,7);
		avaliacaoPage.setarNotaAvaliacaoDisciplinaProfessor(3,6);
		avaliacaoPage.setarNotaAvaliacaoDisciplinaProfessor(4,5);
		avaliacaoPage.setarNotaAvaliacaoDisciplinaProfessor(5,4);
		avaliacaoPage.setarNotaAvaliacaoDisciplinaProfessor(6,5);
		avaliacaoPage.setarNotaAvaliacaoDisciplinaProfessor(7,8);
		avaliacaoPage.setarNotaAvaliacaoDisciplinaProfessor(8,9);
		avaliacaoPage.setarNotaAvaliacaoDisciplinaProfessor(9,10);
		avaliacaoPage.setarNotaAvaliacaoDisciplinaProfessor(10,10);
		avaliacaoPage.setarNotaAvaliacaoDisciplinaProfessor(11,9);
		avaliacaoPage.setarNotaAvaliacaoDisciplinaProfessor(12,6);
		avaliacaoPage.setarNotaAvaliacaoDisciplinaProfessor(13,8);
		avaliacaoPage.setarNotaAvaliacaoDisciplinaProfessor(14,7);
		avaliacaoPage.setarNotaAvaliacaoDisciplinaProfessor(15,6);
		avaliacaoPage.setarNotaAvaliacaoDisciplinaProfessor(16,5);
		avaliacaoPage.setarNotaAvaliacaoDisciplinaProfessor(17,7);
		avaliacaoPage.setarNotaAvaliacaoDisciplinaProfessor(18,8);
		avaliacaoPage.setarNotaAvaliacaoIsntituicaoAtendimento(1, 5);
		avaliacaoPage.setarNotaAvaliacaoIsntituicaoAtendimento(2, 6);
		avaliacaoPage.setarNotaAvaliacaoIsntituicaoAtendimento(3, 9);
		avaliacaoPage.setarNotaAvaliacaoIsntituicaoAtendimento(4, 8);
		avaliacaoPage.setarNotaAvaliacaoIsntituicaoAtendimento(5, 7);
		avaliacaoPage.setarNotaAvaliacaoIsntituicaoAtendimento(6, 10);
		avaliacaoPage.responderPerguntaTexto1("A aula, e o assunto");
		avaliacaoPage.responderPerguntaTexto2("Não, em nada");
		avaliacaoPage.finalizarAvaliacao();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
