package com.vnpt.cache;

/**
 * @author HieuDM24
 * @date 8/6/2022
 */

public interface ICache<K, V> {

    void clear();

    boolean containsKey(Object key);

    V get(Object key) throws Exception;

    boolean isEmpty();

    V put(K key, V value);

    V remove(Object key);

    int size();
}
