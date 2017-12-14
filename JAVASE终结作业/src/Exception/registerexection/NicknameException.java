package Exception.registerexection;

public class NicknameException extends RegisterException {
    @Override
    public String getMessage() {
        return "昵称必须要英文，请重新输入";
    }
}
