package com.cg.ipla;

import java.util.ArrayList;
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

	public ArrayList<BattingData> batsmenWithBestAverage() {
		return (ArrayList<BattingData>)iplBatting.sortingAverageWise();
	}

	public <E> void printData(List<E> listToPrint) {
		listToPrint.stream().forEach(System.out::println);
	}

	public ArrayList<BattingData> batsmenWithMostStrikingRates() {
		return (ArrayList<BattingData>)iplBatting.sortingStrinkingRateWise();
	}

}
