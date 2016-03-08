package com.chriswk.cacher;

import java.util.stream.IntStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import static java.util.stream.Collectors.joining;

@Service
public class BananaService {
    private static final Logger LOG = LogManager.getLogger();
    @Cacheable("bananas")
    public String banana(Integer bananas) {
        LOG.info("Got called with bananas set to {}", bananas);
        return IntStream.range(1, bananas).mapToObj(x -> String.format("%d banana", x)).collect(joining(","));
    }
}
