package co.nz.latitude.excercise.stocktrading;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

/*
 * 
 * 
 */
public class StockTradingMaxProfitExcercise {
	
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