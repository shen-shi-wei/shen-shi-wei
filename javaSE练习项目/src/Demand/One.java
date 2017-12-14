package Demand;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class One {
    public  static void cxone() throws IOException {
        URL url = new URL("http://192.168.20.194:8080/day16/first?");
        byte[] buff = new byte[1024];
        URLConnection urlConnection = url.openConnection();
        InputStream is = urlConnection.getInputStream();
        int len = 0;
        StringBuffer sb = new StringBuffer();
        while ((len = is.read(buff)) != -1) {
            sb.append(new String(buff, 0, len));

            System.out.println(sb);
            sb.setLength(0);
        }
    }

}
