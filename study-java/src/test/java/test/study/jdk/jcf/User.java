package test.study.jdk.jcf;


public class User {

    private String uid;

    public User(String uid) {
        this.uid = uid;
    }

    public String getUid() {
        return uid;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o)
//            return true;
//        if (o == null || getClass() != o.getClass())
//            return false;
//        User user = (User) o;
//        return Objects.equals(uid, user.uid);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(uid);
//    }
}
