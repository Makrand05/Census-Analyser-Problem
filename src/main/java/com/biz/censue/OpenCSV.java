package com.biz.censue;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.Reader;
import java.util.Iterator;

public class OpenCSV {

    static <E> Iterator getCSVIterator(Reader reader, Class csvClass) {
        CsvToBeanBuilder<E> csvToBeanBuilder = new CsvToBeanBuilder(reader);
        csvToBeanBuilder.withType(csvClass);
        csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
        CsvToBean<E> csvToBean = csvToBeanBuilder.build();

            return csvToBean.iterator();

    }
}
