package game;

/**
 * Třída představující mapu prostorů herního světa. V datovém atributu
 * {@link #currentPlace} uchovává odkaz na aktuální prostor, ve kterém
 * se hráč právě nachází. Z aktuálního prostoru je možné se prostřednictvím
 * jeho sousedů dostat ke všem přístupným prostorům ve hře.
 *
 * @author Jan Říha
 * @version ZS-2020, 2020-12-14
 */
public class World
{
    /** Konstanta obsahující název vítězného prostoru <i>(jakmile do něj hráč přijde, vyhrál hru)</i>. */
    public static final String VICTORIOUS_PLACE_HOME_NAME = "domov";
    public static final String VICTORIOUS_ITEM_FLOWERS_NAME = "kvety";

    private Place currentPlace;

    /**
     * Konstruktor třídy, vytvoří jednotlivé prostory a propojí je pomocí
     * východů.
     */
    public World()
    {
        Place bar = new Place("bar", "Toto je bar, v ktorom si mal párty");
        Place florist = new Place("kvetinarstvo", "Kvetinárstvo, kde sa predávajú kvety non-stop.");
        Place tramOlsanska = new Place("tram_olšanská", "Tramvajová zastávka Olšanská, na ktorej čakáš na tramvaj na zastávku Štepánska.");
        Place tram = new Place("tramvaj", "Obyčajná nočná tramvaj, ktorou sa chceš odviezť domov.");
        Place tramStepanska = new Place("tram_štepánska", "Tramvajová zastávka Štepánska, odkiaľ sa potrebuješ dostať domov");
        Place homeEntrance = new Place("vchod_domov", "Vchod do domu, cez ktorý musíš prejsť.", true);
        Place home = new Place(VICTORIOUS_PLACE_HOME_NAME, "Toto je tvoj domov, kde bývaš so svojou priateľkou. Je na teba nahnevaná, musíš si ju udobriť.");

        bar.addNeighbor(florist);
        bar.addNeighbor(tramOlsanska);

        florist.addNeighbor(bar);
        florist.addNeighbor(tramOlsanska);

        tramOlsanska.addNeighbor(florist);
        tramOlsanska.addNeighbor(bar);
        tramOlsanska.addNeighbor(tram);

        tram.addNeighbor(tramOlsanska);
        tram.addNeighbor(tramStepanska);
        
        tramStepanska.addNeighbor(tram);
        tramStepanska.addNeighbor(homeEntrance);
        
        homeEntrance.addNeighbor(tramStepanska);
        homeEntrance.addNeighbor(home);
        home.addNeighbor(homeEntrance);

        
      
        
        
        

        Item keys = new Item("klíče",
                "Zväzok kľúčov od tvojeho domu.");
                
        homeEntrance.setLocked(true);
        homeEntrance.setKey(keys);

        Item wallet = new Item("peňaženka",
                "Tvoja peňaženka aj s peniazmi.");
                
        Item jacket = new Item("bunda",
                "Bunda, aby ti nebola zima.");

        Item flowers = new Item(VICTORIOUS_ITEM_FLOWERS_NAME,
                "Krásny zväzok kvetov, ktorý by určite niekoho potešil");

        Item fertilizer = new Item("hnojivo",
                "Hnojivo na izbové rastliny, ktoré doma pestujete.");
                

        Item seat = new Item("sedačka",
                "Sedačka v tramvaji. Krásne by doplnila interiér u teba doma", false);

        Item closet = new Item("skriňa",
                "Veľká skriňa na šaty. Niekto sa jej potreboval zbaviť.", false);

        Item vodka = new Item("vodka",
                "Fľaša už otvorenej vodky.");

       

        bar.addItem(keys);
        bar.addItem(wallet);
        bar.addItem(jacket);
        
        
        florist.addItem(flowers);
        florist.addItem(fertilizer);

        tramOlsanska.addItem(vodka);
        
        tram.addItem(seat);
        
        tramStepanska.addItem(closet);

        currentPlace = bar;
        
        
    }

    /**
     * Metoda vrací odkaz na aktuální prostor, ve kterém se hráč právě
     * nachází.
     *
     * @return aktuální prostor
     */
    public Place getCurrentPlace()
    {
        return currentPlace;
    }

    /**
     * Metoda nastaví aktuální prostor, používá ji příkaz {@link ActionMove}
     * při přechodu mezi prostory.
     *
     * @param place prostor, který bude nastaven jako aktuální
     */
    public void setCurrentPlace(Place place)
    {
        currentPlace = place;
    }
}
