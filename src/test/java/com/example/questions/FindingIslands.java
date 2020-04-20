package com.example.questions;
/**
 *FindingIslands(寻找岛屿)
 * 通过三种方式实现
 * 1.深度优化算法
 * 2.广度优化算法
 * 3.
 */
//        由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
//        岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
//        此外，你可以假设该网格的四条边均被水包围。
//        示例 1:
//        输入:
//        11110
//        11010
//        11000
//        00000
//        输出: 1

public class FindingIslands {
//         x,y+1
//  x-1,y   x,y    x+1,y
//         x,y-1
//记录横纵{x,y}坐标的四个方向，← ↑ → ↓
private static final int[][] directtion = {{-1,0},{0,1},{1,0},{0,-1}};
//标记数组，标记坐标（grid）是否被访问过
private boolean[][] marked;
//整个坐标的行数
private int rows;
//整个坐标的列数
private int cols;
//坐标(参数)
private  char[][] grid;

    public int numIslands(char[][] grid){
        rows = grid.length;
        if (rows == 0){
            return 0;
        }
        cols = grid[0].length;
        this.grid = grid;
        //记录状态值
        marked = new boolean[rows][cols];
        //count 记录岛屿数量
        int count = 0;
        for (int i = 0;i < rows;i++){
            for (int j = 0 ;j < cols;j++){
                //如果是岛屿中的一个点，并且没有被访问过
                //就进行深度优先算法 dfs(深度优先)
                if (!marked[i][j] && grid[i][j] == '1'){
                    count ++ ;
                    dfs(i,j);
                }
            }
        }
        return count;
    }

    //深度优先算法;从坐标为（i,j）的点进行深度优先遍历
    private void dfs(int i, int j) {
        //把当前坐标设置为已访问
        marked[i][j] = true;
        //得到4个方向的坐标
        for(int k = 0;k < 4;k++){
            int newX = i + directtion[k][0];
            int newY = j + directtion[k][1];
            //如果不越界，没有被访问过，并且是陆地
            if(inArea(newX,newY) && grid[newX][newY]=='1' && !marked[newX][newY]){
                dfs(newX,newY);
            }
        }

    }

    //判断是否越界
    private boolean inArea(int newX, int newY) {
        return newX >= 0 && newX < rows && newY >= 0 && newY < cols;
    }


    public static void main(String[] args) {

        FindingIslands FindingIslands = new FindingIslands();
//        char[][] grid1 = {
//                {'1', '1', '1', '1', '0'},
//                {'1', '1', '0', '1', '0'},
//                {'1', '1', '0', '0', '0'},
//                {'0', '0', '0', '0', '0'}};
        char[][] grid1 = {
                {'1', '0', '0' },
                {'0', '0', '1' },
                {'0', '0', '0' }};
        int numIslands1 = FindingIslands.numIslands(grid1);
        System.out.println("岛屿数量为： "+numIslands1);

    }


}
