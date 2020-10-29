package com.cg.ipla;

import java.util.Comparator;

import com.cg.ipla.dto.AllRounder;

public class AllRounderSortBy {
	
	public static final Comparator<AllRounder> BEST_BATTING_AND_BOWLING_AVG = Comparator.comparing(player -> player.getAverageRuns() + player.getAverageWickets());

	public static Comparator<AllRounder> addConditionsInOrder(Comparator<AllRounder>...comparators ){
		if(comparators.length==0)
			return null;
		Comparator<AllRounder> temp=comparators[0];
		for(int i=1;i<comparators.length-1;i++){
			temp=temp.thenComparing(comparators[i]);
		}
		return temp;
	}

}
