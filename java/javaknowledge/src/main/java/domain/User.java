package domain;

import com.google.common.collect.ComparisonChain;

import java.util.Comparator;
import java.util.Date;

public class User{
    private String name;
    private Integer age;
    private Double price;
    private Date birthday;

    public static Comparator<? super User> multiDescComparator = new Comparator<User>() {
        public int compare(User o1, User o2) {
            return ComparisonChain.start()
                    .compare(o1.getAge(), o2.getAge())
                    .compare(o1.getPrice(),o2.getPrice())
                    .result();
        }
    };
    public static Comparator<? super User> ageDescComparator = new Comparator<User>() {
        public int compare(User o1, User o2) {
            if (o1 == null && o2 == null) {
                return 0;
            } else if (o1 == null && o2 !=null) {
                return 1;
            } else if (o1 != null && o2 == null) {
                return -1;
            } else {
                return -Integer.compare(o1.getAge(), o2.getAge());
            }
        }
    };


    public User(String name, Integer age, Double price, Date birthday) {
        this.name = name;
        this.age = age;
        this.price = price;
        this.birthday = birthday;
    }

    public User(String name, Integer age, Date birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", price=" + price +
                ", birthday=" + birthday +
                '}';
    }
}
