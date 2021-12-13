package com.example.socialmultiplication.repository;

import com.example.socialmultiplication.doMain.Multiplication;
import org.springframework.data.repository.CrudRepository;

/**
 * @author [Guy Cui]
 * @version [1.0.0] @Date [2021/12/13] @Description: [乘法库]
 * @update [序号][2021/12/13] [Cui Guy][变更描述]
 */
public interface MultiplicationRepository extends CrudRepository<Multiplication, Long> {}
