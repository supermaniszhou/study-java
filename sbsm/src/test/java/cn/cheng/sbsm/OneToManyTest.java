package cn.cheng.sbsm;

import cn.cheng.sbsm.jpa.SysPersonRepository;
import cn.cheng.sbsm.pojo.SysPerson;
import cn.cheng.sbsm.pojo.SysRole;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.Optional;

/**
 * 一对多关联关系测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SbsmApplication.class)
public class OneToManyTest {

    @Autowired
    private SysPersonRepository personRepository;

    /**
     * 一对多关联关系的添加
     */
    @Test
    public void testSave() {
        //创建一个用户
        SysPerson person = new SysPerson();
        person.setUsername("zhangsan");
        person.setAlias("张三");
        person.setAge(22);
        person.setBirthday(new Date());

        //创建一个角色
        SysRole roles = new SysRole();
        roles.setRolename("管理员");

        //关联
        roles.getPersons().add(person);
        person.setSysRole(roles);

        //保存
        this.personRepository.save(person);
    }

    /**
     * 一对多关联关系的查询
     */
    @Test
    public void testFind() {
        Optional<SysPerson> optional = this.personRepository.findById(1);
        SysPerson person=optional.get();
        System.out.println(person.toString());
        SysRole roles = person.getSysRole();
        System.out.println(roles.getRolename());
    }
}
