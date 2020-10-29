package com.cg.ipla;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.cg.ipla.dto.AllRounder;
import com.cg.ipla.dto.BattingData;
import com.cg.ipla.dto.BowlingData;

public class IPLAllRounderAnalyser {

	private ArrayList<AllRounder> allRounderList;

	public IPLAllRounderAnalyser() {
		allRounderList = new ArrayList<>();
	}

	public IPLAllRounderAnalyser(ArrayList<AllRounder> allRounderList) {
		this.allRounderList = allRounderList;
	}

	public List<AllRounder> buildAllRounderList(List<BowlingData> bowlersList, List<BattingData> batsmenList) {
		batsmenList.stream().forEach(batsman -> {
			BowlingData bowlers = bowlersList.stream()
					.filter(bowler -> bowler.getPlayer().equalsIgnoreCase(batsman.getPlayer())).findFirst()
					.orElse(null);
			if (bowlers != null) {
				allRounderList.add(new AllRounder(batsman.getPlayer(), batsman.getRuns(), bowlers.getNoOfWickets(),
						batsman.getAverage(), bowlers.getAverage()));
			}
		});

		return allRounderList;
	}
	public List<AllRounder> sortingAllRoundersOrder(Comparator<AllRounder> comparator){
		return allRounderList.stream().sorted(comparator).collect(Collectors.toList());
	}

}
