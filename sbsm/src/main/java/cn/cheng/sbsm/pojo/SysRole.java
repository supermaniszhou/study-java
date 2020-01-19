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
@Table(name = "SYS_ROLE")
@Getter
@Setter
public class SysRole implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private int id;
    @Column(name = "ROLENAME")
    private String rolename;
    @OneToMany(mappedBy = "sysRole")
    private Set<SysPerson> persons=new HashSet<>();

    /**
     * CascadeType.REFRESH：级联刷新，当多个用户同时作操作一个实体，为了用户取到的数据是实时的，在用实体中的数据之前就可以调用一下refresh()方法
     * CascadeType.REMOVE：级联删除，当调用remove()方法删除Order实体时会先级联删除OrderItem的相关数据
     * CascadeType.MERGE：级联更新，当调用了Merge()方法，如果Order中的数据改变了会相应的更新OrderItem中的数据
     * CascadeType.ALL：包含以上所有级联属性
     * CascadeType.PERSIST：级联保存，当调用了Persist() 方法，会级联保存相应的数据
     */
    @ManyToMany(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
    @JoinTable(name = "SYS_ROLE_MENU",joinColumns = @JoinColumn(name = "role_id"),inverseJoinColumns = @JoinColumn(name = "menu_id"))
    private Set<SysMenu> menus=new HashSet<>();
}
