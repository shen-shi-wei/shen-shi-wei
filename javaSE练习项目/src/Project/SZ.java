package Project;

import java.util.Random;

public class SZ {
    public static String getRandomString(){
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<1;i++){
            int number =random.nextInt(42);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }
}
