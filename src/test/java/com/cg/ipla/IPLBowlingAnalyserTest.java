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

}
