package com.company;

import java.util.*;

public class Test_Result {

    static Map<String, List<String>> map=new HashMap<>();
    static Set<String> seen=new HashSet<>();
    static int noOfGroups=0;
    public static int Solution(String[] t,String[] r){
        if(t==null || r==null || t.length==0 || r.length==0 || (t.length!=r.length))
            return 0;

       for(int k=0;k<t.length;k++){
           int numIndex=-1;
           for(int i=0;i<t[k].length();i++){
               char c =t[k].charAt(i);
               if(!Character.isDigit(c))
                   continue;
               if(i+1==t[k].length()){
                   numIndex=i+1;
               }
               if(i+1<t[k].length()-1 && Character.isLetter(t[k].charAt(i+1))){
                   numIndex=i+1;
               }
               if(numIndex!=-1) {
                   String key = t[k].substring(0, i + 1);
                   String val = r[k].toUpperCase();
                   if (!map.containsKey(key) && !seen.contains(key)) {
                       seen.add(key);
                       noOfGroups++;
                       if (val.equals("OK")) {
                           map.put(key, new ArrayList<>());
                           map.get(key).add(val);
                       }
                   } else {
                       if (!val.equals("OK") && map.containsKey(key)) {
                           map.remove(key);
                       }

                   }
                   break;
               }
               //break;
           }
       }
        return (map.size()*100)/noOfGroups;
    }

    public static void main(String[] args){
        //Test case 1
        String[] T=new String[6];
        T[0]="test11a";
        T[1]="test12a";
        T[2]="test11b";
        T[3]="test11c";
        T[4]="test12b";
        T[5]="test111";
        String[] R=new String[6];
        R[0]="Wrong answer";
        R[1]="OK";
        R[2]="Runtime error";
        R[3]="OK";
        R[4]="OK";
        R[5]="Runtime error";

        //Test case 2
       /* String[] T=new String[5];
        T[0]="codility1";
        T[1]="codility3";
        T[2]="codility2";
        T[3]="codility4b";
        T[4]="codility4a";
        String[] R=new String[5];
        R[0]="Wrong answer";
        R[1]="OK";
        R[2]="OK";
        R[3]="Runtime error";
        R[4]="Runtime error";*/

        int result= Test_Result.Solution(T,R);
        boolean val = (1<10?true:false);
        System.out.println("val is: "+ val);

        System.out.println("Score is: "+result);
    }
}
