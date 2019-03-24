package com.example.unit4postmortem.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class EchinodermList {
    @SerializedName("message")
    private List<Echinoderm> echinodermList;

    public EchinodermList(List<Echinoderm> echinodermList) {
        this.echinodermList = echinodermList;
    }

    public List<Echinoderm> getEchinodermList() {
        return echinodermList;
    }
}
