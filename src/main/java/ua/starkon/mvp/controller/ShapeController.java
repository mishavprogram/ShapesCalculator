package ua.starkon.mvp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ua.starkon.mvp.dto.ShapeRequest;
import ua.starkon.mvp.entities.Shape;
import ua.starkon.mvp.service.ShapeService;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
@Validated
public class ShapeController {

    @Autowired
    private ShapeService shapeService;

    @PostMapping("/calculate")
    public ResponseEntity<?> calculate(@Valid @RequestBody ShapeRequest request) {
        Shape shape = shapeService.getShape(request.getShapeType(), request.getParameters());

        Map<String, Double> result = new HashMap<>();
        result.put("area", shape.area());
        result.put("perimeter", shape.perimeter());

        return ResponseEntity.ok().body(result);
    }

    @ExceptionHandler(javax.validation.ConstraintViolationException.class)
    public ResponseEntity<String> handleValidationException(javax.validation.ConstraintViolationException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}
