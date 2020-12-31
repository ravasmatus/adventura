package game;

/**
 * Třída implementující příkaz pro pohyb mezi herními prostory.
 *
 * @author Jan Říha
 * @version ZS-2020, 2020-12-13
 */
public class ActionMove implements IAction
{
    private Game game;

    /**
     * Konstruktor třídy.
     *
     * @param game hra, ve které se bude příkaz používat
     */
    public ActionMove(Game game)
    {
        this.game = game;
    }

    /**
     * Metoda vrací název příkazu tj.&nbsp; slovo <b>jdi</b>.
     *
     * @return název příkazu
     */
    @Override
    public String getName()
    {
        return "jdi";
    }

    /**
     * Metoda se pokusí přesunout hráče do jiného prostoru. Nejprve zkontroluje počet
     * parametrů. Pokud nebyl zadán žádný parametr <i>(tj. neznáme cíl cesty)</i>,
     * nebo bylo zadáno dva a více parametrů <i>(tj. hráč chce jít na více míst
     * současně)</i>, vrátí chybové hlášení. Pokud byl zadán právě jeden parametr,
     * zkontroluje, zda s aktuálním prostorem sousedí prostor s daným názvem <i>(tj.
     * zda z aktuálního prostoru lze jít do požadovaného cíle)</i>. Pokud ne, vrátí
     * chybové hlášení. Pokud všechny kontroly proběhnou v pořádku, provede přesun
     * hráče do cílového prostoru a vrátí jeho popis.
     *
     * @param parameters parametry příkazu <i>(očekává se pole s jedním prvkem)</i>
     * @return informace pro hráče, které hra vypíše na konzoli
     */
    @Override
    public String execute(String... parameters)
    {
        if (parameters.length == 0) {  // Pokud hráč nezadá žádný parametr (cíl cesty)
            return "Tomu nerozumím, musíš zadat nějaký cíl, kam mám jít.";
        }

        
        if (parameters.length > 1) {  // Pokud hráč zadá více parametrů
            return "Tomu nerozumím, neumím se 'rozdvojit' a jít na více míst současně.";
        }

        String targetPlaceName = parameters[0];

        for (Place place : game.getWorld().getCurrentPlace().getNeighbors()) {
            
            if(targetPlaceName.equals(place.getName()) && place.isLocked()){
            return "Miestnost " + place.getName() + "je uzamknuta.";
            }
            
            Bag bag = game.getBag();
            
            if(targetPlaceName.equals("tramvaj") && !bag.containsItemName("jízdenka") ){
            game.setGameOver(true);
            return "Do miesta " +targetPlaceName + " si nastupil bez predmetu jízdenka. Chytil ťa revízor. Prehral si.";
            
           
            
            
            }
            
            if (targetPlaceName.equals(place.getName())) {
                game.getWorld().setCurrentPlace(place);

                return place.getFullDescription();
            }
        }

        return "Do prostoru '" + targetPlaceName + "' se odsud jít nedá.";
    }
}
