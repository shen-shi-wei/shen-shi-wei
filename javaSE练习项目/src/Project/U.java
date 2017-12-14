package Project;

import net.sf.json.JSONObject;
import org.junit.Test;
import org.xmlpull.v1.XmlPullParser;

import javax.xml.stream.XMLStreamReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class U {
    public static void put(String n, long t) throws IOException {
        URL url = new URL("http://192.168.20.194:8080/day16/insert?" + "username=" + n + "&score=" + t);
//    http://192.168.20.194:8080/day16/first?"+"nicheng"+n+"score"+tt
        URLConnection urlConnection = url.openConnection();
        byte[] buff = new byte[1024];
        InputStream is = urlConnection.getInputStream();
        int len = 0;
        StringBuffer sb = new StringBuffer();
        while ((len = is.read(buff)) != -1) {
            sb.append(new String(buff, 0, len));
            System.out.println(sb);
//            XMLStreamReader xmlStreamReader=new XMLStreamReader() ;
            sb.setLength(0);
        }
    }

    public static void tq(String s) throws IOException {

//        s = "1";
        URL url = new URL("http://api.k780.com/?app=weather.future&weaid= "+s+"&&appkey=30514&sign=4774b193caa6837532310bea8cd7972f&format=json");
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
//        System.out.println(new String(b,"utf-8"));
        String str = new String(b,"utf-8");
        Map map = new HashMap();
        map.put("result",CheckTheWeather.ResultBean.class);
//        System.out.println(str);
        JSONObject joss = JSONObject.fromObject(str);
        CheckTheWeather tQapi=(CheckTheWeather) JSONObject.toBean(joss, CheckTheWeather.class, map);
        List<CheckTheWeather.ResultBean> result = tQapi.getResult();
//        System.out.println(result);
        for (CheckTheWeather.ResultBean resultBean : result) {
            System.out.println(resultBean.getDays());
            System.out.println("城市:"+resultBean.getCitynm() + '\n'+"天气:" +resultBean.getWeather());
        }
//        System.out.println(tQapi.getResult().toString());


    }
}









//    public static void cxone() throws IOException {
//        URL url = new URL("http://192.168.20.194:8080/day16/first?");
//        byte[] buff = new byte[1024];
//        URLConnection urlConnection = url.openConnection();
//        InputStream is = urlConnection.getInputStream();
//        int len = 0;
//        StringBuffer sb = new StringBuffer();
//        while ((len = is.read(buff)) != -1) {
//            sb.append(new String(buff, 0, len));
//            System.out.println(sb);
//            sb.setLength(0);
//        }
//    }
//
//    public static void cxten() throws IOException {
//        URL url = new URL("http://192.168.20.194:8080/day16/ten");
//        byte[] buff = new byte[1024];
//        URLConnection urlConnection = url.openConnection();
//        InputStream is = urlConnection.getInputStream();
//        int len = 0;
//        StringBuffer sb = new StringBuffer();
//        while ((len = is.read(buff)) != -1) {
//            sb.append(new String(buff, 0, len));
//            System.out.println(sb);
//            sb.setLength(0);
//        }
//    }
//}
