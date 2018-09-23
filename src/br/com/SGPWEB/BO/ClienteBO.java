/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.SGPWEB.BO;

import java.util.InputMismatchException;
import java.sql.Connection;
import java.util.List;

import br.com.SGPWEB.DAO.ClienteDAO;
import br.com.SGPWEB.beans.Cliente;

/**
 *
 * @author Renato Nascimento
 */
public class ClienteBO {
    public static void cadastrar(Cliente cliente, String cnpj, Connection con) throws Exception{
		//regra de neg�cio
		if(cliente.getRazaosocial().length() < 1){
			throw new Exception("Nome não pode ser vazio!");
		}
                
                if(ClienteBO.validaCNPJ(cnpj)){
                    throw new Exception("CNPJ Inválido!");
                }
		//Chamar o DAO correspondente para efetuar a opera��o no banco
		new ClienteDAO().adicionar(cliente, con);
	}
	
	public static List<Cliente> listar(Connection con) throws Exception{
		return new ClienteDAO().listar(con);
	}
	
	public static List<Cliente> procurarClient(String nome, Connection con) throws Exception{
		if(nome.length() < 2){
			throw new Exception("Nome de busca inv�lido");
		}
		
		return new ClienteDAO().procurar(nome, con);
	}
    
    public static boolean validaCNPJ(String cnpj){
        
        // considera-se erro CNPJ's formados por uma sequencia de numeros iguais
        if (cnpj.equals("00000000000000") || cnpj.equals("11111111111111") ||
            cnpj.equals("22222222222222") || cnpj.equals("33333333333333") ||
            cnpj.equals("44444444444444") || cnpj.equals("55555555555555") ||
            cnpj.equals("66666666666666") || cnpj.equals("77777777777777") ||
            cnpj.equals("88888888888888") || cnpj.equals("99999999999999") ||
            (cnpj.length() != 14))
            return(false);
        char dig13, dig14;
        int sm, i, r, num, peso;
 
    // "try" - protege o código para eventuais erros de conversao de tipo (int)
        try {
    // Calculo do 1o. Digito Verificador
            sm = 0;
            peso = 2;
            for (i=11; i>=0; i--) {
// converte o i-ésimo caractere do CNPJ em um número:
// por exemplo, transforma o caractere '0' no inteiro 0
// (48 eh a posição de '0' na tabela ASCII)
                num = (int)(cnpj.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso + 1;
                if (peso == 10)
                    peso = 2;
            }
 
        r = sm % 11;
        if ((r == 0) || (r == 1))
            dig13 = '0';
        else dig13 = (char)((11-r) + 48);
 
// Calculo do 2o. Digito Verificador
        sm = 0;
        peso = 2;
        for (i=12; i>=0; i--) {
            num = (int)(cnpj.charAt(i)- 48);
            sm = sm + (num * peso);
            peso = peso + 1;
            if (peso == 10)
                peso = 2;
      }
 
        r = sm % 11;
        if ((r == 0) || (r == 1))
            dig14 = '0';
        else dig14 = (char)((11-r) + 48);
 
// Verifica se os dígitos calculados conferem com os dígitos informados.
        if ((dig13 == cnpj.charAt(12)) && (dig14 == cnpj.charAt(13)))
            return true;
        else return false;
    }   catch (InputMismatchException erro) {
            return false;
    }
  }
}
