package randomYT.Codebix;

import java.util.HashMap;

public class Q309_BestTimeToBuyStock {

//	You are given an array prices where prices[i] is the price of a given stock on the ith day.
//
//	Find the maximum profit you can achieve. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times) with the following restrictions:
//
//	After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).
//	Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
//
//	 
//
//	Example 1:
//
//	Input: prices = [1,2,3,0,2]
//	Output: 3
//	Explanation: transactions = [buy, sell, cooldown, buy, sell]
//	Example 2:
//
//	Input: prices = [1]
//	Output: 0
//	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] prices = { 1, 2, 3, 0, 2 };
		System.out.println(new Q309_BestTimeToBuyStock().maxProfit(prices));
		System.out.println(new Q309_BestTimeToBuyStock().maxProfit2(prices));
		prices = new int[] { 1 };
		System.out.println(new Q309_BestTimeToBuyStock().maxProfit(prices));
//		System.out.println(new Q309_BestTimeToBuyStock().maxProfit2(prices));
		// long input complex
		prices = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		System.out.println(new Q309_BestTimeToBuyStock().maxProfit(prices));
//		System.out.println(new Q309_BestTimeToBuyStock().maxProfit2(prices));
	}

	// 1ms
	public int maxProfit(int[] prices) {
		int n = prices.length;
		int[] buy = new int[n];
		int[] sell = new int[n];
		int[] cool = new int[n];

		buy[0] = -prices[0];
		for (int i = 1; i < n; i++) {
			buy[i] = Math.max(cool[i - 1] - prices[i], buy[i - 1]);
			sell[i] = Math.max(buy[i - 1] + prices[i], sell[i - 1]);
			cool[i] = Math.max(sell[i - 1], cool[i - 1]);
		}

		return sell[n - 1];
	}

	// by variables instead of arrays
	// 0ms
	public int maxProfit1(int[] prices) {
		int n = prices.length;
		int buy = -prices[0];
		int sell = 0;
		int cool = 0;

		for (int i = 1; i < n; i++) {
			int prevBuy = buy;
			buy = Math.max(cool - prices[i], buy);
			cool = sell;
			sell = Math.max(prevBuy + prices[i], sell);
		}

		return sell;
	}

	// by recursion

	public int maxProfit2(int[] prices) {
		return maxProfit(prices, 0, false);
	}

	public int maxProfit(int[] prices, int i, boolean hasStock) {
		System.out.println(i + " " + hasStock);
		if (i >= prices.length) {
			return 0;
		}
		if (hasStock) {
			return Math.max(maxProfit(prices, i + 2, false) + prices[i], maxProfit(prices, i + 1, true));
		} else {
			return Math.max(maxProfit(prices, i + 1, true) - prices[i], maxProfit(prices, i + 1, false));
		}
	}

	// by dp with hashmap
	// 10ms
	public int maxProfit3(int[] prices) {
		return maxProfit(prices, 0, false, new HashMap<>());
	}

	public int maxProfit(int[] prices, int i, boolean hasStock, HashMap<String, Integer> map) {
		String key = i + "_" + hasStock;
		if (map.containsKey(key)) {
			return map.get(key);
		}
		if (i >= prices.length) {
			return 0;
		}
		if (hasStock) {
			map.put(key,
					Math.max(maxProfit(prices, i + 2, false, map) + prices[i], maxProfit(prices, i + 1, true, map)));
		} else {
			map.put(key,
					Math.max(maxProfit(prices, i + 1, true, map) - prices[i], maxProfit(prices, i + 1, false, map)));
		}
		return map.get(key);
	}

}
