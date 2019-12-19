package com.company;

import java.util.*;

public class Solution {

    static <T> ArrayList<T> newArrayList(T[] arr) {
        return new ArrayList<>(Arrays.asList(arr));
    }

    static <T> HashSet<T> newHashSet(T[] arr) {
        return new HashSet<>(Arrays.asList(arr));
    }

    static <K, V> HashMap<K, V> newHashMap(MapPair<K, V>[] arr) {
        HashMap<K, V> map = new HashMap<>();
        for(MapPair<K, V> pair : arr) {
            map.put(pair.key, pair.value);
        }
        return map;
    }

    static class MapPair<K, V> {
        public K key;
        public V value;
        public MapPair(K k, V v) {
            key = k;
            value = v;
        }
    }
}