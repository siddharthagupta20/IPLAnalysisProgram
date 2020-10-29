package com.cg.ipla;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.cg.ipla.IPLAnalyserService.BowlingOrBatting;
import com.cg.ipla.dto.AllRounder;
import com.cg.ipla.dto.BattingData;

public class IPLAllRounderAnalyserTest {
	
	public IPLAnalyserService iplAnalyser;
	public static final String BATTING_DATA = "src/main/resources/WP DP Data_01 IPL2019FactsheetMostRuns.csv";
	public static final String BOWLING_DATA = "src/main/resources/WP DP Data_02 IPL2019FactsheetMostWkts.csv";
	
	@Before
	public void setUp() {
		iplAnalyser=new IPLAnalyserService(BATTING_DATA,BowlingOrBatting.BATTING_DATA);
		iplAnalyser.iplBowling=new IPLBowlingAnalyser(BOWLING_DATA);
	}
	
	@Test
	public void givenBowlingAndBattingData_ShouldReturnBestBattingAndBowlingAvgs() {
		List<AllRounder> allRounders=iplAnalyser.sortingCricketers(AllRounderSortBy.BEST_BATTING_AND_BOWLING_AVG);
		assertEquals("Krishnappa Gowtham",allRounders.get(allRounders.size()-1).getPlayer());
		
	}
	@Test
	public void givenBowlingAndBattingData_ShouldReturnCricketersWithMaxRunsAndWickets() {
		List<AllRounder> allRounders=iplAnalyser.sortingCricketers(AllRounderSortBy.MAX_RUNS,AllRounderSortBy.MAX_WICKETS);
		assertEquals("Andre Russell",allRounders.get(allRounders.size()-1).getPlayer());
		
	}
	@Test
	public void givenBowlingAndBattingData_ShouldReturnCricketersWithMax100sAndBestAvgs() {
		List<BattingData> batsmen=iplAnalyser.sortingBatsmen(BattingSortBy.MAX_100S,BattingSortBy.BEST_AVG);
		assertEquals("25",batsmen.get(batsmen.size()-1).getPosition());
	}
	@Test
	public void givenBowlingAndBattingData_ShouldReturnCricketersNotHitting100sOr50sButHavingGreatAvg() { 
		List<BattingData> batsmen=iplAnalyser.sortingBatsmenNotHitting100sAnd50s(BattingSortBy.BEST_AVG);
		assertEquals("13",batsmen.get(batsmen.size()-1).getPosition());
	}

}
