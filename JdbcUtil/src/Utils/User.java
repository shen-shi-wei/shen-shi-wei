package Utils;

public class User {
    private String uid;
    private String uname;
    private int age;
    private String loc;

    public User() {
    }

    public User(String uid, String uname, int age, String loc) {
        this.uid = uid;
        this.uname = uname;
        this.age = age;
        this.loc = loc;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Utils.User{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", age=" + age +
                ", loc='" + loc + '\'' +
                '}';
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }
}
