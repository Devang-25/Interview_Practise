package com.company;

public class NumberOfIslands {

    private static int numOfIslands(char[][] grid){
        if(grid==null || grid.length==0)
            return 0;
         int rows=grid.length;
         int cols=grid[0].length;
         int numOfIslands=0;
         for(int i=0;i<rows;i++){
             for(int j=0;j<cols;j++){
                 if(grid[i][j]=='1') {
                     dfs(i, j, grid);
                     numOfIslands++;
                 }

             }
         }
        return numOfIslands;
    }

    private static void dfs(int i,int j,char[][] grid){
        int rows=grid.length;
        int cols=grid[0].length;
        if(i<0 || j<0 || i>=rows || j>=cols || grid[i][j]!='1')
            return;
        grid[i][j]='0';
        dfs(i+1,j,grid);
        dfs(i-1,j,grid);
        dfs(i,j+1,grid);
        dfs(i,j-1,grid);
    }

    public static void main(String[] args){
        char[] val={'1','1','1','1','0','1','1','0','1','0','1','1','0','0','0','0','0','0','0','0'};
        char[][] grid = new char[4][5];
        int index=0;
        for(int i=0;i<4;i++){
            for(int j=0;j<5;j++){
                grid[i][j]= val[index++];
            }
        }

        for(int i=0;i<4;i++){
            for(int j=0;j<5;j++){
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }

        System.out.println("Number of islands: "+ numOfIslands(grid));

    }
}
