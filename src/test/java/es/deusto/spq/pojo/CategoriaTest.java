package es.deusto.spq.pojo;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

public class CategoriaTest {

	@Mock
	Categoria categoria;
	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		
		assertNotNull(categoria.INFANTIL);
		assertNotNull(categoria.ADULTO);
	}

}
