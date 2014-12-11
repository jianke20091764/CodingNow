package google.com.campus;

import java.util.Scanner;

public class SudokuChecker { 
	
	public static void main(String[] args){
		new Sudoku();
	}
}

class Sudoku {
	private int T ;
	private int N ;
	private int level ;
	private int[][] matrix ; 
	
	public Sudoku(){
		this.getInput();
	}
	
	public Sudoku(int _T,int _N){
		this.N = _N ;
		this.T = _T ;
	}
	
	private void getInput(){
		Scanner cin = new Scanner(System.in);
		int i,j ;
		try {
			this.T = cin.nextInt();
			for(i = 0 ; i < this.T ; i ++ ){
				this.N = cin.nextInt();
				this.level = this.N * this.N ;
				this.matrix = new int[this.level][this.level];
				for(j = 0 ; j < Math.pow(this.N, 4); j ++){
					this.matrix[j/this.level][j %this.level] =  cin.nextInt();
				}
				if(this.parseSoku()){
					Console.info("Case #" + (i + 1) + ": Yes");
				}else{
					Console.info("Case #" + (i + 1) + ": No");
				}
			}
		} catch (Exception e) {
			Console.log(e);
		}
	}
	
	private boolean parseSoku(){
		int[] temp = new int[this.level];
		int i,j,k,p,q,count ;
		for(i = 0; i < this.level ; i ++){
			for( j = 0 ; j < this.level; j ++){
				temp[j] = this.matrix[i][j];
			}
			
			if(!this.judgeOnce(temp)){
				return false;
			};
			
			for( j = 0 ; j < this.level; j ++){
				temp[j] = this.matrix[j][i];
			}
			
			if(!this.judgeOnce(temp)){
				return false;
			};
			
		}
		
		for( i = 0 ; i< this.level ; i ++){
			count = 0 ;
			p = (i / this.N) *this.N ;
			q = (i % this.N) *this.N ;
			for( j = 0 ; j < this.N ; j ++ ){
				for( k = 0 ; k < this.N ; k ++){
					temp[count ++] = this.matrix[p + j][q + k]; 
				}
			}
			
			if(!this.judgeOnce(temp)){
				return false;
			};
			
		}

		return true ;
	}
	
	private boolean judgeOnce(int[] data){
		
		int[] temp = new int[this.level];
		int i ;
		for(i = 0 ;i < this.level ; i ++){
			if(data[i]-1>= 0 && data[i]- 1< this.level){
				temp[data[i]-1] = 1 ;
			}else{
				return false ;
			};
		}
		
		for(i = 0 ; i < this.level ; i ++){
			if(temp[i] != 1){
				return false ;
			}else{
				continue ;
			}
		}
		
		return true ;
	}
	
	
}
