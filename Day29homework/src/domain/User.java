package domain;

public class User {
    private String uid;
    private String uname;
    private String  age;
    private String loc;

    public User() {
    }

    public User(String uid, String uname, String  age, String loc) {
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

    public String  getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "domain.User{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", age=" + age +
                ", loc='" + loc + '\'' +
                '}';
    }

    public void setAge(String  age) {
        this.age = age;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }
}
