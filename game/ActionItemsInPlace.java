package game;

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
     * Metoda vrací název příkazu tj.&nbsp; slovo <b>seber</b>.
     *
     * @return název příkazu
     */
    @Override
    public String getName() {
        return "ukaz_predmety";
    }

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
        return itemNames.toString(); //vrátime celý reťazec
    }
}
