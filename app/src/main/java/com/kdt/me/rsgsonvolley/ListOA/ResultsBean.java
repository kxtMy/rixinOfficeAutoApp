package com.kdt.me.rsgsonvolley.ListOA;

import java.util.List;

/**
 * Created by ME on 2016/8/8.
 */
public class ResultsBean {
    String error;
    List<Results> results;

    public List<Results> getResultsList() {
        return results;
    }

    public void setResultsList(List<Results> resultsList) {
        this.results = resultsList;
    }

    public String getERROR() {
        return error;
    }

    public void setERROR(String ERROR) {
        this.error = ERROR;
    }

}
