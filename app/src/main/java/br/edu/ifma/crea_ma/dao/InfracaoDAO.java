package br.edu.ifma.crea_ma.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import br.edu.ifma.crea_ma.modelo.Infracao;

/**
 * Created by josemar on 13/09/17.
 */

public class InfracaoDAO extends SQLiteOpenHelper{

    public InfracaoDAO(Context context) {
        super(context, "Infracao", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE Infracoes (id INTEGER PRIMARY KEY, nome_notificado TEXT NOT NULL, dados_obra TEXT, etapas_concluidas TEXT, infracoes_cometidas TEXT, valor_multa REAL, nota_infracao REAL);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String sql = "DROP TABLE IF EXISTS Infracoes";
        db.execSQL(sql);
        onCreate(db);

    }

    public void insere(Infracao infracao) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues dados = new ContentValues();
        dados.put("nome_notificado", infracao.getNomeNotificado());
        dados.put("dados_obra", infracao.getDadosObra());
        dados.put("etapas_concluidas", infracao.getEtapasConcluidas());
        dados.put("infracoes_cometidas", infracao.getInfracoesCometidas());
        dados.put("valor_multa", infracao.getValorMulta());
        dados.put("nota_infracao", infracao.getNotaInfracao());
        //String sql = "INSERT INTO Infracoes (nome_notificado, dados_obra, etapas_concluidas, infracoes_cometidas, valor_multa, nota_infracao) VALUES (?, ?, ?, ?, ?)";
        db.insert("Infracoes", null, dados);
    }
}
