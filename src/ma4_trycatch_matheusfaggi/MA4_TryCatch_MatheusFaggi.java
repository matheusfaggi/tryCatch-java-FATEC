/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma4_trycatch_matheusfaggi;
import ma4_trycatch_matheusfaggi.Exceptions.ContatoExceptions;
import ma4_trycatch_matheusfaggi.Exceptions.TesteExceptions;

/**
 *
 * @author matheusfaggi
 */
public class MA4_TryCatch_MatheusFaggi {

    public static void main(String[] args) throws TesteExceptions,ContatoExceptions {
//        Testando algumas funcionalidades hardcoded
        new Teste().runTests();
        new Teste().start();
    }    
}
