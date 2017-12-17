package com.example.frankson.prova2_frankson_619540.network.api;

import com.example.frankson.prova2_frankson_619540.entity.AcoesListEntity;
import com.example.frankson.prova2_frankson_619540.network.service.Desafio2Service;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by frankson on 16/12/17.
 */

public class Desafio2Api {

    private static Desafio2Api instance;
    private Desafio2Service desafio2Service;

    public static Desafio2Api getInstance() {
        if (instance == null) {
            instance = new Desafio2Api();
        }
        return instance;
    }

    private Desafio2Api() {
        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl("https://dl.dropboxusercontent.com/")
                .addConverterFactory(defaultConvertFactory())
                .build();

        this.desafio2Service = retrofit.create(Desafio2Service.class);
    }

    private Converter.Factory defaultConvertFactory() {
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();
        return GsonConverterFactory.create(gson);
    }

    public Call<AcoesListEntity> getAcoes()
    {
        return desafio2Service.getAcoes();
    }

}
