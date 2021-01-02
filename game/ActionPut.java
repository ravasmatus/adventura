package game;

/**
 * Třída implementující příkaz pre pokladanie predmetov.
 *
 * @author Jan Říha
 * @version ZS-2020, 2020-12-14
 */
public class ActionPut implements IAction {
    private Game game;

    /**
     * Konstruktor třídy.
     *
     * @param game hra, ve které se bude příkaz používat
     */
    public ActionPut(Game game) {
        this.game = game;
    }

    /**
     * Metoda vrací název příkazu tj.&nbsp; slovo <b>poloz</b>.
     *
     * @return název příkazu
     */
    @Override
    public String getName() {
        return "poloz";
    }

    /**
     * Metóda sa pokúsi odstrániť predmet z hráčoveho bagu a pridať ho do aktuálnej lokácie.
     * Najskôr skontroluje počet parametrov - v prípade žiadneho, alebo viac ako jedného vypíše chybové hlásenie.
     * Potom metóda získa aktuálne miesto a aktuálny obsah bagu. Následne skontroluje, či sa daný predmet v bagu nachádza. 
     * V prípade úspechu získame konkrétnu vec(nie len jej názov), odstránime ju z bagu a pridáme do lokácie.
     *
     * @param parameters parametry příkazu <i>(očekává se pole s jedním prvkem)</i>
     * @return informace pro hráče, které hra vypíše na konzoli
     */
    @Override
    public String execute(String... parameters) {
        if (parameters.length == 0) {
            return "Tomu nerozumím, musíš mi říct, co mám položit.";
        }

        if (parameters.length > 1) {
            return "Tomu nerozumím, neumím položit více předmětů současně.";
        }

        String itemName = parameters[0];
        Place currentPlace = game.getWorld().getCurrentPlace(); //získame si aktuálne miesto, kde sa hráč nachádza
        Bag bag = game.getBag(); //získame aktuálny obsah bagu
        if (!bag.containsItemName(itemName)) { //skontrolujeme, či daný predmet v taške je, ak nie vypíše danä hlášku
            return "Předmět '" + itemName + "' není v taske.";
        }
        Item item = bag.getItemByName(itemName); //názov predmetu priradíme už celému predmetu so všetkými atribútmi
        bag.deleteItem(item);//odstránime položku z bagu

        currentPlace.addItem(item); //pridáme do aktuálnej oblasti

        return "Polozil(a) jsi předmět '" + itemName + "' do mistnosti.";
    }
}
