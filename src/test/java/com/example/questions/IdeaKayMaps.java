package com.example.questions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class IdeaKayMaps {


    private int max;
    private int anInt;
    private static int i;
    Map map ;

    public static void main(String[] args, String sayHello) {
        List<String> list = new ArrayList();
        list.add("13");
        getMax(list, 9, sayHello);
        getMax(list, 9,"sayHello");
        getMax(list, 9,"sayHello");
        getMax(list, 9, "sayHello");
        getMix();
    }

    private static void getMix() {
        List<String> list = null;
        foo(list, "sayHello");

        getSayHello(list);

        getMax(list, 9,"sayHello");
        sss(list, "sayHello");
    }

    private static void sss(List<String> list, String sayHello) {
        getMax(list, 9, sayHello);
    }

    private static void getSayHello(List<String> list) {
        getMax(list, 9,"sayHello");
    }

    private static void foo(List<String> list, String sayHello) {
        getMax(list, 9, sayHello);
        getMax(list, 9, "sayHello");
    }

    private static void getMax(List<String> list, int Max, String sayHello) {
        getMax(list, Max, sayHello, "username is zhangsan");
    }

    private static void getMax(List<String> list, int Max, String sayHello, String zhangsan) {
        int i = 0;

        forf(list, zhangsan, i);

    }

    private static void forf(List<String> list, String zhangsan, int i) {
        for (String item : list) {
            i += 1;
            System.out.printf("item = %s%n", item);
            getOutp(zhangsan, i, item);

        }
    }

    private static void getOutp(String zhangsan, int i, String item) {
        outp(zhangsan, i, item);
    }

    private static void outp(String zhangsan, int i, String item) {
        System.out.printf("name :%s  nj : %d%n  x:", item, i, "key");
        System.out.println(zhangsan);
    }


}

