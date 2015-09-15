package pietra;  
  
import java.security.MessageDigest;      
import java.security.NoSuchAlgorithmException;      
  
import sun.misc.BASE64Encoder;            
  
/**     
 * @author jarbas    
 * Retirado do link:
 * http://javafree.uol.com.br/topic-871490-Criptografando-Senhas-em-Java.html
 */      
public class EncriptaSenha {     
  
     public static String encripta (String senha) {     
          try {     
               MessageDigest digest = MessageDigest.getInstance("MD5");      
               digest.update(senha.getBytes());      
               BASE64Encoder encoder = new BASE64Encoder ();      
               return encoder.encode (digest.digest ());      
          } catch (NoSuchAlgorithmException ns) {     
               ns.printStackTrace ();      
               return senha;      
          }      
     }      
}   