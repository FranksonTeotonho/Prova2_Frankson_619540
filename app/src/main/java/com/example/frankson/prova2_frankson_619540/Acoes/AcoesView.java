package com.example.frankson.prova2_frankson_619540.Acoes;

import com.example.frankson.prova2_frankson_619540.entity.AcaoEntity;

import java.util.List;

/**
 * Created by frankson on 16/12/17.
 */

interface AcoesView {
    void setList(List<AcaoEntity> acoesList);
    void showMessage(String msg);
    void showLoading();
    void hideLoading();

}
