package leetcode.editor.cn.structure;

import java.util.TreeMap;

public class Trie {

    private class Node {
        // isWord 表示沿着根结点往下走，走到这个结点的时候是否是一个单词的结尾
        public boolean isWord;
        // 因为这里不涉及排序操作，用哈希表也是可以的
        public TreeMap<Character, Node> next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            next = new TreeMap<>();
        }

        public Node() {
            this(false);
        }
    }

    private Node root;
    private int size;

    public Trie() {
        root = new Node();
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public void add(String word) {
        // root 是当前 Trie 对象的属性
        Node currNode = root;
        for (int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            if (currNode.next.get(c) == null) {
                currNode.next.put(c, new Node());
            }
            currNode = currNode.next.get(c);
        }
        // 如果已经添加过，才将 size++
        if (!currNode.isWord) {
            currNode.isWord = true;
            size++;
        }
    }

    public boolean contains(String word){
        Node currNode = root;
        Character currC;
        for (int i = 0; i < word.length(); i++) {
            currC = word.charAt(i);
            if (currNode.next.get(currC) == null) {
                return false;
            }
            currNode = currNode.next.get(currC);
        }
        return currNode.isWord;
    }

    public boolean isPrefix(String prefix) {
        Character c;
        Node currNode = root;
        for (int i = 0; i < prefix.length(); i++) {
            c = prefix.charAt(i);
            if (currNode.next.get(c) == null) {
                return false;
            }
            currNode = currNode.next.get(c);
        }
        // 只需要判断从树的根结点是不是很顺利地都能匹配单词的每一个字符，所以，能走到这里来，就返回 True
        return true;
    }
}
