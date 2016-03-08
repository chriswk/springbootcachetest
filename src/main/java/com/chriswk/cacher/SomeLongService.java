package com.chriswk.cacher;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class SomeLongService {
    private static final Logger LOG = LogManager.getLogger();

    @Cacheable("longness")
    public String getPieFor(String f) {
        LOG.info("Pie got called for {}", f);
        return String.format("%s got pie", f);
    }
}
