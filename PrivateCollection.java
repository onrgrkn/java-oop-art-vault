import java.util.ArrayList;

public class PrivateCollection {
    private ArrayList<Artwork> collection;


    public PrivateCollection(){
        this.collection = new ArrayList<>();
    }


    public ArrayList<Artwork> getCollection() {
        return collection;
    }
    public void addArtworktoCollection(Artwork artwork){ //painting objesi yollandığında patlıyor
        collection.add(artwork);
    }
    public void removeArtworkinCollection(Artwork artwork){
        collection.remove(artwork);
    }
    public void printCollection(){
        System.out.println("in Private Collection");
        for(Artwork a : collection ){
            a.printAnObject();
        }
    }

    public void addArchitectureArrayListToCollection(ArrayList<Architecture> aL){
        for(Architecture i : aL){
            if(i.isTradable()){
                this.collection.add(i);
            }
        }
    }
    public void addPaintingArrayListToCollection(ArrayList<Painting> aL){
        for(Painting i : aL){
            if(i.isTradable()){
                this.collection.add(i);
            }
        }
    }
    public void addSculptureArrayListToCollection(ArrayList<Sculpture> aL){
        for(Sculpture i : aL){
            if(i.isTradable()){
                this.collection.add(i);
            }
        }
    }
}
