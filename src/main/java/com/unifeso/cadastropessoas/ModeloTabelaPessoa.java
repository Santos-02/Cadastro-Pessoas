/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unifeso.cadastropessoas;

import com.unifeso.cadastropessoas.Pessoa;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Hprdo
 */
public class ModeloTabelaPessoa extends AbstractTableModel {
   private static final int COLUNA_NOME = 0;
   private static final int COLUNA_TELEFONE =1;
   private static final int COLUNA_EMAIL =2;
   
   private String colunas[] = new String[]{"Nome","Telefone", "E-mail"};
   private ArrayList<Pessoa> pessoas;
   
   public ModeloTabelaPessoa(ArrayList<Pessoa> pessoas){
       this.pessoas = new ArrayList<Pessoa>(pessoas);
   }
   
   @Override
   public int getColumnCount(){
       return colunas.length;
   }
   
   @Override
   public int getRowCount(){
       return pessoas.size();
   }
   
   @Override
   public String getColumnName(int indiceColuna){
       return colunas[indiceColuna];
   }
   
   @Override
   public boolean isCellEditable(int indiceLinha, int indiceColuna){
       return false;
   }
   
   @Override
   public Object getValueAt(int indiceLinha, int indiceColuna){
       Pessoa pessoa = pessoas.get(indiceLinha);
       switch (indiceColuna){
           case COLUNA_NOME :
               return pessoa.getNome();
           case COLUNA_TELEFONE:
               return pessoa.getTelefone();
           case COLUNA_EMAIL:
               return pessoa.getEmail();
       }
       return "";
   }
   
   @Override
   public void setValueAt(Object valor, int indiceLinha, int indiceColuna){
       Pessoa pessoa = pessoas.get(indiceLinha);
       switch (indiceColuna){
           case COLUNA_NOME:
               pessoa.setNome(valor.toString());
               break;
           case COLUNA_TELEFONE:
               pessoa.setTelefone(valor.toString());
               break;
           case COLUNA_EMAIL:
               pessoa.setEmail(valor.toString());
               break;
       }
   }
   
   public Pessoa obterPessoa(int indicePessoa){
       return pessoas.get(indicePessoa);
   }
   
   public void incluirPessoa(Pessoa pessoa){
       pessoas.add(pessoa);
       int ultimo = getRowCount()-1;
       fireTableRowsInserted (ultimo, ultimo);
   }
   
   public void atualizarPessoa(int indicePessoa, Pessoa pessoa){
       pessoas.set(indicePessoa, pessoa);
       fireTableRowsUpdated(indicePessoa,indicePessoa);
   }
   
   public void excluirPessoa(int indicePessoa){
       pessoas.remove(indicePessoa);
       fireTableRowsDeleted(indicePessoa, indicePessoa);
   }
   
   
}
