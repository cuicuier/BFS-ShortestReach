import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        Integer numberOfQueries = inputScanner.nextInt();
        
        ArrayList<HashMap<Integer,ArrayList<Integer>>> graphArray = new ArrayList<>();

        //for each query
        for(int i = 0; i < numberOfQueries; i++){
            Integer numberOfNodes = inputScanner.nextInt();
            Integer numberOfEdges = inputScanner.nextInt();
            
            HashMap<Integer,ArrayList<Integer>> graph  = new HashMap<>();
            
            //fill out all nodes in graph
            for(int nodeNum = 1; nodeNum <= numberOfNodes; nodeNum++){
                graph.put(nodeNum,new ArrayList<Integer>());
            }
            
            
            //add edges to graph
            for(int edgeNum = 1; edgeNum <= numberOfEdges; edgeNum++){
                Integer startEdge = inputScanner.nextInt();
                Integer endEdge = inputScanner.nextInt();
                
                //add bi-directional edge to adj. list
                graph.get(startEdge).add(endEdge);
                graph.get(endEdge).add(startEdge);
            }
            System.out.println(graph.toString());
            
            graphArray.add(graph);
            
            Integer startingNode = inputScanner.nextInt();
            
            //init results array
            Integer[] results = new Integer[numberOfNodes];
            for(int j= 0; j < numberOfNodes+1; j++){
                results[j] = -1;
            }
            
            //do BFS
            Integer currentLevel = 0;
            Integer nextLevel = 1; 
            Queue<Integer> currentLevelQueue = new LinkedList<Integer>();
            Queue<Integer> nextLevelQueue = new LinkedList<Integer>();
            
            currentLevelQueue.add(startingNode);
         
            while(currentLevelQueue.size() > 0){
                Integer currentLevelNodeId = currentLevelQueue.poll();
                results[currentLevelNodeId] = currentLevel;
                
                //get children
                ArrayList<Integer> children = graph.get(currentLevelNodeId);
                
                //loop over children
                //add them to next level
                //skip visited or don't include them, checkingg if -1 should be good enough
                
                //if current level queue is empty, set it to next level
            }

            //read through resultarray multiply by 6 if # > 0, skip printing S
            
        }
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    }
}
