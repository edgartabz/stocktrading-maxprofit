package co.nz.latitude.exercise.stocktrading;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

/*
 * This solution traverses the array only once. Therefore obtaining optimal O(n) complexity.
 * 
 * Iterating through arrays may not be thread safe. So, the toolkit classes of 
 * java.util.concurrent.atomic package is used for thread safety during retrieval/setting of 
 * array values and integers.
 * 
 * There are two variables holds important information while traversing the array:
 * 1. minPrice  - is the smallest integer value detected while iterating the array.
 * 2. maxProfit - is the biggest integer value detected while computing the difference
 *                between the current price at the position of the array and the minimum price.
 * 
 */
public class StockTradingMaxProfitExercise {
	
	public int getMaxProfit(int[] stockPrices) {

		if (stockPrices.length < 2) {
			throw new IllegalArgumentException("There must be at least 2 stock prices to compare.");
		}
		
		synchronized(this) {
			AtomicIntegerArray array = new AtomicIntegerArray(stockPrices);
			AtomicInteger minPrice = new AtomicInteger(array.get(0));
			AtomicInteger maxProfit =  new AtomicInteger(array.get(1) - array.get(0));

			for (int i = 1; i < stockPrices.length; i++) {	
		        maxProfit.set(Math.max(maxProfit.get(), array.get(i) - minPrice.get()));
		        minPrice.set(Math.min(minPrice.get(), array.get(i)));
		    }
			
			return maxProfit.get();
		}
	}
}