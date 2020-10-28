package com.cg.ipla;

import org.junit.Test;

import com.cg.ipla.dto.BowlingData;

import static org.junit.Assert.*;

import java.util.ArrayList;

public class IPLBowlingAnalyserTest {

	public static final String BOWLING_DATA = "src/main/resources/WP DP Data_02 IPL2019FactsheetMostWkts.csv";

	@Test
	public void givenBowlingData_ShouldReturnLastEntry() {
		IPLAnalyser iplAnalyser = new IPLAnalyser();
		ArrayList<BowlingData> bowlersList = (ArrayList<BowlingData>) iplAnalyser.getBowlingDataFile(BOWLING_DATA);
		System.out.println("BOWLERS LIST:");
		iplAnalyser.printData(bowlersList);
		System.out.println("-------------------------------------------");
		assertEquals(100, bowlersList.get(bowlersList.size() - 1).getPosition());

	}

}
