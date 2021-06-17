public abstract class Artwork implements IComparable, ISearchable, ITradable{
    String name;
    String style;

    public Artwork(){}

    public Artwork(String name, String style) {
        this.name = name;
        this.style = style;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }


    public abstract double calculateCost();
}
