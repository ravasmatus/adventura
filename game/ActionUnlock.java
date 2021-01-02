package game;
/**
 * Trieda, ktorá implementuje príkaz odomkni. 
 *
 * @author Matúš Ravas
 * @version 2021-01-02
 */
public class ActionUnlock implements IAction {
    private Game game;
    private String room = "Miestnost ";

     /**
     * Konstruktor třídy.
     *
     * @param game hra, ve které se bude příkaz používat
     */
    public ActionUnlock(Game game) {
        this.game = game;
    }

    /**
     * Metoda vrací název příkazu tj.&nbsp; slovo <b>odemkni</b>.
     *
     * @return název příkazu
     */
    @Override
    public String getName() {
        return "odemkni";
    }

      /**
     * V případě, že je metoda zavolána bez parametrů alebo viac ako 1 parametrami, hráčovi sa 
     * vypíše chybové hlásenie. Metóda pomocou cyklusu prejde akutálne susedné lokácie. V prípade, že je daná miestnosť
     * zamknutá a zároveň máme v bagu potrebný predmet, odomkne sa. V prípade, že nám kľúč chýba, vypíše chybové hlásenie.
     * Skontroluje taktiež, či už daná miestnosť nebola odomknutá - v tomto prípade o tom informuje hráča.
     *
     * @param parameters parametry příkazu <i>(očakávame 1 parameter)</i>
     * @return informace pro hráče, které hra vypíše na konzoli
     */
    @Override
    public String execute(String... parameters) {
        if (parameters.length == 0) {  // pokial hrac nezada, co ma odomknut
            return "Nerozumiem, musis napisat co mam odomknut";
        }

        if (parameters.length > 1) {  // pokiaľ hráč zadá viac parametrov
            return "Tomu nerozumím, odomknut vies len jednu miestnost.";
        }

        String targetPlaceNameForUnlock = parameters[0];
        Bag bag = game.getBag();

        
        for (Place place : game.getWorld().getCurrentPlace().getNeighbors()) {

            if (targetPlaceNameForUnlock.equals(place.getName()) && place.isLocked() && bag.containsItemName(place.getKey().getName())) {
                place.setLocked(false);
                return room + place.getName() + " bola odomknuta.";
            }// najskôr skontroluje, či je zadané miesto v susedstve, potom či je zamknuté a či máme potrebný predmet
            //ak sú podmienky splnené, odomkne miestnosť

            if (targetPlaceNameForUnlock.equals(place.getName()) && place.isLocked() && !bag.containsItemName(place.getKey().getName())) {

                return room + place.getName() + " nemozes odomknut, pretoze ti chyba predmet " + place.getKey().getName() ;
            }
            //ak nemáme potrebný predmet
            if (targetPlaceNameForUnlock.equals(place.getName()) && !place.isLocked()) {
                return room + targetPlaceNameForUnlock + " uz bola odokmnuta!";

            }
            //ak sa pokúsime odomknúť už odomknutú miestnosť
        }

        return room + targetPlaceNameForUnlock + " nemozes odomknut, pretoze je daleko od teba!";

    }

}
