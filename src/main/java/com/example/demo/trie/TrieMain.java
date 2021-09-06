package com.example.demo.trie;

/**
 * TODO 添加类的描述
 *
 * @author gqq
 * @version 1.0, 2021/4/24 17:41
 */
public class TrieMain {


    public static void main(String[] args) {
        char[] text1 = new char[]{'a','b','c','d'};
        char[] text2 = new char[]{'b','c','d'};
        char[] text3 = new char[]{'b','c'};
        char[] text4 = new char[]{'c','d'};
        TestTrie testTrie = new TestTrie();
        testTrie.insert(text1);
        testTrie.insert(text2);
        testTrie.insert(text3);
        testTrie.insert(text4);
        testTrie.buildFailurePointer();
        System.out.println(testTrie.root2);

    }

}
