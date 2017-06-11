package com.urlshortener.user;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long>{
    User findByAccountId(String accountId);
}
