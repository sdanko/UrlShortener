package com.urlshortener.url;

import com.google.common.hash.Hashing;
import com.urlshortener.core.AlphabetEncoder;
import com.urlshortener.core.BaseController;
import com.urlshortener.core.GlobalProperties;
import com.urlshortener.user.User;
import com.urlshortener.user.UserRepository;
import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class UrlController extends BaseController{
    private final UrlRepository urlRepository;
    private  final UserRepository userRepository;
    private final GlobalProperties globalProperties;

    @Autowired
    public UrlController(UrlRepository urlRepository, UserRepository userRepository, GlobalProperties globalProperties) {
        this.urlRepository = urlRepository;
        this.userRepository = userRepository;
        this.globalProperties = globalProperties;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/register")
    ResponseEntity<RegisterUrlResult> add(@RequestBody RegisterUrlRequest register) {
        try {
            String shortCode;
            final UrlValidator urlValidator = new UrlValidator(new String[]{"http", "https"});
            if (urlValidator.isValid(register.getUrl())) {
                shortCode = Hashing.murmur3_32().hashString(register.getUrl(), StandardCharsets.UTF_8).toString();
            } else
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).
                        body(new RegisterUrlResult(""));

            User user = userRepository.findByAccountId(getAccountId());
            shortCode += AlphabetEncoder.encode(user.getId().intValue());
            urlRepository.save(new Url(register.getUrl(),
                    register.getRedirectType(),0,getAccountId(), shortCode));

            String fullUrl = globalProperties.getDomain() + "/" + shortCode;

            return ResponseEntity.status(HttpStatus.OK).
                    body(new RegisterUrlResult(fullUrl));
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
                    body(new RegisterUrlResult(""));
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/statistics/{accountId}")
    ResponseEntity<?> statistics(@PathVariable String accountId) {
        List<Url> urls = urlRepository.findByAccountId(accountId);

        Map<String, Integer> result = urls.stream().collect(
                Collectors.toMap(Url::getUrl, Url::getRedirects,
                        (oldValue, newValue) -> oldValue));

        return ResponseEntity.status(HttpStatus.OK).
                body(result);
    }

    @RequestMapping("/{shortCode}")
    ResponseEntity<?> redirect(@PathVariable String shortCode) {
        try {
            Url url = urlRepository.findByShortCode(shortCode);

            if(url==null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Unknown URL");
            }

            url.setRedirects(url.getRedirects()+1);
            urlRepository.save(url);

            URI uri = new URI(url.getUrl());
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setLocation(uri);
            return ResponseEntity.status(url.getRedirectType()).
                    headers(httpHeaders).body("");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error redirecting");
        }
    }

}
