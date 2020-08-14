package tests;

import org.junit.Test;

import core.AbstractTest;
import pages.DashBoardCoordenadorPage;
import pages.ListarUsuarioPage;

public class ModuloCoordenadorTest extends AbstractTest {

	DashBoardCoordenadorPage dashCoordenador = new DashBoardCoordenadorPage();
	ListarUsuarioPage listarUsuarioPage = new ListarUsuarioPage();
	
	@Test
	public void teste() {
		dashCoordenador.clickUsuario();
		listarUsuarioPage.cadastrarUsuario();
	}
}
