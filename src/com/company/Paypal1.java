import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


import java.util.TreeMap;
class Result {

    /*
     * Complete the 'stockLounge' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY onHand
     *  2. INTEGER_ARRAY supplier
     *  3. INTEGER demand
     */

    static TreeMap<Integer,Integer> hand=new TreeMap<>();
    static TreeMap<Integer,Integer> supply=new TreeMap<>();

    public static int stockLounge(List<Integer> onHand, List<Integer> supplier, int demand) {
        // Write your code here
        int[] onHandArr=new int[onHand.size()];
        int[] supplierArr=new int[supplier.size()];

        for(int i=0;i<onHand.size();i++){
            onHandArr[i]=onHand.get(i);
        }

        for(int i=0;i<supplier.size();i++){
            supplierArr[i]=supplier.get(i);
        }

        int max=Integer.MIN_VALUE;
        int m= onHand.size();
        int n=supplier.size();

        // demand exceeds supply return -1
        if(demand>m+n){
            return -1;
        }

        for(int i:onHandArr){
            hand.put(i,hand.getOrDefault(i,0)+1);
            max=Math.max(max,i);
        }
        for(int i:supplierArr){
            supply.put(i,supply.getOrDefault(i,0)+1);
        }
        int supplierCount=0, ldemand=0;
        int higherH,higherS;

        for(int i=0;i<=max;i++){
            //initialize demand for each day
            ldemand=demand;

            // get the next higher expiry date value for both hand and supply
            higherH=hand.higherKey(i)==null?Integer.MAX_VALUE:hand.higherKey(i);
            higherS=supply.higherKey(i)==null?Integer.MAX_VALUE:supply.higherKey(i);

            //System.out.println("Higher hand: "+higherH);
            //System.out.println("Higher supplier: "+higherS);

            int currIndex=i;
            //case 1: both hand and supply contain items with expiry date i
            //if(hand.containsKey(currIndex) && supply.containsKey(currIndex)){
            while(ldemand>0) {
                if(hand.containsKey(currIndex)) {
                    while (ldemand > 0 && hand.containsKey(currIndex) && hand.get(currIndex) > 0) {
                        //if supply greater than demand then wasted
                        if (hand.get(currIndex) > ldemand && i==currIndex)
                            return -1;
                        if (hand.get(currIndex) == ldemand) {
                            hand.put(currIndex,0);
                            break;
                        }
                        //supplierCount++;
                        //System.out.println("hand here");
                        ldemand--;
                        hand.put(currIndex, hand.get(currIndex) - 1);
                    }
                }
                if(supply.containsKey(currIndex)) {
                    while (ldemand > 0 && supply.containsKey(currIndex) && supply.get(currIndex) > 0) {
                        //System.out.println("supply here");
                        supplierCount++;
                        ldemand--;
                        supply.put(currIndex, supply.get(currIndex) - 1);
                    }
                }
                //System.out.println("Ldemand: "+ldemand);
                //System.out.println("Supple Amount: "+supplierCount);
                //System.out.println("--------------");
                if(ldemand > 0) {
                    if(higherH==Integer.MAX_VALUE && higherS==Integer.MAX_VALUE)
                        break;
                    currIndex = Math.min(higherH, higherS);//2
                    higherH=hand.higherKey(currIndex)==null?Integer.MAX_VALUE:hand.higherKey(currIndex);
                    higherS=supply.higherKey(currIndex)==null?Integer.MAX_VALUE:supply.higherKey(currIndex);
                    //System.out.println("Current Index: "+currIndex);
                    //System.out.println("processing 1");
                }
            }
        }
        return supplierCount<=0?-1:supplierCount;

    }

}
