package com.skills.utils;

import com.skills.composer.Composer;

import java.util.*;

public class CollectionsUtil {
    public static <E, V> Map<E, List<V>> groupMapComposerId(Collection<V> collection, Composer<E, V> c) {
        Map<E, List<V>> map = new HashMap(collection.size());

        Object v;
        Object list;
        for(Iterator iterator = collection.iterator(); iterator.hasNext(); ((List)list).add(v)) {
            v = iterator.next();
            E composerId = c.getComposerId((V) v);
            list = (List)map.get(composerId);
            if (list == null) {
                list = new LinkedList();
                map.put(composerId, (List)list);
            }
        }

        return map;
    }

    public static <E, V> Map<E, V> mapComposerId(Collection<V> collection, Composer<E, V> c) {
        Map<E, V> map = new HashMap(collection.size());
        Iterator iterator = collection.iterator();

        while(iterator.hasNext()) {
            V v = (V) iterator.next();
            map.put(c.getComposerId(v), v);
        }

        return map;
    }


}
