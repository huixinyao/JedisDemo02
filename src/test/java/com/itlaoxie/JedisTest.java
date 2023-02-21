package com.itlaoxie;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * @description:  JedisTest
 * @author:huixinyao  快速上手
 * @create: 2023-02-20 10:54
 **/
public class JedisTest {
//    public static void main(String[] args) {
//        test01();
//    }

    @Test
    public void test01(){
        //第一步：连接Redis
        Jedis jedis = new Jedis("127.0.0.1", 6379);


        //第二步：针对于数据设置或者获取
        jedis.set("infoFromJava","Jedis");  //存

        String infoFromJava = jedis.get("infoFromJava"); //取
        System.out.println("infoFromJava = " + infoFromJava); //输出


        //关闭Redis连接
        jedis.close();
    }

    @Test
    public void test02(){
        //第一步：连接Redis
        Jedis jedis = new Jedis("127.0.0.1", 6379);


        //第二步：针对于数据设置或者获取
        Long rpush = jedis.rpush("names", "Andy", "Jack", "Jim", "Lucy");  //存 list
        System.out.println("rpush = " + rpush);  //输出list元素个数

        List<String> names = jedis.lrange("names", 0, -1);  //取出

        for (String name : names) {  //输出
            System.out.println(name);
        }


        //关闭Redis连接
        jedis.close();
    }


}
















