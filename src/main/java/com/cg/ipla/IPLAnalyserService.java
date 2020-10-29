package com.cg.ipla;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Predicate;

import com.cg.ipla.dto.AllRounder;
import com.cg.ipla.dto.BattingData;
import com.cg.ipla.dto.BowlingData;

public class IPLAnalyserService {

	public enum BowlingOrBatting {
		BOWLING_DATA, BATTING_DATA
	}

	IPLBattingAnalyser iplBatting;
	IPLBowlingAnalyser iplBowling;

	public IPLAnalyserService(String dataPath, BowlingOrBatting chooseDataFile) {

		if (chooseDataFile.equals(BowlingOrBatting.BATTING_DATA))
			iplBatting = new IPLBattingAnalyser(dataPath);
		else if (chooseDataFile.equals(BowlingOrBatting.BOWLING_DATA))
			iplBowling = new IPLBowlingAnalyser(dataPath);
	}

	public ArrayList<BowlingData> getBowlingDataFile(String bowlingDataPath) {
		return (ArrayList<BowlingData>) new IPLBowlingAnalyser().gettingBowlingList(bowlingDataPath);

	}

	public ArrayList<BattingData> getBattingDataFile(String battingDataPath) {
		return (ArrayList<BattingData>) new IPLBattingAnalyser().gettingBattingList(battingDataPath);

	}

	public ArrayList<BattingData> sortingBatsmen(Comparator<BattingData>... comparators) {
		Comparator<BattingData> comparator = BattingSortBy.addConditionsInOrder(comparators);
		return (ArrayList<BattingData>) iplBatting.sortingBatsmenOrder(comparator);
	}

	public ArrayList<BowlingData> sortingBowlers(Comparator<BowlingData>... comparators) {
		Comparator<BowlingData> comparator = BowlingSortBy.addConditionsInOrder(comparators);
		return (ArrayList<BowlingData>) iplBowling.sortingBowlersOrder(comparator);
	}
	public ArrayList<BowlingData> sortingBowlers(ArrayList<BowlingData> list,Comparator<BowlingData>... comparators) {
		Comparator<BowlingData> comparator = BowlingSortBy.addConditionsInOrder(comparators);
		return (ArrayList<BowlingData>) new IPLBowlingAnalyser(list).sortingBowlersOrder(comparator);
	}

	public ArrayList<BowlingData> sortingBowlersOnSpecificConditions(Predicate<BowlingData> p,
																					Comparator<BowlingData>... comparators) {
		ArrayList<BowlingData> filteredList = (ArrayList<BowlingData>) iplBowling.filteringBowlers(p);
		return this.sortingBowlers(filteredList,comparators);
	}

	public ArrayList<BowlingData> sortingBowlersHaving4wsAnd5ws(Comparator<BowlingData>... comparators) {
		Predicate<BowlingData> has4wsAnd5ws = bowlers -> bowlers.getFourWickets() != 0 || bowlers.getFiveWickets() != 0;
		return this.sortingBowlersOnSpecificConditions(has4wsAnd5ws, comparators);
	}
	
	public ArrayList<AllRounder> sortingCricketers(Comparator<AllRounder>... comparators){
		 IPLAllRounderAnalyser iplara= new IPLAllRounderAnalyser();
		 iplara.buildAllRounderList(iplBowling.bowlersList, iplBatting.batsmenList);
		 Comparator<AllRounder> comparator=AllRounderSortBy.addConditionsInOrder(comparators);
		 return (ArrayList<AllRounder>) iplara.sortingAllRoundersOrder(comparator);
	}

	public <E> void printData(ArrayList<E> list) {
		list.stream().forEach(System.out::println);

	}

}
