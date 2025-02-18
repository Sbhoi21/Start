package randomYT.Codebix;

public class Q342_PowerOfFour {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Q342_PowerOfFour obj = new Q342_PowerOfFour();
		System.out.println(obj.isPowerOfFour(16)); // true

		System.out.println(obj.isPowerOfFour2(16)); // true

	}

	// 0ms
	public boolean isPowerOfFour(int num) {
		if (num <= 0) {
			return false;
		}
		while (num % 4 == 0) {
			num /= 4;
		}
		return num == 1;
	}

	// 1ms
	public boolean isPowerOfFour2(int num) {
		return num > 0 && (num & (num - 1)) == 0 && (num & 0x55555555) != 0;
	}

	// 4ms
	public boolean isPowerOfFour3(int num) {
		return Integer.toString(num, 4).matches("10*");
	}

	// 1ms
	public boolean isPowerOfFour4(int num) {
		return (Math.log(num) / Math.log(4)) % 1 == 0;
	}

	// 0ms
	public boolean isPowerOfFour6(int num) {
		return num > 0 && (num & (num - 1)) == 0 && (num - 1) % 3 == 0;
	}

	// 1ms
	public boolean isPowerOfFour7(int num) {
		int count = 0;
		for (int i = 0; i < 32; i++) {
			if (((num >>> i) & 1) == 1) {
				count++;
				if (i % 2 == 1 || count > 1) {
					return false;
				}
			}
		}
		return count == 1;
	}

}
