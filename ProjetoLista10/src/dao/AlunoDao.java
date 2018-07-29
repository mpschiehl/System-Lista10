

package dao;

import bean.AlunosBean;
import conexao.ConexaoFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Marcio
 */
public class AlunoDao {
    public int inserir(AlunosBean aluno) {
        Connection conexao = ConexaoFactory.obterConexao();
        if (conexao != null) {
            String sql = "INSERT INTO alunos"
                    + "\n(id, nome, nota1, nota2, nota3,codigo_de_matricula ,frequencia )"
                    + "\nVALUES(?,?,?,?,?,?,?)";
            try {
                PreparedStatement preparedStatement = conexao
                        .prepareStatement(sql,
                                PreparedStatement.RETURN_GENERATED_KEYS);
                preparedStatement.setInt(1, aluno.getId());
                preparedStatement.setString(2, aluno.getNome());
                preparedStatement.setDouble(3, aluno.getNota1());
                preparedStatement.setDouble(4, aluno.getNota2());
                preparedStatement.setDouble(5, aluno.getNota3());
                preparedStatement.setString(7, aluno.getCodigoDeMatricula());
                preparedStatement.setByte(8, aluno.getFrequencia());
                preparedStatement.execute();
                ResultSet resultSet = preparedStatement.getGeneratedKeys();

                if (resultSet.next()) {
                    return resultSet.getInt(1);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                ConexaoFactory.fecharConexao();
            }
        }
        return 0;
    }

    public boolean alterar(AlunosBean aluno) {
        Connection conexao = ConexaoFactory.obterConexao();
        String sql = "UPDATE alunos"
                + "\nSET nome = ?,codigo_matricula = ?,nota_1 = ?,nota_2 = ?,nota_3 = ?,frequencia = ?"
                + "WHERE id = ?";
        if(conexao != null){
            try {
                PreparedStatement ps = conexao.prepareStatement(sql);
                ps.setString(1,aluno.getNome());
                ps.setString(2,aluno.getCodigoDeMatricula());
                ps.setFloat(3,aluno.getNota1());
                ps.setFloat(4,aluno.getNota2());
                ps.setFloat(5,aluno.getNota3());
                ps.setByte(7,aluno.getFrequencia());
                ps.setInt(9, aluno.getId());
                return ps.executeUpdate() == 1;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            finally{
                ConexaoFactory.fecharConexao();
            }
        }
        return false;
    }

    public boolean apagar(int id) {
        String sql = "DELETE FROM alunos WHERE id = ?;";
        Connection conexao = ConexaoFactory.obterConexao();
        if (conexao != null) {
            try {
                PreparedStatement ps = conexao.prepareStatement(sql);
                ps.setInt(1, id);
                return ps.executeUpdate() == 1;
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                ConexaoFactory.fecharConexao();
            }
        }
        return false;
    }

    public AlunosBean obterAlunoPeloId(int id) {
        String sql = "SELECT id, nome, Nota1, Nota2, Nota3, codigo_de_matricula ,frequencia "
                + "FROM alunos WHERE id = ?;";
        Connection conexao = ConexaoFactory.obterConexao();
        if (conexao != null) {
            try {
                PreparedStatement ps = conexao.prepareStatement(sql);
                ps.setInt(1, id);
                ps.execute();
                ResultSet resultSet = ps.getResultSet();
                if (resultSet.next()) {
                    AlunosBean aluno = new AlunosBean();
                    aluno.setId(resultSet.getInt("id"));
                    aluno.setNome(resultSet.getString("nome"));
                    aluno.setNota1(resultSet.getFloat("nota1"));
                    aluno.setNota2(resultSet.getFloat("nota2"));
                    aluno.setNota3(resultSet.getFloat("nota3"));
                    aluno.setCodigoDeMatricula(resultSet.getString("codigo_de_matricula"));
                    aluno.setFrequencia(resultSet.getByte("frequencia"));
                    return aluno;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                ConexaoFactory.fecharConexao();
            }
        }
        return null;
    }

    public List<AlunosBean> obterAlunos() {
        List<AlunosBean> alunos = new ArrayList<>();
        Connection conexao = ConexaoFactory.obterConexao();
        if (conexao != null) {
            String sql = "SELECT id, nome, nota1, nota2, nota3"
                    + "codigo_de_matricula ,frequencia FROM alunos";
            try {
                Statement statement = conexao.createStatement();
                statement.execute(sql);
                ResultSet resultSet = statement.getResultSet();
                while (resultSet.next()) {
                    AlunosBean aluno = new AlunosBean();
                    aluno.setId(resultSet.getInt("id"));
                    aluno.setNome(resultSet.getString("nome"));
                    aluno.setNota1(resultSet.getFloat("nota1"));
                    aluno.setNota2(resultSet.getFloat("nota2"));
                    aluno.setNota3(resultSet.getFloat("nota3"));
                    aluno.setCodigoDeMatricula(resultSet.getString("codigo_de_matricula"));
                    aluno.setFrequencia(resultSet.getByte("frequencia"));
                    alunos.add(aluno);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                ConexaoFactory.fecharConexao();
            }
        }
        return alunos;
    }
}
