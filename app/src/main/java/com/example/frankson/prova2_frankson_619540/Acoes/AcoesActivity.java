package com.example.frankson.prova2_frankson_619540.Acoes;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.frankson.prova2_frankson_619540.AcoesDetalhes.AcoesDetailActivity;
import com.example.frankson.prova2_frankson_619540.R;
import com.example.frankson.prova2_frankson_619540.entity.AcaoEntity;
import com.example.frankson.prova2_frankson_619540.entity.AcoesListEntity;
import com.google.gson.Gson;

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

        acoesPresenter = new AcoesPresenter(this);
        acoesPresenter.setAdapterList();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_download, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_download:
                acoesPresenter.saveAcoes();

            default:
                return super.onOptionsItemSelected(item);
        }

    }

    @Override
    public void setList(final List<AcaoEntity> acoesList) {

        AcoesAdapter acoesAdapter = new AcoesAdapter(acoesList ,this);

        acoesAdapter.setOnRecyclerViewSelected(new OnRecyclerViewSelected() {
            @Override
            public void onClick(View view, int position) {
                Intent intent = new Intent
                        (AcoesActivity.this,
                                AcoesDetailActivity.class);

                intent.putExtra("Name", acoesList.get(position).getName());
                intent.putExtra("Image", acoesList.get(position).getImage());
                intent.putExtra("Description", acoesList.get(position).getDescription());
                intent.putExtra("Site", acoesList.get(position).getSite());
                startActivity(intent);
                //Toast.makeText(AcoesActivity.this, "Clique rápido", Toast.LENGTH_SHORT).show();
            }

        });

        rvAcoes.setAdapter(acoesAdapter);

        // criação do gerenciador de layouts
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        DividerItemDecoration dividerItemDecoration =
                new DividerItemDecoration(this, layoutManager.getOrientation());
        rvAcoes.setLayoutManager(layoutManager);
        rvAcoes.addItemDecoration(dividerItemDecoration);
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



    @Override
    public void saveInSharedPreferences(String jsonAcoes) {
        //salva json das para trabalhar ofline
        SharedPreferences.Editor editor = getSharedPreferences("acoes_json",MODE_PRIVATE).edit();
        editor.putString("acoes_entity_json", jsonAcoes);
        editor.apply();
        showMessage("Informações salvas com sucesso");
    }

    @Override
    public void workOffline() {
        SharedPreferences preferences = getSharedPreferences("acoes_json", MODE_PRIVATE);
        String jsonAcoes = preferences.getString("acoes_entity_json", null);

        //Caso não tenha nenhum dado salvo
        if(jsonAcoes != null){
            showMessage("Dados salvos anteriormente");
            AcoesListEntity acoesListEntity = new Gson().fromJson(jsonAcoes, AcoesListEntity.class);
            List<AcaoEntity> acoesList = acoesListEntity.getAcoes();
            setList(acoesList);
        }


    }

}
