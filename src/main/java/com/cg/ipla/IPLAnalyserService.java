package com.cg.ipla;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.cg.ipla.dto.BattingData;
import com.cg.ipla.dto.BowlingData;

public class IPLAnalyserService {
	
	public enum BowlingOrBatting{
		BOWLING_DATA,BATTING_DATA
	}
	
	IPLBattingAnalyser iplBatting;
	IPLBowlingAnalyser iplBowling;
	
	public IPLAnalyserService(String dataPath, BowlingOrBatting chooseDataFile) {
		
		if(chooseDataFile.equals(BowlingOrBatting.BATTING_DATA))
			iplBatting=new IPLBattingAnalyser(dataPath);
		else if(chooseDataFile.equals(BowlingOrBatting.BOWLING_DATA))
			iplBowling=new IPLBowlingAnalyser(dataPath);
	}
	public ArrayList<BowlingData> getBowlingDataFile(String bowlingDataPath) {
		return (ArrayList<BowlingData>)new IPLBowlingAnalyser().gettingBowlingList(bowlingDataPath);

	}

	public ArrayList<BattingData> getBattingDataFile(String battingDataPath) {
		return (ArrayList<BattingData>)new IPLBattingAnalyser().gettingBattingList(battingDataPath);

	}

	public ArrayList<BattingData> sortingBatsmen(Comparator<BattingData>... comparators) {
		Comparator<BattingData> comparator=BattingSortBy.addConditionsInOrder(comparators);
		return (ArrayList<BattingData>) iplBatting.sortingBatsmenOrder(comparator);
	}
	public<E> void printData(ArrayList<E> list) {
		list.stream().forEach(System.out::println);
		
	}


}
