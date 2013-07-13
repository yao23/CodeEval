
public class GridWalk {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i, j, dup_counter = 0, max = 299, counter = 0;
		int[][] visited = new int[max][max]; 
			for (i = 0; i < max; i++)
				for (j = 0; j < max; j++)
					visited[i][j] = 0;
		
		counter = search(0, 0, counter, visited);
		for (int m = 0; m < visited[0].length; m++) {
			if (visited[0][m] == 1)
				dup_counter++;
		}
		counter -= dup_counter; // remove the duplicated part
		counter *= 4; // 4 areas in coordinate system
		counter++; // the origin (0, 0)
		
		System.out.print(counter);

	}
	
	public static int search(int x, int y, int counter, int[][] visited) {
		if (beyond_nineteen(x, y))	// check the constraint.
			return counter;
		if (visited[x][y] == 1)	// check for duplicate.
			return counter;
		visited[x][y] = 1;
		counter++;

		counter = search(x + 1, y, counter, visited);
		counter = search(x, y + 1, counter, visited);
		
		return counter;
	}
	
	public static boolean beyond_nineteen(int x, int y) {
		int x_tmp = x, y_tmp = y, digits_sum = 0;
		
		do {
			digits_sum += (x_tmp % 10);
			x_tmp /= 10;
		} while (x_tmp > 0);
			
		do {
			digits_sum += (y_tmp % 10);			
			y_tmp /= 10;
		} while (y_tmp > 0);
		
		if (digits_sum > 19) return true;
		else return false;
	}

}

