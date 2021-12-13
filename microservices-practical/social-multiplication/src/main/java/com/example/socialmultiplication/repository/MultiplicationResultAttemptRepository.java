package com.example.socialmultiplication.repository;

import com.example.socialmultiplication.doMain.MultiplicationResultAttempt;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @className: MultiplicationResultAttemptRepository
 * @description:  类描述
 * @author: GuyCui
 * @date: 2021/12/13
 **/
public interface MultiplicationResultAttemptRepository extends CrudRepository<MultiplicationResultAttempt,Long> {

    /**
     * @description:  查询最近的5次结果
     * @param userAlias
     * @return: java.util.List<com.example.socialmultiplication.doMain.MultiplicationResultAttempt>
     */
    List<MultiplicationResultAttempt> findTop5ByUserAliasOrderByIdDesc(String userAlias);

}
