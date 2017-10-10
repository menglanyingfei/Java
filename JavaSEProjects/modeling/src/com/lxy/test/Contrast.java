package com.lxy.test;

public class Contrast {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int graph[][] = {
				{0,1,0,1,0,0,0,1,0},  
                {1,0,1,0,1,0,0,1,0},  
                {0,1,0,0,0,1,0,0,0},  
                {1,0,0,0,1,0,0,0,0},  
                {0,1,0,1,0,1,0,1,0},  
                {0,0,1,0,1,0,0,0,0},
                {0,0,0,0,0,0,0,1,1},  
                {1,1,0,1,1,0,1,0,0},  
                {0,0,0,1,0,0,1,0,0}
                };  	
		int graph1[][] = {
				{0,0,1,1,0,0,0,1,0},  
                {0,0,1,0,1,0,0,1,0},  
                {1,0,0,0,0,1,0,0,0},  
                {1,0,0,0,0,0,1,0,0},  
                {0,1,0,0,0,1,0,1,0},  
                {0,0,1,0,1,0,0,0,0},
                {0,0,0,1,0,0,0,1,1},  
                {1,1,0,0,1,0,1,0,0},  
                {0,0,0,1,0,0,1,0,0}
                };
		int graph2[][] = {
				{0,1,0,1,0,1,0,1,1},  
                {1,0,1,1,1,0,1,1,1},  
                {0,1,0,1,0,1,0,0,0},  
                {1,1,1,0,1,0,1,0,1},  
                {0,1,0,1,0,1,1,1,0},  
                {1,0,1,0,1,0,0,0,1},
                {0,1,0,1,1,0,0,1,1},  
                {1,1,0,1,1,0,1,0,1},  
                {1,1,0,1,0,1,1,1,0}
                };
		int graph3[][] = {  
				{0,1,1,1,1,1,1,1,1},  
                {1,0,1,1,1,1,1,1,1},  
                {1,1,0,1,1,1,1,1,1},  
                {1,1,1,0,1,1,1,1,1},  
                {1,1,1,1,0,1,1,1,1},  
                {1,1,1,1,1,0,1,1,1},
                {1,1,1,1,1,1,0,1,1},  
                {1,1,1,1,1,1,1,0,1},  
                {1,1,1,1,1,1,1,1,0}
                };  
      double D = edgeConnectivity(graph);
      double D1 = edgeConnectivity(graph1);
      double D2 = edgeConnectivity(graph2);      
      double D3 = edgeConnectivity(graph3);      
      System.out.println(D);  
      System.out.println(D1);  
      System.out.println(D2); 
      System.out.println(D3); 
      System.out.println("小区开放前后平均边连通度之比为(优化)：");
      System.out.println("1. 一字型的情况：");
      System.out.println("D1/D:  " + D1 / D);
      System.out.println("2. 十字型的情况：");
      System.out.println("D2/D:  " + D2 / D);
      System.out.println("3. 环型的情况：");
      System.out.println("D3/D:  " + D3 / D);
	}

	public static int edgeConnectivity(int graph[][])  
    {  
        int min = Integer.MAX_VALUE;  
        MaxFlow m = new MaxFlow();
        for(int i=1;i<graph.length;i++)  
        {  
            int maxflow = m.fordFulkerson(graph, 0, i);  
            if(maxflow<min)  
                min=maxflow;  
        }  
        return min;  
    }  
	
}
