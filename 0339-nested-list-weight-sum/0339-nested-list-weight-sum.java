/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // The result is undefined if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // The result is undefined if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        // get the depth -- DFS
        // add the sum (if an integer, we calculate the sum as n*d, 
        // or calculate the sum of the list recursively with depth equals d+1

        return depthList(nestedList, 1);
    }

    private int depthList(List<NestedInteger> list, int depth){
        int sum = 0;

        for(NestedInteger ls : list) {
            if(ls.isInteger()) { // use inner API
            sum += ls.getInteger() * depth;
            } else {
                sum += depthList(ls.getList(), depth+1);
            }
        }

        return sum;
    }
}