package ua.starkon.mvp.dto;

import ua.starkon.mvp.utils.PositiveArray;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ShapeRequest {
    @NotNull
    @NotEmpty
    private String shapeType;
    @NotNull
    @PositiveArray
    private double[] parameters;

    public String getShapeType() {
        return shapeType;
    }

    public void setShapeType(String shapeType) {
        this.shapeType = shapeType;
    }

    public double[] getParameters() {
        return parameters;
    }

    public void setParameters(double[] parameters) {
        this.parameters = parameters;
    }
}
