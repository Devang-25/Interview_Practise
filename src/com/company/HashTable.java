package com.company;

import java.util.ArrayList;

public class HashTable<K,V> {
        private int maxBuckets;
        private int size;
        private ArrayList<HashTableNode<K,V>> bucket;

        public HashTable(){
            maxBuckets=10;
            size=0;
            bucket=new ArrayList<>();
            for(int i=0;i<maxBuckets;i++){
                bucket.add(null);
            }
        }

        public int size(){
            return size;
        }

        public boolean isEmpty(){
            return size==0;
        }

        // gets the index of the key
        private int getIndex(K key){
            int hashcode=key.hashCode();
            int index=hashcode%maxBuckets;
            return index;
        }


        public V remove(K key){
            int index=getIndex(key);
            HashTableNode<K, V> head=bucket.get(index);
            HashTableNode<K, V> prev=null;
            while(head!=null){
                if(head.key.equals(key))
                    break;
                prev=head;
                head=head.next;

            }
            if(head==null)
                return null;
            size--;
            if(prev!=null){
                prev.next=head.next;
            }
            else
                bucket.set(index,head.next);

            return head.value;

        }

        public V get(K key){
            int index=getIndex(key);
            HashTableNode<K, V> head=bucket.get(index);
            while(head!=null){
                if(head.key.equals(key))
                    return head.value;
                head=head.next;
            }
            return null;
        }

        public void add(K key,V value){
            int index=getIndex(key);
            HashTableNode<K, V> head=bucket.get(index);
            while(head!=null){
                if(head.key.equals(key))
                    head.value=value;
                head=head.next;
            }
            head=bucket.get(index);
            size++;
            HashTableNode<K,V> newNode=new HashTableNode<>(key,value);
            newNode.next=head;
            bucket.set(index,newNode);
            if((0.1*size)/maxBuckets >= 0.7){
                ArrayList<HashTableNode<K,V>> temp=bucket;
                bucket=new ArrayList<>();
                maxBuckets=2*maxBuckets;
                size=0;
                for(int i=0;i<maxBuckets;i++){
                    bucket.add(null);
                }
                for(HashTableNode<K,V> node: temp){
                    while(node!=null) {
                        add(node.key, node.value);
                        node=node.next;
                    }
                }
            }

        }
    public static void main(String[] args)
    {
        HashTable<String, Integer>map = new HashTable<>();
        map.add("this",1 );
        map.add("coder",2 );
        map.add("this",4 );
        map.add("hi",5 );
        System.out.println(map.size());
        System.out.println(map.remove("this"));
        System.out.println(map.remove("this"));
        System.out.println(map.remove("this"));
        System.out.println(map.size());
        System.out.println(map.isEmpty());
    }
}
