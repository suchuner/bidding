package com.suchuner.bidding.controller.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author suchuner
 */
public class BiddingDateConverter implements Converter<String,Date> {

    public Date convert(String source) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(source);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
