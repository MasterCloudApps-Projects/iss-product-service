package es.urjc.code.products;

import java.io.IOException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import es.urjc.code.products.exception.BusinessException;
import es.urjc.code.products.exception.EntityNotFoundException;

@RestController
public class TestController {

    @GetMapping("/test/not-found")
    public void entityNotFound() {
        throw new EntityNotFoundException("entity not found");
    }

    @GetMapping("/test/business-exception")
    public void business() {
        throw new BusinessException("business error");
    }

    @GetMapping("/test/io-exception")
    public void io() throws IOException {
        throw new IOException("io error");
    }
}
