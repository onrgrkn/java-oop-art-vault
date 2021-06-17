import java.util.ArrayList;

public class Artist extends Person  {
    private ArrayList<String> periods= new ArrayList<>();//arraylist


    public Artist(){}

    public Artist (String name, String born, String died, String nationality){
        super(name, born, died, nationality);
    }

    public Artist(String name, String born, String died, String nationality,ArrayList<String>periods) {
        super(name, born, died, nationality);
        this.periods=periods;
    }

    public ArrayList<String> getPeriods() {
        return periods;
    }

    @Override
    public void printAnObject() {
        System.out.println("Artist:");
        System.out.println("        Name:"+ this.getName());
        System.out.println("        Born:"+this.getBorn());
        System.out.println("        Died:"+ this.getDied());
        System.out.println("        Nationality:"+ this.getNationality());
        System.out.println("        Periods:"+this.getPeriods().toString());

    }

    @Override
    public int compareTo(Object object, int sortTypeID) {
        if(object instanceof Artist){
            Artist otherArtist = ((Artist)object);
            int l1 ,l2, lmin;
            String first="", second="";
            switch (sortTypeID) {
                case 1:
                    first = this.getName();
                    second = otherArtist.getName();
                    break;
                case 2:
                    first = this.getBorn();
                    second = otherArtist.getBorn();
                    break;
                case 3:
                    first = this.getNationality();
                    second = otherArtist.getNationality();
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
        else{
            System.exit(0);
            return -1;
        }
    }

    @Override
    public int search(String keyword) {
        if((this.getName().equalsIgnoreCase(keyword)) || (this.getBorn().equalsIgnoreCase(keyword)) || (this.getNationality().equalsIgnoreCase(keyword)) || (this.getDied().equalsIgnoreCase(keyword))) {
            return 1;
        }
        else {
            for (String element : this.periods){
                if(element.equals(keyword)){ return 1;}
            }
            return 0;
        }
    }
}
