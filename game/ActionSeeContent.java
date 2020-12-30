package game;



public class ActionSeeContent implements IAction
{
    private Game game;
    
    public ActionSeeContent(Game game)
    {
        this.game = game;
    }
    
    @Override
    public String getName() {
        return "zobraz_obsah";
    }


    @Override
    public String execute(String... parameters) { //overím, že nie je zadaný žiadny parameter
        if(parameters.length !=0){
            return "Tento prikaz nepotrebuje ziadny parameter";

        }

        Bag bag = game.getBag(); //keď nie je zadaný žiadny parameter, získam odkaz na bag v hre, ktorú práve teraz hrám
        return bag.toString(); //vďaka prepísanej metóde toString vrátim obsah bagu
    }
}
