package com.cg.ipla;

import java.util.Comparator;

import com.cg.ipla.dto.BattingData;

public class BattingSortBy {

	public static final Comparator<BattingData> BEST_AVG = Comparator.comparing(BattingData::getAverage);

	public static final Comparator<BattingData> BEST_STRIKE_RATE = Comparator
			.comparing(BattingData::getStrikeRate);

	public static final Comparator<BattingData> MAX_4S_AND_6S = Comparator
			.comparing(batsman -> batsman.getNoOfFours() + batsman.getNoOfSixes());
	
	public static final Comparator<BattingData> MAX_RUNS = Comparator.comparing(BattingData::getRuns);
	
	public static Comparator<BattingData> addConditionsInOrder(Comparator<BattingData>...comparators){ 
		if(comparators.length==0)
			return null;
		Comparator<BattingData> temp=comparators[0];
		for(int i=1;i<comparators.length-1;i++){
			temp=temp.thenComparing(comparators[i]);
		}
		return temp;
		
	}

}
