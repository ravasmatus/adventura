package game;


//trieda people - každý človek bude mať 2 atribúty - meno a informáciu, či dokáže niečo predávať.

public class People implements INamed, Comparable<People>
{
    private String name;
    private boolean saleperson;

    public People(String name, boolean saleperson) //konštruktor
    {
        this.name = name;
        this.saleperson = saleperson;
    }

    @Override //metóda, ktorou získame meno
    public String getName()
    {
        return name;
    }

    public boolean isSalePerson()//metóda, ktorou získame true/false, či dokáže predávať
    {
        return saleperson;
    }
    

    public void setSaleperson(boolean saleperson) //metóda, ktorou nastavíme info, či dokáže predávať
    {
        this.saleperson = saleperson;
    }

    @Override
    public boolean equals(final Object o)
    {
        if (o == this) {
            return true;
        }

        if (o == null) {
            return false;
        }

        if (o instanceof People) {
            People people = (People) o;

            return name.equals(people.getName());
        }

        return false;
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
    @Override
    public String toString()
    {
        return name+" ";


    }
}
