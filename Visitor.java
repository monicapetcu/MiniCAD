
interface Visitor {
    void visit(Line line);
    void visit(Circle circle);
    void visit(Diamond diamond);
    void visit(Polygon polygon);
    void visit(Rectangle rectangle);
    void visit(Square square);
    void visit(Triangle triangle);
}
