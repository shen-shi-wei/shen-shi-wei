package Project;

import java.util.Random;

public class KN {
    public static String getRandomString(){
        String str="/.,\';][=-~!@#$%^&*()_+}{|?><1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random=new Random();

        StringBuffer sb=new StringBuffer();

        for(int i=0;i<30;i++){

            int number =random.nextInt(91);

            sb.append(str.charAt(number));
        }
        return sb.toString();
    }

}
