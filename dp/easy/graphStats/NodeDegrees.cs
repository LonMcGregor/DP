// 266E - Basic Graph Stats - Node Degrees [+ Bonus Adjacency Matrix]
// https://redd.it/4ijtrt
// Assumes Undirected Graph, allowing multiple edges, allow self loops

namespace uk.lonm.dp.easy {

using System;

class GraphStatRunner {
    public static void main(string[] args){
        
    }
}

class NodeDegreeAnalyser {
    private List<List<int>> adjacencyMatrix;
    private List<int> nodePositions;
    private List<int> nodeDegrees;
    
    public NodeDegreeAnalyser(){
        nodePositions = new List<int>();
        adjacencyMatrix = new List<List<int>>();
    }
    
    public void printAdjacencyMatrix(){
        foreach(List<int> row in adjacencyMatrix){
            foreach(int cell in row){
                Console.Write("{0} ", cell);
            }
            Console.WriteLine();
        }
    }
    
    public void printNodeDegrees(){
        for(int i = 0; i < nodePositions; i++){
            Console.WriteLine("Node {0} has a degree of {1}", nodePositions[i], nodeDegrees[i]);
        }
    }
    
    public void addNewEdge(int nodeAName, int nodeBName){
        int posOfA = getPositionOfNode(nodeAName);
        int posOfB = getPositionOfNode(nodeBName);
        adjacencyMatrix[posOfA][posOfB]++;
        adjacencyMatrix[posOfB][posOfA]++;
        if(posA!=posB){
            nodeDegrees[posOfA]++;
        }
        nodeDegrees[posOfB]++;
    }
    
    private int getPositionOfNode(int nodeName){
        int position = nodePositions.IndexOf(nodeName);
        if(position==-1){
            nodePositions.Add(nodeName);
            registerNewNode();
            return nodePositions.Count-1;
        }
        return position;
    }
    
    private void registerNewNode(){
        for(int i = 0; i < adjacencyMatrix.Count; i++){
            adjacencyMatrix[i].Add(0);
        }
        adjacencyMatrix.Add(new List<int>());
        int newRowNumber = adjacencyMatrix.Count-1;
        for(int i = 0; i < adjacencyMatrix.Count; i++){
            adjacencyMatrix[newRowNumber].Add(0);
        }
        nodeDegrees.Add(0);
    }
    
}

}