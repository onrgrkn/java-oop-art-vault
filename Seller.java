import java.util.ArrayList;

public class Seller {

    private Wallet wallet;
    private PrivateCollection sellerCollection;

    public Seller(){
        this.wallet = new Wallet();
        this.sellerCollection = new PrivateCollection();

    }


    public PrivateCollection getSellerCollection() {
        return sellerCollection;
    }

    public void sellArtwork(Artwork artwork){
        sellerCollection.removeArtworkinCollection(artwork);
        wallet.addBalance(artwork.calculateCost());
    }

    public void addPaintingsArrayListToCollection(ArrayList<Painting> aL){
        sellerCollection.addPaintingArrayListToCollection(aL);
    }
    public void addSculpturesArrayListToCollection(ArrayList<Sculpture> aL){
        sellerCollection.addSculptureArrayListToCollection(aL);
    }
    public void addArchitecturesArrayListToCollection(ArrayList<Architecture> aL){
        sellerCollection.addArchitectureArrayListToCollection(aL);
    }

    public Wallet getWallet() {
        return wallet;
    }


    public void printSellerBalance(){
        System.out.println("Seller current balance is " + getWallet().getBalance());
    }
}