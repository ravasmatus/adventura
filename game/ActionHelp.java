package game;

/**
 * Třída implementující příkaz pro zobrazení nápovědy ke hře.
 *
 * @author Jan Říha
 * @version ZS-2020, 2020-12-07
 */
public class ActionHelp implements IAction
{
    private Game game;

    /**
     * Konstruktor třídy.
     *
     * @param game hra, ve které se bude příkaz používat
     */
    public ActionHelp(Game game)
    {
        this.game = game;
    }

    /**
     * Metoda vrací název příkazu tj.&nbsp; slovo <b>nápověda</b>.
     *
     * @return název příkazu
     */
    @Override
    public String getName()
    {
        return "nápověda";
    }

    /**
     * Metoda vrací obecnou nápovědu ke hře. Nyní vypisuje vcelku primitivní
     * zprávu o herním příběhu a seznam dostupných příkazů, které může hráč
     * používat.
     *
     * @param parameters parametry příkazu <i>(aktuálně se ignorují)</i>
     * @return nápověda, kterou hra vypíše na konzoli
     */
    @Override
    public String execute(String... parameters)
    {
        return "Tvojou úlohou je dostať sa pomocou tramvaje domov."
                + "\nMusíš si taktiež nejako udobriť svoju priateľku."
                + "\n\nVe hře můžeš používat tyto příkazy:\n"
                + game.getAllActions().getAllNames();
    }
}
