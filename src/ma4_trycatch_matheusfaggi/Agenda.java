/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma4_trycatch_matheusfaggi;

import ma4_trycatch_matheusfaggi.Exceptions.ContatoExceptions;
import java.util.ArrayList;
/**
 *
 * @author matheusfaggi
 */
public class Agenda {
    public ArrayList<Contato> contatos =  new ArrayList();
    
    public void addContato(Contato contato){
        contatos.add(contato);
    }
    
    public ArrayList<Contato> pesquisaContato(String nome) throws ContatoExceptions {
        ArrayList<Contato> aux = new ArrayList();
        
        for(Contato c : contatos)
            if(c.getNome().matches(".*" + nome + ".*")) aux.add(c);
        
        if (aux.isEmpty())
            throw new ContatoExceptions("Contato não existe");
        return aux;
    }
    public int quantidade(){
        return this.contatos.size();
    }
}
