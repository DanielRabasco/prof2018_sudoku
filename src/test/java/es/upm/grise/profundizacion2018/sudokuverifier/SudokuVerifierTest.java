package es.upm.grise.profundizacion2018.sudokuverifier;

import static org.junit.Assert.*;

import org.junit.Test;

public class SudokuVerifierTest {
    
	SudokuVerifier sd = new SudokuVerifier();
	
	@Test
	public void sudoku_bien_devuelve_0() {
		assertEquals(0, 
				sd.verify("915384276" +
						"843726915" +
						"762591483" +
						"698257341" +
						"327148569" +
						"154639827" +
						"436972158" +
						"279815634" +
						"581463792"));
	}
	
	@Test
	public void sudoku_fila_mal_devuelve_menos3() {
		assertEquals(-3, 
				sd.verify("915394276" +
						"843726915" + 
						"762591483" + 
						"698257341" +
						"327148569" +
						"154639827" +
						"436972158" +
						"279815634" +
						"581463792"));
	}

	@Test
	public void sudoku_columna_mal_devuelve_menos4() {
		assertEquals(-4, 
				sd.verify("915384276943726915762591483698257341327148569154639827436972158279815634581463792"));
	}
	
	@Test
	public void sudoku_grid_mal_devuelve_menos2() {
		assertEquals(-2, 
				sd.verify("915384276893726415762591483698257341327148569154639827436972158279815634581463792"));
	}
	
	@Test
	public void sudoku_con_cero_devuelve_menos1() {
		assertEquals(-1, 
				sd.verify("915384276843726915762591083698257341327148569154639827436972158279815634581463792"));
	}
}
