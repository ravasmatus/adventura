package game;
//trieda Item - každá položka má 5 atribúty - meno, popis, info o tom, či je prenositeľná a či je potrebné za ňu zaplatiť 
public class Item implements INamed, Comparable<Item>
{
    private String name;
    private String description;
    private boolean moveable;
    private boolean moneyRequired;

    public Item(String name, String description) //konštruktor
    {
        this(name, description, true, false);
    }

    public Item(String name, String description, boolean moveable, boolean moneyRequired) //konštruktor
    {
        this.name = name;
        this.description = description;
        this.moveable = moveable;
        this.moneyRequired = moneyRequired;
    }

    @Override //metóda, kt. získame meno
    public String getName()
    {
        return name;
    }

    public String getDescription() //metóda, kt. získame popis
    {
        return description;
    }

    public void setDescription(String description) //metóda, kt. nastavíme popis
    {
        this.description = description;
    }

    public boolean isMoveable() //metóda, kt. získame info o tom, či je prenositeľný
    {
        return moveable;
    }
    

    public void setMoveable(boolean moveable) //metóda, kt. nastavíme info o tom, či je prenositeľný
    {
        this.moveable = moveable;
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

        if (o instanceof Item) {
            Item item = (Item) o;

            return name.equals(item.getName());
        }

        return false;
    }

    
     public boolean isMoneyRequired() //metóda, kt. získame info o tom, či je potrebné za ňu platiť
    {
        return moneyRequired;
    }
    

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

    //pomocou prepísaním metódy toString sa pri výpise objektu tohoto typu vypíše len jeho názov
    @Override
    public String toString()
    {
        return name+" ";


    }
}
