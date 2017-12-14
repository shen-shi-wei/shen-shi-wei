import Exception.registerexection.RegisterException;
import net.sf.json.JSONObject;
import org.dom4j.DocumentException;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;
import java.util.Scanner;

public class Main {

    private static final int REGISTER_CODE = 1;
    private static final int LOGIN_CODE = 2;
    private static final int 查询天气 = 1;
    private static final int 查询手机号归属地 = 2;
    private static final int 手速游戏 = 3;
    private static final int 查询手速游戏前十用户 = 4;
    private static final int 困难 = 1;
    private static final int 适中 = 2;
    private static final int 简单 = 3;

    public static void main(String[] args) throws DocumentException, IOException, InterruptedException {

        w:while (true){
            Scanner input = new Scanner(System.in);
            System.out.println("1.注册  2.登录");
            int choice = input.nextInt();
            input.nextLine();
            UserOperate uo = new UserOperate();
            switch (choice){
                case REGISTER_CODE:
                    System.out.println("请输入昵称");
                    String registernickname = input.nextLine();
                    System.out.println("请输入用户名");
                    String registerusername = input.nextLine();
                    System.out.println("请输入密码");
                    String registerpassword = input.nextLine();
                    try {
                        uo.register(registernickname,registerusername,registerpassword);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (RegisterException e) {
                        System.out.println(e.getMessage());
                    } catch (DocumentException e) {
                        e.printStackTrace();
                    }
                    break;
                case LOGIN_CODE:
                    System.out.println("请输入用户名");
                    String loginusername = input.nextLine();
                    System.out.println("请输入密码");
                    String loginpassword = input.nextLine();
                    Users loginusers = uo.login(loginusername, loginpassword);
                    if (loginusers != null){
                        System.out.println("昵称为："+loginusers.getNickname());
                        break w;
                    }
            }
        }
        q:while (true){
            System.out.println("1.查询天气,2.查询手机号归属地,3.手速游戏,4.查询手速游戏前十用户");
            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();

            switch (choice) {
                case 查询天气:
//                    weatherSelect();
                case 查询手机号归属地:
//                    AreaSelect();
                case 手速游戏:
                    System.out.println("选择等级：1.困难（30个字符），2.适中（20个字符），3.简单（10个字符）");
                    int choice1 = input.nextInt();
                    switch (choice1){
                        case 困难:

                        case 适中:

                        case 简单:
                            for (int i = 3; i > 0; i--) {
                                System.out.println("倒计时"+i+"秒钟后开始");
                                Thread.sleep(1000);
                            }
                            String val = "";
                            Random random = new Random();

                            //参数length，表示生成几位随机数
                            for(int i = 0; i < 10; i++) {

                                String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
                                //输出字母还是数字
                                if( "char".equalsIgnoreCase(charOrNum) ) {
                                    //输出是大写字母还是小写字母
                                    int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
                                    val += (char)(random.nextInt(26) + temp);
                                } else if( "num".equalsIgnoreCase(charOrNum) ) {
                                    val += String.valueOf(random.nextInt(10));
                                }
                            }
                            System.out.println("开始");
                            System.out.println("随机生成字符串为:"+val);
                            String inputchar = input.nextLine();


                    }

                case 查询手速游戏前十用户:

            }

        }
    }

//    @Test
//    public void AreaSelect() throws IOException {
//        URL url = new URL("http://api.k780.com/?app=phone.get&phone=13806279231&appkey=29836&sign=4fe58a60443a900a251f8b05763d4622&format=json");
//        InputStream in = url.openStream();
//        ByteArrayOutputStream out = new ByteArrayOutputStream();
//        try {
//            byte buf[]=new byte[1024];
//            int read = 0;
//            while ((read = in.read(buf)) > 0) {
//                out.write(buf, 0, read);
//            }
//        }  finally {
//            if (in != null) {
//                in.close();
//            }
//        }
//        byte b[]=out.toByteArray( );
//        System.out.println(new String(b,"utf-8"));
//    }

    @Test
    public  void weatherSelect() throws IOException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你要查询的城市名称");
        String cityname = scanner.nextLine();

        URL url = new URL("http://api.k780.com/?app=weather.today&weaid=2&&cityname="+cityname+"&appkey=10003&" +
                "sign=b59bc3ef6191eb9f747dd4e83c99f2a4&format=json");
        InputStream in = url.openStream();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            byte buf[]=new byte[1024];
            int read = 0;
            while ((read = in.read(buf)) > 0) {
                out.write(buf, 0, read);
            }
        }  finally {
            if (in != null) {
                in.close();
            }
        }
        byte b[]=out.toByteArray( );
        System.out.println(new String(b,"utf-8"));
//        String str = new String(b,"utf-8");
//        JSONObject joss = JSONObject.fromObject(str);
//        Object o = JSONObject.toBean(joss, Book.class);
//        Book weather = (Book) o;
    }
}
