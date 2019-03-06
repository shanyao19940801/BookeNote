package code.dynamic_proxy;

/**
 * @create by  单耀
 * @create date  2019/3/6
 */
public class UserServiceImpl implements UserService {
    @Override
    public void addUser(User user) {
        System.out.println("添加新的user ：" + user.toString());
    }
}
