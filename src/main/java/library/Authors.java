package library;

import java.util.List;

public class Authors {
    private int authotID;
    private String authorName;
    private int age;

    public Authors(int id, String authorName, int age) {
        this.authotID = authotID;
        this.authorName = authorName;
        this.age = age;
    }

    public int getId() {
        return authotID;
    }

    public void setId(int id) {
        this.authotID = authotID;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
