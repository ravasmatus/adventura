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
 * @author Jan Říha
 * @version ZS-2020, 2020-12-14
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
