package code.dynamic_proxy;

/**
 * @create by  单耀
 * @create date  2019/3/6
 * 被代理的类
 */
public class UserServiceImpl implements UserService {
    @Override
    public void addUser(User user) {
        System.out.println("添加新的user ：" + user.toString());
    }

    @Override
    public void delete(User user) {
        System.out.println("删除user：" + user.toString());
    }

}
