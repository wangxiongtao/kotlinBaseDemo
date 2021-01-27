package com.dawn.lib;

public abstract class MyView {
    public MyView(int a){
        System.out.println("MyView==2="+a);

    }
    public MyView(int a,int b){
        System.out.println("MyView==2="+a+"---"+b+"----");
    }
    public MyView(int a,int b,int c){
        System.out.println("MyView==3="+a+"---"+b+"----"+c);
    }

    public static void main(String[] args) {
        new MyKotlinView(1,8,10000);
    }



}
class MyV extends MyView{

    public MyV(int a) {
        super(a);
    }

    public MyV(int a, int b) {
        super(a, b);
    }

    public MyV(int a, int b, int c) {
        super(a, b, c);
    }
}


