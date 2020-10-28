package com.cg.ipla;

import java.util.List;

import com.cg.ipla.dto.BattingData;
import com.cg.ipla.dto.BowlingData;

public class IPLAnalyser {

	public List<BowlingData> getBowlingDataFile(String bowlingDataPath) {
		try {
			List<BowlingData> bowlersList=new CSVFileLoader().loadCsvFile(bowlingDataPath, BowlingData.class);
			bowlersList.remove(bowlersList.size()-1);
			bowlersList.remove(bowlersList.size()-1);
			return bowlersList;
		} catch (IPLException e) {
			System.out.println(e.getMessage());
		}
		return null;

	}

	public List<BattingData> getBattingDataFile(String battingDataPath) {
		try {
			return (new CSVFileLoader()).loadCsvFile(battingDataPath, BattingData.class);
		} catch (IPLException e) {
			System.out.println(e.getMessage());
		}
		return null;

	}

	public <E> void printData(List<E> listToPrint) {
		listToPrint.stream().forEach(System.out::println);
	}

}
