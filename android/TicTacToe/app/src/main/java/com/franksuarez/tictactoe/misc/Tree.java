/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.franksuarez.MultiDimensional;

import com.google.common.collect.TreeBasedTable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author franksuarez
 */
public class Tree<T> {

    public static class Node<T> {

        private int maxKey = 0;

        private T value;
        private Map<Integer, Node<T>> nodes;

        public void setValue(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public Node() {
            this.nodes = new HashMap<>();

        }

        public Node(T value) {
            this();
            this.value = value;
        }

        public void put(T value, int idx) {
            this.maxKey = Math.max(this.maxKey, idx);

            Node<T> n = new Node<>();
            n.setValue(value);
            this.nodes.put(idx, n);
        }

        public void put(int idx) {
            put(null, idx);
        }
        
        public Node<T> get(int idx) throws IndexOutOfBoundsException {
            Node<T> n = this.nodes.get(idx);
            if (n == null) {
                throw new IndexOutOfBoundsException();
            }

            return n;
        }

        public void remove(int idx) {
            this.nodes.remove(idx);
        }

        public String listNodes(int tabLevel) {
            StringBuilder sb = new StringBuilder();

            for (Integer i : nodes.keySet()) {
                Node<T> n = nodes.get(i);

                sb.repeat("\t", tabLevel);
                sb.append("Node (").append(i).append("): ");
                sb.append(n.getValue());
                sb.append("\n");
                if (!n.nodes.isEmpty()) {
                    sb.append(n.listNodes(tabLevel + 1));
                }
            }
            return sb.toString();
        }

        public String listNodes() {
            return listNodes(0);
        }

        @Override
        public String toString() {
            return listNodes();
        }

        /**
         * Returns a Node which only has index idx at level.
         *
         * TODO:
         *
         * @param level
         * @param idx
         * @return
         */
        public Node<T> filterLevel(int level, int idx) {
            throw new UnsupportedOperationException("unimplemented");
        }

    }

    private Node<T> rootNode;

    public Tree() {
        this.rootNode = new Node<>();
    }

//
//    public void put(int idx, T value) {
//        this.rootNode.put(idx, value);
//    }

    /**
     * NOTE: vararg needs to be at the end. An array at the front could be used.
     * @param value
     * @param idxs 
     */
    public void put(T value, int... idxs) {
        // if a level does not exist, create it.
        
        Node<T> currentNode = this.rootNode;
        
        for (int i: idxs) {
            Node<T> nextNode;
            
            try {
                nextNode = currentNode.get(i);
            } catch (IndexOutOfBoundsException ex) {
                currentNode.put(null, i);
                nextNode = currentNode.get(i);
            }
            
            currentNode = nextNode;
            
            
        }
        
        currentNode.setValue(value);
    }
    
    
    public Node<T> get(int... idxs) {
        Node<T> currentNode = this.rootNode;
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        
        
        
        for (int i : idxs) {
            sb.append(i).append(",");
            try {
                currentNode = currentNode.get(i);
            } catch (IndexOutOfBoundsException ex) {
                
                sb.append(")");
                throw new IndexOutOfBoundsException("Cannot get "+sb.toString());
            }
        }

        return currentNode;
    }

    public String toString() {
        return this.rootNode.toString();
    }

}
