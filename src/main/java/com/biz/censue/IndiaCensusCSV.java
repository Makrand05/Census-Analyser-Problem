package com.biz.censue;

import com.opencsv.bean.CsvBindByName;

public class IndiaCensusCSV {
    //State,Population,AreaInSqKm,DensityPerSqKm

    @CsvBindByName(column = "State")
    private String state;
    @CsvBindByName(column = "Population")
    private int population;
    @CsvBindByName(column = "AreaInSqKm")
    private int areaInSqKm;
    @CsvBindByName(column = "DensityPerSqKm")
    private int densityPerSqKm;
}
