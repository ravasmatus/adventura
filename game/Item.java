package game;
/**
 * Trieda, ktorá predstavuje jednotlivé položky. V datovém atributu
 * {@link #name} uchovává názov danej veci. V datovém atributu
 * {@link #decription} uchovává reťazec obsahujúci popis danej veci. V datovém atributu
 * {@link #moveable} uchovává hodnotu true/false o tom, či je daný objekt prenositeľný. Ak prenositeľný nie je,
 * nie je umožnené pridať ho do bagu. V datovém atributu
 * {@link #moneyRequired} uchovává hodnotu true/false, či je potrebné túto vec kúpiť.
 *
 * @author Jan Říha, edited by Matúš Ravas
 * @version 2021-01-02
 */
public class Item implements INamed, Comparable<Item>
{
    private String name;
    private String description;
    private boolean moveable;
    private boolean moneyRequired;

     /**
     * Konstruktor třídy, ktorý vytvorí konkrétnu vec v prípade, že zadáme len parametre name a description, 
     * t.j. hodnota moveable má hodnotu true a moneyRequired false.
     */
    public Item(String name, String description)
    {
        this(name, description, true, false);
    }

    /**
     * Konstruktor třídy, ktorý vytvorí konkrétnu vec v prípade, že zadáme všetky požadované parametre.
     */
    public Item(String name, String description, boolean moveable, boolean moneyRequired) 
    {
        this.name = name;
        this.description = description;
        this.moveable = moveable;
        this.moneyRequired = moneyRequired;
    }

    /**
     * Metóda, ktorá nám vráti názov konkrétnej veci.
     * 
     * @return name - názov
     */
    @Override 
    public String getName()
    {
        return name;
    }

    /**
     * Metóda, ktorá nám vráti popis konkrétnej veci.
     * 
     * @return description - popis
     */
    public String getDescription() 
    {
        return description;
    }

    /**
     * Metóda, pomocou ktorej nastavíme popis danej veci.
     * 
     * @param description - reťazec, popis
     */
    public void setDescription(String description) 
    {
        this.description = description;
    }

    /**
     * Metóda, pomocou ktorej zistíme, či je daná vec prenositeľná.
     * 
     * @return moveable - hodnota true/fale
     */
    public boolean isMoveable() 
    {
        return moveable;
    }

    /**
     * Metóda, pomocou ktorej nastavíme informáciu, či je daný predmet prenositeľný.
     * 
     * @param moveable - hodnota true/fale
     */
    public void setMoveable(boolean moveable)
    {
        this.moveable = moveable;
    }


    /**
     * Metóda, pomocou ktorej zistíme, či je potrebné za danú vec zaplatiť.
     * 
     * @return moneyRequired - hodnota true/fale
     */
    public boolean isMoneyRequired() 
    {
        return moneyRequired;
    }

    /**
     * Metóda, pomocou ktorej nastavíme informáciu, či musíme za daný predmet zaplatiť.
     * 
     * @param moneyRequired - hodnota true/fale
     */
    public void setMoneyRequired(boolean MoneyRequired) //metóda, kt. nastavíme info o tom, či je prenositeľný
    {
        this.moneyRequired = moneyRequired;
    }

    @Override
    public int hashCode()
    {
        return name.hashCode();
    }

    @Override
    public int compareTo(Item item)
    {
        return name.compareTo(item.getName());
    }

    /**
     * Prepíšeme metódu toString, aby pri výpise konkrétnej veci vrátila len jeho názov
     * 
     * @return name+" "  - vráti názvy konkrétnych vecí, pričom budú oddelené medzerou
     */
    @Override
    public String toString()
    {
        return name+" ";

    }
}
