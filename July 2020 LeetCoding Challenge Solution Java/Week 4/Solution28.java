/*
Task Scheduler

You are given a char array representing tasks CPU need to do. It contains capital letters A to Z where each letter represents a different task. Tasks could be done without the original order of the array. Each task is done in one unit of time. For each unit of time, the CPU could complete either one task or just be idle.

However, there is a non-negative integer n that represents the cooldown period between two same tasks (the same letter in the array), that is that there must be at least n units of time between any two same tasks.

You need to return the least number of units of times that the CPU will take to finish all the given tasks.

 

Example 1:

Input: tasks = ["A","A","A","B","B","B"], n = 2
Output: 8
Explanation: 
A -> B -> idle -> A -> B -> idle -> A -> B
There is at least 2 units of time between any two same tasks.

Example 2:

Input: tasks = ["A","A","A","B","B","B"], n = 0
Output: 6
Explanation: On this case any permutation of size 6 would work since n = 0.
["A","A","A","B","B","B"]
["A","B","A","B","A","B"]
["B","B","B","A","A","A"]
...
And so on.

Example 3:

Input: tasks = ["A","A","A","A","A","A","B","C","D","E","F","G"], n = 2
Output: 16
Explanation: 
One possible solution is
A -> B -> C -> A -> D -> E -> A -> F -> G -> A -> idle -> idle -> A -> idle -> idle -> A
*/
/*
ntuition of the problem
We have to find least number of intervals to finish all tasks. Given that, each task requires one interval, for tasks of size t, we need at least t intervals to complete it.

Now the problem is reduced to finding the minimum idle time when no task is executing.
Our result would be idle Time + t (size of task array)

How to find the idle time ?
Assume, there 3 A tasks. Tasks = ["A","A","A","B"] . cooling time n = 2 .
If A Is run at a particular time, we cannot run it for 2 intervals after that.
So we have to try filling up those 2 spaces with some other task.

 What are the maximum number of idle spaces that we could have?

It would be (max Frequency task - 1 * n)
In this example, A has maximum frequency of 3, so there are 2 set of intervals(each of size n=2) that needs to be filled with some other task.
image

Once we know the maximum number of idle spaces, we have to just reduce the the count of spaces every time we find a task that can fill up that idle space.

Steps -
1) Create count array to keep track of frequency of each task. Size 26 as given in input.
2) Sort the frequency is ascending order, the task at last position (arr[25]) would be the one with maximum frequency.
Example -
Tasks ["A","A","A","B","B","C"]
A has max occurrence = 3, n = 2. Hence we can place A as follows
image

Max idle spaces = (3-1) * 2 = 4. We could see there 4 idle spaces above.

3)Now we have to just find that there are sufficient tasks to fill these 4 idle spaces.
We iterate over rest of array in descending order and substract it's count from idle spaces.
Task B has count 2 and C has count 1. Hence 1 space remains idle.

image

Answer , task length + idle time = 6 + 1 = 7
*/
class Solution {
    public int leastInterval(char[] t, int n) {
        if(n == 0) return t.length;
        int[] a = new int[26];
        for (char c: t) ++a[c-'A'];
        Arrays.sort(a);
        int max = a[25]-1;
        int s = max * n;
        for (int i = 24; i >= 0; --i) s -= Math.min(max, a[i]);
        s = Math.max(0, s);
        return t.length+s;
    }
}
