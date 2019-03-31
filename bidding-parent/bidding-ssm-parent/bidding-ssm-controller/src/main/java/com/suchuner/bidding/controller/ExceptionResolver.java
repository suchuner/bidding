package com.suchuner.bidding.controller;

import com.suchuner.bidding.common.exception.BiddingException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author suchuner
 */
public class ExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        BiddingException exception =null;
        if(e instanceof BiddingException){
            exception = (BiddingException) e;
        }else{
            exception = new BiddingException("未知错误!");
        }
        String errMess = exception.getMessage();
        return new ModelAndView("exception/exception","errMess",errMess);
    }
}
