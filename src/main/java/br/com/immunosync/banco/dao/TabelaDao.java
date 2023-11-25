package br.com.immunosync.banco.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.immunosync.banco.exception.IdNotFoundException;
import br.com.immunosync.model.Tabela;

public class TabelaDao {

    private Connection conexao;

    public TabelaDao() {
    }

    public TabelaDao(Connection conexao) {
        this.conexao = conexao;
    }

    public void cadastrarTabela(Tabela tabela) throws SQLException {
        String sql = "INSERT INTO tb_tabela "
                + "(cd_tabela, ds_bcg, ds_hepatiteB, ds_rotavirus, ds_dtpa, ds_vip, ds_hib, ds_vpc10, "
                + "ds_meningococicasConjugadas, ds_meningococicaB, ds_influenza, ds_febreAmarela, ds_scr, "
                + "ds_varicela, ds_hepatiteA, ds_hpv4, ds_dengue, ds_covid19, cd_paciente) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stm = conexao.prepareStatement(sql)) {
        	stm.setInt(1, tabela.getId());
            stm.setString(2, tabela.getBcg());
            stm.setString(3, tabela.getHepatiteB());
            stm.setString(4, tabela.getRotavirus());
            stm.setString(5, tabela.getDtpa());
            stm.setString(6, tabela.getVip());
            stm.setString(7, tabela.getHib());
            stm.setString(8, tabela.getVpc10());
            stm.setString(9, tabela.getMeningococicasConjugadas());
            stm.setString(10, tabela.getMeningococicaB());
            stm.setString(11, tabela.getInfluenza());
            stm.setString(12, tabela.getFebreAmarela());
            stm.setString(13, tabela.getScr());
            stm.setString(14, tabela.getVaricela());
            stm.setString(15, tabela.getHepatiteA());
            stm.setString(16, tabela.getHpv4());
            stm.setString(17, tabela.getDengue());
            stm.setString(18, tabela.getCovid19());
            stm.setInt(19, tabela.getIdPaciente());

            stm.executeUpdate();
        }
    }


    private Tabela parse(ResultSet resultado) throws SQLException {
        int id = resultado.getInt("cd_tabela");
        String bcg = resultado.getString("ds_bcg");
        String hepatiteB = resultado.getString("ds_hepatiteB");
        String rotavirus = resultado.getString("ds_rotavirus");
        String dtpa = resultado.getString("ds_dtpa");
        String vip = resultado.getString("ds_vip");
        String hib = resultado.getString("ds_hib");
        String vpc10 = resultado.getString("ds_vpc10");
        String meningococicasConjugadas = resultado.getString("ds_meningococicasConjugadas");
        String meningococicaB = resultado.getString("ds_meningococicaB");
        String influenza = resultado.getString("ds_influenza");
        String febreAmarela = resultado.getString("ds_febreAmarela");
        String scr = resultado.getString("ds_scr");
        String varicela = resultado.getString("ds_varicela");
        String hepatiteA = resultado.getString("ds_hepatiteA");
        String hpv4 = resultado.getString("ds_hpv4");
        String dengue = resultado.getString("ds_dengue");
        String covid19 = resultado.getString("ds_covid19");
        int idPaciente = resultado.getInt("cd_paciente");

        return new Tabela(id, bcg, hepatiteB, rotavirus, dtpa, vip, hib, vpc10, meningococicasConjugadas,
                meningococicaB, influenza, febreAmarela, scr, varicela, hepatiteA, hpv4, dengue, covid19, idPaciente);
    }

    public List<Tabela> listarTabelas() throws SQLException {
        PreparedStatement stm = conexao.prepareStatement("SELECT * FROM tb_tabela");
        ResultSet resultado = stm.executeQuery();

        List<Tabela> lista = new ArrayList<>();

        while (resultado.next()) {
            Tabela tabela = parse(resultado);
            lista.add(tabela);
        }

        return lista;
    }

    public Tabela pesquisaTabelaPorId(int id) throws SQLException, IdNotFoundException {
        PreparedStatement stm = conexao.prepareStatement("SELECT * FROM tb_tabela WHERE cd_tabela = ?");
        stm.setInt(1, id);
        ResultSet resultado = stm.executeQuery();

        if (!resultado.next()) {
            throw new IdNotFoundException("O id não foi encontrado");
        }

        return parse(resultado);
    }

    public void atualizarTabela(Tabela tabela) throws SQLException {
        String sql = "UPDATE tb_tabela SET ds_bcg = ?, ds_hepatiteB = ?, ds_rotavirus = ?, ds_dtpa = ?, "
                   + "ds_vip = ?, ds_hib = ?, ds_vpc10 = ?, ds_meningococicasConjugadas = ?, "
                   + "ds_meningococicaB = ?, ds_influenza = ?, ds_febreAmarela = ?, ds_scr = ?, "
                   + "ds_varicela = ?, ds_hepatiteA = ?, ds_hpv4 = ?, ds_dengue = ?, ds_covid19 = ?, cd_paciente = ? "
                   + "WHERE cd_tabela = ?";

        try (PreparedStatement stm = conexao.prepareStatement(sql)) {
            stm.setString(1, tabela.getBcg());
            stm.setString(2, tabela.getHepatiteB());
            stm.setString(3, tabela.getRotavirus());
            stm.setString(4, tabela.getDtpa());
            stm.setString(5, tabela.getVip());
            stm.setString(6, tabela.getHib());
            stm.setString(7, tabela.getVpc10());
            stm.setString(8, tabela.getMeningococicasConjugadas());
            stm.setString(9, tabela.getMeningococicaB());
            stm.setString(10, tabela.getInfluenza());
            stm.setString(11, tabela.getFebreAmarela());
            stm.setString(12, tabela.getScr());
            stm.setString(13, tabela.getVaricela());
            stm.setString(14, tabela.getHepatiteA());
            stm.setString(15, tabela.getHpv4());
            stm.setString(16, tabela.getDengue());
            stm.setString(17, tabela.getCovid19());
            stm.setInt(18, tabela.getIdPaciente());

            stm.setInt(19, tabela.getId());

            stm.executeUpdate();
        }
    }

    public void removerTabela(int id) throws SQLException {
        String sql = "DELETE FROM tb_tabela WHERE cd_tabela = ?";

        try (PreparedStatement stm = conexao.prepareStatement(sql)) {
            stm.setInt(1, id);
            stm.executeUpdate();
        }
    }
}
