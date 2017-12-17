package com.example.frankson.prova2_frankson_619540.Acoes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.frankson.prova2_frankson_619540.R;
import com.example.frankson.prova2_frankson_619540.entity.AcaoEntity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AcoesActivity extends AppCompatActivity implements AcoesView{
    @BindView(R.id.rv_acoes)
    RecyclerView rvAcoes;

    @BindView(R.id.linear_layout_loading)
    LinearLayout loadingLayout;

    AcoesPresenter acoesPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acoes);

        //Altera o titulo da action bar ActionBar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Ações");
        }

        ButterKnife.bind(this);
        List<AcaoEntity> l = new ArrayList<>();
        AcaoEntity a = new AcaoEntity("PLP 2.0", "http://s2.glbimg.com/HuBW1kt_fTAKC0s4C0KxGeMBVXM=/0x0:1353x821/695x422/s.glbimg.com/po/tt2/f/original/2014/04/30/conservation_1.jpg");
        l.add(a);
        acoesPresenter = new AcoesPresenter(this);
        acoesPresenter.setAdapterList();

    }

    @Override
    public void setList(final List<AcaoEntity> acoesList) {

        AcoesAdapter acoesAdapter = new AcoesAdapter(acoesList ,this);

        acoesAdapter.setOnRecyclerViewSelected(new OnRecyclerViewSelected() {
            @Override
            public void onClick(View view, int position) {
                Toast.makeText(AcoesActivity.this, "Clique rápido", Toast.LENGTH_SHORT).show();
            }

        });
        rvAcoes.setAdapter(acoesAdapter);
    }

    @Override
    public void showMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoading() {
        loadingLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        loadingLayout.setVisibility(View.GONE);
    }
}
