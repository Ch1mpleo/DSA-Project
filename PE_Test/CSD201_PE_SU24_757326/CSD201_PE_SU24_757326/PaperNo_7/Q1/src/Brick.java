// =========== DO NOT EDIT THE GIVEN CONTENT OF THIS FILE ============

class Brick {

    String place;
    int price, type;

    Brick() {
    }

    Brick(String xPlace, int xPrice, int xType) {
        place = xPlace;
        price = xPrice;
        type = xType;
    }

    public String toString() {
        return ("(" + place + "," + price + "," + type + ")");
    }
}
