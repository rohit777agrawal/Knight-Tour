package KnightChess;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

/** 
 * 
 * @author rohitagrawal
 *
 */

public class GraphicFill {
	int N=8;  // Can modify to N=8
	static int count = 0;
	
	JFrame frame;
	JPanel squares[][] = new JPanel[N][N];
	
	
	void fillArea( String[][] pBoardMatrix, int row, int col) throws InterruptedException
	{
		int bottomRow = pBoardMatrix.length - 1;
		int rightCol = pBoardMatrix[0].length - 1;
		Thread.sleep(1000);
		displayMatrix(pBoardMatrix , row,col);
		
		System.out.println(row +"    " +col +"     " + count);
		int xMove[] = {2, 1, -1, -2, -2, -1, 1, 2}; 
		int yMove[] = {1, 2, 2, 1, -1, -2, -2, -1}; 
		
		//pBoardMatrix[row][col] = "@";
		count = count+1;
		
		for (int i=0;i<8;i++){
			if(row + xMove[i] >= 0 &&  col+yMove[i] >=0 && row +xMove[i] <= bottomRow &&  col+yMove[i] <= rightCol)
				if(Integer.toString(count).equals(pBoardMatrix[row +xMove[i]][col+yMove[i]]))
					fillArea(pBoardMatrix, row +xMove[i], col+yMove[i]);
		}
	}
	
	private void displayMatrix(String[][] pBoardMatrix , int row , int col) {
		// TODO Auto-generated method stub
		
	    
		 for (int i = 0; i < N; i++) {
		        for (int j = 0; j < N; j++) {
		            JLabel jlabel = new JLabel(pBoardMatrix[i][j]);
		            Component c = null;
		            if(squares[i][j].getComponentCount() > 0)
		            	{ 
		            	c = squares[i][j].getComponent(0);
		            	squares[i][j].remove(c);
		            	}
		            if(i==row && j==col){
		            	squares[i][j].setBackground(Color.GREEN);
		            }
		            squares[i][j].add(jlabel);
		            frame.add(squares[i][j]);
		        }
		    }
		 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);
	}
	public GraphicFill() {
		// TODO Auto-generated constructor stub
		System.out.println("\n\n"); 
		
		frame = new JFrame("Simplified Chess");
	    frame.setSize(500, 500);
	    frame.setLayout(new GridLayout(N, N));
	    Border blackline = BorderFactory.createLineBorder(Color.black);
	    for (int i = 0; i < N; i++) 
	        for (int j = 0; j < N; j++) 
	            {
	        	squares[i][j] = new JPanel();
	        	squares[i][j].setBorder(blackline);
	            }
	    System.out.println("ROW  COL  COUNT");
	}
	
	
}