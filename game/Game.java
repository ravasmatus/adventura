package game;

/**
 * Hlavní třída hry. Vytváří a uchovává odkazy na instance tříd {@link Bag}
 * a {@link World} a také vytváří seznam platných příkazů a instance tříd
 * provádějících jednotlivé příkazy.
 * <p>
 * Veškeré informace o stavu hry <i>(mapa prostorů, inventář, vlastnosti
 * hlavní postavy, informace o plnění úkolů apod.)</i> by měly být uložené
 * zde v podobě datových atributů.
 * <p>
 * Během hry třída vyhodnocuje jednotlivé příkazy zadané uživatelem.
 *
 * @author Jan Říha, edited by Matúš Ravas
 * @version 2020-01-02
 */
public class Game
{
    private ListOfActions allActions;
    private boolean gameOver;
    private Bag bag;
    private World world;

    /**
     * Konstruktor třídy, vytvoří hru a seznam platných příkazů. Hra po
     * vytvoření neběží, je nutné ji zahájit zadáním 'prázdného příkazu'.
     */
    public Game()
    {
        allActions = new ListOfActions();
        allActions.addAction(new ActionHelp(this));
        allActions.addAction(new ActionTerminate(this));
        allActions.addAction(new ActionMove(this));
        allActions.addAction(new ActionPut(this));
        allActions.addAction(new ActionPick(this));
        allActions.addAction(new ActionSeeContent(this));
        allActions.addAction(new ActionUnlock(this));
        allActions.addAction(new ActionBuy(this));
        allActions.addAction(new ActionItemsInPlace(this));
        
       

        gameOver = true;
    }

    /**
     * Metoda vrací odkaz na katalog všech platných herních příkazů.
     *
     * @return katalog herních příkazů
     */
    public ListOfActions getAllActions()
    {
        return allActions;
    }

    /**
     * Metoda vrací informaci, zda hra již skončila <i>(je jedno, jestli
     * výhrou, prohrou nebo příkazem 'konec')</i>.
     *
     * @return {@code true}, pokud hra již skončila; jinak {@code false}
     */
    public boolean isGameOver()
    {
        return gameOver;
    }

    /**
     * Metoda nastaví příznak indikující, zda hra skončila. Metodu
     * využívá třída {@link ActionTerminate}, mohou ji ale použít
     * i další implementace rozhraní {@link IAction}.
     *
     * @param gameOver příznak indikující, zda hra již skončila
     */
    public void setGameOver(boolean gameOver)
    {
        this.gameOver = gameOver;
    }

    /**
     * Metoda vrací odkaz na inventář hráče.
     *
     * @return inventář hráče.
     */
    public Bag getBag()
    {
        return bag;
    }


    /**
     * Metoda vrací odkaz na mapu prostorů herního světa.
     *
     * @return mapa prostorů herního světa
     */
    public World getWorld()
    {
        return world;
    }

    /**
     * Metoda zpracuje herní příkaz <i>(jeden řádek textu zadaný na konzoli)</i>.
     * Řetězec uvedený jako parametr se rozdělí na slova. První slovo je považováno
     * za název příkazu, další slova za jeho parametry.
     * <p>
     * Metoda nejprve ověří, zda první slovo odpovídá hernímu příkazu <i>(např.
     * 'napoveda', 'konec', 'jdi' apod.)</i>. Pokud ano, spustí obsluhu tohoto
     * příkazu a zbývající slova předá jako parametry.
     * <p>
     * Pokud hra aktuálně neběží, metoda přijme prázdný textový řetězec jako pokyn
     * pro zahájení nové hry.
     *
     * @param input text, který hráč zadal na konzoli jako příkaz pro hru
     * @return výsledek zpracování <i>(informace pro hráče, které se vypíšou na konzoli)</i>
     */
    public String executeAction(String input)
    {
        if (gameOver && input.equals("")) {
            return startGame();
        } else if (gameOver) {
            return "Hra aktuálně neběží, pro její zahájení stiskni klávesu 'Enter'.";
        } else {
            String[] words = input.split("[ \t]+");

            String actionName = words[0];
            String[] actionParameters = new String[words.length - 1];

            for (int i = 0; i < actionParameters.length; i++) {
                actionParameters[i] = words[i + 1];
            }

            if (allActions.checkAction(actionName)) {
                IAction action = allActions.getAction(actionName);

                String actionResult = action.execute(actionParameters);
                String epilogue = checkGameEnd();

                String result = actionResult;
                if (epilogue != null) {
                    result += "\n\n" + epilogue;
                }

                return result;
            } else {
                return "Tomu nerozumím, příkaz '" + actionName + "' neznám.";
            }
        }
    }

    
 /**
 * Metóda, ktorá overí, či sa naša aktuálna lokácia zhoduje s tou, ktorá je nastavená ako výherná.
 * Zároveň overí, či sa v aktuálnej lokácií nachádza aj výherný predmet.
 * 
 * @return výsledok spracovania - informácia, ktorá sa vypíše na konzolu, keď hráč hru vyhrá.
 *
 * @author Jan Říha, edited by Matúš Ravas
 * @version ZS-2020, 2020-12-07
 * 
 */
    
    private String checkGameEnd()
    {
        if (World.VICTORIOUS_PLACE_HOME_NAME.equals(world.getCurrentPlace().getName())) {
            for (Item item : world.getCurrentPlace().getItems()) {
                if (World.VICTORIOUS_ITEM_FLOWERS_NAME.equals(item.getName())) {
                    gameOver = true;
                    return "Vyhrál(a) jsi, dorazil(a) si domov a dal(a) priateľke kvety.";
                }
            }
        }

        return null;
    }

 /**
 * Metóda, ktorá inicializuje novú hru, t.j. budeme sa nachádzať v predvolenej lokácii a obsah bagu bude prázdny.
 *
 *@return úvodná popis hry, ktorý sa hráčovi vypíše na konzolu
 *
 * @author Jan Říha
 * @version ZS-2020, 2020-12-07
 */
    private String startGame()
    {
        gameOver = false;
        world = new World();
        bag = new Bag();

        return "Vitajte!"
                + "\nSte v bare, trošku ste dezorientovaný a potrebujete sa dostať domov."
                + "\nNevíte-li, jak pokračovat, zadejte příkaz 'nápověda'.";
    }
}
