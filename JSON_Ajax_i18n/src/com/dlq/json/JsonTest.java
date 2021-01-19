package com.dlq.json;

import com.dlq.pojo.Person;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;

import java.util.*;

/**
 *@program: Java_Web
 *@description:
 *@author: Hasee
 *@create: 2021-01-19 18:14
 */
public class JsonTest {

    //javaBean和json的互转
    @Test
    public void test1() {
        Person person = new Person(1,"张三");
        //创建Gosn实例
        Gson gson = new Gson();
        // toJson()：方法可以把java对象转换成为json字符串
        String persinJsonString = gson.toJson(person);
        System.out.println(persinJsonString);
        // fromJson()：方法可以把json字符串转换回Java对象
        // 第一个参数是json字符串
        // 第二个参数是转换回去的Java对象类型
        Person person1 = gson.fromJson(persinJsonString, Person.class);
        System.out.println(person1);
    }

    //List和json的互转
    @Test
    public void test2() {
        List<Person> list = new ArrayList<>();
        list.add(new Person(1,"张三"));
        list.add(new Person(1,"李四"));
        System.out.println(list);

        Gson gson = new Gson();
        // 把List转换为json字符串
        String listToJson = gson.toJson(list);
        System.out.println(listToJson);

        //把json字符串转换回List
        ArrayList<Person> arrayList = gson.fromJson(listToJson, new PersonListType().getType());
        System.out.println(arrayList);
        Person person = arrayList.get(0);
        System.out.println(person);
    }

    //map和json的互转
    @Test
    public void test3() {
        Map<Integer,Person> personMap = new HashMap<>();
        personMap.put(1,new Person(1,"张三"));
        personMap.put(2,new Person(2,"张三"));

        Gson gson = new Gson();
        //把 Map 集合转化成为json字符串
        String personMapToJsonString = gson.toJson(personMap);
        System.out.println(personMapToJsonString);

        //把 json字符串转换回 Map集合
        //Map<Integer, Person> personJsonToMap = gson.fromJson(personMapToJsonString,
        //        new PersonMapType().getType());
        Map<Integer,Person> personJsonToMap = gson.fromJson(personMapToJsonString,
                new TypeToken<Map<Integer,Person>>(){}.getType());
        System.out.println(personJsonToMap);
        Person p = personJsonToMap.get(1);
        System.out.println(p);
    }
}
