package Project;


import org.dom4j.DocumentException;

import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipException;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("请选择： 1  注册   2  登录");
        Scanner input=new Scanner(System.in);
        int a = input.nextInt();
       k: switch (a){
            case 1:
                System.out.println("请输入你的昵称");
                Scanner inputss=new Scanner(System.in);
                String name=inputss.nextLine();
                String regex="[a-zA-Z]{1}[a-zA-Z0-9_]{1,15}";
                boolean name1 = Pattern.matches(regex, name);
                if (!name1){
                    System.out.println("你输入的昵称有误！！");
                }
                System.out.println("请输入注册账号");
                Scanner inputs=new Scanner(System.in);
                String username=inputs.nextLine();
                String regexPhone = "[1][38]\\d([-]{0,1})\\d{4}([-]{0,1})\\d{4}";
                regex = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
//                Pattern pattern = Pattern.compile("^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$");
//                Matcher matcher = pattern.matcher(username);
//                boolean matches = matcher.matches();
//                boolean flg= false;
//                flg = matches
//                if (flg == true)
                boolean isMatched = Pattern.matches(regexPhone, username);
                boolean iss = Pattern.matches(regex, username);
                iss=true;
                isMatched=true;

                if (!isMatched){
                    System.out.println("账号格式错误,请输入手机号或者邮箱！！！");
                    break;
                }else if (!iss){
                    System.out.println("账号格式错误,请输入手机号或者邮箱！！！");
                }
                System.out.println("请输入注册密码");
                Scanner inputsss=new Scanner(System.in);
                String password=inputsss.nextLine();
                try {
                    Register.register(name, username, password);
                } catch (ZuceExcePtion zuceExcePtion) {
                    zuceExcePtion.printStackTrace();
                    break;
                }
                break k;
            case 2:
                System.out.println("请输入登录账号");
                Scanner inputssss=new Scanner(System.in);
                String username1=inputssss.nextLine();
                System.out.println("请输入登录账号");
                Scanner inputsssss=new Scanner(System.in);
                String password1=inputsssss.nextLine();

                    Login.login(username1,password1);


                System.out.println("请选择：1  查询天气   2  查询手机归属地  3  手速游戏  4  查询手速游戏前十用户");
                int b=input.nextInt();
                switch (b){
                    case 1:
                        System.out.println("请输入你的城市名：");
                        Scanner vv=new Scanner(System.in);
//                       sc.nextLine();

                       U.tq(vv.nextLine());
                    case 2:
                        System.out.println("请先输入你的手机号：");
                        break;
                    case 3:
                        System.out.println("请选择1  困难  2适中  3简单");
                        Scanner c=new Scanner(System.in);
                        int i = c.nextInt();
                        switch (i){
                            case 1:
                                Game.KNyouxi();
                                break;
                            case 2:
                                Game.SZyouxi();
                                break;
                            case 3:
                                Game.JDyouxi();
                                break;
                                default:
                                    System.out.println("---------");
                        }
                    case 4:
//                        System.out.println("1  查询第一   2  查询前十");
//                        Scanner scanner=new Scanner(System.in);
//                        int y=scanner.nextInt();
//                        switch (y){
//                            case 1:
//                                Demand.One.cxone();
//                            case 2:
//                                Demand.Ten.cxten();
//
//                        }




                }
        }
    }
}
