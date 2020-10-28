package com.cg.ipla;

import java.util.List;

import com.cg.csvbuilder.CSVBeanBuilderException;
import com.cg.csvbuilder.CSVBuilderFactory;
import com.cg.csvbuilder.OpenCSVBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CSVFileLoader {

	public <E> List<E> loadCsvFile(String csvFilePath, Class<E> csvClass) throws IPLException {
		if (!csvFilePath.contains(".csv"))
			throw new IPLException("Not .csv file", IPLException.ExceptionType.WRONG_TYPE);
		try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))) {
			OpenCSVBuilder<E> csvBuilder = (OpenCSVBuilder<E>) CSVBuilderFactory.createCSVBuilder();
			List<E> iplDataList = csvBuilder.getCsvList(reader, csvClass);
			return iplDataList;
		} catch (IOException e) {
			throw new IPLException("File not found", IPLException.ExceptionType.WRONG_CSV);
		} catch (NullPointerException e) {
			throw new IPLException("File is empty", IPLException.ExceptionType.NO_DATA);
		} catch (RuntimeException e) {
			throw new IPLException("File internal data not proper", IPLException.ExceptionType.INTERNAL_ISSUE);
		} catch (CSVBeanBuilderException e) {
			throw new IPLException(e.getMessage(), IPLException.ExceptionType.UNABLE_TO_PARSE);
		}
	}

}
