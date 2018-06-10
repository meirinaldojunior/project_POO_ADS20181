/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_poo_ads20181.funcao;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author meirinaldojunior
 */
public class CriptografaMD5 {
    
    public static String  criptografa(String text) throws NoSuchAlgorithmException{
       String s = text;
       MessageDigest m=MessageDigest.getInstance("MD5");
       m.update(s.getBytes(),0,s.length());
       return new BigInteger(1,m.digest()).toString(16);
    }
    
    public static Boolean comparaCripografia(String senhaCriptograda, String senhaDescriptograda){
        return senhaCriptograda.equals(senhaDescriptograda);
    }
    
}
