package com.example.demo.yewu;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * TODO 添加类的描述
 *
 * @author gqq
 * @version 1.0, 2021/6/8 11:48
 */
public class Test {

    public void getRecord(Consumer<? super Record> action){
        List<Record> list = new ArrayList<>();
        list.add(new Record(1L,"gqq",1));
        list.add(new Record(2L,"gqq2",2));
        list.forEach(action);
        System.out.println(list);
    }

    public static void main(String[] args) {
        Test test = new Test();
        Consumer<? super Record> action = record -> {
            record.setAge(999);record.setName("lalal");
        };
        test.getRecord(action);
    }

}
