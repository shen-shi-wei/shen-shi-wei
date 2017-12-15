package Exception.registerexection;
public class ExistException extends RegisterException {
    @Override
    public String getMessage() {
        return "您输入的用户名已存在，请重新输入！";
    }
}

