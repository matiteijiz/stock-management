package com.emanagement.stock.provider;

import com.emanagement.stock.entity.Item;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ResponseProvider {

    public <T> ResponseEntity<T> notFound() {
        return ResponseEntity
                .notFound()
                .build();
    }

    public <T> ResponseEntity<T> noContent() {
        return ResponseEntity
                .noContent()
                .build();
    }

    public <T> ResponseEntity<T> ok(T body) {
        return ResponseEntity
                .ok(body);
    }

    public <T> ResponseEntity<T> created(T body) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(body);
    }

}
