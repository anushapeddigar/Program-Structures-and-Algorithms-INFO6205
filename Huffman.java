/*
 * Anusha Peddigari
 * 001023769
 */
package Test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

/**
 *
 * @author 16175
 */
public class Huffman {

    public static class HuffmanNode {

        char character;
        int frequency;
        HuffmanNode left = null;
        HuffmanNode right = null;

        HuffmanNode(char character, int frequency) {
            this.character = character;
            this.frequency = frequency;
        }

        HuffmanNode(char character, int frequency, HuffmanNode left, HuffmanNode right) {
            this.character = character;
            this.frequency = frequency;
            this.left = left;
            this.right = right;
        }
    }

    class MyComparator implements Comparator<HuffmanNode> {

        public int compare(HuffmanNode x, HuffmanNode y) {
            return x.frequency - y.frequency;
        }
    }

    public static void main(String[] args) {
        

        String text = "There are sunny days, rainy days, and windy days";
        Huffman hc = new Huffman();
        hc.createTree(text);

    }

    
    public void createTree(String text) {
        Map<Character, Integer> huff = new HashMap<>();
        for (char c : text.toCharArray()) {
            huff.put(c, huff.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<HuffmanNode> priorityqueue = new PriorityQueue<>(huff.keySet().size(), new MyComparator());

        for (Entry<Character, Integer> entry : huff.entrySet()) {
            priorityqueue.add(new HuffmanNode(entry.getKey(), entry.getValue()));
        }

        while (priorityqueue.size() != 1) {
            HuffmanNode left = priorityqueue.poll();
            HuffmanNode right = priorityqueue.poll();

            int result = left.frequency + right.frequency;
            priorityqueue.add(new HuffmanNode('\0', result, left, right));
        }

        HuffmanNode root = priorityqueue.peek();

        System.out.println("String given:" + text);
        Map<Character, String> codes = new HashMap<Character, String>();
        getCodes(root, "", codes);
        
        
        
        System.out.println("Codes:");
        for (Map.Entry<Character, String> entry : codes.entrySet()) {
		    System.out.println("'" + entry.getKey() + "'"+ " --> " + entry.getValue());
		}

        
        System.out.println("\nHuffman Weight:" + root.frequency);
   


    }

    
    public void getCodes(HuffmanNode root, String value, Map<Character, String> codes) {

        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            codes.put(root.character, value);
        }

        getCodes(root.left, value + "0", codes);
        getCodes(root.right, value + "1", codes);
    }
}
