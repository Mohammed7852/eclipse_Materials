package Adaptive_Huffmand;

import java.util.*;

 public class Tree<T>{
	public Tree(){}
    private Node<T> root = null ;
    public Tree(Data rootData){
        root = new Node<T>();
        root.data = rootData;
        root.children = new ArrayList<Node<T>>();
    }
    
 public void fill_node(Data data){
	root = new Node<T>();
    root.data = data;
    root.children = new ArrayList<Node<T>>();
  }
 public static class Node<T>{
        private Data data;
        private Node<T> parent;
        private Node<T> left ; 
        private Node<T> right;
        private List<Node<T>> children;
    }
}
