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

	public List<BattingData> sortingBatsmenOrder(Comparator<BattingData> comparator) {
		return batsmenList.stream()
							.sorted(comparator)
							.collect(Collectors.toList());

	}
}
