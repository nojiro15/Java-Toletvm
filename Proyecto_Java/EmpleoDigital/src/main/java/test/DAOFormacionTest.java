package test;

import java.util.Date;

import org.junit.Test;

import dao.DAOFormacionImpl;
import junit.framework.TestCase;
import modelos.Formacion;

public class DAOFormacionTest extends TestCase {
	DAOFormacionImpl daof = new DAOFormacionImpl();
	
	@Test
	public void testCreate(){
		Formacion f = new Formacion("Prueba", new Date());
		daof.create(f);
		daof.read("Prueba");
		
	}

}
