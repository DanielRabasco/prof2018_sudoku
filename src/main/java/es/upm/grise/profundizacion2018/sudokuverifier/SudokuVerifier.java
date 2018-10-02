package es.upm.grise.profundizacion2018.sudokuverifier;

import java.util.ArrayList;

public class SudokuVerifier 
{
public int verify(String candidateSolution){
		
		Group[] columnas= new Group[9];
		Group[] filas = new Group[9];
		Group[] subgrid = new Group[9];
		
		int cont = 0;
		
		for (int i = 0; i < 9; i++){
			filas[i] = new Group();
			columnas[i] = new Group();
			subgrid[i] = new Group();
		}
		
		for (int i = 0; i < 9; i++){
			for (int j = 0; j < 9; j++){
				if (!Character.isDigit(candidateSolution.charAt(cont)) || candidateSolution.charAt(cont) == '0'){
					return -1;
				}
				else{
					if (!filas[i].AddNumber(candidateSolution.charAt(cont))){
						return -3;
					}					
					else if (!columnas[j].AddNumber(candidateSolution.charAt(cont))){
						return -4;
					}
					
					if (i < 3 && j < 3){
						if (!subgrid[0].AddNumber(candidateSolution.charAt(cont))){
							return -2;
						}
					}
					else if (i < 3 && 2 < j && j < 6){
						if (!subgrid[1].AddNumber(candidateSolution.charAt(cont))){
							return -2;
						}
					}
					else if (i < 3 && 5 < j){
						if (!subgrid[2].AddNumber(candidateSolution.charAt(cont))){
							return -2;
						}
					}
					else if (2 < i && i < 6 && j < 3){
						if (!subgrid[3].AddNumber(candidateSolution.charAt(cont))){
							return -2;
						}
					}
					else if (2 < i && i < 6 && 2 < j && j < 6){
						if (!subgrid[4].AddNumber(candidateSolution.charAt(cont))){
							return -2;
						}
					}
					else if (2 < i && i < 6 && j > 5){
						if (!subgrid[5].AddNumber(candidateSolution.charAt(cont))){
							return -2;
						}
					}
					else if (i > 5 && j < 3){
						if (!subgrid[6].AddNumber(candidateSolution.charAt(cont))){
							return -2;
						}
					}
					else if (i > 5 && 2 < j && j < 6){
						if (!subgrid[7].AddNumber(candidateSolution.charAt(cont))){
							return -2;
						}
					}
					else if (i > 5 && j > 5){
						if (!subgrid[8].AddNumber(candidateSolution.charAt(cont))){
							return -2;
						}
					}
					
					cont++;
				}
			}
		}
		return 0;
	}
	
	public class Group {
		
		ArrayList<Character> group;
		
		public Group(){
			group = new ArrayList<Character>();
		}
		
		public boolean AddNumber(char number){
			if (group.contains(number)){
				return false;				
			}
			else{
				group.add(number);
				return true;
			}
		}
	}
}
