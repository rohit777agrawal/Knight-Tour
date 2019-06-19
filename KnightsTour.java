package KnightChess;


// Java program for Knight Tour problem 

/**
 * 
 * @author rohitagrawal
 *
 */

class KnightsTour { 
	//Static variable ->> N
	public static int N = 8;   // Can modify to N=8 . Also need to modify N=8 in GraphicFill class
	
	/* Driver program to test functions */
	public static void main(String args[]) throws InterruptedException { 
		solveKT(); 
	} 
	
	/**
	 * PRE-CONDITION ->> should have all the parameters declared
	 * POST-CONDITION ->> return true/false. 
	 * @param x
	 * @param y
	 * @param sol
	 * @return true/false
	 */
	public static boolean isSafe(int x, int y, int sol[][]) { 
		return (x >= 0 && x < N && y >= 0 && 
				y < N && sol[x][y] == -1); 
	} 
	
	/**
	 * Method --> printSolution
	 * PRE-CONDITION ->> There should be Int double array 
	 * POST-CONDITION ->> Will print the view
	 * START
	 * STRING sol1 double array
	 * INT X && Y
	 * FOR	X is zero & x<N & x increment
	 * 	IF x>0 && N==8
	 * 		print
	 * 	ELSE IF 
	 * 		print
	 * 	ELSE IF 
	 * 		print
	 * 	ELSE 
	 * 		print
	 * 	FOR Y=0 && y<N && y increment.
	 * 		print
	 * FOR loops ends
	 * IF N==8
	 * 	print
	 * ELSE
	 * 	print
	 * END
	 */
	public static void printSolution(int sol[][]) throws InterruptedException { 
		String sol1[][] = new String[N][N];
		int x = 0,y=0;
		
		for ( x = 0; x < N; x++) {
			if(x>0 && N==8)
				System.out.println("\t|-------|-------|-------|-------|-------|-------|-------|-------|");
			else if(x==0 && N==8)
				System.out.println("\t-----------------------------------------------------------------");
			else if(x==0 && N==5)
				System.out.println("\t-----------------------------------------");
			else
				System.out.println("\t|-------|-------|-------|-------|-------|");
			for ( y = 0; y < N; y++){ 
				System.out.print( "\t|"+sol[x][y]);
				sol1[x][y] = Integer.toString(sol[x][y]);
			}
				System.out.print("\t|\n"); 
			
		}
		if(N==8)
			System.out.println("\t-----------------------------------------------------------------");
		else
			System.out.println("\t-----------------------------------------");
		
		new GraphicFill().fillArea(sol1, 0, 0);
	} 

		
	/**
	 * METHOD ->> solveKT
	 * @return true/false
	 * @throws InterruptedException
	 * PRE-CONDITION ->> there should be no interrupted exception
	 * POST-CONDITION ->> return true/false
	 * START
	 * INT sol double array 8*8
	 * FOR (INT X)
	 * 		FOR (INT Y)
	 * 			SOL INITIALIZE
	 * INT xMove[]
	 * INT yMove[]
	 * SOL 1 index 0,0
	 * IF (calling solveKTUtil method)
	 * 		Print does not exist.
	 * 		return false;
	 * ELSE
	 * 		Print gap
	 * 		calling method printSolution(sol);
	 * return true.
	 * END	
	 */
	public static boolean solveKT() throws InterruptedException { 
		int sol[][] = new int[8][8]; 

		/* Initialization of solution matrix */
		for (int x = 0; x < N; x++) 
			for (int y = 0; y < N; y++) 
				sol[x][y] = -1; 
		int xMove[] = {2, 1, -1, -2, -2, -1, 1, 2}; 
		int yMove[] = {1, 2, 2, 1, -1, -2, -2, -1}; 

		sol[0][0] = 0; 
		if (!solveKTUtil(0, 0, 1, sol, xMove, yMove)) { 
			System.out.println("Solution does not exist"); 
			return false; 
		}
		else{
			System.out.println("\n\n");
			printSolution(sol); 
		}
		return true; 
	} 

	/**
	 * METHOD ->> solveKTUtil
	 * @param x
	 * @param y
	 * @param movei
	 * @param sol
	 * @param xMove
	 * @param yMove
	 * @return true/false
	 * PRE-CONDITION ->> parameters should be there.
	 * POST-CONDITION ->> return true/false
	 * START
	 * INT k, next_x, next_y
	 * IF(last condition)
	 * 		return true;
	 * FOR (INT K)
	 * 		next_x
	 * 		next_y //determines the position and if it is safe or not.
	 * 		IF(it is safe)
	 * 			determine the next position.
	 * 			return true if all found.
	 * 		ELSE
	 * 			backtracking.
	 * return false
	 * END
	 */
	public static boolean solveKTUtil(int x, int y, int movei, 
							int sol[][], int xMove[], 
							int yMove[]) { 
		int k, next_x, next_y; 
		if (movei == N * N) 
			return true; 

		for (k = 0; k < 8; k++) { 
			next_x = x + xMove[k]; 
			next_y = y + yMove[k]; 
			if (isSafe(next_x, next_y, sol)) { 
				sol[next_x][next_y] = movei; 
				if (solveKTUtil(next_x, next_y, movei + 1, 
								sol, xMove, yMove)) 
					return true; 
				else
					sol[next_x][next_y] = -1;// backtracking 
			} 
		} 

		return false; 
	} 
	
} 