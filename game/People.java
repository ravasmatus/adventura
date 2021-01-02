package game;

/**
 * Trieda, ktorá predstavuje jednotlivých ľudí. V datovém atributu
 * {@link #name} uchovává meno danej osoby. V datovém atributu
 * {@link #saleperson} uchovává informáciu, či je človek spôsobilý niečo predávať. 
 *
 * @author Matúš Ravas
 * @version 2021-01-02
 */
public class People implements INamed, Comparable<People>
{
    private String name;
    private boolean saleperson;

     /**
     * Konstruktor třídy, ktorý vytvorí konkrétneho človeka. Má dva parametre - meno a boolean true/false.
     */
    public People(String name, boolean saleperson) //konštruktor
    {
        this.name = name;
        this.saleperson = saleperson;
    }

    /**
     * Metóda, ktorá nám vráti názov človeka.
     * 
     * @return name - názov
     */
    @Override
    public String getName()
    {
        return name;
    }

     /**
     * Metóda, ktorou získame true/false, či dokáže predávať.
     * 
     * @return saleperson - true/false
     */
    public boolean isSalePerson()
    {
        return saleperson;
    }

     /**
     * Metóda, ktorou nastavíme info true/false, či dokáže predávať.
     * 
     * @param saleperson - true/false
     */
    public void setSaleperson(boolean saleperson) 
    {
        this.saleperson = saleperson;
    }

   
    @Override
    public int hashCode()
    {
        return name.hashCode();
    }

    public int compareTo(People people)
    {
        return name.compareTo(people.getName());
    }

    //pomocou prepísaním metódy toString sa pri výpise objektu tohoto typu vypíše len jeho názov
     /**
     * Pomocou prepísaním metódy toString sa pri výpise objektu tohoto typu vypíše len jeho názov.
     * 
     *
     */
    @Override
    public String toString()
    {
        return name+" ";

    }
}
