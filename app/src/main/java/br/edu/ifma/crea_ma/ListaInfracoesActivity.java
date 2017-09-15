package br.edu.ifma.crea_ma;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import br.edu.ifma.crea_ma.dao.InfracaoDAO;
import br.edu.ifma.crea_ma.modelo.Infracao;

public class ListaInfracoesActivity extends AppCompatActivity {

    private ListView listaInfracoes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_infracoes);

        listaInfracoes = (ListView) findViewById(R.id.lista_infracoes);

        listaInfracoes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> lista, View item, int posicao, long id) {
                Infracao infracao = (Infracao) listaInfracoes.getItemAtPosition(posicao);
                Intent intentVaiProFormulario = new Intent(ListaInfracoesActivity.this, FormularioInfracoesActivity.class);
                intentVaiProFormulario.putExtra("infracao", infracao);
                startActivity(intentVaiProFormulario);
            }
        });

        Button novaInfracao = (Button) findViewById(R.id.btnIncluirInfracao);
        novaInfracao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentVaiProFormulario = new Intent(ListaInfracoesActivity.this, FormularioInfracoesActivity.class);
                startActivity(intentVaiProFormulario);

            }
        });

        listaInfracoes.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> lista, View item, int posicao, long id) {
                Toast.makeText(ListaInfracoesActivity.this, " Clique longo!", Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        registerForContextMenu(listaInfracoes);
     }

    private void carregaListaInfracao() {
        InfracaoDAO dao = new InfracaoDAO(this);
        List<Infracao> listaDeInfracoes = dao.buscaInfracoes();
        dao.close();


        ArrayAdapter<Infracao> adapter = new ArrayAdapter<Infracao>(this, android.R.layout.simple_expandable_list_item_1, listaDeInfracoes);
        listaInfracoes.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        carregaListaInfracao();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, final ContextMenu.ContextMenuInfo menuInfo) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        final Infracao infracao = (Infracao) listaInfracoes.getItemAtPosition(info.position);

        MenuItem itemSite = menu.add("Visitar site");
        Intent intentSite = new Intent(Intent.ACTION_VIEW);
        intentSite.setData(Uri.parse("http://www.creama.org.br/new/"));
        itemSite.setIntent(intentSite);

        MenuItem deletar = menu.add("Remover");
        deletar.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {


                InfracaoDAO dao = new InfracaoDAO(ListaInfracoesActivity.this);
                dao.remove(infracao);
                dao.close();

                carregaListaInfracao();
                return false;
            }
        });
    }


}
