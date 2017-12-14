package Project;

public class BuCunZaiLoginException extends Exception{
    @Override
    public String getMessage() {
        return "账号不存在！！！";
    }
}
