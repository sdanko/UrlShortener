package com.urlshortener.url;


import com.urlshortener.user.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UrlRepository extends CrudRepository<Url, Long>{
    List<Url> findByAccountId(String accountId);
}
