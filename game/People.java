package game;

public class People implements INamed, Comparable<People>
{
    private String name;
    private boolean saleperson;

    public People(String name, boolean saleperson)
    {
        this.name = name;
        this.saleperson = saleperson;
    }

    @Override
    public String getName()
    {
        return name;
    }

    public boolean isSalePerson()
    {
        return saleperson;
    }
    

    public void setSaleperson(boolean saleperson)
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
