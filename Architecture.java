import java.util.ArrayList;

public class Architecture extends Artwork {


    private ArrayList<Architect> architects = new ArrayList<>();
    private double dimension1;
    private double dimension2;
    private double dimension3;

    public Architecture() {
    }


    public Architecture(String name, String style, double dimension1, double dimension2, double dimension3) {
        super(name, style);
        this.dimension1 = dimension1;
        this.dimension2 = dimension2;
        this.dimension3 = dimension3;
    }

    public Architecture(String name, String style, double dimension1, double dimension2, double dimension3, ArrayList<Architect> architects) {
        this(name, style, dimension1, dimension2, dimension3);
        this.architects = architects;

    }

    public ArrayList<Architect> getArchitects() {
        return architects;
    }

    public double getDimension1() {
        return dimension1;
    }

    public void setDimension1(double dimension1) {
        this.dimension1 = dimension1;
    }

    public double getDimension2() {
        return dimension2;
    }

    public void setDimension2(double dimension2) {
        this.dimension2 = dimension2;
    }

    public double getDimension3() {
        return dimension3;
    }

    public void setDimension3(int dimension3) {
        this.dimension3 = dimension3;
    }

    @Override
    public void printAnObject() {
        System.out.println("Architecture: ");
        System.out.println("        name:" + this.getName());
        System.out.println("        style:" + this.getStyle());
        System.out.println("        dimesion1:" + this.getDimension1());
        System.out.println("        dimesion2:" + this.getDimension2());
        System.out.println("        dimesion3:" + this.getDimension3());
        for (int i = 0; i < this.getArchitects().size(); i++) {
            System.out.println("        " + (i + 1) + ". architect  :" + this.getArchitects().get(i).getName());

        }
    }

    @Override
    public int compareTo(Object object, int sortTypeID) {
        if(object instanceof Architecture){
            Architecture otherArchitecture = ((Architecture)object);
            int l1 ,l2, lmin;
            String first="", second="";
            switch (sortTypeID) {
                case 1:
                    first = this.getName();
                    second = otherArchitecture.getName();
                    break;
                case 2:
                    first = this.getStyle();
                    second = otherArchitecture.getStyle();
                    break;
            }
            l1 = first.length();
            l2 = second.length();
            lmin = Math.min(l1, l2);
            for (int i = 0; i < lmin; i++) {
                int this_ch = (int) first.charAt(i);
                int painting_ch = (int) second.charAt(i);
                if (this_ch != painting_ch) {
                    return this_ch - painting_ch;
                }
            }
            if (l1 != l2) {
                return l1 - l2;
            } else {
                return 0;
            }
        }
        else{// object is not architecture exit program
            System.exit(0);
            return -1;
        }
    }

    @Override
    public int search(String keyword) {
        if((this.getName().equalsIgnoreCase(keyword)) || (this.getStyle().equalsIgnoreCase(keyword)) || ((this.getDimension1()+"").equalsIgnoreCase(keyword)) || ((this.getDimension2()+"").equalsIgnoreCase(keyword)) || ((this.getDimension3()+"").equalsIgnoreCase(keyword))){
            return 1;
        }
        else{
            for(Architect architect : this.getArchitects()){
                if ( architect.getName().equals(keyword) ){return  1;}
            }
        }
        return 0;
    }
    @Override
    public double calculateCost(){
        double unitPrice=0.6;
        if(this.style=="Gothic"){unitPrice = 1.0;}
        else if(this.style == "Baraque"){unitPrice = 0.8;}
        return this.dimension1*this.dimension2*this.dimension3*unitPrice;
    }
    @Override
    public boolean isTradable(){
        if(this.getStyle()=="Gothic"){
            return  false;
        }
        return  true;
    }
    @Override
    public boolean tradeToBuyer(Buyer buyer, Seller seller) {
        if(this.isTradable()){
            buyer.buyArtwork(this);
            seller.sellArtwork(this);
            return  true;
        }
        return false;
    }
}
