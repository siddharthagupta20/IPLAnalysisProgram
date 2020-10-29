package com.cg.ipla;

import org.junit.Before;
import org.junit.Test;

import com.cg.ipla.IPLAnalyserService.BowlingOrBatting;
import com.cg.ipla.dto.BowlingData;


import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class IPLBowlingAnalyserTest {

	public static final String BOWLING_DATA = "src/main/resources/WP DP Data_02 IPL2019FactsheetMostWkts.csv";

	IPLAnalyserService iplAnalyser=null;
	ArrayList<BowlingData> bowlersList=null;
	
	@Before
	public void setUp() {
		iplAnalyser = new IPLAnalyserService(BOWLING_DATA,BowlingOrBatting.BOWLING_DATA);
		bowlersList=iplAnalyser.getBowlingDataFile(BOWLING_DATA);
	}
	@Test
	public void givenBowlingData_ShouldReturnLastEntry() {
		System.out.println("BOWLERS LIST:");
		iplAnalyser.printData(bowlersList);
		System.out.println("-------------------------------------------");
		assertEquals(100, bowlersList.get(bowlersList.size() - 1).getPosition());

	}
	@Test
	public void givenBowlingData_ShouldReturnBowlerWithBestAverage() {
		List<BowlingData> bowlers=iplAnalyser.sortingBowlers(BowlingSortBy.BEST_AVG);
		assertEquals(75, bowlers.get(98).getPosition());
	}
	@Test
	public void givenBowlingData_ShouldReturnBowlerWithBestStrikeRate() {
		List<BowlingData> bowlers=iplAnalyser.sortingBowlers(BowlingSortBy.BEST_STRIKE_RATE);
		assertEquals(75, bowlers.get(98).getPosition());
	}
	@Test
	public void givenBowlingData_ShouldReturnBowlerWithBestEconomy() {
		List<BowlingData> bowlers=iplAnalyser.sortingBowlers(BowlingSortBy.BEST_ECONOMY);
		assertEquals(87, bowlers.get(98).getPosition());
	}
	@Test 
	public void givenBowlingData_ShouldReturnBowlersWithBestAvgsAnd4wsAnd5ws() {
		List<BowlingData> bowlers=iplAnalyser.sortingBowlersHaving4wsAnd5ws(BowlingSortBy.BEST_AVG);
		assertEquals(29, bowlers.get(bowlers.size()-1).getPosition());
	}
	@Test
	public void givenBowlingData_ShouldReturnBowlersWithBestStrikeRateAndGreatAverages() {
		List<BowlingData> bowlers=iplAnalyser.sortingBowlers(BowlingSortBy.BEST_STRIKE_RATE,BowlingSortBy.BEST_AVG);
		assertEquals(75, bowlers.get(98).getPosition());
	}
	@Test
	public void givenBowlingData_ShouldReturnBowlersWithMaxWicketsAndGreatAverages() {
		List<BowlingData> bowlers=iplAnalyser.sortingBowlers(BowlingSortBy.MAX_WKTS,BowlingSortBy.BEST_AVG);
		assertEquals(1, bowlers.get(98).getPosition());
	}

}
