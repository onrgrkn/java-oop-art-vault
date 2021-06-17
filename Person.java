public abstract class Person implements IComparable, ISearchable {
    String name;
    String born;
    String died;
    String nationality;

    public Person(){}

    public Person(String name, String born, String died, String nationality) {
        this.name = name;
        this.born = born;
        this.died = died;
        this.nationality = nationality;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBorn() {
        return born;
    }

    public void setBorn(String born) {
        this.born = born;
    }

    public String getDied() {
        return died;
    }

    public void setDied(String died) {
        this.died = died;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

}
