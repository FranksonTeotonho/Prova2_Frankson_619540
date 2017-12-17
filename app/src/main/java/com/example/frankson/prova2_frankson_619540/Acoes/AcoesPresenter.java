package com.example.frankson.prova2_frankson_619540.Acoes;

import com.example.frankson.prova2_frankson_619540.entity.AcaoEntity;
import com.example.frankson.prova2_frankson_619540.entity.AcoesListEntity;
import com.example.frankson.prova2_frankson_619540.network.api.Desafio2Api;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by frankson on 16/12/17.
 */

public class AcoesPresenter {
    private AcoesView acoesView;
    private List<AcaoEntity> acoesList = new ArrayList<>();

    AcoesPresenter(AcoesView acoesView){
        this.acoesView = acoesView;
    }

    public void setAdapterList(){
        final Desafio2Api desafio2Api = Desafio2Api.getInstance();
        acoesView.showLoading();
        desafio2Api.getAcoes().enqueue(new Callback<AcoesListEntity>() {
            @Override
            public void onResponse(Call<AcoesListEntity> call, Response<AcoesListEntity> response) {

                AcoesListEntity acoesListEntity = response.body();
                if(acoesListEntity != null){
                    acoesView.setList(acoesListEntity.getAcoes());

                } else{
                    acoesView.showMessage("Falha no login");
                }
                acoesView.hideLoading();
            }

            @Override
            public void onFailure(Call<AcoesListEntity> call, Throwable t) {
                acoesView.showMessage("Falha no acesso ao servidor");
            }
        });
    }
}
