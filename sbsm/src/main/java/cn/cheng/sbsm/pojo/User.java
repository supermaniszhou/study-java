package cn.cheng.sbsm.pojo;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;


/**
 * 周刘成   2020-1-14
 */
@Getter
@Setter
public class User implements Serializable {


    private int id;
    @NotBlank(message = "密码不能为空")
    @Length(min = 6, max = 12, message = "最小长度为6位，最大长度为12位")
    private String password;
    //    @NotNull
    private String role;
    //    @NotBlank(message = "{user.username}")
    @NotBlank(message = "用户名不可为空")
    private String username;
//    @Email
//    private String email;

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
