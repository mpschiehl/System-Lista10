/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Marcio
 */
public class SystemAluno {
    public SystemAluno(){
        gerarTela();
        instanciarComponentes();
        adicionarComponentes();
        gerarLocalizacoes();
        gerarDimensoes();
        jFrameSystem.setVisible(true);

    }
private JFrame  jFrameSystem;
private JTextField jTextFieldNome,jTextFieldId,jTextFieldCodigoMatricula,
        jTextFieldFrequencia,jTextFieldNota1,jTextFieldNota2,jTextFieldNota3,
        jTextFieldNota4;
private JLabel jLabelNome, jLabelId;
    private void gerarTela() {
        jFrameSystem = new JFrame();
        jFrameSystem.setSize(460,360);
        jFrameSystem.setLocationRelativeTo(null);
        jFrameSystem.setLayout(null);
        jFrameSystem.setDefaultCloseOperation(jFrameSystem.DISPOSE_ON_CLOSE);
        
    }

    private void instanciarComponentes() {
        jTextFieldId = new JTextField();
        jTextFieldFrequencia = new JTextField();
        jTextFieldNome = new JTextField();
        jTextFieldCodigoMatricula = new JTextField();
        jTextFieldNota1= new JTextField();
        jTextFieldNota2= new JTextField();
        jTextFieldNota3= new JTextField();
        jTextFieldNota4= new JTextField();
        jLabelId = new JLabel("Id:");
        jLabelNome = new JLabel("Nome");
    }

    private void adicionarComponentes() {
        jFrameSystem.add(jLabelId);
        jFrameSystem.add(jLabelNome);
        jFrameSystem.add(jTextFieldId);
      //  jFrameSystem.add(jTextFieldFrequencia);
        jFrameSystem.add(jTextFieldNome);
      /*  jFrameSystem.add(jTextFieldCodigoMatricula);
       /* jFrameSystem.add(jTextFieldNota1);
      /*  jFrameSystem.add(jTextFieldNota2);
      /*  jFrameSystem.add(jTextFieldNota3);
      /*  jFrameSystem.add(jTextFieldNota4);*/
        
    }

    private void gerarLocalizacoes() {
      jLabelId.setLocation(200,3);
      jLabelNome.setLocation(10,3);
      jTextFieldId.setLocation(200,25);
      jTextFieldNome.setLocation(10,25);
    }

    private void gerarDimensoes() {
         jLabelId.setSize(25,20);
         jLabelNome.setSize(60,20);
         jTextFieldId.setSize(70,20);
         jTextFieldNome.setSize(180,20);
    }
}
