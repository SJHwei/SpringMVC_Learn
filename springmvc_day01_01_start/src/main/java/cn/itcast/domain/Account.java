package cn.itcast.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author ShiWei
 * @date 2021/4/11 - 17:23
 */
public class Account implements Serializable {

    private String username;
    private String password;
    private Double money;

    //如果该类中包含集合类型，那怎么给list和map传值呢？看param.jsp
    private List<User> list;
    private Map<String, User> map;

    public List<User> getList() {
        return list;
    }

    public void setList(List<User> list) {
        this.list = list;
    }

    public Map<String, User> getMap() {
        return map;
    }

    public void setMap(Map<String, User> map) {
        this.map = map;
    }

    //如果该类中包含一个引用类型，那怎么给user属性传值呢？看param.jsp
//    private User user;

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

//    @Override
//    public String toString() {
//        return "Account{" +
//                "username='" + username + '\'' +
//                ", password='" + password + '\'' +
//                ", money=" + money +
//                ", user=" + user +
//                '}';
//    }


    @Override
    public String toString() {
        return "Account{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", money=" + money +
                ", list=" + list +
                ", map=" + map +
                '}';
    }
}
