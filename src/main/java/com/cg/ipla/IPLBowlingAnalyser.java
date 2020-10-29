package com.cg.ipla;

import java.util.ArrayList;
import java.util.List;

import com.cg.ipla.dto.BowlingData;

public class IPLBowlingAnalyser {
	
	public ArrayList<BowlingData> bowlersList = null;
	
	public IPLBowlingAnalyser() {
		bowlersList=new ArrayList<BowlingData>();
	}
	public IPLBowlingAnalyser(List<BowlingData> bowlersList) {
		this.bowlersList=(ArrayList<BowlingData>)bowlersList;
	}
	public IPLBowlingAnalyser(String battingDataPath) {
			bowlersList = (ArrayList<BowlingData>) gettingBowlingList(battingDataPath);
	}
	
	public List<BowlingData> gettingBowlingList(String bowlingDataPath){
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

}
