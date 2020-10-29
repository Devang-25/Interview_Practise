package com.company;
import java.util.*;
import java.util.ArrayList;

public class AllPathSourceToTarget {

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res=new ArrayList();
        if(graph==null || graph.length==0)
            return res;
        List<Integer> path=new ArrayList<Integer>();
        path.add(0);
        dfs(graph,0,path,res);
        return res;
    }

    private static void dfs(int[][] graph,int node,List<Integer> path,List<List<Integer>> res){
        if(node==graph.length-1){
            res.add(new ArrayList<>(path));
            return ;
        }
        for(int next:graph[node]){
            path.add(next);
            dfs(graph,next,path,res);
            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args){
        int[][] graph ={{1,2},{3},{3},{}};
        List<List<Integer>> result=allPathsSourceTarget(graph);
        for(int i=0;i<result.size();i++){
            System.out.println(result.get(i));
        }
    }

}
