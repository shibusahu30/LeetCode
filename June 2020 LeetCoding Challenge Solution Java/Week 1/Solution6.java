/*
Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers (h, k), where h is the height of the person and k is the number of people in front of this person who have a height greater than or equal to h. Write an algorithm to reconstruct the queue.

Note:
The number of people is less than 1,100.
 

Example

Input:
[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

Output:
[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]

 
   Hide Hint #1  
What can you say about the position of the shortest person?
If the position of the shortest person is i, how many people would be in front of the shortest person?
   Hide Hint #2  
Once you fix the position of the shortest person, what can you say about the position of the second shortest person?
*/
class Solution {
        public int[][] reconstructQueue(int[][] people) {
			// sort array using Arrays.sort with custom comparator
            Arrays.sort(people, (p1, p2) -> p1[0] == p2[0] ? p1[1] - p2[1] : p2[0] - p1[0]); 
            List<int[]> list = new ArrayList<>();
            for (int i = 0; i < people.length; i++) {
                list.add(people[i][1], people[i]); // placing people based on the K value
            }
            return list.toArray(people); // convert list to array
        }
}
