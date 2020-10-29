package com.company;

import java.util.HashMap;
import java.util.TreeMap;

public class LoungeStockingGreedy {
    static TreeMap<Integer,Integer> hand;
    static TreeMap<Integer,Integer> supply;

    public LoungeStockingGreedy(){
        hand=new TreeMap<>();
        supply=new TreeMap<>();
    }

    private static int stockLounge(int[] onHand,int[] supplier,int demand){
        int max=Integer.MIN_VALUE;
        int m= onHand.length;
        int n=supplier.length;
        // demand exceeds supply return -1
        if(demand>m+n){
            return -1;
        }
        for(int i:onHand){
            hand.put(i,hand.getOrDefault(i,0)+1);
            max=Math.max(max,i);
        }
        for(int i:supplier){
            supply.put(i,supply.getOrDefault(i,0)+1);
        }
        int supplierCount=0,maxCount=0, ldemand=0;
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

    public static void main(String[] args) {

        //test case 1: output:2
        //int[] onHand={0,2,2};
        //int[] supplier={2,0,0};

        //test case 2: output:3
        //int[] onHand={1,0,1};
        //int[] supplier={2,0,2,0,0,2};

        //test case 3: output:-1
        //int[] onHand={1,1,1};
        //int[] supplier={2,0,0,0};

        //test case 4: output:2
        //int[] onHand={0,2,2,2};
        //int[] supplier={0,0,2,2};

        //test case 5: output:3
        int[] onHand={1,0,1};
        int[] supplier={2,0,2,0,0,2};

        int demand=2;

        LoungeStockingGreedy ls=new LoungeStockingGreedy();
        int result=ls.stockLounge(onHand,supplier,demand);
        System.out.println("The max amount needed is: " +result);
    }
}
