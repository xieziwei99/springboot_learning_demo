package com.xzw.springbootPaging.entity;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author xieziwei99
 * 2019-06-29
 */
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

}
