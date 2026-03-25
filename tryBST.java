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
