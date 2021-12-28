package com.example.socialmultiplication.repository;

import com.example.socialmultiplication.doMain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * @author [Cui Guy]
 * @version [1.0.0] @Date [2021/12/13] @Description: [用户存储库]
 * @update [序号][2021/12/13] [Cui Guy][变更描述]
 */
public interface UserRepository extends CrudRepository<User, Long> {

    /**
     * 找到别名
     * 找到的别名
     *
     * @param alias 别名
     *
     * @return {@code Optional<User>}
     */
    Optional<User> findByAlias(final String alias);
}
