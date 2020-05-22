package com.example.questions;

public class StrTest {
    public static void main(String[] args) {
        StrTest test = new StrTest();
        test.isMax("eleetminicoworoep");
    }

    String[] str = {"a","e","i","o","u"};
    String oldStr= "";
    int count = 0;
    private void isMax(String elecommmeo) {
      String  len = elecommmeo;
      if (len.length() < 2){
          return;
      }
      getNewStr(len);

    }


    private void getNewStr(String len) {
        String newStr = "";
        for (int i = 0; i < len.length()+1; i++) {
            newStr = len.substring(i,len.length());
            if (newStr.length() < 2)continue;
            for (String s:str ) {
                querty(s,newStr);
            }
            if((count&1) != 1){
                if(oldStr.length() < newStr.length()) {
                   oldStr = newStr;
                    System.out.println("oldStr ====== " + oldStr);
                }
            }
        }
    }

    private void querty(String s, String newStr) {

        int xb = 0;
        xb  =  newStr.indexOf(s);
        if(xb != -1){
            querty(s,newStr.substring(xb+1,newStr.length()));
          count++;
        }
    }


    int StrTest(int cc, String s) {
        System.out.printf("na's :" +s);
        if ( s != null) {
            System.out.println("s = " + s);
        }
        return cc;
    }
}
