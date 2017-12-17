package com.example.frankson.prova2_frankson_619540.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by frankson on 16/12/17.
 */

public class AcoesListEntity {
    @SerializedName("acoes_sociais")
    @Expose
    private List<AcaoEntity> acoes = null;

    public List<AcaoEntity> getAcoes() { return acoes; }
}
