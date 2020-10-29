package com.cg.ipla;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.cg.ipla.IPLAnalyserService.BowlingOrBatting;
import com.cg.ipla.dto.BattingData;


public class IPLBattingAnalyserTest {
	public static final String BATTING_DATA = "src/main/resources/WP DP Data_01 IPL2019FactsheetMostRuns.csv";
	IPLAnalyserService iplAnalyser=null;
	ArrayList<BattingData> batsmenList=null;
	
	@Before
	public void setUp() {
		iplAnalyser = new IPLAnalyserService(BATTING_DATA,BowlingOrBatting.BATTING_DATA);
		batsmenList=iplAnalyser.getBattingDataFile(BATTING_DATA);
	}

	@Test
	public void givenBattingData_ShouldReturnSize() {
		System.out.println("BATSMEN LIST:");
		iplAnalyser.printData(batsmenList);
		System.out.println("--------------------------------------------");
		assertEquals(101, batsmenList.size());

	}
	
	@Test
	public void givenBattingData_ShouldReturnBatsmenWithBestAverage() {
		
		List<BattingData> batsmen=iplAnalyser.sortingBatsmen(BattingSortBy.BEST_AVG);
		assertEquals("13",batsmen.get(100).getPosition());
		
	}
	@Test
	public void givenBattingData_ShouldReturnBatmenWithMostStrikingRates() {
		List<BattingData> batsmen=iplAnalyser.sortingBatsmen(BattingSortBy.BEST_STRIKE_RATE);
		assertEquals("97", batsmen.get(100).getPosition());
	}
	@Test
	public void givenBattingData_ShouldReturnBatsmenWithMax6sAnd4s() {
		List<BattingData> batsmen=iplAnalyser.sortingBatsmen(BattingSortBy.MAX_4S_AND_6S);
		assertEquals("5",batsmen.get(100).getPosition());
		
	}
	@Test
	public void givenBattingData_ShouldReturnBatsmenWithBestStrikingRateWith6sAnd4s() {
		List<BattingData> batsmen=iplAnalyser.sortingBatsmen(BattingSortBy.BEST_STRIKE_RATE,BattingSortBy.MAX_4S_AND_6S);
		assertEquals("97",batsmen.get(100).getPosition());
	}
	@Test
	public void givenBattingData_ShouldReturnBatsmenWithBestStrikingRateWithGreatAverages() {
		List<BattingData> batsmen=iplAnalyser.sortingBatsmen(BattingSortBy.BEST_STRIKE_RATE,BattingSortBy.BEST_AVG);
		assertEquals("97",batsmen.get(100).getPosition());
	}
}
