/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MIB_informationssystem;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author adamd
 */
public class OvrigaFunktioner {
    
    /*"Trimmar" alla elemelnt hos en ArrayList, det vill säga tomma tecken som mellanslag
    och tabbar, tror jag, tas bort från alla element hos en ArrayList.
    */
    public static HashMap<String, String> trimHashMap(HashMap<String, String> hashMap) {
        
        for(String element : hashMap) {
            element = element.trim();
        }
        
        return hashMap;
    }
    
    
    
}
