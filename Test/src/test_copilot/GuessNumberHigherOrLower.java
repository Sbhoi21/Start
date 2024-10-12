package test_copilot;

//LC. 374 Guess Number Higher or Lower
public class GuessNumberHigherOrLower {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = 10;
		System.out.println(guessNumber(n));
		
		
	}
	
	
	public static int guessNumber(int n) {
		int left = 1;
		int right = n;
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (guess(mid) == 0) {
				return mid;
			} else if (guess(mid) == 1) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		return left;
	}
	
	public static int guess(int num) {
		
		//-1 is the number is lower than the guess
		//1 if the number is higher than the guess
		//0 if the number is equal to the
		int pick = 9;
		if (num == pick) {
			return 0;
		} else if (num < pick) {
			return 1;
		} else {
			return -1;
		}
	}

}
