package striversSDE.Arrays;

public class F121_BuySellStock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		You are given an array prices where prices[i] is the price of a given stock on the ith day.
//
//		You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
//
//		Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

//		Example 1:
//		Input: prices = [7,1,5,3,6,4]
//		Output: 5
//		Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
//		Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
//
//		Example 2:
//		Input: prices = [7,6,4,3,1]
//		Output: 0
//		Explanation: In this case, no transactions are done and the max profit = 0.
//		 
//		Constraints:
//		1 <= prices.length <= 105
//		0 <= prices[i] <= 104

		int[] prices = { 7, 1, 5, 3, 6, 4 };
		System.out.println(maxProfit(prices));

	}

	public static int maxProfit(int[] prices) {

		int max = prices[prices.length - 1], diff = 0;
		for (int i = prices.length - 1; i >= 0; i--) {
			if (max < prices[i]) {
				max = prices[i];
			}
			if ((max - prices[i]) > diff) {
				diff = max - prices[i];
			}
			System.out.println("diff" + diff + "  max: " + max + "   i-> " + prices[i]);
		}
		return diff;
	}

//	pls try 122, 123, 188

}
