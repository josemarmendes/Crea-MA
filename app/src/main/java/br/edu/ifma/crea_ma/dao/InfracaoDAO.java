package br.edu.ifma.crea_ma.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

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
        ContentValues dados = pegaDadosDaInfracao(infracao);

        db.insert("Infracoes", null, dados);
    }

    @NonNull
    private ContentValues pegaDadosDaInfracao(Infracao infracao) {
        ContentValues dados = new ContentValues();
        dados.put("nome_notificado", infracao.getNomeNotificado());
        dados.put("dados_obra", infracao.getDadosObra());
        dados.put("etapas_concluidas", infracao.getEtapasConcluidas());
        dados.put("infracoes_cometidas", infracao.getInfracoesCometidas());
        dados.put("valor_multa", infracao.getValorMulta());
        dados.put("nota_infracao", infracao.getNotaInfracao());
        return dados;
    }

    public List<Infracao> buscaInfracoes() {

        String sql = "SELECT * FROM Infracoes;";
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(sql, null);
        List<Infracao> infracoes = new ArrayList<Infracao>();

        while (c.moveToNext()){
            Infracao infracao = new Infracao();
            infracao.setId(c.getLong(c.getColumnIndex("id")));
            infracao.setNomeNotificado(c.getString(c.getColumnIndex("nome_notificado")));
            infracao.setDadosObra(c.getString(c.getColumnIndex("dados_obra")));
            infracao.setEtapasConcluidas(c.getString(c.getColumnIndex("etapas_concluidas")));
            infracao.setInfracoesCometidas(c.getString(c.getColumnIndex("infracoes_cometidas")));
            infracao.setValorMulta(c.getDouble(c.getColumnIndex("valor_multa")));
            infracao.setNotaInfracao(c.getDouble(c.getColumnIndex("nota_infracao")));

            infracoes.add(infracao);
        }

        c.close();

        return infracoes;
    }

    public void remove(Infracao infracao) {
        SQLiteDatabase db = getWritableDatabase();
        String[] params = {infracao.getId().toString()};
        db.delete("Infracoes", "id = ?", params);

    }

    public void altera(Infracao infracao) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues dados = pegaDadosDaInfracao(infracao);

        String[] params = {infracao.getId().toString()};
        db.update("Infracoes", dados, "id = ?", params);

    }

}
