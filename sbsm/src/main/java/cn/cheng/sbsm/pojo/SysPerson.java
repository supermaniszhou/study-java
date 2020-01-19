package cn.cheng.sbsm.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 周刘成   2020-1-17
 */
@Entity
@Table(name = "SYS_PERSON")
@Getter
@Setter
public class SysPerson implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private int id;
    @Column(name = "USERNAME")
    private String username;
    @Column(name = "alias")
    private String alias;
    @Column(name = "password")
    private String password;
    @Column(name = "age")
    private Integer age;
    @Column(name = "phone")
    private String phone;
    @Column(name = "tel")
    private String tel;
    @Column(name = "qq")
    private String qq;
    @Column(name = "weixin")
    private String weixin;
    @Column(name = "address")
    private String address;
    @Column(name = "birthday")
    private Date birthday;
    @Column(name = "sex")
    private int sex;

    @ManyToOne(cascade = CascadeType.PERSIST)
    //@JoinColumn:维护外键
    @JoinColumn(name = "role_id")
    private SysRole sysRole;

    @Override
    public String toString() {
        return "SysPerson{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", alias='" + alias + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", tel='" + tel + '\'' +
                ", qq='" + qq + '\'' +
                ", weixin='" + weixin + '\'' +
                ", address='" + address + '\'' +
                ", birthday=" + birthday +
                ", sex=" + sex +
                '}';
    }
}
