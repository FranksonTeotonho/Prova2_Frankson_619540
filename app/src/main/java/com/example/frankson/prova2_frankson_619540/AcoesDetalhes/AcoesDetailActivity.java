package com.example.frankson.prova2_frankson_619540.AcoesDetalhes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.frankson.prova2_frankson_619540.R;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AcoesDetailActivity extends AppCompatActivity {
    @BindView(R.id.text_view_description)
    TextView txDescricao;

    @BindView(R.id.text_view_site)
    TextView txSite;

    @BindView(R.id.image_view_header)
    ImageView imgHead;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acoes_detail);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String name = intent.getStringExtra("Name");
        String image = intent.getStringExtra("Image");
        String descricao = intent.getStringExtra("Description");
        String site = intent.getStringExtra("Site");



        //Altera o titulo da action bar ActionBar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(name);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        txDescricao.setText(descricao);
        txSite.setText(site);
        Picasso.with(getBaseContext())
                .load(image)
                .centerCrop()
                .fit()
                .into(imgHead);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            this.finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
