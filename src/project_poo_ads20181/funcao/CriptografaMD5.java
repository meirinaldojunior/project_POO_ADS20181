/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_poo_ads20181.funcao;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author meirinaldojunior
 */
public class CriptografaMD5 {
    
    public static String  criptografa(String text) throws NoSuchAlgorithmException{   
       MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.update(StandardCharsets.UTF_8.encode(text));
        return String.format("%032x", new BigInteger(1, md5.digest()));
    }
    
    public static Boolean comparaCripografia(String senhaCriptograda, String senhaDescriptograda){
        return senhaCriptograda.equals(senhaDescriptograda);
    }
    
}
