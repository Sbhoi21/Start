package b_string;

public class H_JewelsStone {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String jewels = "aA";
		String stones = "aAAbbbb";
		System.out.println(numJewelsInStones(jewels, stones));
	}

	public static int numJewelsInStones(String jewels, String stones) {
		int count = 0;
		for (char c : stones.toCharArray()) {
			if (jewels.indexOf(c) != -1) {
				count++;
			}
		}
		return count;
	}

}
