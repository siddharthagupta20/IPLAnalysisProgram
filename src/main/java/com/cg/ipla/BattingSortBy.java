package com.cg.ipla;

import java.util.Comparator;

import com.cg.ipla.dto.BattingData;

public class BattingSortBy {

	public static final Comparator<BattingData> COMPARATOR_BEST_AVG = Comparator.comparing(BattingData::getAverage);

	public static final Comparator<BattingData> COMPARATOR_STRIKE_RATE = Comparator
			.comparing(BattingData::getStrikeRate);

	public static final Comparator<BattingData> COMPARATOR_4S_AND_6S = Comparator
			.comparing(batsman -> batsman.getNoOfFours() + batsman.getNoOfSixes());

}
