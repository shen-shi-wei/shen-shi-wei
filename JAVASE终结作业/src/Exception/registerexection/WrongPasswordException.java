package Exception.registerexection;

public class WrongPasswordException extends RegisterException {
    @Override
    public String getMessage() {
        return "您输入的密码不正确，请重新输入！";
    }
}
