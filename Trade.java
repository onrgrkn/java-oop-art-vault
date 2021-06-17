import java.util.*;
public class Trade {

public void tradeArtworkWithNCustomers(Vault vault, int n){
    Seller seller = new Seller();
    seller.addArchitecturesArrayListToCollection(vault.getArchitectureArrayList());
    seller.addSculpturesArrayListToCollection(vault.getSculptureArrayList());
    seller.addPaintingsArrayListToCollection(vault.getPaintingArrayList());
    Random rand = new Random();
    Buyer[] buyers = new Buyer[n];
    for(int i=0;i < n ; i++){
        int numberOfArtwork = seller.getSellerCollection().getCollection().size();
        int rand_int = rand.nextInt(numberOfArtwork);
        buyers[i]= new Buyer();
        System.out.println((i+1)+". buyer bought---> ");
        Artwork a = seller.getSellerCollection().getCollection().get(rand_int);
        tradeOneArtwork(buyers[i],seller,a);
    }
}
private void tradeOneArtwork(Buyer buyer, Seller seller, Artwork artwork){
    artwork.tradeToBuyer(buyer,seller);
    printArtworkNameAndPrice(artwork);
    seller.printSellerBalance();
    buyer.printBuyerBalance();
    System.out.println();
}
private void printArtworkNameAndPrice(Artwork artwork){
    System.out.println();
    System.out.println(artwork.getClass().toString().substring(6)+":");
    System.out.println("        Name:"+artwork.getName());
    System.out.println("        Price:"+artwork.calculateCost());
}
}
