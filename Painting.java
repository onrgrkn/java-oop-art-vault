import java.awt.*;

public class Painting extends Artwork {

    private Artist artist;
    private int dimension1;
    private int dimension2;

    public Painting(String name, String style, Artist artist, int dimension1, int dimension2) {
        super(name, style);
        this.artist = artist;
        this.dimension1 = dimension1;
        this.dimension2 = dimension2;
    }
    public Painting(){}

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public int getDimension1() {
        return dimension1;
    }

    public void setDimension1(int dimension1) {
        this.dimension1 = dimension1;
    }

    public int getDimension2() {
        return dimension2;
    }

    public void setDimension2(int dimension2) {
        this.dimension2 = dimension2;
    }

    @Override
    public void printAnObject() {
        System.out.println("Painting:");
        System.out.println("        name:"+ this.getName());
        System.out.println("        artist:"+ this.getArtist().getName());
        System.out.println("        stlye:"+ this.getStyle());
        System.out.println("        dimensions:"+ this.getDimension1()+ "cm X" + this.getDimension2()+ "cm");


    }

    @Override
    public int compareTo(Object object, int sortTypeID){ //büyük ise pozitif ,eşit=0, küçük ise negatif
        if(object instanceof Painting) {//casting
            Painting otherPainting = ((Painting) object);
            int l1, l2, lmin;
            String first = "", second = "";
            switch (sortTypeID) {
                case 1:
                    first = this.getName();
                    second = otherPainting.getName();
                    break;
                case 2:
                    first = this.getStyle();
                    second = otherPainting.getStyle();
                    break;
                case 3:
                    return this.getArtist().compareTo(otherPainting.getArtist(), 1);
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
        else
          System.exit(0);
            return -1;
        }
    @Override
    public int search(String keyword){

        if((this.getStyle().equalsIgnoreCase(keyword)) || (this.getName().equalsIgnoreCase(keyword) ) || (this.getArtist().getName().equalsIgnoreCase(keyword))){
            return 1;
        }
        return  0;
    }
    @Override
    public double calculateCost() {
        double unitPrice=4.5;
        if(this.getStyle()=="Renaissance"){ unitPrice = 7;}
        else if(this.getStyle()=="Barque"){ unitPrice = 5.5;}

        return (this.dimension1*this.dimension2*unitPrice);
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

