package game;
/**
 * Trieda, ktorá implementuje príkaz, ktorá zobrazí predmety v bagu. 
 *
 * @author Matúš Ravas
 * @version 2021-01-02
 */


public class ActionSeeContent implements IAction
{
    private Game game;
    
    /**
     * Konstruktor třídy.
     *
     * @param game hra, ve které se bude příkaz používat
     */
    public ActionSeeContent(Game game)
    {
        this.game = game;
    }
    
     /**
     * Metoda vrací název příkazu tj.&nbsp; slovo <b>zobraz_obsah</b>.
     *
     * @return název příkazu
     */
    @Override
    public String getName() {
        return "zobraz_obsah";
    }


     /**
     * V prípade, že hráč zadá nejaký parameter, hra vypíše chybové hlásenie. Najskôr si metóda získa aktuálny bag z hry.
     * Potom, vďaka tomu, že sme prepísali metódu toString, vypíše na konzolu.
     *
     * @param parameters parametry příkazu <i>(neočakávame žiadny parameter)</i>
     * @return informace pro hráče, které hra vypíše na konzoli
     */
    @Override
    public String execute(String... parameters) { //overím, že nie je zadaný žiadny parameter
        if(parameters.length !=0){
            return "Tento prikaz nepotrebuje ziadny parameter";

        }

        Bag bag = game.getBag(); //keď nie je zadaný žiadny parameter, získam odkaz na bag v hre, ktorú práve teraz hrám
        return bag.toString(); //vďaka prepísanej metóde toString vrátim obsah bagu
    }
}
