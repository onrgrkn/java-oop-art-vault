import java.util.ArrayList;

public class Vault {
    ArrayListSorter sorter = new ArrayListSorter();

        private ArrayList<Architect> architectArrayList;
        private ArrayList<Artist> artistArrayList;
        private ArrayList<Painting> paintingArrayList;
        private ArrayList<Sculpture> sculptureArrayList ;
        private ArrayList<Architecture> architectureArrayList;

        public Vault(){
            this.architectArrayList= new ArrayList<>();
            this.artistArrayList = new ArrayList<>();
            this.paintingArrayList = new ArrayList<>();
            this.sculptureArrayList = new ArrayList<>();
            this.architectureArrayList = new ArrayList<>();
        }
        public Vault(ArrayList<Architect> architectArrayList,ArrayList<Artist> artistArrayList,ArrayList<Painting> paintingArrayList, ArrayList<Sculpture> sculptureArrayList ,ArrayList<Architecture> architectureArrayList){
            this.architectArrayList = architectArrayList;
            this.artistArrayList = artistArrayList;
            this.paintingArrayList = paintingArrayList;
            this.sculptureArrayList = sculptureArrayList;
            this.architectureArrayList =  architectureArrayList;
        }
        public void setArchitectArrayList(ArrayList<Architect> architectArrayList) {
            this.architectArrayList = architectArrayList;
        }

        public void setArtistArrayList(ArrayList<Artist> artistArrayList) {
            this.artistArrayList = artistArrayList;
        }

        public void setPaintingArrayList(ArrayList<Painting> paintingArrayList) {
            this.paintingArrayList = paintingArrayList;
        }

        public void setSculptureArrayList(ArrayList<Sculpture> sculptureArrayList) {
            this.sculptureArrayList = sculptureArrayList;
        }

        public void setArchitectureArrayList(ArrayList<Architecture> architectureArrayList) {
            this.architectureArrayList = architectureArrayList;
        }

        public ArrayList<Architect> getArchitectArrayList() {
            return architectArrayList;
        }

        public ArrayList<Artist> getArtistArrayList() {
            return artistArrayList;
        }

        public ArrayList<Painting> getPaintingArrayList() {
            return paintingArrayList;
        }

        public ArrayList<Sculpture> getSculptureArrayList() {
            return sculptureArrayList;
        }

        public ArrayList<Architecture> getArchitectureArrayList() {
            return architectureArrayList;
        }

        public Vault createVault(){
            CSVReader r = new CSVReader();
            return r.readFile();
        }
        public void architectArrayListSorter(int sortOption){
            sorter.arrayListSorting(getArchitectArrayList(), getArchitectArrayList().size(), sortOption);

        }
        public void architectArrayListPrinter(){
        for (Architect i : getArchitectArrayList()) {
            i.printAnObject(); }

        }
        public void artistArrayListSorter(int sortOption){
            sorter.arrayListSorting(getArtistArrayList(), getArtistArrayList().size(), sortOption);

        }
        public void artistArrayListPrinter(){
            for (Artist i : getArtistArrayList()) {
                i.printAnObject();
            }
        }

        public void paintingArrayListSorter(int sortOption){
            sorter.arrayListSorting(getPaintingArrayList(), getPaintingArrayList().size(), sortOption);
        }
        public void paintingArrayListPrinter(){
            for (Painting i : getPaintingArrayList()) {
                i.printAnObject();
            }
        }
        public void sculptureArrayListSorter(int sortOption){
            sorter.arrayListSorting(getSculptureArrayList(), getSculptureArrayList().size(), sortOption);
        }
        public void sculptureArrayListPrinter(){
            for (Sculpture i : getSculptureArrayList()) {
                i.printAnObject();
            }
        }
        public void architectureArrayListSorter(int sortOption){
            sorter.arrayListSorting(getArchitectureArrayList(), getArchitectureArrayList().size(),sortOption);
        }
        public void architectureArrayListPrinter(){
            for (Architecture i : getArchitectureArrayList()) {
                i.printAnObject();
            }
        }
        public void paintingArrayListSearcher(String keyword){
            for (int i = 0; i < getPaintingArrayList().size(); i++) {
                if (getPaintingArrayList().get(i).search(keyword) == 1) {
                    getPaintingArrayList().get(i).printAnObject();
                    }
            }
        }
        public void artistArrayListSearcher(String keyword){
            for (int i = 0; i < getArtistArrayList().size(); i++) {
                if (getArtistArrayList().get(i).search(keyword) == 1) {
                    getArtistArrayList().get(i).printAnObject();

                }
            }
        }
        public void sculptureArrayListSearcher(String keyword){
            for (int i = 0; i < getSculptureArrayList().size(); i++) {
                if (getSculptureArrayList().get(i).search(keyword) == 1) {
                    getSculptureArrayList().get(i).printAnObject();

                }
            }
        }
        public void architectArrayListSearcher(String keyword){
            for (int i = 0; i < getArchitectArrayList().size(); i++) {
                if (getArchitectArrayList().get(i).search(keyword) == 1) {
                    getArchitectArrayList().get(i).printAnObject();

                }
            }
        }
        public void architectureArrayListSearcher(String keyword){
            for (int i = 0; i < getArchitectureArrayList().size(); i++) {
                if (getArchitectureArrayList().get(i).search(keyword) == 1) {
                    getArchitectureArrayList().get(i).printAnObject();

                }
            }
        }


    }

