package com.cg.ipla;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.cg.ipla.dto.BattingData;

public class IPLBattingAnalyser {

	public ArrayList<BattingData> batsmenList;

	public IPLBattingAnalyser() {
		batsmenList = new ArrayList<BattingData>();
	}

	public IPLBattingAnalyser(List<BattingData> batsmenList) {
		this.batsmenList = (ArrayList<BattingData>) batsmenList;
	}

	public IPLBattingAnalyser(String battingDataPath) {
		batsmenList = (ArrayList<BattingData>) gettingBattingList(battingDataPath);
	}

	public List<BattingData> gettingBattingList(String battingDataPath) {
		try {
			batsmenList = (ArrayList<BattingData>) (new CSVFileLoader()).loadCsvFile(battingDataPath,
					BattingData.class);
			return batsmenList;
		} catch (IPLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public List<BattingData> sortingAverageWise() {
		Comparator<BattingData> comparatorBestAvg = Comparator.comparing(BattingData::getAverage);
		List<BattingData> batsmenList = this.batsmenList;
		return batsmenList.stream().sorted(comparatorBestAvg).collect(Collectors.toList());

	}

	public List<BattingData> sortingStrinkingRateWise() {
		Comparator<BattingData> comparatorMostStrikeRate = Comparator.comparing(BattingData::getStrikeRate);
		List<BattingData> batsmenList = this.batsmenList;
		return batsmenList.stream().sorted(comparatorMostStrikeRate).collect(Collectors.toList());

	}
}
