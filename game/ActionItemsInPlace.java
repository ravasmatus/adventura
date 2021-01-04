package game;
/**
 * Trieda, ktorá implementuje príkaz, ktorá zobrazí predmety v danom priestore. 
 *
 * @author Matúš Ravas
 * @version 2021-01-02
 */
public class ActionItemsInPlace implements IAction
{
    private Game game;

    /**
     * Konstruktor třídy.
     *
     * @param game hra, ve které se bude příkaz používat
     */
    public ActionItemsInPlace(Game game) {
        this.game = game;
    }

    /**
     * Metoda vrací název příkazu tj.&nbsp; slovo <b>ukaz_predmety</b>.
     *
     * @return název příkazu
     */
    @Override
    public String getName() {
        return "ukaz_predmety";
    }

    /**
     * V prípade, že hráč zadá nejaký parameter, hra vypíše chybové hlásenie. Najskôr si metóda získa aktuálnu miestnosť
     * a vytvorí nový reťazec, do ktorého postupne pomocou cyklu naplní predmety.
     *
     * @param parameters parametry příkazu <i>(neočakávame žiadny parameter)</i>
     * @return informace pro hráče, které hra vypíše na konzoli
     */
    @Override
    public String execute(String... parameters) {
        if (parameters.length != 0) {
            return "Nepotrebujem ziadny parameter.";
        }

        Place currentPlace = game.getWorld().getCurrentPlace(); //získam aktuálne miesto
        String itemNames = "V miestnosti su:"; //vytvoríme nový reťazec
        for (Item i : currentPlace.getItems()) { //cyklusom prejdeme aktuálne predmety v lokácii
            itemNames+=" ";
            itemNames+=i; //pridáma ich do reťazca
        }
        return itemNames; //vrátime celý reťazec
    }
}
