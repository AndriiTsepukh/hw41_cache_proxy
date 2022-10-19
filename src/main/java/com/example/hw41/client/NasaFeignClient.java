package com.example.hw41.client;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="picture-service", url = "http://localhost:8080/" )
public interface NasaFeignClient {
    @GetMapping("mars/pictures/largest")
    @Cacheable({"redis-cache"})
    byte[] getBiggestPicture(@RequestParam("sol") int sol, @RequestParam(value = "camera", required = false) String camera);
}
