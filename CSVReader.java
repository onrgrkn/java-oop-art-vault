import java.io.*;

import java.util.*;

public class CSVReader {

        public CSVReader(){

        }

        public Vault readFile(){			//reads artVaultData

            ArrayList<Architect> architectArrayList = new ArrayList<Architect>();
            ArrayList<Artist> artistArrayList = new ArrayList<Artist>();
            ArrayList<Painting> paintingArrayList = new ArrayList<Painting>();
            ArrayList<Sculpture> sculptureArrayList = new ArrayList<Sculpture>();
            ArrayList<Architecture> architectureArrayList = new ArrayList<Architecture>();
            File filename=new File("C:\\Users\\onr\\IdeaProjects\\ceng211hw2\\CENG211_HW2_ArtVaultData.csv");
            try {
                Scanner in = new Scanner(filename);
                //outer while to process lines
                while (in.hasNextLine()) {
                    StringTokenizer tokenizer = new StringTokenizer(in.nextLine(), ",");
                    while (tokenizer.hasMoreTokens()) {//process tokens in line

                        int id = Integer.parseInt(tokenizer.nextToken());                //first token to check object type
                        switch (id) {
                            case 1:
                            {
                                Painting painting = new Painting();
                                String name = tokenizer.nextToken();                //second token as name
                                painting.setName(name);
                                String style = tokenizer.nextToken();                //third token as style
                                painting.setStyle(style);
                                String artistName = tokenizer.nextToken();          //forth token as artistname of painting
                                boolean flag = false;

                                  for(int i =0 ; i<artistArrayList.size() ; i++){
                                      if(artistArrayList.get(i).getName() == artistName)
                                      flag = true;
                                        { painting.setArtist(artistArrayList.get(i));
                                      break; }}
                                  if(flag){}
                                  else
                                  {
                                      Artist artist = new Artist();
                                      artist.setName(artistName);
                                      painting.setArtist(artist);
                                  }


                                int dimension1 = Integer.parseInt(tokenizer.nextToken());            //fifth token as dimension1
                                painting.setDimension1(dimension1);
                                int dimension2 = Integer.parseInt(tokenizer.nextToken());            //fifth token as dimension2
                                painting.setDimension2(dimension2);

                                paintingArrayList.add(painting);// paingting add into ArrayList
                                break;
                                }

                            case 2 :
                            {
                                Sculpture sculpture = new Sculpture();
                                String nameSc = tokenizer.nextToken();                //second token as name
                                sculpture.setName(nameSc);
                                String styleSc = tokenizer.nextToken();                //third token as style
                                sculpture.setStyle(styleSc);
                                Artist artistSc = new Artist();
                                String artistNameSc = tokenizer.nextToken();        //forth token as artistname of sculpture
                                artistSc.setName(artistNameSc);
                                sculpture.setArtist(artistSc);
                                String material = tokenizer.nextToken();                //fifth token as material
                                sculpture.setMaterial(material);
                                int weight = Integer.parseInt(tokenizer.nextToken());            //sixth token as weight
                               sculpture.setWeight(weight);

                               sculptureArrayList.add(sculpture);// sculpture add into ArrayList
                                break;
                            }

                            case 3 :
                            {
                                String name = tokenizer.nextToken();                //second token as name

                                String style = tokenizer.nextToken();                //third token as style

                                double dimension1 = Double.parseDouble((tokenizer.nextToken()));            //fifth token as dimension1

                                double dimension2 = Double.parseDouble((tokenizer.nextToken()));            //fifth token as dimension2

                                double dimension3 = Double.parseDouble((tokenizer.nextToken()));            //fifth token as dimension1

                                Architecture architecture = new Architecture(name,style,dimension1,dimension2,dimension3);
                                int numberOfArchitect = tokenizer.countTokens();
                                boolean flag3 = false;
                                for(int i =0; i< numberOfArchitect; i++){
                                    String archi = tokenizer.nextToken();
                                    for(int k =0 ; k<architectArrayList.size() ; k++){
                                        if(archi == architectArrayList.get(k).getName()){
                                            flag3 = true;
                                            architecture.getArchitects().add(architectArrayList.get(k)); }}
                                    if(!flag3){
                                            Architect newArchi = new Architect();
                                            newArchi.setName(archi);
                                            architecture.getArchitects().add(newArchi);//add new architect to architects without info

                                        }

                                }
                                architectureArrayList.add(architecture);//architecture add into ArrayList
                                break;}
                            case 4 :
                            {
                                boolean flag2 = false;
                                String name = tokenizer.nextToken();                //second token as name
                                for(int j = 0; j<paintingArrayList.size() ; j++){
                                if(paintingArrayList.get(j).getArtist().getName()==name)
                                {
                                     flag2 = true;

                                    String born = tokenizer.nextToken();                //third token as born
                                    paintingArrayList.get(j).getArtist().setBorn(born);

                                    String died = tokenizer.nextToken();                //forth token as died
                                    paintingArrayList.get(j).getArtist().setDied(died);

                                    String nationality = tokenizer.nextToken();                //fifth token as nationality
                                    paintingArrayList.get(j).getArtist().setNationality(nationality);

                                    int numberOfPeriods=tokenizer.countTokens();
                                    for(int i =0; i<numberOfPeriods; i++){
                                        String period = tokenizer.nextToken();                //sixth token as name
                                        paintingArrayList.get(j).getArtist().getPeriods().add(period);//add period to ArrayList in Artist Class
                                    }

                                    artistArrayList.add(paintingArrayList.get(j).getArtist());}}
                                if(flag2){}
                                else{
                                    Artist artist = new Artist();
                                    artist.setName(name);
                                    String born = tokenizer.nextToken();
                                    artist.setBorn(born);
                                    String died = tokenizer.nextToken();
                                    artist.setDied(died);
                                    String nationality = tokenizer.nextToken();
                                    artist.setNationality(nationality);
                                    int numberOfPeriods=tokenizer.countTokens();
                                    for(int i =0; i<numberOfPeriods; i++){
                                        String period = tokenizer.nextToken();
                                        artist.getPeriods().add(period);//add period to ArrayList in Artist Class

                                    }
                                    artistArrayList.add(artist);//artist add into ArrayList

                                }


                                break;}

                            case 5 :
                            {
                                boolean flag4 = false;
                                String name = tokenizer.nextToken();                //second token as name
                                for(int i=0 ; i< architectureArrayList.size(); i++){
                                    for (int k =0 ; k< architectureArrayList.get(i).getArchitects().size() ; k++){
                                        if(architectureArrayList.get(i).getArchitects().get(k).getName() == name){
                                            flag4 = true;

                                            String born = tokenizer.nextToken();                //third token as born
                                            architectureArrayList.get(i).getArchitects().get(k).setBorn(born);

                                            String died = tokenizer.nextToken();                //fourth token as died
                                            architectureArrayList.get(i).getArchitects().get(k).setDied(died);

                                            String nationality = tokenizer.nextToken();                //fifth token as nationality
                                            architectureArrayList.get(i).getArchitects().get(k).setNationality(nationality);

                                            architectArrayList.add(architectureArrayList.get(i).getArchitects().get(k));// add architect to arraylist




                                        }
                                    }
                                }
                                if(!flag4){
                                    Architect architect = new Architect();
                                    architect.setName(name);
                                    String born = tokenizer.nextToken();
                                    architect.setBorn(born);
                                    String died = tokenizer.nextToken();
                                    architect.setDied(died);
                                    String nationality = tokenizer.nextToken();
                                    architect.setNationality(nationality);

                                    architectArrayList.add(architect);// add architect to arraylist
                                }



                                break;}
                            }
                        }//close inner while

                    }//close outer while
                }
            catch(FileNotFoundException e){                            //io exceptions
                    System.out.println("Unable to open file city ");
                }
            catch(NoSuchElementException e)
                {
                    System.out.println("File not found.");
                }

            Vault vault = new Vault(architectArrayList ,artistArrayList, paintingArrayList,sculptureArrayList,architectureArrayList);
            return vault;
    }
}















