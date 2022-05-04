public interface UserDao {
    boolean insertUser(User user);
    User getUser(int id);
}