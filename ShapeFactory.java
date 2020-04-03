
final class ShapeFactory {

    public static Shape getShape(final String shapeType) {
        if (shapeType == null) {
            return null;
        }
        if (shapeType.equalsIgnoreCase("CIRCLE")) {
            return new Circle();

        } else if (shapeType.equalsIgnoreCase("RECTANGLE")) {
            return new Rectangle();

        } else if (shapeType.equalsIgnoreCase("SQUARE")) {
            return new Square();

        } else if (shapeType.equalsIgnoreCase("LINE")) {
            return new Line();

        } else if (shapeType.equalsIgnoreCase("DIAMOND")) {
            return new Diamond();

        } else if (shapeType.equalsIgnoreCase("TRIANGLE")) {
            return new Triangle();

        } else if (shapeType.equalsIgnoreCase("POLYGON")) {
            return new Polygon();
        }
        return null;
   }
}
