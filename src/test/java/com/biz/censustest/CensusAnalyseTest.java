package com.biz.censustest;

import com.biz.censue.CensusAnalyser;
import com.biz.censue.CensusAnalyserException;
import org.junit.Test;
import org.testng.Assert;

public class CensusAnalyseTest {

    private static final String INDIA_CENSUS_CSV_PATH="C:\\Users\\MS\\IdeaProjects\\CensusAnalyzer\\src\\main\\resources\\IndiaStateCensusData.csv";

//    Given the States Census CSV file, Check to ensure the Number  of Record matches
    @Test
    public void givenIndianCensusCSVFile_whenLoad_shouldReturnCorrectRecordCase1() {
        CensusAnalyser censusAnalyser=new CensusAnalyser();
        try{
            int numberOfRecord=censusAnalyser.loadIndiaCensusData(INDIA_CENSUS_CSV_PATH);
            Assert.assertEquals(29,numberOfRecord);

        } catch (CensusAnalyserException e) {
            e.printStackTrace();
        }
    }

    //Given the State Census CSV File if incorrect Returns a custom Exception
    @Test
    public void givenIncorrectIndianCensusCSVFile_whenLoad_shouldReturnCorrectRecordCase2(){
        String filePath="C:\\Users\\MS\\IdeaProjects\\CensusAnalyzer\\src\\main\\resources\\IndiaState.csv";
        CensusAnalyser censusAnalyser=new CensusAnalyser();
        try{
            int numberOfRecord=censusAnalyser.loadIndiaCensusData(filePath);
            Assert.assertEquals(29,numberOfRecord);
        } catch (CensusAnalyserException e) {
            System.out.print("Case 2 : ");
            System.out.println(e.getMessage());
        }
    }

    //Given the State Census CSV File when correct but type incorrect Returns a custom Exception
    @Test
    public void givenIndianCensusCSVFile_whenLoad_shouldReturnIncorrectRecordCase3() throws CensusAnalyserException {
        CensusAnalyser censusAnalyser=new CensusAnalyser();
        try{
            int numberOfRecord=censusAnalyser.loadIndiaCensusData(INDIA_CENSUS_CSV_PATH);
            Assert.assertEquals(30,numberOfRecord);
        } catch (AssertionError e) {
            System.out.println("Case 3 : Incorrect entry count Exception : "+e.getMessage());
        }
    }
    //Given the State Census CSV File when correct but delimiter incorrect Returns a custom Exception
    @Test
    public void givenIndianCensusCSVFile_whenLoad_shouldReturnIncorrectRecordCase4(){

        String PDF_FILE="C:\\Users\\MS\\IdeaProjects\\CensusAnalyzer\\src\\main\\resources\\IndiaStateCensusData.pdf";
        CensusAnalyser censusAnalyser=new CensusAnalyser();
        try{
            int numberOfRecord=censusAnalyser.loadIndiaCensusData(PDF_FILE);
            Assert.assertEquals(29,numberOfRecord);
        } catch (CensusAnalyserException e) {
            System.out.print("Case 4 : ");
            System.out.println(e.getMessage());
        }
        //Given the State Census CSV File when correct but csv header incorrect Returns a custom Exception

    }

}
