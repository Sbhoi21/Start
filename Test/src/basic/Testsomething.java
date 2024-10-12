package basic;

import java.util.ArrayList;

public class Testsomething {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//lcm of m that should be in n
//		int m = 12;
//		int n = 18;
//		int lcm = 0;
//		
//		for (int i = 1; i <= n; i++) {
//			if (i % m == 0 && i % n == 0) {
//				lcm = i;
//				break;
//			}
//		}
//		
//		System.out.println("LCM of " + m + " and " + n + " is: " + lcm);
		
		
		int k ,l, m, n =0;
		m=18;
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (k = 1; k < m; k++) {
			if (m%k == 0) {
				n++;
				list.add(k);
			}
		}
		System.out.println(n);
		for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
	}

}
