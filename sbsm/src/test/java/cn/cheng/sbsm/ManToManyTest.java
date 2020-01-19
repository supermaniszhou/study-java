package cn.cheng.sbsm;

import cn.cheng.sbsm.jpa.SysRoleRepository;
import cn.cheng.sbsm.pojo.SysMenu;
import cn.cheng.sbsm.pojo.SysRole;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * 周刘成   2020-1-17
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SbsmApplication.class)
public class ManToManyTest {

    @Autowired
    private SysRoleRepository roleRepository;
    @Test
    @Transactional
    public void toAdd(){
        SysRole role=new SysRole();
//        role.setId(3);
        role.setRolename("项目经理");

        SysMenu menu2=new SysMenu();
//        menu2.setId(1);
        menu2.setMenuName("项目管理");
        menu2.setParentId(0);
        SysMenu sysMenu=new SysMenu();
//        sysMenu.setId(2);
        sysMenu.setMenuName("xxxx管理系统");
        sysMenu.setParentId(1);

        role.getMenus().add(sysMenu);
        role.getMenus().add(menu2);

        sysMenu.getSysRoles().add(role);
        menu2.getSysRoles().add(role);

        this.roleRepository.save(role);
    }

    @Test
    public void getRole(){
//        Optional<SysRole> sysRole=this.roleRepository.findById();
    }
}
