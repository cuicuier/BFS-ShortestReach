import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        Integer numberOfQueries = inputScanner.nextInt();
        
       // ArrayList<HashMap<Integer,ArrayList<Integer>>> graphArray = new ArrayList<>();

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
           
            
            Integer startingNode = inputScanner.nextInt();
            
            //init results array
            Integer[] results = new Integer[numberOfNodes+1];
            for(int j= 0; j < numberOfNodes+1; j++){
                results[j] = -1;
            }
            
            //do BFS
            Integer currentLevel = 0;

            Queue<Integer> currentLevelQueue = new LinkedList<Integer>();
            Queue<Integer> nextLevelQueue = new LinkedList<Integer>();
            
            currentLevelQueue.add(startingNode);
         
            while(currentLevelQueue.size() > 0){
                Integer currentLevelNodeId = currentLevelQueue.poll();
                results[currentLevelNodeId] = currentLevel * 6;
                //get children
                ArrayList<Integer> children = graph.get(currentLevelNodeId);
                
                //add all unvisited children to next level and results
                for(int k = 0; k < children.size(); k++){
                    Integer childNode = children.get(k);
                    //if we havent seen this child yet, tehn result will be -1
                    //unreachable nodes will never be looked at anyways

                    if(results[childNode] == -1){
                        nextLevelQueue.add(childNode);
                    }
                }
                
                //move on to next level if we are done with this one
                if(currentLevelQueue.size() == 0){
                    currentLevelQueue = nextLevelQueue;
                    nextLevelQueue = new LinkedList<Integer>();
                    currentLevel++;
                }
            }
            

            for(int l = 1; l < numberOfNodes+1; l++){
                //skip start node at level 0
                if(results[l] != 0){
                    System.out.print(results[l] + " ");
                }
            }
            System.out.println();
            
        }
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    }
}
