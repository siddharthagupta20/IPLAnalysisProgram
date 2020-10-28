package com.cg.ipla;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.cg.ipla.dto.BattingData;


public class IPLBattingAnalyserTest {
	public static final String BATTING_DATA = "src/main/resources/WP DP Data_01 IPL2019FactsheetMostRuns.csv";
	IPLAnalyser iplAnalyser=null;
	
	@Before
	public void setUp() {
		iplAnalyser = new IPLAnalyser();
		iplAnalyser.getBattingDataFile(BATTING_DATA);
	}

	@Test
	public void givenBattingData_ShouldReturnSize() {
		System.out.println("BATTERS LIST:");
		iplAnalyser.printData(iplAnalyser.batsmenList);
		System.out.println("--------------------------------------------");
		assertEquals(101, iplAnalyser.batsmenList.size());

	}
	
	@Test
	public void givenBattingData_ShouldReturnBatsmenWithBestAverage() {
		List<BattingData> batsmen=iplAnalyser.sortingBatsmanWithBestAverage(); 
		assertEquals("13",batsmen.get(100).getPosition());
		
	}
}
