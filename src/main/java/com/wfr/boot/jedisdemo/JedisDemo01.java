package com.wfr.boot.jedisdemo;

import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class JedisDemo01 {

    public static void main(String[] args) {
//        Jedis jedis = new Jedis("192.168.200.130", 6379);
//        String ping = jedis.ping();
//        System.out.println(ping);

        ArrayList strings = new ArrayList<>();

        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
        }

        // 编译类型是List 运行类型是ArrayList
        List strings1 = new ArrayList<>();
        Collection strings2 = new ArrayList<>();

    }
}



