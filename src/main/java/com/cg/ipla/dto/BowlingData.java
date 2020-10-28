package com.cg.ipla.dto;

import com.opencsv.bean.CsvBindByName;

public class BowlingData {
	@CsvBindByName(column = "POS")
	private int position;

	@CsvBindByName(column = "PLAYER")
	private String player;

	@CsvBindByName(column = "MAT")
	private int noOfMatches;

	@CsvBindByName(column = "Inns")
	private int innings;

	@CsvBindByName(column = "Ov")
	private double overs;

	@CsvBindByName(column = "Runs")
	private int runs;

	@CsvBindByName(column = "Wkts")
	private int noOfWickets;

	@CsvBindByName(column = "BBI")
	private int bbi;

	@CsvBindByName(column = "Avg")
	private String average;

	@CsvBindByName(column = "Econ")
	private double economy;

	@CsvBindByName(column = "SR")
	private String strikeRate;

	@CsvBindByName(column = "4w")
	private int fourWickets;
	
	@CsvBindByName(column = "5w")
	private int fiveWickets;

	public int getPosition() {
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

	public double getOvers() {
		return overs;
	}

	public int getRuns() {
		return runs;
	}

	public int getNoOfWickets() {
		return noOfWickets;
	}

	public int getBbi() {
		return bbi;
	}

	public double getAverage() {
		if (average.equals("-"))
			return 0.0;
		return Double.parseDouble(average);
	}

	public double getEconomy() {
		return economy;
	}

	public double getStrikeRate() {
		if (strikeRate.equals("-"))
			return 0.0;
		return Double.parseDouble(strikeRate);
	}

	public int getFourWickets() {
		return fourWickets;
	}

	public int getFiveWickets() {
		return fiveWickets;
	}
	
	public String toString() {
		return this.player;
	}

}