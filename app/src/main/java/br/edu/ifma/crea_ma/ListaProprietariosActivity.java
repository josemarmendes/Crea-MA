package br.edu.ifma.crea_ma;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
import br.edu.ifma.crea_ma.dao.ProprietarioDAO;
import br.edu.ifma.crea_ma.modelo.Infracao;
import br.edu.ifma.crea_ma.modelo.Proprietario;

public class ListaProprietariosActivity extends AppCompatActivity {

    private ListView listaProprietarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_proprietarios);

        listaProprietarios = (ListView) findViewById(R.id.lista_proprietarios);

        listaProprietarios.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> lista, View item, int posicao, long id) {
                Proprietario proprietario = (Proprietario) listaProprietarios.getItemAtPosition(posicao);
                Intent intentVaiProFormulario = new Intent(ListaProprietariosActivity.this, FormularioProprietariosActivity.class);
                intentVaiProFormulario.putExtra("proprietario", proprietario);
                startActivity(intentVaiProFormulario);
            }
        });

        Button novaInfracao = (Button) findViewById(R.id.btnIncluirProprietario);
        novaInfracao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentVaiProFormulario = new Intent(ListaProprietariosActivity.this, FormularioProprietariosActivity.class);
                startActivity(intentVaiProFormulario);

            }
        });

        listaProprietarios.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> lista, View item, int posicao, long id) {
                Toast.makeText(ListaProprietariosActivity.this, " Clique longo!", Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        registerForContextMenu(listaProprietarios);
     }

    private void carregaListaProprietario() {
        ProprietarioDAO dao = new ProprietarioDAO(this);
        List<Proprietario> listaDeProprietarios = dao.buscaProprietarios();
        dao.close();


        ArrayAdapter<Proprietario> adapter = new ArrayAdapter<Proprietario>(this, android.R.layout.simple_expandable_list_item_1, listaDeProprietarios);
        listaProprietarios.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        carregaListaProprietario();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, final ContextMenu.ContextMenuInfo menuInfo) {
       MenuItem deletar = menu.add("Remover");
        deletar.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
                Proprietario proprietario = (Proprietario) listaProprietarios.getItemAtPosition(info.position);

                ProprietarioDAO dao = new ProprietarioDAO(ListaProprietariosActivity.this);
                dao.remove(proprietario);
                dao.close();

                carregaListaProprietario();
                return false;
            }
        });
    }


}
