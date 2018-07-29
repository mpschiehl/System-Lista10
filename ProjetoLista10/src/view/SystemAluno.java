/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.ActionEvent;
import bean.AlunosBean;
import dao.AlunoDao;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Marcio Pedro Schiehl
 */
public class SystemAluno {
    public SystemAluno(){
        gerarTela();
        instanciarComponentes();
        adicionarComponentes();
        gerarLocalizacoes();
        gerarDimensoes();
        acaoBotaoSalvar();
        jFrameSystem.setVisible(true);

    }
private JFrame  jFrameSystem;
private JTextField jTextFieldNome,jTextFieldId,jTextFieldCodigoMatricula,
        jTextFieldFrequencia,jTextFieldNota1,jTextFieldNota2,jTextFieldNota3,
        jTextFieldNota4;
private JLabel jLabelNome, jLabelId,jLabelNota1,jLabelNota2,jLabelNota3,jLabelNota4;
private JButton jButtonSalvar,jButtonCancelar,jButtonEdital;
    private void gerarTela() {
        jFrameSystem = new JFrame();
        jFrameSystem.setSize(390,240);
        jFrameSystem.setLocationRelativeTo(null);
        jFrameSystem.setLayout(null);
        jFrameSystem.setResizable(false);
        jFrameSystem.setDefaultCloseOperation(jFrameSystem.DISPOSE_ON_CLOSE);

        
    }

    private void instanciarComponentes() {
        jTextFieldId = new JTextField();
        jTextFieldFrequencia = new JTextField("jTextFieldFrequencia");
        jTextFieldNome = new JTextField();
        jTextFieldCodigoMatricula = new JTextField("jTextFieldCodigoMatricula");
        jTextFieldNota1= new JTextField();
        jTextFieldNota2= new JTextField();
        jTextFieldNota3= new JTextField();
        jTextFieldNota4= new JTextField();
        jLabelId = new JLabel("Id:");
        jLabelNome = new JLabel("Nome");
        jLabelNota1 = new JLabel("1° nota");
        jLabelNota2 = new JLabel("2° nota");
        jLabelNota3 = new JLabel("3° nota");
        jLabelNota4 = new JLabel("4° nota");
        jButtonSalvar = new JButton("Salvar");
        jButtonEdital = new JButton("Editar");
    }

    private void adicionarComponentes() {
        jFrameSystem.add(jLabelId);
        jFrameSystem.add(jLabelNome);
        jFrameSystem.add(jLabelNota1);
        jFrameSystem.add(jLabelNota2);
        jFrameSystem.add(jLabelNota3);
        jFrameSystem.add(jLabelNota4);
        jFrameSystem.add(jTextFieldId);
        jFrameSystem.add(jTextFieldFrequencia);
        jFrameSystem.add(jTextFieldNome);
        jFrameSystem.add(jTextFieldCodigoMatricula);
        jFrameSystem.add(jTextFieldNota1);
        jFrameSystem.add(jTextFieldNota2);
        jFrameSystem.add(jTextFieldNota3);
        jFrameSystem.add(jTextFieldNota4);
        jFrameSystem.add(jButtonSalvar);
        jFrameSystem.add(jButtonEdital);
        
    }

    private void gerarLocalizacoes() {
      int margem =20, entreLinha = 20;
      jLabelId.setLocation(200+margem,3+entreLinha);
      jLabelNome.setLocation(10+margem,3+entreLinha);
      jTextFieldId.setLocation(200+margem,25+entreLinha);
      jTextFieldNome.setLocation(10+margem,25+entreLinha);
      jTextFieldNota1.setLocation(10+margem, 60+entreLinha);
      jTextFieldNota2.setLocation(90+margem,60+entreLinha);
      jTextFieldNota3.setLocation(170+margem,60+entreLinha);
      jTextFieldNota4.setLocation(250+margem,60+entreLinha);
      jLabelNota1.setLocation(jTextFieldNota1.getX(),62);
      jLabelNota2.setLocation(jTextFieldNota2.getX(),62);
      jLabelNota3.setLocation(jTextFieldNota3.getX(),62);
      jLabelNota4.setLocation(jTextFieldNota4.getX(),62);
      jTextFieldCodigoMatricula.setLocation(jLabelNota1.getX(),100+entreLinha);
      jTextFieldFrequencia.setLocation(jLabelNota2.getX(),100+entreLinha);
      jButtonSalvar.setLocation(jLabelNota1.getX(), jTextFieldCodigoMatricula.getY()+ entreLinha);
      jButtonEdital.setLocation(101,jTextFieldFrequencia.getY()+entreLinha);
    }

    private void gerarDimensoes() {
         jLabelId.setSize(25,20);
         jLabelNome.setSize(60,20);
         jTextFieldId.setSize(70,20);
         jTextFieldNome.setSize(180,20);
         jTextFieldNota1.setSize(jTextFieldId.getSize());
         jTextFieldNota2.setSize(jTextFieldId.getSize());
         jTextFieldNota3.setSize(jTextFieldId.getSize());
         jTextFieldNota4.setSize(jTextFieldId.getSize());
         jLabelNota1.setSize(jLabelNome.getSize());
         jLabelNota2.setSize(jLabelNome.getSize());
         jLabelNota3.setSize(jLabelNome.getSize());
         jLabelNota4.setSize(jLabelNome.getSize());
         jTextFieldCodigoMatricula.setSize(jTextFieldId.getSize());
         jTextFieldFrequencia.setSize(jTextFieldId.getSize());
         jButtonSalvar.setSize(jTextFieldCodigoMatricula.getSize());
         jButtonEdital.setSize(85,20);
    }

    private void acaoBotaoSalvar() {
         jButtonSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                
                AlunosBean aluno = new AlunosBean();
                aluno.setNome(jTextFieldNome.getText().trim());
                aluno.setCodigoDeMatricula(jTextFieldCodigoMatricula.getText().trim());
                aluno.setNota1(Float.parseFloat(jTextFieldNota1.getText()));
                aluno.setNota2(Float.parseFloat(jTextFieldNota2.getText()));
                aluno.setNota3(Float.parseFloat(jTextFieldNota3.getText()));
                aluno.setNota4(Float.parseFloat(jTextFieldNota4.getText()));
                aluno.setFrequencia(Byte.parseByte(jTextFieldFrequencia.getText()));
                
                if(jTextFieldId.getText().isEmpty()){
                    int id = new AlunoDao().inserir(aluno);
                    aluno.setId(id);
                }
            }    
         }
    }
}
