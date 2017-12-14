package Project;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.List;

public class Login {
    public static void login(String username,String password) throws DocumentException, Exception, BuCunZaiLoginException, MiMaLoginException {
        SAXReader reader=new SAXReader();
        Document read = reader.read(new File("C:/Users/lanou3g/untitled/javaSE练习项目/src/out.xml"));
        Element rootElement = read.getRootElement();

        List<Element> list= rootElement.elements("user");
        for (Element element : list) {
            Element username1 = element.element("username");
            Element password1 = element.element("password");
            //System.out.println(username1.getText());
            if (username1.getText().equals(username)&&password1.getText().equals(password)){
                System.out.println("登录成功！！！");
                Attribute name = element.attribute("name");
                System.out.println("用户姓名为："+name.getValue());

                break;
            } else //System.out.println("111");
                if (username1.getText().equals(username)&&!(password1.getText().equals(password)))
                    throw new MiMaLoginException();
                else //System.out.println("2222");
                    if (!(username1.getText().equals(username))&&!(password1.getText().equals(password)))
                        throw new BuCunZaiLoginException();
        }



    }



}
