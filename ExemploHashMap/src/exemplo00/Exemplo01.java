
package exemplo00;

import java.util.HashMap;

/**
 *
 * @author Uma aluna aí....
 */
public class Exemplo01 {
    
    public static void main(String[]args){
        //o void é do tipo primitivo
         
        HashMap<String,Integer> idades
                = new HashMap<>();
        idades.put("Cleiton",22);
        idades.put("Kleyton",24);
        
        if(idades.containsKey("Kleytom")){
            System.out.println("TEM KLEYTOM");
        } else{
            System.out.println("NÃO TEM KLEYTOM");
        }
        int idade = idades.get("Kleyton");
        System.out.println("Idade do Kleyton: " + idade);
        
        idades.put("Kleyton" , 27);
    }
}
