package com.urlshortener.url;


import com.urlshortener.user.User;
import org.springframework.data.repository.CrudRepository;

public interface UrlRepository extends CrudRepository<Url, Long>{
    Url findByUser(User user);
}
