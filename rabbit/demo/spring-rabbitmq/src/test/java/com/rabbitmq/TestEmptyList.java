package com.rabbitmq;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class TestEmptyList {
    public static void main(String[] args) {
        List<String> list = Collections.emptyList();
        String test = list.get(0);

    }
}
