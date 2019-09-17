package com.sky.model;

public class MyException extends Exception{

    private String exceptionName; //定义一个私有变量,用来为自定义异常
    public MyException(){} //创建一个无参数的构造函数
    public MyException(String exceptionName){ //创建一个有参数的构造函数,传入的参数为前面定义的异常名称
        this.exceptionName=exceptionName;
    }
    public String getExceptionName()
    { //定义一个方法,提供给外部来获取私有变量
        return this.exceptionName;
    }
}
