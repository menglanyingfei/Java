package com.lxy.test;   

public class EdgeConnectivity {  
      
        /** 
         * @param args 
         */  
        public static void main(String[] args) {  
        	
            int graph1[][] = {
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
            int graph2[][] = {  
            		{0,1,0,1,0,0,0,1,1},  
                    {1,0,1,0,1,0,0,1,1},  
                    {0,1,0,0,0,1,0,0,0},  
                    {1,0,0,0,1,0,0,0,0},  
                    {0,1,0,1,0,1,0,1,0},  
                    {0,0,1,0,1,0,0,0,0},
                    {0,0,0,0,0,0,0,1,1},  
                    {1,1,0,1,1,0,1,0,1},  
                    {1,1,0,1,0,0,1,1,0}
                     };  
            double D1 = edgeConnectivity(graph1);
            double D2 = edgeConnectivity(graph2);      
            System.out.println(D1);  
            System.out.println(D2); 
            System.out.println("小区开放前后平均边连通度之比为：");
            System.out.println("D2/D1:  " + D2 / D1);
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