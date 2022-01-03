package com.biz.censue;

import com.opencsv.bean.CsvBindByName;

public class IndiaStateCode {
    //SrNo,State Name,TIN,StateCode

    @CsvBindByName(column = "SrNo")
    private int rrNo;

    @CsvBindByName(column = "State Name")
    private String stateName;

    @CsvBindByName(column = "TIN")
    private int tin;

    @CsvBindByName(column = "StateCode")
    private int stateCode;


}
