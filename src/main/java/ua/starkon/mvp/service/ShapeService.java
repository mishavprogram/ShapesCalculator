package ua.starkon.mvp.service;

import org.springframework.stereotype.Service;
import ua.starkon.mvp.entities.*;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class ShapeService {

    private static Map<String, Function<double[], Shape>> shapeCreators = new HashMap<>();

    static {
        shapeCreators.put("Square", params -> new Square(params[0]));
        shapeCreators.put("Rectangle", params -> new Rectangle(params[0], params[1]));
        shapeCreators.put("Triangle", params -> new Triangle(params[0], params[1], params[2]));
        shapeCreators.put("Circle", params -> new Circle(params[0]));
    }


    public Shape getShape(String shapeType, double[] parameters) {
        return shapeCreators.get(shapeType).apply(parameters);
    }
}
