package Exception.registerexection;

public class WrongNumberException extends RegisterException {
    @Override
    public String getMessage() {
        return "你输入的手机号或邮箱不正确，请重新输入！";
    }
}
