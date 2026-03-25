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
