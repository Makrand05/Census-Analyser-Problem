package com.biz.censue;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.StreamSupport;

public class CensusAnalyser {

    public int loadIndiaCensusData(String csvPath) throws CensusAnalyserException {

        try (Reader reader = Files.newBufferedReader(Paths.get(csvPath))) {
            Iterator<IndiaCensusCSV> censusCSVIterator = OpenCSV.getCSVIterator(reader, IndiaCensusCSV.class);
        return    getCount(censusCSVIterator);
        } catch (IOException e) {
            throw new CensusAnalyserException("File not found exception", CensusAnalyserException.ExceptionType.FILE_NOT_FOUNT);
        }
    }

    private <E> int getCount(Iterator<E> censusCSVIterator) {
        Iterable<E> csvIterable = () -> censusCSVIterator;
        int numberOfEntries = (int) StreamSupport.stream(csvIterable.spliterator(), true).count();
        return numberOfEntries;
    }

    private <E>  Iterator getCSVIterator(Reader reader, Class csvClass) {
        CsvToBeanBuilder<E> csvToBeanBuilder = new CsvToBeanBuilder(reader);
        csvToBeanBuilder.withType(csvClass);
        csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
        CsvToBean<E> csvToBean = csvToBeanBuilder.build();
        return csvToBean.iterator();

    }

    public int loadIndiaStateCode(String csvPath) throws CensusAnalyserException {

        try (Reader reader = Files.newBufferedReader(Paths.get(csvPath))) {
            Iterator<IndiaStateCode> censusCSVIterator = getCSVIterator(reader, IndiaCensusCSV.class);
            return    getCount(censusCSVIterator);
        } catch (IOException e) {
            throw new CensusAnalyserException("File not found exception", CensusAnalyserException.ExceptionType.FILE_NOT_FOUNT);
        }

    }
}
