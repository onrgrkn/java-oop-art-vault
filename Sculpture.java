public class Sculpture extends Artwork {

    private Artist artist;
    private String material;
    private int weight;

    public Sculpture(){}

    public Sculpture(String name, String style, Artist artist, String material, int weight) {
        super(name, style);
        this.artist = artist;
        this.material = material;
        this.weight = weight;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public void printAnObject() {
        System.out.println("Sculpture:");
        System.out.println("        Name:" + this.getName());
        System.out.println("        Artist:" + this.getArtist().getName());
        System.out.println("        Style:"+ this.getStyle());
        System.out.println("        Material"+ this.getMaterial());
        System.out.println("        Weight:" + this.getWeight()+ "kg");

    }

    @Override
    public int compareTo(Object object, int sortTypeID) {
        if(object instanceof Sculpture){
            Sculpture otherSculpture = ((Sculpture)object);
            int l1 ,l2, lmin;
            String first="", second="";
            switch (sortTypeID) {
                case 1:
                    first = this.getName();
                    second = otherSculpture.getName();
                    break;
                case 2:
                    first = this.getStyle();
                    second = otherSculpture.getStyle();
                    break;
                case 3:
                    return this.getArtist().compareTo(otherSculpture.getArtist(),1);
                case 4:
                    first= this.getMaterial();
                    second=otherSculpture.getMaterial();
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
        else{
            System.exit(0);
            return -1;
        }
    }
    @Override
    public int search(String keyword){
        if((this.getName().equalsIgnoreCase(keyword)) || (this.getStyle().equalsIgnoreCase(keyword)) || (((this.getWeight()+"").equalsIgnoreCase(keyword)) || (this.getMaterial().equalsIgnoreCase(keyword)) || (this.getArtist().getName().equalsIgnoreCase(keyword) ))){return 1;}
        return 0;
    }

    @Override
    public double calculateCost(){
        int unitPrice=15;
        if(this.material== "Bronze"){unitPrice=180;}
        return this.weight*unitPrice;
    }

    @Override
    public boolean isTradable(){
        if(this.getStyle()=="Baroque"){
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


