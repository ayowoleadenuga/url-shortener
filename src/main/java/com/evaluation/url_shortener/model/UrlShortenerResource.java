package com.evaluation.url_shortener.model;

import Utility.UrlUtil;
import com.google.common.hash.Hashing;
import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@RequestMapping("/rest")
@RestController
public class UrlShortenerResource {

    @Autowired
    StringRedisTemplate redisTemplate;

    @GetMapping("/{id}")
    public String getUrl(@PathVariable String id, HttpServletResponse resp) throws IOException {
        String url = redisTemplate.opsForValue().get(id);
        if(url != null){
            resp.sendRedirect(url);
        }
        else{
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
        return url;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Response create(@RequestBody String url){
        UrlValidator urlValidator = new UrlValidator(
                new String[]{"http", "https"}
        );
        if (urlValidator.isValid(url)) {
            Response response = new Response("00", "Successful" , null , "http://localhost:8080/rest" + UrlUtil.generateShortUrl(url) );
            String id = UrlUtil.generateShortUrl(url);
            redisTemplate.opsForValue().set(id, url);
            return response;
        }
        throw new RuntimeException("Invalid URL: " + url);
    }
}
