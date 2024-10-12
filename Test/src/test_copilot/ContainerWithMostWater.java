package test_copilot;

public class ContainerWithMostWater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
		int[] height = {1,8,6,2,5,4,8,3,7};
		System.out.println(maxArea(height));
		
	}
	
	// time complexity is O(n) and space complexity is O(1)
	public static int maxArea(int[] height) {
		int maxArea = 0;
		int left = 0;
		int right = height.length - 1;

		while (left < right) {
			int area = Math.min(height[left], height[right]) * (right - left);
			maxArea = Math.max(maxArea, area);

			if (height[left] < height[right]) {
				left++;
			} else {
				right--;
			}
		}

		return maxArea;
	}

}
