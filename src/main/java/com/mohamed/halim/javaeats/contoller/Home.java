package com.mohamed.halim.javaeats.contoller;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.charset.Charset;

@RestController
public class Home {
    @GetMapping(value = {"/", "/health"})
    // THANKS to Ehab for this
    public String home() throws IOException {
        Resource resource = new ClassPathResource("banner.txt");
        return String.format("<pre>%s</pre>",
                IOUtils.toString(resource.getInputStream(), Charset.defaultCharset()));
    }
}
