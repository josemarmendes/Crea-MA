package br.edu.ifma.crea_ma;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

import br.edu.ifma.crea_ma.dao.InfracaoDAO;
import br.edu.ifma.crea_ma.modelo.Infracao;

public class ListaInfracoesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_infracoes);

        Button novaInfracao = (Button) findViewById(R.id.btnIncluirInfracao);

        novaInfracao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentVaiProFormulario = new Intent(ListaInfracoesActivity.this, FormularioInfracoesActivity.class);
                startActivity(intentVaiProFormulario);

            }
        });
     }

    private void carregaListaInfracao() {
        InfracaoDAO dao = new InfracaoDAO(this);
        List<Infracao> listaDeInfracoes = dao.buscaInfracoes();
        dao.close();

        ListView listaInfracoes = (ListView) findViewById(R.id.lista_infracoes);
        ArrayAdapter<Infracao> adapter = new ArrayAdapter<Infracao>(this, android.R.layout.simple_expandable_list_item_1, listaDeInfracoes);
        listaInfracoes.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        carregaListaInfracao();
    }
}
