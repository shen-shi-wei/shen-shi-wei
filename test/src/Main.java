import Exception.registerexection.RegisterException;
import bean.Users;
import org.dom4j.DocumentException;
import utils.Constants;
import utils.Tool;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
    private static List<Character> difficult;
    private static List<Character> middle;
    private static List<Character> easy;
    private static final int TIMES_DIFFICULT = 30;
    private static final int TIMES_MIDDLE = 20;
    private static final int TIMES_EASY = 10;
    private static Tool netTool;
    private static Random random;
    private static String nickname = "lipapa";

    public static void main(String[] args) throws DocumentException, IOException, InterruptedException, SQLException {

        w:while (true){
            Scanner input = new Scanner(System.in);
            System.out.println("1.注册  2.登录 3.修改个人信息 4.销户");
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
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case LOGIN_CODE:
                    System.out.println("请输入用户名");
                    String loginusername = input.nextLine();
                    System.out.println("请输入密码");
                    String loginpassword = input.nextLine();
                     uo.login(loginusername, loginpassword);
                    break w;
                default:
                    System.out.println("您的输入有误，请重新输入");
                    break ;
            }
        }
        q:while (true){
            System.out.println("1.查询天气,2.查询手机号归属地,3.手速游戏,4.查询手速游戏前十用户");
            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();

            switch (choice) {
                case 查询天气:
//                    weatherSelect();
                    break ;
                case 查询手机号归属地:
//                    AreaSelect();
                    break ;
                case 手速游戏:
                    initGame();
                    System.out.println("选择等级：1.困难（30个字符），2.适中（20个字符），3.简单（10个字符）");
                    int choice1 = input.nextInt();
                    switch (choice1){
                        case 困难:
                            startGame(difficult,TIMES_DIFFICULT);
                            break ;
                        case 适中:
                            startGame(middle,TIMES_MIDDLE);
                            break ;
                        case 简单:
                            startGame(easy,TIMES_EASY);
                            break ;
                        default:
                            System.out.println("您的输入有误，请重新输入");
                            break ;
                    }
                    break ;
                case 查询手速游戏前十用户:

                    List<Users> users = netTool.pullJsonArray(Constants.URL_TEN, Users.class);
                    for (int i = 0; i < users.size(); i++) {
                        Users user = users.get(i);
                        int index = i + 1;
                        System.out.println("第" + index + "名：\t昵称：" + user.getNickname() + "\t成绩：" + user.getScore());
                    }
                    break;
                default:
                    System.out.println("您的输入有误，请重新输入");
                    break ;
            }

        }
    }

    private static void initGame() {
        difficult = new ArrayList();
        middle = new ArrayList<>();
        easy = new ArrayList<>();
        //32是空格，126是~
        for (char i = 32; i <= 126; i++) {
            difficult.add(i);
        }

        //大写字母
        for (char i = 65; i <= 90; i++) {
            middle.add(i);
        }
        //小写字母
        for (char i = 97; i <= 122; i++) {
            middle.add(i);
        }
        //数字
        for (char i = 48; i <= 57; i++) {
            middle.add(i);
        }


        //小写字母
        for (char i = 97; i <= 122; i++) {
            easy.add(i);
        }
        //数字
        for (char i = 48; i <= 57; i++) {
            easy.add(i);
        }
    }

    public static void startGame(List<Character> cs, int times) {
        StringBuilder game = new StringBuilder();
        for (int i = 0; i < times; i++) {
            int index = random.nextInt(cs.size() - 1);
            game.append(cs.get(index));
        }

        for (int i = 3; i >= 0; i--) {
            if (i == 0) {
                System.out.println("游戏开始：");
            } else {
                System.out.println("倒计时" + i + "秒后开始");
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(game);

        long start = System.currentTimeMillis();
        Scanner input = new Scanner(System.in);
        input.nextLine();
        String receive = input.nextLine();

        if (game.toString().equals(receive)) {
            long end = System.currentTimeMillis();
            long score = end - start;

            Number number = new Long(score);
            int time = number.intValue();

            System.out.println("恭喜您，成绩为：" + time + "毫秒");

            String result = netTool.pushScore(Constants.URL_INSERT, nickname, time);

            if (result.equals("SUCCESS")) {
                System.out.println("成绩以提交成功");
            }

            Users users = netTool.pullXml(Constants.URL_FIRST, Users.class);
            System.out.println("目前第一名为：" + users.getNickname() + "\t成绩为" + users.getScore());

        } else {
            System.out.println("游戏失败");
        }

    }

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

//    public  void weatherSelect() throws IOException {
//
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("请输入你要查询的城市名称");
//        String cityname = scanner.nextLine();
//
//        URL url = new URL("http://api.k780.com/?app=weather.today&weaid=2&&cityname="+cityname+"&appkey=10003&" +
//                "sign=b59bc3ef6191eb9f747dd4e83c99f2a4&format=json");
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
//        String str = new String(b,"utf-8");
//        JSONObject joss = JSONObject.fromObject(str);
//        Object o = JSONObject.toBean(joss, bean.Book.class);
//        bean.Book weather = (bean.Book) o;
//    }
}
