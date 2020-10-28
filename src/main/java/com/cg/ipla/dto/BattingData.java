package com.cg.ipla.dto;

import com.opencsv.bean.CsvBindByName;

public class BattingData {
	@CsvBindByName(column = "POS", required = true)
	private String position;
	
	@CsvBindByName(column = "PLAYER", required = true)
	private String player;
	
	@CsvBindByName(column = "MAT")
	private int noOfMatches;
	
	@CsvBindByName(column = "Inns")
	private int innings;
	
	@CsvBindByName(column = "NO")
	private int notOut;
	
	@CsvBindByName(column = "Runs")
	private int runs;
	
	@CsvBindByName(column = "HS")
	private String highestScore;
	
	@CsvBindByName(column = "Avg")
	private String average;
	
	@CsvBindByName(column = "BF")
	private int ballFaced;
	
	@CsvBindByName(column = "SR")
	private double strikeRate;
	
	@CsvBindByName(column = "100")
	private int century;
	
	@CsvBindByName(column = "50")
	private int halfCentury;
	
	@CsvBindByName(column = "4s")
	private int noOfFours;
	
	@CsvBindByName(column = "6s")
	private int noOfSixes;

	public String getPosition() {
		return position;
	}

	public String getPlayer() {
		return player;
	}

	public int getNoOfMatches() {
		return noOfMatches;
	}

	public int getInnings() {
		return innings;
	}

	public int getNotOut() {
		return notOut;
	}

	public int getRuns() {
		return runs;
	}

	public String getHighestScore() {
		return highestScore;
	}

	public double getAverage() {
		if(average.equals("-")) return 0.0;
		return Double.parseDouble(average);
	}

	public int getBallFaced() {
		return ballFaced;
	}

	public double getStrikeRate() {
		return strikeRate;
	}

	public int getCentury() {
		return century;
	}

	public int getHalfCentury() {
		return halfCentury;
	}

	public int getNoOfFours() {
		return noOfFours;
	}

	public int getNoOfSixes() {
		return noOfSixes;
	}
	
}
