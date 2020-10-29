package com.cg.ipla;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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
	public List<BowlingData> sortingBowlersOrder(Comparator<BowlingData> comparator) {
		return bowlersList.stream().sorted(comparator).collect(Collectors.toList());
	}
	public <E> List<BowlingData> filteringBowlers(Predicate<BowlingData> p){
		return bowlersList.stream().filter(p).collect(Collectors.toList());
	}

}
