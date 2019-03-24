package com.example.unit4postmortem.network;

import com.example.unit4postmortem.model.EchinodermList;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface EchinodermsService {
    @GET("JDVila/storybook/master/echinoderms.json")
    Observable<EchinodermList> getEchinodermList();
}
