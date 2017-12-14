package Project;

import java.util.Random;

public class JD {
    public static String getRandomString(){
        String str="1234567890abcdefghijklmnopqrstuvwxyz0123456789";
        Random random=new Random();

        StringBuffer sb=new StringBuffer();

        for(int i=0;i<10;i++){

            int number =random.nextInt(36);

            sb.append(str.charAt(number));
        }
        return sb.toString();
    }
//    public static void main(String[] args) {
//        System.out.println(getRandomString(10));
//    }
}
