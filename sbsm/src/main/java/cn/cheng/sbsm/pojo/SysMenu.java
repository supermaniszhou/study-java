package cn.cheng.sbsm.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 周刘成   2020-1-17
 */
@Entity
@Table(name = "SYS_MENU")
@Getter
@Setter
public class SysMenu implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private int id;
    @Column(name = "menu_name")
    private String menuName;
    @Column(name = "menu_url")
    private String menuUrl;
    @Column(name = "menu_icon")
    private String menuIcon;
    @Column(name = "parent_id")
    private int parentId;

    @ManyToMany(mappedBy = "menus")
    private Set<SysRole> sysRoles = new HashSet<>();

}
