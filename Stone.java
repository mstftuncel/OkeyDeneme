

public class Stone{

	Integer value;//Tasin 1-13 arasi gorunen degeri
    String color;//Tasin Rengi
    Integer trueValue;//Tasin 0-52 arasi gercek degeri

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getTrueValue() {
        return trueValue;
    }

    public void setTrueValue(Integer trueValue) {
        this.trueValue = trueValue;
    }

    public Stone(Integer trueValue, String color, Integer value) {
        this.value = value;
        this.color = color;
        this.trueValue = trueValue;
    }
    
}
