package com.urlshortener.user;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long>{
    User finfByAccountId(String accountId);
}
