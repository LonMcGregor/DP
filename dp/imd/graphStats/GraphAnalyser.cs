// 266I - Graph Stats - Radius and Diameter
// https://redd.it/4iut1x
// Assumes Directed Graph, Assume nodes are numbered by their index+1
// i.e. Edge 1 2 is listed as Node id 0 has neighbour 1
// Assume max 2 edges between two adjacent nodes [1 in each direction]
// Assume all distances on edges = 1

namespace uk.lonm.dp.imd {

using System;
using System.Text.RegularExpressions;

class GraphAnalyserRunner {
    public static void Main(string[] args){
        Console.Write("Number of Nodes: ");
        int numberOfNodes = Convert.ToInt32(Console.ReadLine());
        GraphAnalyser ga = new GraphAnalyser(numberOfNodes);
        Console.WriteLine("Enter Edges:");
        Regex r = new Regex(@"\d+");
        int[] nodes = new int[2];
        string s = Console.ReadLine();
        while(s!=""){
            int i = 0;
            foreach(Match m in r.Matches(s)){
                nodes[i++] = Convert.ToInt32(m.Value);
            }
            ga.addNewEdge(nodes[0], nodes[1]);
            s = Console.ReadLine();
        }
        Console.WriteLine("Radius: {0}", ga.getRadius().ToString());
        Console.WriteLine("Diameter: {0}", ga.getDiameter().ToString());
    }
}

class GraphAnalyser {
    private int numNodes;
    private GraphNode[] nodes;
    
    public GraphAnalyser(int numberOfNodes){
        numNodes = numberOfNodes;
        nodes = new GraphNode[numNodes];
        for(int i =0; i<numNodes;i++){
            nodes[i] = new GraphNode(i);
        }
    }
        
    private int getEccentricityForNode(int nodeA){
        //The eccentricity ecc(v) of vertex / node v in graph G is the greatest distance from v to any other node.
        //so, do a dijkstras between nodeA, and take the largest value?
        
        int posOfA = nodeA-1;
        
        int INFINITY = -1;
        int NODE_UNDEFINED = -2;
        
        List<int> unvisitedNodes = new List<int>();
        int[] distanceFromStartTo = new int[numNodes];
        int[] previousNodeInOptimalPath = new int[numNodes];
        
        for(int i = 0; i < numNodes; i++){             
            distanceFromStartTo[i] = INFINITY;             
            previousNodeInOptimalPath = NODE_UNDEFINED;
            unvisitedNodes.Add(i);         
        }
        
        distanceFromStartTo[posOfA] = 0;
        
        while(Q.Count>0){
            u ← vertex in Q with min dist[u]    // Source node will be selected first
            int nodeU = minDistanceForUnvisited(unvisitedNodes, distanceFromStartTo);
            remove u from Q 
            
            for each neighbor v of u:           // where v is still in Q.
                alt ← dist[u] + length(u, v)
                if alt < dist[v]:               // A shorter path to v has been found
                    dist[v] ← alt 
                    prev[v] ← u
        }
        //return dist[], prev[]
    }
    
    private int minDistanceForUnvisited(List<int> unvisitedNodes, int[] distanceFromStartTo){
        for(int i = 0 ;i < distanceFromStartTo.Length; i++){
            if(unvisitedNodes.Contains(i)){
                currentMin = distanceFromStartTo[i];
                currentPos = i;
                break;
            }
        }
        for(int i = 0 ;i < distanceFromStartTo.Length; i++){
            if(unvisitedNodes.Contains(i) && distanceFromStartTo[i] < currentMin){
                currentMin = distanceFromStartTo[i];
                currentPos = i;
            }
        }
        return currentPos;
    }
    
    public int getRadius(){
        //The radius rad(G) of G is the value of the smallest eccentricity.
    }
    
    public int getDiameter(){
        //The diameter diam(G) of G is the value of the greatest eccentricity.
    }
    
    public List<int> getCentre(){
        //The center of G is the set of nodes v such that ecc(v)=rad(G)
    }
    
    public void addNewEdge(int nodeAName, int nodeBName){
        int posOfA = nodeAName-1;
        int posOfB = nodeBName-1;
        if(nodes[posOfA]==null){
            nodes[posOfA] = new
        }
    }
}

class GraphNode{
    int id;
    List<int> neighbours;
    
    public GraphNode(int id){
        this.id = id;
        neighbours = new List<int>();
    }
    
    public void addNeighbour(int id){
        if(neighbours.Contains(id))return;
        neighbours.Add(id);
    }
}

}