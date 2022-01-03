package com.biz.censustest;

import com.biz.censue.CensusAnalyser;
import com.biz.censue.CensusAnalyserException;
import org.junit.Test;
import org.testng.Assert;

public class CensusAnalyseTest {

    private static final String INDIA_CENSUS_CSV_PATH="C:\\Users\\MS\\IdeaProjects\\CensusAnalyzer\\src\\main\\resources\\IndiaStateCensusData.csv";

    @Test
    public void givenIndianCensusCSVFile_whenLoad_shouldReturnCorrectRecord() {
        CensusAnalyser censusAnalyser=new CensusAnalyser();
        try{
            int numberOfRecord=censusAnalyser.loadIndiaCensusData(INDIA_CENSUS_CSV_PATH);
            Assert.assertEquals(29,numberOfRecord);
            
        } catch (CensusAnalyserException e) {
            e.printStackTrace();
        }
    }
}
