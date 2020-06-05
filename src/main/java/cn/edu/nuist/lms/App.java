package cn.edu.nuist.lms;

import cn.edu.nuist.lms.model.Literature;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello World");
        App.test();
    }

    static void test(){
        Literature literature = new Literature();
        System.out.println(literature);
    }
}