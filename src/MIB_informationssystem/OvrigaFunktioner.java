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
        
        for(String key : hashMap.keySet()) {
            String trimmedValue = hashMap.get(key).trim();
            hashMap.put(key, trimmedValue);
        }
        
        return hashMap;
    }
    
    
        //Alternativ kod. Den här koden kanske inte funkar.
    /*  
    public static javax.swing.JTextArea fillTextArea(ArrayList<String> stringArrayList) {
        
        javax.swing.JTextArea textArea = null;
        
        for (String string : stringArrayList) {
            textArea.append(string + "\n");
        }
        
        return textArea;
    }
    */
    
    //I retursträngen så är det ett värde per rad.
    public static String ArrayListToString(ArrayList<String> stringArrayList) {
        
        //Man kan sammanfoga text genom en StringBuilder, vilket man även kan göra med en String, men StringBuilder är ett annat alternativ.
        StringBuilder sammanfogadText = null;
        
        //Sammanfogar strängarna till en text.
        for (String string : stringArrayList) {
            sammanfogadText.append(string + "\n");
        }
        
        return sammanfogadText.toString();
    }
    
    
    public static ArrayList<String> HashMapToArrayList(HashMap<String, String> hashMap) {
        
        //Man kan sammanfoga text genom en StringBuilder, vilket man även kan göra med en String, men StringBuilder är ett annat alternativ.
        ArrayList<String> arrayList = null;
        String value;
        
        //Sammanfogar strängarna till en text.
        for (String key : hashMap.keySet()) {
            value = hashMap.get(key);
            arrayList.add(value);
        }
        
        return arrayList;
    }
    
    public static String hashMapArrayListToString(ArrayList<HashMap<String, String>> hashMapArrayList) {
        
        String sammanfogadText = null;
        ArrayList<String> stringArrayList;
                
                
        for(HashMap<String, String> hashMap : hashMapArrayList) {
            
            stringArrayList = HashMapToArrayList(hashMap);
            
            //Sammanfogar strängarna till en text.
            for(String string : stringArrayList){
                
                sammanfogadText += string + " ";
            }
            
            sammanfogadText += "\n";
        }
        
        return sammanfogadText.toString();
    }
    
    
    
    
    
    
}
