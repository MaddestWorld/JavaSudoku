package main;

import java.util.concurrent.ThreadLocalRandom;

public class Sudoku {
	//glavni ze resen sudoku 
	int[][] sudoku=new int[9][9];
	//prvoten zapis sudokuja ki ga uporabnik vidi
	int[][] nedSudoku=new int[9][9];
	//uporabnikov popravljen sudoku
	int[][] trenutniSudoku=new int[9][9];
	//tezavnostna stopnja
	private int tezavnost=80;
	
	public int getTezavnost() {
		return tezavnost;
	}
	
	public void setTezavnost(int tezavnost) {
		this.tezavnost = tezavnost;
		this.pobrisiElemente();
		this.nastavi();
	}
	
	public void generiraj(){
		/*Generira sudoku*/
		
		
	}
	
	public void pobrisiElemente(){
		/*pripravi sudoku za resevanje, to naredi tako, da
		 *uposteva tezavnost ter na tezavnost izbrise podatke  */
		int stElementovZaPobrisati=0;
		int vrs=0;
		int stol=0;
		this.nedSudoku=new int[9][9];
		for (int vrstica=0;vrstica<9;vrstica++){
			for(int stolpec=0;stolpec<9;stolpec++){
				this.nedSudoku[vrstica][stolpec]=this.sudoku[vrstica][stolpec];
			}
		}
		stElementovZaPobrisati=81-this.tezavnost;
		while (stElementovZaPobrisati>0){
			vrs=ThreadLocalRandom.current().nextInt(0,9);
			stol=ThreadLocalRandom.current().nextInt(0,9);
			if (this.nedSudoku[vrs][stol]!=0){
				this.nedSudoku[vrs][stol]=0;
				stElementovZaPobrisati--;
			}
		}
		
	}
	
	public void nastavi(){
		/*Nastavi sudoku tako da ga lahko uporabnik spreminja*/
		for (int vrstica=0;vrstica<9;vrstica++){
			for(int stolpec=0;stolpec<9;stolpec++){
				this.trenutniSudoku[vrstica][stolpec]=this.nedSudoku[vrstica][stolpec];
			}
		}	
	}
	
	public void posodobi(int vrstica,int stolpec,int stevilo){
		/*Posodobi trenuniSudoku da se ujema z zaslonom*/
		this.trenutniSudoku[vrstica][stolpec]=stevilo;
		
	}
	
	public boolean preveriEnakost(){
		/*Preveri ce je sudoku resen pravilno*/
		for (int vrstica=0;vrstica<9;vrstica++){
			for(int stolpec=0;stolpec<9;stolpec++){
				if(this.trenutniSudoku[vrstica][stolpec]!=this.sudoku[vrstica][stolpec]){
					return false;
				}
			}
		}
		return false;
	}

}
