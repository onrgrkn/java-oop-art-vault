public class Buyer {
    private Wallet wallet;
    private PrivateCollection collection;

    public Buyer(){
        this.wallet = new Wallet(5000000);
        this.collection = new PrivateCollection();
    }


    public void buyArtwork(Artwork artwork){
        collection.addArtworktoCollection(artwork);
        wallet.addBalance(artwork.calculateCost()*-1);
    }
    public Wallet getWallet() {
        return wallet;
    }

    public PrivateCollection getCollection() {
        return collection;
    }

    public void printBuyerBalance(){
        System.out.println("Buyer current balance is "+ getWallet().getBalance());
    }
}
