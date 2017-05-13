import java.util.*;
import java.io.*;
import java.lang.*;

public class Dijkstra
{
 public static int G[][];
 public static int n;
 public static int startnode;
 

 public static void dijk(int G[][], int n, int startnode)
 {
    int cost[][]= new int[10][10];
    int distance[]= new int[10];
    int path[]= new int[10];
    int visited[]= new int[10];
    int count, mindistance, nextnode=-1, i,j;
    
    for(i=0;i < n;i++)
    {
      for(j=0;j < n;j++)
      {
        if(G[i][j]==0)
         cost[i][j]=999;
        else
         cost[i][j]=G[i][j];
      }
    }

    for(i=0;i< n;i++)
    {
      distance[i]=cost[startnode][i];
      path[i]=startnode;
      visited[i]=0;
    }
 
    distance[startnode]=0;
    visited[startnode]=1;
    count=1;
  
    while(count < n)
    {
      mindistance=999;
      for(i=0;i < n;i++)
      {
        if(distance[i] < mindistance && visited[i]==0)
        {
         mindistance=distance[i];
         nextnode=i;
        }
      }

     visited[nextnode]=1;

     for(i=0;i < n;i++)
     {
       if(visited[i]==0 && mindistance+cost[nextnode][i] < distance[i])
       {
        distance[i]=mindistance+cost[nextnode][i];
        path[i]=nextnode;
       }
     }
    count++;
    }
     
    for(i=0;i < n;i++)
    {
     if(i!=startnode)
     {
      System.out.printf("\nDistance of %d = %d", i, distance[i]);
      System.out.printf("\nPath = %d", i);
      j=i;
 
      do
      {
       j=path[j];
       System.out.printf(" <-%d", j);
      } while(j!=startnode);
     }
    }
 }


 public static void main(String args[])
 {
    G=new int[10][10];
    int i, j, n, u;

    Scanner in=new Scanner(System.in);

    System.out.print("\nEnter the no. of vertices: ");
    n=in.nextInt();
   
    System.out.print("\nEnter the adjacency matrix:\n");
    for(i=0;i < n;i++)
    {
     for(j=0;j < n;j++)
     {
      G[i][j]=in.nextInt();
     }
    }

    System.out.print("\nEnter the starting node: ");
    u=in.nextInt();

    dijk(G,n,u);
 }
 
}   
