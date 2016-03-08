package com.chriswk.cacher;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CacheController {
    private static final Logger LOG = LogManager.getLogger();
    private SomeLongService someLongService;
    private BananaService bananaService;
    @Autowired
    public CacheController(SomeLongService someLongService, BananaService service) {
        this.someLongService = someLongService;
    }

    @RequestMapping("/")
    @ResponseBody
    public String hello() {
        StringBuilder sb = new StringBuilder();
        sb.append(someLongService.getPieFor("World"));
        sb.append("\n");
        sb.append(bananaService.banana(5));
        sb.append("\n");
        sb.append(getName(this.getClass().getSimpleName()));
        return sb.toString();
    }

    @Cacheable("controller")
    public String getName(String name) {
        LOG.info("Got called for name {}", name);
        return name;
    }
}
