package com.company;

public class HashTableNode<K,V> {
    public K key;
    public V value;
    HashTableNode<K,V> next;

    public HashTableNode(K key,V value){
        this.key=key;
        this.value=value;
    }
}
