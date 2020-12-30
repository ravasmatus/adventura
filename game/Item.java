package game;

public class Item implements INamed, Comparable<Item>
{
    private String name;
    private String description;
    private boolean moveable;

    public Item(String name, String description)
    {
        this(name, description, true);
    }

    public Item(String name, String description, boolean moveable)
    {
        this.name = name;
        this.description = description;
        this.moveable = moveable;
    }

    @Override
    public String getName()
    {
        return name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public boolean isMoveable()
    {
        return moveable;
    }
    

    public void setMoveable(boolean moveable)
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