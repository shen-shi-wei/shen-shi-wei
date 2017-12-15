package utils;

import bean.Users;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.Dom4JDriver;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class Tool {

    public String pushScore(String url,String nickname,int score){
        String pushscoreurl = url + "?" + "username="+nickname+"&score=" + score;

        String json = getResultString(pushscoreurl);
        return json;
    }

    /**
     * 拉取结果为json对象的请求
     * @param url
     * @param clazz 指定要将json转换成的实体类类型
     * @param <T>
     * @return
     */
    public <T> T pullJsonObject(String url, Class<T> clazz) {

        String json = getResultString(url);

        JSONObject jsonObject = JSONObject.fromObject(json);
        T t = (T) JSONObject.toBean(jsonObject);

        return t;

    }

    /**
     * 拉取结果为xml数据的请求
     * @param url
     * @param clazz 指定要将xml转换成的实体类类型
     * @param <T>
     * @return
     */
    public <T> T pullXml(String url,Class<T> clazz){
        String xml = getResultString(url);
        XStream xStream = new XStream(new Dom4JDriver());
        xStream.alias("User", Users.class);
        T t = null;
        try {
            t = (T) xStream.fromXML(xml,clazz.newInstance());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return t;
    }

    public <T> List<T> pullJsonArray(String url, Class<T> clazz) {

        String json = getResultString(url);

        JSONArray jsonArray = JSONArray.fromObject(json);
        List<T> list = null;
        try {
            list = jsonArray.toList(jsonArray, clazz.newInstance(), new JsonConfig());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 获得访问的字符串结果
     * 可能是xml
     * 可能是json
     * @param url
     * @return
     */

    public String getResultString(String url) {
        StringBuilder sb = new StringBuilder();
        try {
            URL u = new URL(url);
            URLConnection conn = u.openConnection();
            InputStream is = conn.getInputStream();

            byte[] bytes = new byte[1024];

            int len = 0;
            while ((len = is.read(bytes)) != -1) {
                String str = new String(bytes, 0, len);
                sb.append(str);
            }

            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
