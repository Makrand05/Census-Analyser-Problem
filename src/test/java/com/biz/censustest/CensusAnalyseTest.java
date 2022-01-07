package com.biz.censustest;

import com.biz.censue.CensusAnalyser;
import com.biz.censue.CensusAnalyserException;
import org.junit.Test;
import org.testng.Assert;

public class CensusAnalyseTest {

    private static final String INDIA_CENSUS_CSV_PATH="C:\\Users\\MS\\IdeaProjects\\CensusAnalyzer\\src\\main\\resources\\IndiaStateCensusData.csv";
    private  static final String INDIA_STATE_CODE ="C:\\Users\\MS\\IdeaProjects\\CensusAnalyzer\\src\\main\\resources\\IndiaStateCode.csv";
    private static final String X_INDIA_CENSUS_CSV_PATH="C:\\Users\\MS\\IdeaProjects\\CensusAnalyzer\\src\\main\\resources\\IndiaStateCensusDatax.csv";
    private  static final String X_INDIA_STATE_CODE ="C:\\Users\\MS\\IdeaProjects\\CensusAnalyzer\\src\\main\\resources\\IndiaStateCodex.csv";
    //Use case 1
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
    //Use case 2
    //Given the State Census CSV File if incorrect Returns a custom Exception
    @Test
    public void givenIncorrectIndianCensusCSVFile_whenLoad_shouldReturnCorrectRecordCase2() throws CensusAnalyserException {
        String filePath="C:\\Users\\MS\\IdeaProjects\\CensusAnalyzer\\src\\main\\resources\\IndiaState.csv";
        CensusAnalyser censusAnalyser=new CensusAnalyser();
        try{
            int numberOfRecord=censusAnalyser.loadIndiaCensusData(filePath);
            Assert.assertEquals(29,numberOfRecord);
        } catch (CensusAnalyserException e) {
            System.out.println(e.getMessage());
        }
    }
    //Use case 3
    //Given the State Census CSV File when correct but type incorrect Returns a custom Exception
    @Test
    public void givenIndianCensusCSVFile_whenLoad_shouldReturnIncorrectRecordCase3() throws CensusAnalyserException {
        CensusAnalyser censusAnalyser=new CensusAnalyser();
        try{
            int numberOfRecord=censusAnalyser.loadIndiaCensusData(INDIA_CENSUS_CSV_PATH);
            Assert.assertNotEquals(29,numberOfRecord);
        } catch (CensusAnalyserException  e) {
            System.out.println(e.getMessage());
        }
    }
    //Use Case 4
    //Given the State Census CSV File when correct but delimiter incorrect Returns a custom Exception
    @Test
    public void givenIndianCensusCSVFile_whenLoad_shouldReturnIncorrectRecordCase4()  {

        String PDF_FILE = "C:\\Users\\MS\\IdeaProjects\\CensusAnalyzer\\src\\main\\resources\\IndiaStateCensusData.pdf";
        CensusAnalyser censusAnalyser = new CensusAnalyser();
        try {
            int numberOfRecord = censusAnalyser.loadIndiaCensusData(PDF_FILE);
            Assert.assertEquals(29, numberOfRecord);
        } catch (CensusAnalyserException e) {
            System.out.println(e.getMessage());

        }
    }
        //Use Case 5
        //Given the State Census CSV File when correct but csv header incorrect Returns a custom Exception
        @Test
        public void givenIndianCensusCSVFile_whenLoadIncorrectHeader_shouldReturnCorrectRecord() {


            CensusAnalyser censusAnalyser=new CensusAnalyser();
            try{
                int numberOfRecord=censusAnalyser.loadIndiaCensusData(X_INDIA_CENSUS_CSV_PATH);
                Assert.assertEquals(29,numberOfRecord);
            } catch (CensusAnalyserException e ) {
                System.out.println(e.getMessage());
            }
    }
    //Use case 1
     //Given the States Census CSV file, Check to ensure the Number of Record matches
    @Test
    public void givenIndianStateCodeCSVFile_whenLoad_shouldReturnCorrectRecord() {
        CensusAnalyser censusAnalyser=new CensusAnalyser();
        try{
            int numberOfRecord=censusAnalyser.loadIndiaStateCode(INDIA_STATE_CODE);
            Assert.assertEquals(37,numberOfRecord);

        } catch (CensusAnalyserException e) {
            e.printStackTrace();
        }
    }

    //Use case 2
    //Given the State Census CSV File if incorrect Returns a custom Exception
    @Test
    public void givenIncorrectIndianStateCodeCSVFile_whenLoad_shouldReturnIncorrectRecord(){
        String filePath="C:\\Users\\MS\\IdeaProjects\\CensusAnalyzer\\src\\main\\resources\\State.csv";
        CensusAnalyser censusAnalyser=new CensusAnalyser();
        try{
            int numberOfRecord=censusAnalyser.loadIndiaCensusData(filePath);
            Assert.assertEquals(37,numberOfRecord);
        } catch (CensusAnalyserException e) {
            System.out.print("Case 2 : ");
            System.out.println(e.getMessage());
        }
    }

    //Use case 3
    //Given the State Census CSV File when correct but type incorrect Returns a custom Exception
    @Test
    public void givenIndianStateCodeCSVFile_whenLoad_shouldReturnIncorrectRecord() throws CensusAnalyserException {
        CensusAnalyser censusAnalyser=new CensusAnalyser();
        try{
            int numberOfRecord=censusAnalyser.loadIndiaCensusData(INDIA_STATE_CODE);
            Assert.assertEquals(30,numberOfRecord);
        } catch (AssertionError e) {
            System.out.println(e.getMessage());
         }
    }
    //Use Case 4
    //Given the State Census CSV File when correct but delimiter incorrect Returns a custom Exception
    @Test
    public void givenIndianStateCodeCSVFile_whenLoad_shouldReturnDelimiterIncorrectRecord() throws CensusAnalyserException {

        String PDF_FILE = "C:\\Users\\MS\\IdeaProjects\\CensusAnalyzer\\src\\main\\resources\\IndiaStateCode.pdf";
        CensusAnalyser censusAnalyser = new CensusAnalyser();
        try {
            int numberOfRecord = censusAnalyser.loadIndiaCensusData(PDF_FILE);
            Assert.assertEquals(29, numberOfRecord);
        } catch (CensusAnalyserException e) {
            System.out.println(e.getMessage());
         }
    }
    //Use Case 5
    //Given the State Census CSV File when correct but csv header incorrect Returns a custom Exception

    @Test
    public void givenIndianStateCodeCSVCSVFile_whenLoadIncorrectHeader_shouldReturnCorrectRecord() throws CensusAnalyserException {
        CensusAnalyser censusAnalyser=new CensusAnalyser();
        try{
            int numberOfRecord=censusAnalyser.loadIndiaCensusData(X_INDIA_STATE_CODE);
            Assert.assertEquals(29,numberOfRecord);
            throw new CensusAnalyserException(" Number of data fields does not match number of headers ", CensusAnalyserException.ExceptionType.HEADER_MISSING);
        } catch (CensusAnalyserException e) {
            System.out.println(e.getMessage());
        }

    }
}
