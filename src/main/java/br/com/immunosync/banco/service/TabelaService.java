package br.com.immunosync.banco.service;

import br.com.immunosync.banco.dao.TabelaDao;
import br.com.immunosync.banco.exception.BadInfoException;
import br.com.immunosync.banco.exception.IdNotFoundException;
import br.com.immunosync.banco.factory.ConnectionFactory;
import br.com.immunosync.model.Tabela;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TabelaService {

    private Connection conexao;
    private TabelaDao tabelaDao;

    public TabelaService() throws ClassNotFoundException, SQLException {
        conexao = ConnectionFactory.getConnection();
        tabelaDao = new TabelaDao(conexao);
    }

    public void cadastrarTabela(Tabela tabela) throws SQLException, BadInfoException {
    	validar(tabela);
        tabelaDao.cadastrarTabela(tabela);
    }
    
    private void validar(Tabela tabela) throws BadInfoException {
        if (tabela.getBcg() == null || tabela.getBcg().length() > 50) {
            throw new BadInfoException("A vacina BCG não deve ser nula ou possuir mais de 50 caracteres.");
        }

        if (tabela.getHepatiteB() == null || tabela.getHepatiteB().length() > 50) {
            throw new BadInfoException("A vacina Hepatite B não deve ser nula ou possuir mais de 50 caracteres.");
        }

        if (tabela.getRotavirus() == null || tabela.getRotavirus().length() > 50) {
            throw new BadInfoException("A vacina Rotavírus não deve ser nula ou possuir mais de 50 caracteres.");
        }

        if (tabela.getDtpa() == null || tabela.getDtpa().length() > 50) {
            throw new BadInfoException("A vacina DTPa não deve ser nula ou possuir mais de 50 caracteres.");
        }

        if (tabela.getVip() == null || tabela.getVip().length() > 50) {
            throw new BadInfoException("A vacina VIP não deve ser nula ou possuir mais de 50 caracteres.");
        }

        if (tabela.getHib() == null || tabela.getHib().length() > 50) {
            throw new BadInfoException("A vacina Hib não deve ser nula ou possuir mais de 50 caracteres.");
        }

        if (tabela.getVpc10() == null || tabela.getVpc10().length() > 50) {
            throw new BadInfoException("A vacina VPC10 não deve ser nula ou possuir mais de 50 caracteres.");
        }

        if (tabela.getMeningococicasConjugadas() == null || tabela.getMeningococicasConjugadas().length() > 50) {
            throw new BadInfoException("A vacina Meningocócicas Conjugadas não deve ser nula ou possuir mais de 50 caracteres.");
        }

        if (tabela.getMeningococicaB() == null || tabela.getMeningococicaB().length() > 50) {
            throw new BadInfoException("A vacina Meningocócica B não deve ser nula ou possuir mais de 50 caracteres.");
        }

        if (tabela.getInfluenza() == null || tabela.getInfluenza().length() > 50) {
            throw new BadInfoException("A vacina Influenza não deve ser nula ou possuir mais de 50 caracteres.");
        }

        if (tabela.getFebreAmarela() == null || tabela.getFebreAmarela().length() > 50) {
            throw new BadInfoException("A vacina Febre Amarela não deve ser nula ou possuir mais de 50 caracteres.");
        }

        if (tabela.getScr() == null || tabela.getScr().length() > 50) {
            throw new BadInfoException("A vacina SCR não deve ser nula ou possuir mais de 50 caracteres.");
        }

        if (tabela.getVaricela() == null || tabela.getVaricela().length() > 50) {
            throw new BadInfoException("A vacina Varicela não deve ser nula ou possuir mais de 50 caracteres.");
        }

        if (tabela.getHepatiteA() == null || tabela.getHepatiteA().length() > 50) {
            throw new BadInfoException("A vacina Hepatite A não deve ser nula ou possuir mais de 50 caracteres.");
        }

        if (tabela.getHpv4() == null || tabela.getHpv4().length() > 50) {
            throw new BadInfoException("A vacina HPV4 não deve ser nula ou possuir mais de 50 caracteres.");
        }

        if (tabela.getDengue() == null || tabela.getDengue().length() > 50) {
            throw new BadInfoException("A vacina Dengue não deve ser nula ou possuir mais de 50 caracteres.");
        }

        if (tabela.getCovid19() == null || tabela.getCovid19().length() > 50) {
            throw new BadInfoException("A vacina COVID-19 não deve ser nula ou possuir mais de 50 caracteres.");
        }
    }

    public List<Tabela> listarTabelas() throws SQLException {
        return tabelaDao.listarTabelas();
    }

    public Tabela pesquisaTabelaPorId(int id) throws SQLException, IdNotFoundException {
        return tabelaDao.pesquisaTabelaPorId(id);
    }

    public void atualizarTabela(Tabela tabela) throws SQLException, BadInfoException {
    	validar(tabela);
        tabelaDao.atualizarTabela(tabela);
    }

    public void removerTabela(int id) throws SQLException {
        tabelaDao.removerTabela(id);
    }
}

