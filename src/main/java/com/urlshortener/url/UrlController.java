package com.urlshortener.url;

import com.urlshortener.core.BaseController;
import com.urlshortener.core.GlobalProperties;
import com.urlshortener.core.UrlShortener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UrlController extends BaseController{
    private final UrlRepository urlRepository;
    private GlobalProperties globalProperties;

    @Autowired
    public UrlController(UrlRepository urlRepository, GlobalProperties globalProperties) {
        this.urlRepository = urlRepository;
        this.globalProperties = globalProperties;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/register")
    ResponseEntity<RegisterUrlResult> add(@RequestBody RegisterUrlRequest register) {
        try {
            Url url = urlRepository.save(new Url(register.getUrl(),
                    register.getRedirectType(),0,getAccountId()));

            String shortUrl = UrlShortener.encode(url.getId().intValue());
            String fullUrl = globalProperties.getDomain() + "/" + shortUrl;

            return ResponseEntity.status(HttpStatus.OK).
                    body(new RegisterUrlResult(fullUrl));
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
                    body(new RegisterUrlResult(""));
        }
    }
}
