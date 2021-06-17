

public class Architect extends Person {

    public Architect(){}


    public Architect(String name, String born, String died, String nationality) {
        super(name, born, died, nationality);
    }

    @Override
    public void printAnObject() {
        System.out.println("Architect:");
        System.out.println("        Name:"+ this.getName());
        System.out.println("        Born:"+this.getBorn());
        System.out.println("        Died:"+ this.getDied());
        System.out.println("        Nationality:"+ this.getNationality());

    }

    @Override
    public int compareTo(Object object, int sortTypeID) {
        if(object instanceof Architect){
            Architect otherArchitect = ((Architect)object);
            int l1 ,l2, lmin;
            String first="", second="";
            switch (sortTypeID) {
                case 1:
                    first = this.getName();
                    second = otherArchitect.getName();
                    break;
                case 2:
                    first = this.getBorn();
                    second = otherArchitect.getBorn();
                    break;
                case 3:
                    first = this.getNationality();
                    second = otherArchitect.getNationality();
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
        if((this.getName().equalsIgnoreCase(keyword)) || (this.getBorn().equalsIgnoreCase(keyword)) || (this.getDied().equalsIgnoreCase(keyword)) || (this.getNationality().equalsIgnoreCase(keyword))) {
            return  1;
        }
        return 0;
    }
}
