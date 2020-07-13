package co.nz.latitude.exercise.stocktrading;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import co.nz.latitude.exercise.stocktrading.StockTradingMaxProfitExercise;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StockTradingMaxProfitExerciseTest {

	private StockTradingMaxProfitExercise program = new StockTradingMaxProfitExercise();

	private static final int[] SAMPLE_STOCK_PRICES = new int[] {10, 7, 5, 8, 11, 9};
	private static final int[] SAMPLE_8HR_TRADE = new int[] {4, 456, 243, 408, 134, 14, 277, 66, 269, 374, 64, 134, 465, 100, 188, 240, 27, 61, 100, 274, 104, 148, 170, 484, 267, 437, 301, 309, 245, 14, 63, 303, 304, 232, 390, 229, 185, 272, 338, 182, 24, 467, 24, 509, 260, 430, 19, 167, 469, 456, 376, 396, 295, 204, 175, 443, 192, 368, 128, 323, 166, 148, 67, 491, 63, 481, 191, 499, 13, 461, 81, 165, 34, 307, 483, 344, 461, 359, 117, 410, 393, 102, 483, 104, 119, 158, 9, 83, 255, 256, 498, 113, 422, 191, 470, 296, 245, 98, 258, 511, 200, 305, 184, 78, 237, 315, 187, 460, 494, 93, 474, 263, 361, 335, 378, 220, 42, 339, 121, 77, 476, 259, 332, 397, 350, 67, 62, 330, 281, 183, 510, 5, 76, 268, 210, 246, 400, 225, 454, 57, 257, 278, 370, 388, 256, 372, 453, 190, 122, 331, 105, 283, 43, 300, 493, 205, 265, 231, 235, 231, 226, 168, 378, 331, 192, 495, 295, 55, 228, 283, 256, 493, 187, 203, 286, 313, 153, 310, 362, 343, 341, 5, 477, 50, 116, 406, 137, 284, 265, 421, 273, 187, 139, 152, 361, 461, 205, 166, 361, 361, 171, 173, 184, 402, 187, 116, 8, 137, 475, 283, 250, 74, 503, 240, 249, 232, 438, 232, 11, 293, 333, 474, 464, 506, 447, 19, 107, 409, 169, 245, 313, 250, 388, 501, 472, 377, 165, 218, 336, 117, 138, 355, 11, 114, 27, 311, 334, 425, 304, 309, 463, 13, 142, 156, 250, 12, 171, 354, 262, 364, 368, 367, 35, 303, 478, 264, 177, 3, 154, 54, 200, 23, 253, 74, 26, 385, 422, 216, 17, 49, 279, 266, 202, 278, 292, 329, 209, 183, 456, 73, 498, 12, 30, 364, 409, 331, 128, 118, 445, 70, 322, 219, 461, 61, 172, 47, 265, 491, 187, 27, 73, 486, 456, 113, 482, 304, 392, 235, 451, 193, 5, 212, 71, 212, 372, 253, 488, 256, 340, 478, 146, 31, 59, 477, 172, 374, 220, 453, 459, 207, 12, 468, 294, 38, 427, 431, 453, 174, 474, 175, 82, 503, 194, 398, 217, 124, 354, 281, 404, 32, 365, 173, 472, 151, 99, 500, 397, 177, 206, 283, 345, 87, 232, 262, 252, 480, 30, 259, 341, 488, 331, 4, 124, 80, 287, 201, 114, 503, 51, 25, 396, 325, 241, 192, 303, 228, 200, 347, 80, 173, 493, 79, 326, 276, 351, 108, 370, 238, 107, 244, 440, 124, 344, 67, 453, 93, 46, 392, 13, 50};
	private static final int[] SAMPLE_UPTREND_PRICES = new int[] {8, 8, 7, 8, 10, 11, 8};
	private static final int[] SAMPLE_DOWNTREND_PRICES = new int[] {8, 11, 10, 8, 7, 8, 8};
	private static final int[] SAMPLE_TRADE_LOSS = new int[] {18, 11, 10, 8, 7, 8, 8};

	@Test
	public void test_1_GetMaxProfit() {
		Assert.assertEquals(6, program.getMaxProfit(SAMPLE_STOCK_PRICES));
	}
	
	@Test
	public void test_2_GetMaxProfit8HrTrade() {
		Assert.assertEquals(507, program.getMaxProfit(SAMPLE_8HR_TRADE));
	}
	
	@Test
	public void test_3_GetMaxProfitUptrendPrices() {
		Assert.assertEquals(4, program.getMaxProfit(SAMPLE_UPTREND_PRICES));
	}

	@Test
	public void test_4_GetMaxProfitDowntrendPrices() {
		Assert.assertEquals(3, program.getMaxProfit(SAMPLE_DOWNTREND_PRICES));
	}

	@Test
	public void test_5_GetMaxProfitTradeLoss() {
		Assert.assertEquals(1, program.getMaxProfit(SAMPLE_TRADE_LOSS));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_6_ThrowIllegalArgumentException() {
		program.getMaxProfit(new int[] {109});
	}
}
