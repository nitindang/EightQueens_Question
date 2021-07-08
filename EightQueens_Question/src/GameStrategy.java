public class GameStrategy {
	private boolean placedQueens[][] = new boolean[8][8];
	private int numQueens = 0;

	private int getColumn(int cellId) {
		// WRITE YOUR LOGIC HERE...................................
		//Because with the increase in cellId the column changes
		return cellId%8;
	}
	
	private int getRow(int cellId) {
		// WRITE YOUR LOGIC HERE....................................
		//Because row only increases after 8 squares
		return cellId/8;

	}

	public boolean isValidPosition(int cellId) {


		if(numQueens == 8) throw new GameOverException();	// just return out of the method

		// the game is still on, so let us continue...
		
		int col = getColumn(cellId);
		
		int row = getRow(cellId);
		
		// Is it already placed
		if(placedQueens[row][col]==true){
			return false;
		}
		else{
			//Checking if a queen is already present in that entire row and column
			for(int i = 0;i < 8;i++) {
				if (placedQueens[row][i] || placedQueens[i][col]) {
					return false;
				}
			}
			//Now checking in diagonals
			for(int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
				if(placedQueens[i][j]) {
					return false;
				}
			}

			for(int i = row - 1, j = col + 1; i >= 0 && j< 8; i--, j++) {
				if(placedQueens[i][j]) {
					return false;
				}
			}

			for(int i = row + 1, j = col - 1; i< 8 && j >= 0; i++, j--) {
				if(placedQueens[i][j]) {
					return false;
				}
			}

			for(int i = row + 1, j = col + 1; i<8 && j<8; i++, j++) {
				if(placedQueens[i][j]) {
					return false;
				}
			}
		}
		// Because it didn't return false until now. Hence a valid position.
		placedQueens[row][col]=true;
		numQueens++;
		return true;
	}
}














