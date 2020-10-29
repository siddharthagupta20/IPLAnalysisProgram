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
		
		return batsmenList.stream().sorted(BattingSortBy.COMPARATOR_BEST_AVG).collect(Collectors.toList());

	}

	public List<BattingData> sortingStrinkingRateWise() {
		
		return batsmenList.stream().sorted(BattingSortBy.COMPARATOR_STRIKE_RATE).collect(Collectors.toList());

	}

	public List<BattingData> sortingMax4sAnd6sWise() {
		return batsmenList.stream().sorted(BattingSortBy.COMPARATOR_4S_AND_6S).collect(Collectors.toList());
	}
}
