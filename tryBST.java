//comment 1
//comment 2
import java.util.*;
class tNode{
    int key;
    tNode left, right;

    public tNode(int key){
        this.key = key;
        left = null;
        right = null;
    }
}

class BST{
    tNode root;
    BST() {
        root = null;
    }
  //comment 3
    tNode insertRec(tNode root, int key){
        if(root == null){
            root = new tNode (key);
            return root;
        }
        if(key< root.key)
            root.left = insertRec(root.left, key);

        else if(key > root.key)
            root.right = insertRec(root.right,key);

        return root;
    }
    void insert(int key){
        root = insertRec(root, key);
    }
    //comment 4
    boolean isBST (tNode node, int min, int max){
        if(node == null)
            return true;
        if(node.key < min || node.key > max)
            return false;
        
        return isBST(node.left, min, node.key-1) && isBST(node.right, node.key+1, max);
}
    //comment 5
int minimumValue(tNode node){
        int minimum = node.key;
        
        while(node.left != null){
            minimum = node.left.key;
            node = node.left;
        }
        return minimum;
}
    //comment 6
tNode deleteRec(tNode root, int key){
        if(root == null)
            return root;
        if(key < root.key)
            root.left = deleteRec(root.left, key);
        else if(key > root.key)
            root.right = deleteRec(root.right, key);
        else{
            if(root.left ==null)
                return root.right;
            else if(root.right == null)
                return root.left;
            root.key = minimumValue(root.right);
            root.right = deleteRec(root.right, root.key);
        }
        return root;
}
    //comment 7
    public class tryBST {
    static void buildBalanced(BST tree,int start, int end){
        if(start > end)
            return;
        int mid = (start + end) /2;
        tree.insert(mid);
        buildBalanced(tree , start,mid-1);
        buildBalanced(tree, mid+1, end);
    }
        //comment 7
static void removeEvenNumbers(BST tree, int max){
        for(int i=2; i<= max; i +=2){
            tree.root = tree.deleteRec(tree.root, i);
        }
}
//comment 8 
public static void main(String[] args){
        int n= 18;
        int max = (int) Math.pow(2, n) -1;
        int repetitions = 30;

        long populateTotal =0;
        long deleteTotal =0;

        for(int i=0; i < repetitions; i++){
            BST tree = new BST();
            long populateStart = System.currentTimeMillis();
            buildBalanced(tree,1 ,max);
            long populateEnd = System.currentTimeMillis();
            
            populateTotal += (populateEnd - populateStart);
            
            if(!tree.isBST(tree.root, Integer.MIN_VALUE, Integer.MAX_VALUE)){
                System.out.println("Tree is not a BST!");
            }
            
            long deleteStart =System.currentTimeMillis();
            removeEvenNumbers(tree, max);
            long deleteEnd = System.currentTimeMillis();
            deleteTotal += (deleteEnd - deleteStart);
        }
        double populateAvg = populateTotal/ (double) repetitions;
        double deleteAvg = deleteTotal/ (double) repetitions;
    //comment 9
