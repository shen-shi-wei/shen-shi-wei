package Project;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Register {
    public static void register(String name,String username,String password) throws DocumentException,IOException, ZuceExcePtion {
        SAXReader reader=new SAXReader();
        Document read = reader.read(new File("C:/Users/lanou3g/untitled/javaSE练习项目/src/out.xml"));
        Element users = read.getRootElement();
        if (users==null){
            read.addElement("users");
            users = read.getRootElement();
        }
        List user = users.elements("user");
        List<Element>list;

        if (user==null){
            users.addElement("user");
        }
        list=users.elements();
        for (Element element : list) {
            Element username1 = element.element("username");
            if (username1==null){
                element.addElement("uesrname");
                username1=element.element("username");
            }
            Element password1 = element.element("password");
            if (password1==null){
                element.addElement("password");
                password1=element.element("password");
            }
            if (username1.getText().equals(username)){
                throw new ZuceExcePtion();
            }if (!username1.getText().equals(username)){

                Element element1 = users.addElement("user");
                element1.addAttribute("name",name);
                element1.addElement("username").addText(username);
                Element element2 = element1.addElement("password");
                element2.addText(password);

                System.out.println("注册成功！！");
            }
        }

        OutputFormat outputFormat = OutputFormat.createPrettyPrint();
        outputFormat.setEncoding("utf-8");
        XMLWriter xmlWriter=new XMLWriter(new FileWriter("C:/Users/lanou3g/untitled/javaSE练习项目/src/out.xml"),outputFormat);
        xmlWriter.write(read);
        xmlWriter.close();
        }
}
