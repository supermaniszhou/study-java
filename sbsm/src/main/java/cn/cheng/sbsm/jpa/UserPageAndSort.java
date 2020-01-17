package cn.cheng.sbsm.jpa;

import cn.cheng.sbsm.pojo.User;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * 周刘成   2020-1-17
 */
public interface UserPageAndSort extends PagingAndSortingRepository<User, Integer> {
}
