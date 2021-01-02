package game;
/**
 * Trieda, ktorá implementuje príkaz kúpiť. 
 *
 * @author Matúš Ravas
 * @version 2021-01-02
 */

public class ActionBuy implements IAction {
    private Game game;

     /**
     * Konstruktor třídy.
     *
     * @param game hra, ve které se bude příkaz používat
     */
    public ActionBuy(Game game) {
        this.game = game;
    }

    /**
     * Metoda vrací název příkazu tj.&nbsp; slovo <b>kup</b>.
     *
     * @return název příkazu
     */
    @Override
    public String getName() {
        return "kup";
    }

      /**
     * V případě, že je metoda zavolána bez parametrů, s jedným alebo viac ako 2 parametrami, hráčovi sa 
     * vypíše chybové hlásenie. Metóda najskôr overí, či sa daná vec nachádza v danom priestore, potom či je potrebné
     * ju zakúpiť. Následne zistí, či sa daný človek na mieste nachádza, a či je daná osoba spôsobilá nám ho predať.
     * Ako posledné overí, či máme pri sebe peňaženku a či nemáme plný inventár. 
     *
     * @param parameters parametry příkazu <i>(očakávame 2 parametre)</i>
     * @return informace pro hráče, které hra vypíše na konzoli
     */
    @Override
    public String execute(String... parameters) {
        if (parameters.length == 0) {  // pokial hrac nezada, co ma kupit
            return "Nerozumiem, musis napisat co mam kupit";
        }


        if (parameters.length == 1) {  // pokiaľ hráč zadá len jeden parameter
            return "Tomu nerozumiem, musis mi povedat, od koho si to mam kupit.";
        }

        if (parameters.length > 2) {  // pokiaľ hráč zadá viac ako 3 parametre
            return "Tomu nerozumiem, potrebujem len 2 parametre.";
        }
        
        String itemName = parameters[0];
        String personName = parameters[1];
        Place currentPlace = game.getWorld().getCurrentPlace(); //získame si aktuálne miesto v hre


        if (!currentPlace.containsItem(itemName)) { //zistím, či sa daný predmet nachádza v danej lokácii
            return "Předmět '" + itemName + "' tady není.";
        }

        Item item = currentPlace.getItem(itemName);
        
        if (currentPlace.containsItem(itemName) && !item.isMoneyRequired()) { // ak daná lokácia obsahuje predmet, avšak nie je určený na predaj
            return "Předmět '" + itemName + "' sa kupit neda. Mozes si ho zobrat.";
        }

        Bag bag = game.getBag();
        
        People people = currentPlace.getPerson(personName);
        if(!currentPlace.containsPerson(personName)){
        return "Človek " + personName + " tu nie je.";
        
        }
        
         if (!people.isSalePerson()){
            return "Predmet " + itemName + " si nemôžeš kúpiť od " + personName + ". Skús to u niekoho iného.";
        
        }
        
        
          if (item.isMoneyRequired() && !bag.containsItemName("peňaženka") ) { //ak si chcem niečo kúpiť, ale nemám peňaženku
            return "Předmět '" + itemName + "' sa kupit nemozes, chyba ti penazenka!";
        }

        if (!bag.putItem(item)) { //v prípade, že mám plný invetár
            return "Tvůj inventář je plný, '" + itemName + "' nebylo možné koupit.";
        }

        
        
       
        currentPlace.removeItem(itemName);
        
        return "Kúpil(a) jsi předmět '" + itemName + "' a uložil(a) ho do inventáře.";
      
    }


}
