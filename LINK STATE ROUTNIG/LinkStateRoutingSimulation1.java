
import java.util.*;
public class LinkStateRoutingSimulation1 {

    private static final int  N =5;
    private static final int  INFIN= Integer.MAX_VALUE;

    private int[][] adj;
    private int[]costs;
    private boolean[] visited;

    LinkStateRoutingSimulation1()
    {
        adj= new int [10][10];
        costs = new int[10];
        visited =new boolean[10];
    }

    public void addLink(int s,int d, int c)
    {
        adj[s][d]=c;
        adj[d][s]=c;
    }

    private int  getnextnode()
    {
        int mincost=INFIN;
        int nextnode=-1;

        for(int i=0;i<N;i++)
        {
            if(visited[i]==false && costs[i]<mincost)
            {
                mincost=costs[i];
                nextnode=i;

            }
        }
         return nextnode;
    }

    public List<Integer> findShortestPath(int source,int destination)
    {  
        Arrays.fill(costs,INFIN);
        Arrays.fill(visited,false );
        costs[source]=0;
        int currentnode;
        for(int i=0;i<N;i++)
        {  
            currentnode=getnextnode();
            visited[currentnode]=true;

            for(int j=0;j<N;j++)
            {
                if(visited[j]==false && adj[currentnode][j]!=0)
                {
                    int newCost= adj[currentnode][j] + costs[currentnode];
                    if(newCost < costs[j])
                    {
                        costs[j]=newCost;
                    }
                }


            }
        }


        return buildpath(source,destination);
}
    

   private List<Integer> buildpath( int s,int d)
   {
     List <Integer> path = new ArrayList<>();
     int curr=d;
     
     while(curr!=s)
     {
        path.add(curr);
        for(int i=0;i<N;i++)
        {
            if(adj[curr][i]!=0 && adj[curr][i] + costs[i]==costs[curr] )
            {
                curr=i;
                break;

            }

        }
     }
      path.add(s);
      Collections.reverse(path);
      return path;


   }

   //--------------------------------------------------------------------
   public static void main(String args[])
   {
     LinkStateRoutingSimulation1 router=new LinkStateRoutingSimulation1();
        router.addLink(0, 1, 2);
        router.addLink(0, 2, 5);
        router.addLink(1, 3, 1);
        router.addLink(2, 3, 3);
        router.addLink(2, 4, 7);
        router.addLink(3, 4, 2);

    int s=0;
    int d=4;

    List<Integer> path = router.findShortestPath(s ,d);
   
    if(path.isEmpty()==true)
    {
        System.out.println("no path found");
    }
    else
    {
        for(int x:path)
        {System.out.println(x);}
    }

       


   }
}




    