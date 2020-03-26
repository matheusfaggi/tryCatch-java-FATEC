/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma4_trycatch_matheusfaggi;
import java.util.ArrayList;
import java.util.Scanner;
import ma4_trycatch_matheusfaggi.Exceptions.TesteExceptions;
import ma4_trycatch_matheusfaggi.Exceptions.ContatoExceptions;
/**
 *
 * @author matheusfaggi
 */
public class Teste {
    private final Agenda agenda = new Agenda();
    private int option;
    private boolean running = true;
        public void start() throws ContatoExceptions{
        
        while(this.running){  
            Scanner scanner = new Scanner(System.in);
            System.out.println(String.format("qtd contatos: %d",this.agenda.quantidade()));
            System.out.println("1 - add contato\n"
                + "2 - consulta contato\n"
                      + "3 - sair");
             try { 
                this.setOption(Integer.parseInt(scanner.next()));
                
             } catch(TesteExceptions ex){
                 System.out.println(ex.getMessage());
             }

            switch(this.option){
                case 1:
                    this.addContato();
                    break;
                case 2:
                    this.consultaNome();
                    break;
                case 3:
                    System.out.println("FIM");
                    this.running = false;
                    break;
            }
        }    
    }
    
    public void runTests(){     
        try{
            System.out.println("Adicionando null e null");
            this.agenda.addContato(new Contato(this.agenda,null,null));
        }
        catch(ContatoExceptions ex){
            System.out.println(ex.getMessage() + "\n");
        }
        try{
            System.out.println("Adicionando \"\" e \"\" ");
            this.agenda.addContato(new Contato(this.agenda,"",""));
        }catch(ContatoExceptions ex){
            System.out.println(ex.getMessage() + "\n");
        }
        
        try{
            System.out.println("Adicionando null e \"\" ");
            this.agenda.addContato(new Contato(this.agenda,null,""));
        }catch(ContatoExceptions ex){
            System.out.println(ex.getMessage() + "\n");
        }
        try{
            System.out.println("Adicionando \"\" e null ");
            this.agenda.addContato(new Contato(this.agenda,"",null));
        }catch(ContatoExceptions ex){
            System.out.println(ex.getMessage() + "\n");
        }
        try{
            this.runSeed();
        }catch(ContatoExceptions e){
            System.out.println(e.getMessage());
        }
    }
    
    
    private void clearConsole(){
//       Não consegui achar um comando pra apagar
        System.out.println("----------------------");
    }
    
    private void setOption(int option) throws TesteExceptions {
        if(option < 1 || option > 2)
            throw new TesteExceptions("Opção inválida\n\n");
        
        this.option = option;
        this.clearConsole();
    }
    
    private void runSeed() throws ContatoExceptions{
        System.out.println("Adicionando contatos\n");
        
        this.agenda.addContato(new Contato(this.agenda,"Matheus Faggi", "11 964-747-312"));
        this.agenda.addContato(new Contato(this.agenda,"Monica Faggi", "11 981-406-312"));
    }
    
    private void addContato() {
        try{
            Scanner scanner = new Scanner(System.in);
            System.out.println("Digite o nome: ");
            String nome = (String)scanner.nextLine();

            System.out.println("Digite o telefone: ");
            String telefone = (String)scanner.nextLine();
            this.agenda.addContato(new Contato(this.agenda, nome, telefone));
        }catch(ContatoExceptions e){
            System.out.println(e.getMessage());
        }
        
    }
    private void consultaNome(){
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Digite o nome: ");
        String nome = scanner.nextLine();
        try{
            ArrayList<Contato> resultado = this.agenda.pesquisaContato(nome);
            for(Contato c : resultado)
                System.out.println(String.format("%s: %s", c.getNome(), c.getTelefone()));
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }
    
 }
