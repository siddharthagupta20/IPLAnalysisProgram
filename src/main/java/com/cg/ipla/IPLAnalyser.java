package com.cg.ipla;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.cg.ipla.dto.BattingData;
import com.cg.ipla.dto.BowlingData;

public class IPLAnalyser {

	public ArrayList<BowlingData> bowlersList = null;
	public ArrayList<BattingData> batsmenList = null;

	public List<BowlingData> getBowlingDataFile(String bowlingDataPath) {
		try {
			bowlersList = (ArrayList<BowlingData>) new CSVFileLoader().loadCsvFile(bowlingDataPath, BowlingData.class);
			bowlersList.remove(bowlersList.size() - 1);
			bowlersList.remove(bowlersList.size() - 1);
			return bowlersList;
		} catch (IPLException e) {
			System.out.println(e.getMessage());
		}
		return null;

	}

	public List<BattingData> getBattingDataFile(String battingDataPath) {
		try {
			batsmenList = (ArrayList<BattingData>) (new CSVFileLoader()).loadCsvFile(battingDataPath, BattingData.class);
			return batsmenList;
		} catch (IPLException e) {
			System.out.println(e.getMessage());
		}
		return null;

	}

	public List<BattingData> sortingBatsmanWithBestAverage() {
		Comparator<BattingData> comparatorBestAvg=Comparator.comparing(BattingData::getAverage);
		return batsmenList.stream().sorted(comparatorBestAvg).collect(Collectors.toList());
	}

	public <E> void printData(List<E> listToPrint) {
		listToPrint.stream().forEach(System.out::println);
	}

}
