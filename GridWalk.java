
public class GridWalk {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i, j, max_coordinate = 298, counter = 0;		
		for (i = 1; i <= max_coordinate; i++) { // x axis, from 1 to (max_coordinate-1)
			for (j = 0; j <= (max_coordinate-i); j++) {// y axis, from (max_coordinate-i) to 1 
				if( beyond_nineteen(i, j) ) break;
				//if( beyond_nineteen(i, j) ) j = max_coordinate;
				else counter++;
			}
		}
		counter *= 4; // 4 areas divided by 2 axes
		counter++; // the origin (0, 0)
		
		System.out.print(counter);

	}
	
	public static boolean beyond_nineteen(int x, int y) {
		int x_tmp = x, y_tmp = y;
		//int[] x_digits = {0, 0, 0};
		//int[] y_digits = {0, 0, 0};
		int i = 0, digits_sum = 0;
		do {
			//x_digits[i] = x_tmp % 10;
			digits_sum += (x_tmp % 10);
			i++;
			x_tmp /= 10;
		} while (x_tmp > 0);
			
		i = 0;
		do {
			//y_digits[i] = y_tmp % 10;
			digits_sum += (y_tmp % 10);
			i++;
			y_tmp /= 10;
		} while (y_tmp > 0);
/*
		for (i = 0; i < 3; i++) {
			digits_sum += x_digits[i];
			digits_sum += y_digits[i];
		}
*/		
		if (digits_sum > 19) return true;
		else return false;
	}

}

