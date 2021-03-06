package com.cg.ipla;

import java.util.Comparator;

import com.cg.ipla.dto.BowlingData;

public class BowlingSortBy {

	public static final Comparator<BowlingData> BEST_AVG = Comparator.comparing(BowlingData::getAverage);

	public static final Comparator<BowlingData> BEST_STRIKE_RATE = Comparator.comparing(BowlingData::getStrikeRate);

	public static final Comparator<BowlingData> BEST_ECONOMY = Comparator.comparing(BowlingData::getEconomy);
	
	public static final Comparator<BowlingData> MAX_WKTS=Comparator.comparing(BowlingData::getNoOfWickets);

	public static Comparator<BowlingData> addConditionsInOrder(Comparator<BowlingData>[] comparators) {
		if (comparators.length == 0)
			return null;
		Comparator<BowlingData> temp = comparators[0];
		for (int i = 1; i < comparators.length; i++) {
			temp = temp.thenComparing(comparators[i]);
		}
		return temp;
	}

}
