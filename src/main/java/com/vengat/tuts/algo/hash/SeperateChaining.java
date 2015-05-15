package com.vengat.tuts.algo.hash;

/**
 * Created by veramanan on 4/23/14.
 * <p>Seperate chaining works on the following rules
 * A key is hashed to an int value .i.e. the hash function will map each key to an index in the table
 * An array of size M is initialized
 * Usually the M size would be smaller than the number of Keys n
 * So when the key is hashed, the value is stored in the array's index whose value
 * corresponds to the hash value. If the index has already a value, of the key stored, we store the value in the next node
 * in the same index
 * :) Yes, we will maintain a linked list in each index
 *
 * </p>
 */
public class SeperateChaining<Key, Value> {

    private int M = 97;

    private Node[] st = new Node[M];

    private static class Node {
        private Object key;
        private Object val;
        private Node next;
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    /**
     * <p>
     * While searching, the key is hashed and the corresponding index is identified in the table
     * We iterate over the linked list till we find the value
     * </p>
     * @param key
     * @return
     */
    public Value get(Key key) {
        int i = hash(key);
        for(Node x= st[i]; x !=null; x = x.next) {
            if(key.equals(x.key)) return (Value) x.val;
        }
        return null;
    }




}
