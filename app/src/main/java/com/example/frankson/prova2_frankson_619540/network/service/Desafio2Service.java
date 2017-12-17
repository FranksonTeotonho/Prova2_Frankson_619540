package com.example.frankson.prova2_frankson_619540.network.service;

import com.example.frankson.prova2_frankson_619540.entity.AcoesListEntity;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by frankson on 16/12/17.
 */

public interface Desafio2Service {

    @GET("sociais.json")
    Call<AcoesListEntity> getAcoes();
}
