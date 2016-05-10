// 266E - Basic Graph Stats - Node Degrees [+ Bonus Adjacency Matrix]
// https://redd.it/4ijtrt
// Assumes Undirected Graph, allowing multiple edges, allow self loops

namespace uk.lonm.dp.easy {

using System;
using System.Text.RegularExpressions;

class GraphStatRunner {
    public static void Main(string[] args){
        Console.Write("Number of Nodes: ");
        int numberOfNodes = Convert.ToInt32(Console.ReadLine());
        NodeDegreeAnalyser nda = new NodeDegreeAnalyser(numberOfNodes);
        Console.WriteLine("Enter Edges:");
        string s = Console.ReadLine();
        while(s!=""){
            int[] nodes = handleInputString(s);
            nda.addNewEdge(nodes[0], nodes[1]);
            s = Console.ReadLine();
        }
        nda.printNodeDegrees();
        nda.printAdjacencyMatrix();
    }
    
    public static int[] handleInputString(string s){
        Regex r = new Regex(@"\d+");
        int[] nodes = new int[2];
        int i = 0;
        foreach(Match m in r.Matches(s)){
            nodes[i++] = Convert.ToInt32(m.Value);
        }
        return nodes;
    }
}

class NodeDegreeAnalyser {
    private int[][] adjacencyMatrix;
    private int[] nodePositions;
    private int[] nodeDegrees;
    
    public NodeDegreeAnalyser(int numberOfNodes){
        adjacencyMatrix = new int[numberOfNodes][];
        for(int i = 0; i < numberOfNodes; i++){
            adjacencyMatrix[i] = new int[numberOfNodes];
        }
        nodePositions = new int[numberOfNodes];
        nodeDegrees = new int[numberOfNodes];
    }
    
    public void printAdjacencyMatrix(){
        foreach(int[] row in adjacencyMatrix){
            foreach(int cell in row){
                Console.Write("{0} ", cell);
            }
            Console.WriteLine();
        }
    }
    
    public void printNodeDegrees(){
        for(int i = 0; i < nodePositions.Length; i++){
            Console.WriteLine("Node {0} has a degree of {1}", nodePositions[i], nodeDegrees[i]);
        }
    }
    
    public void addNewEdge(int nodeAName, int nodeBName){
        int posOfA = getPositionOfNode(nodeAName);
        int posOfB = getPositionOfNode(nodeBName);
        adjacencyMatrix[posOfA][posOfB]++;
        adjacencyMatrix[posOfB][posOfA]++;
        if(posOfA!=posOfB){
            nodeDegrees[posOfA]++;
        }
        nodeDegrees[posOfB]++;
    }
    
    private int getPositionOfNode(int nodeName){
        for(int i = 0; i < nodePositions.Length; i++){
            if(nodePositions[i] == 0){
                nodePositions[i] = nodeName;
                return i;
            }
            if(nodePositions[i] == nodeName){
                return i;
            }
        }
        throw new Exception("More Nodes named than Declared");
    }
}

}