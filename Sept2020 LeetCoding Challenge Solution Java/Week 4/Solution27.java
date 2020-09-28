/*
Evaluate Division

You are given equations in the format A / B = k, where A and B are variables represented as strings, and k is a real number (floating-point number). Given some queries, return the answers. If the answer does not exist, return -1.0.

The input is always valid. You may assume that evaluating the queries will result in no division by zero and there is no contradiction.

 

Example 1:

Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
Explanation: 
Given: a / b = 2.0, b / c = 3.0
queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
return: [6.0, 0.5, -1.0, 1.0, -1.0 ]

Example 2:

Input: equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
Output: [3.75000,0.40000,5.00000,0.20000]

Example 3:

Input: equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["a","c"],["x","y"]]
Output: [0.50000,2.00000,-1.00000,-1.00000]

*/
class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, HashMap<String, Double>> g = build(equations, values);
        double[] ans = new double[queries.size()];
        
        for(int i = 0; i < queries.size(); ++i) ans[i] = getAns(queries.get(i).get(0), queries.get(i).get(1), g, new HashSet<>());
        
        return ans;
    }
    HashMap<String, HashMap<String, Double>> build(List<List<String>> e, double[] v) {
        HashMap<String, HashMap<String, Double>> g = new HashMap<>();
        
        for(int i = 0; i < v.length; ++i) {
            String u = e.get(i).get(0);
            String d = e.get(i).get(1);
            g.putIfAbsent(u, new HashMap<>());
            g.get(u).put(d, v[i]);
            g.putIfAbsent(d, new HashMap<>());
            g.get(d).put(u, 1.0/v[i]);
        }
        return g;
    }
    double getAns(String s, String e, HashMap<String, HashMap<String, Double>> g, HashSet<String> visited) {
        if(!g.containsKey(s)) return -1.0;
        if(g.get(s).containsKey(e)) return g.get(s).get(e);
        
        visited.add(s);
        
        for(Map.Entry<String, Double> it : g.get(s).entrySet()) {
            if(!visited.contains(it.getKey())) {
                double val = getAns(it.getKey(), e, g, visited);
                if(val != -1.0) return it.getValue() * val;
            }
        }
        // visited.remove(s); no need of backtracking
        return -1.0;
    }
}
