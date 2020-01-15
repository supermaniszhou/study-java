package cn.cheng.sbsm.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * 周刘成   2020-1-14
 */
@Getter
@Setter
public class User {
    private int id;
    @NotNull
    private String password;
//    @NotNull
    private String role;
    @NotNull
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
