import java.util.ArrayList;
import java.util.Hashtable;

public class test {
	//**
	 // Definition for a binary tree node.
	  public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	 
	public static class Solution {
	    boolean flag = false;
	    boolean found = false;
	    public static void main(String[] args) {
	    	
	    }
	    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	        return solv(root , p , q);
	    }
	    public TreeNode solv(TreeNode current ,TreeNode p , TreeNode q){
	        if(current == null || current.val == p.val){
	            return current;
	        }
	        TreeNode node = solv(current.left , p ,q);
	        if(found){
	            return node;
	        }
	        if(node == null){
	            node = solv(current.right , p , q);
	            if(find(node , q.val)){
	                found = true;
	                return node;
	            }
	            return current;
	        }else{
	            if(find(node , q.val)){
	                found = true;
	                return node;
	            }
	            return current;
	        }
	        
	    }
	    public boolean find(TreeNode node , int val){
	        TreeNode n = node.left;
	        while(n!= null){
	            if(n.val == val){
	                return true;
	            }
	            n = n.left;
	        }
	         n = node.right;
	        while(n!= null){
	            if(n.val == val){
	                return true;
	            }
	            n = n.right;
	        }
	        return false;
	    }
	}
}
