public class Runner {
    public void start(){
        CSVReader reader = new CSVReader();
        Vault mainVault = reader.readFile();
        Menu menu = new Menu(mainVault);

        menu.userMenu();
    }
}

