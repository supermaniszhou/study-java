package cn.cheng.sbsm.pojo;

import lombok.Getter;
import lombok.Setter;

/**
 * 周刘成   2020-1-14
 */
@Getter
@Setter
public class User {
    private int id;
    private String password;
    private String role;
    private String username;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
