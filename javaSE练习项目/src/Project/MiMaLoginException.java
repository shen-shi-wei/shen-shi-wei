package Project;

public class MiMaLoginException extends Exception {
    @Override
    public String getMessage() {
        return "密码错误！！";
    }
}
