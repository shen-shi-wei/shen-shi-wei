package Project;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.time;

public class Game {
    public static  void daojishi(){
        long tt;
        new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 3; i >0; i--) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                        System.out.println("游戏倒计时："+i);
                }
                }
            }).start();
            }
    public static void kaishi(){
       new Thread(new Runnable() {
            @Override
            public void run() {
                for (int a = 1; a >0 ; a--) {
                    try {
                        Thread.sleep(4000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    String str=KN.getRandomString();
                    System.out.println("游戏开始啦  快！！    " +"请输入："+  str);
                    //开始时间
                    Date date = new Date();
                    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                    String t = dateFormat.format(date);
                    String b = str;
                    Scanner input = new Scanner(System.in);
                    String n = input.nextLine();
                    if (b.equals(n)) {
                        System.out.println("恭喜挑战成功！！！");
                        Date date1 = new Date();
                        DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                        String t1 = dateFormat.format(date1);
                        //System.out.println(t1);
                        long time1 = date1.getTime();
                        long time = date.getTime();
                        long tt=(time1-time);
                        System.out.print("游戏所花时间为："+tt+"毫秒");
                        try {

                            U.put("xuhan",tt);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println("输入错误  GG思密达！！！！");
                    }
                }
            }
        }).start();
    }
    public static void SZyouxi(){
        daojishi();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int a = 1; a >0 ; a--) {
                    try {
                        Thread.sleep(4000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    String str= SZ.getRandomString();
                    System.out.println("游戏开始啦  快！！    " +"请输入："+  str);
                    //开始时间
                    Date date = new Date();
                    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                    String t = dateFormat.format(date);
                    String b = str;
                    Scanner input = new Scanner(System.in);
                    String n = input.nextLine();
                    if (b.equals(n)) {
                        System.out.println("恭喜挑战成功！！");
                        Date date1 = new Date();
                        DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                        String t1 = dateFormat.format(date1);
                        //System.out.println(t1);
                        long time1 = date1.getTime();
                        long time = date.getTime();
                        long tt=(time1-time);
                        System.out.print("游戏所花时间为："+tt+"毫秒");
                        try {
                            System.out.println("");
                            U.put("xuhan",tt);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println("输入错误  GG思密达！！！！");
                    }
                }
            }
        }).start();
    }
    public static void KNyouxi(){
        daojishi();
        kaishi();
    }
    public static void time() {
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String t = dateFormat.format(date);
        System.out.print(t);
    }
    public static void JDyouxi(){
        daojishi();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int a = 1; a >0 ; a--) {
                    try {
                        Thread.sleep(4000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    String str= JD.getRandomString();
                    System.out.println("游戏开始啦  快！！    " +"请输入："+ str);
                    //开始时间
                    Date date = new Date();
                    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                    String t = dateFormat.format(date);
                    String b = str;
                    Scanner input = new Scanner(System.in);
                    String n = input.nextLine();
                    if (b.equals(n)) {
                        System.out.println("恭喜挑战成功！！");
                        Date date1 = new Date();
                        DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                        String t1 = dateFormat.format(date1);
                        //System.out.println(t1);
                        long time1 = date1.getTime();
                        long time = date.getTime();
                        long tt=(time1-time);
                        System.out.print("游戏所花时间为 ："+tt+"毫秒");
                        try {
                            System.out.println("");
                            U.put("d",tt);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println("输入错误  GG思密达！！！");
                    }


                }
            }
        }).start();





    }



}



