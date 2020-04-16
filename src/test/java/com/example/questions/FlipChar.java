package com.example.questions;

import org.assertj.core.util.Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FlipChar {
    public static void main(String[] args) {
        UpsideDown("hello     world   !");
    }

    /**
     * 翻转字符串输出（）
     * 20200410
     */

    protected static void UpsideDown(String str){
        List  strList = Arrays.asList(str.trim().split(" +"));//正则匹配空格分隔字符
        Collections.reverse(strList);//翻转
        System.out.println(String.join(" ", strList));//连接字符输出
    }




}
