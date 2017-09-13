package br.edu.ifma.crea_ma;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class ListaInfracoesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_infracoes);

        String [] infracoes = {"1 - Obra sem licenciamento", "2 - Obra em desacordo com os projetos aprovados ou visados"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, infracoes);

        ListView listaInfracoes = (ListView) findViewById(R.id.lista_infracoes);
        listaInfracoes.setAdapter(adapter);

        Button novaInfracao = (Button) findViewById(R.id.btnIncluirInfracao);

        novaInfracao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentVaiProFormulario = new Intent(ListaInfracoesActivity.this, FormularioInfracoesActivity.class);
                startActivity(intentVaiProFormulario);

            }
        });
     }
}
