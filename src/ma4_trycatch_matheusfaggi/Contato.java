/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma4_trycatch_matheusfaggi;
import ma4_trycatch_matheusfaggi.Exceptions.ContatoExceptions;
/**
 *
 * @author matheusfaggi
 */
public class Contato {
    private String nome;
    private String telefone;
    private int id;
    
    private void validation(String nome, String telefone) throws ContatoExceptions{
        if(nome == null)
            throw new ContatoExceptions("Valor inválido, telefone não aceita null");
        if(telefone == null)
            throw new ContatoExceptions("Valor inválido, telefone não aceita null");
        if(telefone.equals("") || nome.equals(""))
            throw new ContatoExceptions("Telefone está vazio, não tem porquê salvar");
   
    }
    public Contato(Agenda agenda, String nome, String telefone) throws ContatoExceptions {
        this.validation(nome,telefone);
        this.nome = nome;
        this.telefone = telefone;
        this.id = agenda.contatos.size() + 1;
    }
   
    public String getNome()  {
        return nome;
    }

    public int getId() {
        return id;
    }
    
    public void setNome(String nome)  {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

}
