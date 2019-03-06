package code.dynamic_proxy;

/**
 * @create by  单耀
 * @create date  2019/3/6
 */
public class Main {
    public static void main(String[] args) {
        JdkProxy proxy = new JdkProxy(new UserServiceImpl());
        UserService userService = (UserService) proxy.getProxy();
        User user = new User();
        user.setAge(1);
        user.setName("shan");
        userService.addUser(user);
    }
}
