/*
Reconstruct Itinerary

Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.

Note:

    If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
    All airports are represented by three capital letters (IATA code).
    You may assume all tickets form at least one valid itinerary.
    One must use all the tickets once and only once.

Example 1:

Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]

Example 2:

Input: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"].
             But it is larger in lexical order.
*/
rajmc's avatar
rajmc
147

Last Edit: 2 hours ago

449 VIEWS

Video Explanation https://www.youtube.com/watch?v=KNFbEPjJTUg

Ariprot we can treat as vertex and the flights connecting as directed edges of Graph

Steps

    Create graph using Map<String, PriorityQueue> why PriorityQueue? becasue we have to return smaller lexical order path.
    Call the dfs for Vertex JFK

Note: Here important thing is from the problem notes there will be one valid itinerary and start airport given JFK.
If it not mentioned in problem this problem will be more Hard where we have to first check existent condition of eularian path and then find the start and end vertices.

    If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
    All airports are represented by three capital letters (IATA code).
    You may assume all tickets form at least one valid itinerary.
    One must use all the tickets once and only once.

Recursive

class Solution {
    Map<String, PriorityQueue<String>> flights;
    LinkedList<String> path;
    
    public List<String> findItinerary(List<List<String>> tickets) {
		// Initialization
        flights = new HashMap<>();
        path = new LinkedList<>();
		
		// build graph 
        for (List<String> ticket : tickets) {
            flights.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            flights.get(ticket.get(0)).add(ticket.get(1));
        }
        dfs("JFK");// dfs call from starting airport JFK
        return path;    
    }
    
    public void dfs(String departure) {
        PriorityQueue<String> arrivals = flights.get(departure);
        while (arrivals != null && !arrivals.isEmpty())
            dfs(arrivals.poll());
        path.addFirst(departure);
    }
}

class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> flights = new HashMap<>();
		// build graph 
        for (List<String> ticket : tickets) {
            flights.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            flights.get(ticket.get(0)).add(ticket.get(1));
        }

        LinkedList<String> path = new LinkedList<>();
        Stack<String> stack = new Stack<>();
        stack.push("JFK");
        while (!stack.empty()) {
            while (flights.containsKey(stack.peek()) && !flights.get(stack.peek()).isEmpty())
                stack.push(flights.get(stack.peek()).poll());
			path.addFirst(stack.pop());
        }
        
        return path;
    }
}
