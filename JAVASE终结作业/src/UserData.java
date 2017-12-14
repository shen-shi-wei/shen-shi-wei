
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class UserData {
    SAXReader reader = new SAXReader();
    Document document = null;
    public void writeIn(String nickname,String username,String password) throws IOException, DocumentException {
//        if (document == null){
            document = reader.read(new File("src/userdata.xml"));
//        }
        Element users = document.getRootElement();
        Element nickname1 = users.addElement("nickname");
        nickname1.addText(nickname);
        Element username1 = nickname1.addElement("username");
        username1.addText(username);
        Element password1 = nickname1.addElement("password");
        password1.addText(password);
        OutputFormat outputFormat = OutputFormat.createPrettyPrint();
        outputFormat.setEncoding("UTF-8");
        XMLWriter xmlWriter = new XMLWriter(new FileWriter("src/userdata.xml"), outputFormat);
        xmlWriter.write(document);
        xmlWriter.close();

    }

    public List<Users> read() throws DocumentException {
        document = reader.read(new File("src/userdata.xml"));
        Element rootElement = document.getRootElement();
        List<Element> nickname = rootElement.elements("nickname");
        List<Users> usersdata = new ArrayList<>();
        for (int i = 0; i < nickname.size(); i++) {
            Users users = new Users();
            Element ele = nickname.get(i);
            String nickname1 = ele.getText();
            users.setNickname(nickname1);

            Element username1 = ele.element("username");
            String text = username1.getText();
            users.setUsername(text);

            Element password1 = ele.element("password");
            String text1 = password1.getText();
            users.setPassword(text1);

            usersdata.add(users);
        }
        return usersdata;
    }

}
