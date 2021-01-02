package game;

import java.util.*;

/**
 * Třída představující inventář hráče, ktorý má formu TreeSetu - t.j. je usporiadaný.
 * Inventář má omezenou kapacitu <i>(maximální počet předmětů)</i> - t.j. v hre nie je možné zbierať veci donekonečna.
 * 
 *
 * @author Matus Ravas
 * @version 26-12-2020
 */
public class Bag {
    private TreeSet<Item> bagContent; 
    private static final int CAPACITY = 6; 

    /**
     * Hlavný konštruktor triedy, ktorý vytvorí nový bag, resp. prázdny TreeSet.
     *
     * @author Matus Ravas
     * @version 26-12-2020
     */
    public Bag() {
        bagContent = new TreeSet<Item>();
    }

    /**
     * Metóda, pomocou ktorej pridáme do bagu nejaký predmet,
     * pričom musí mať bag dostatočnú kapacitu a predmet musí byť prenositeľný.
     * <p>
     * @param item - konkrétna vec, ktorú budeme chcieť pridať do bagu
     * @return boolean - vrátime true/false, na základe toho, či sa do bagu vec podarila pridať alebo nie
     *
     * @author Matus Ravas
     * @version 26-12-2020
     */
    public boolean putItem(Item item) {
        if (isAvailableCapacity() && item.isMoveable()) {
            bagContent.add(item);
            return true;
        }
        return false;
    }

    /**
     * Metóda, pomocou ktorej odstránime z bagu nejaký predmet
     * <p>
     * @param item - konkrétna vec, ktorú budeme chcieť z bagu odstrániť
     * @return true/fasle -  na základe toho, či sa z bagu vec podarila odstrániť (metóda remove())
     *
     * @author Matus Ravas
     * @version 26-12-2020
     */
    public boolean deleteItem(Item item) {

        return bagContent.remove(item);
        //metóda na odstránenie predmetu z bagu
    }

    /**
     * Metóda, ktorá zistí, či je v danom bagu názov nejakého predmetu.
     * <p>
     * @param name - názov konkrétnej veci, pri ktorej chcem overiť, či sa v bagu nachádza
     * @return true/false -  na základe toho, či sa v bagu daná položka nachádza alebo nie
     *
     * @author Matus Ravas
     * @version 26-12-2020
     */
    public boolean containsItemName(String name){

        for(Item i : bagContent){
            if(i.getName().equals(name)){
                return true;
            }
        }
        return false;

    } 

    /**
     * Metóda, ktorá na základe mena konkrétnej veci vráti konkrétny item
     * <p>
     * @param name - názov konkrétnej veci, na základe ktorej chcem získať celý item
     * @return tmp - konkrétny item
     * <p>
     * pozn.: danú metódu použijem až keď sa presvedčím, že meno daného predmetu vôbec existuje - t.j
     * daná metóda vždy vráti nejaký item.
     *
     * @author Matus Ravas
     * @version 26-12-2020
     */
    public Item getItemByName(String name){
        Item tmp=null;
        for(Item i : bagContent){
            if(i.getName().equals(name)){
                tmp=i;
                break;
            }
        }
        return tmp;
    }

    /**
     * Metóda, ktorá na základe konkrétneho itemu vráti informáciu, či sa nachádza v bagu.
     * <p>
     * @param name - konkrétna vecc, na základe ktorej chcem získať hodnotu true/false
     * @return true/false - metóda contains()
     * 
     * 
     * @author Matus Ravas
     * @version 26-12-2020
     */
    public boolean containsItem(Item item) {
        return bagContent.contains(item);
    }

    /**
     * Metóda, ktorá zistí či má daný bag ešte dostatočnú kapacitu. Veľkosť bagu porovná s prednastavenou hodnotou v CAPACITY.
     * <p>
     * 
     * @return boolean - metóda vráti hodnotu true/false na základe toho, či ešte máme dostatočnú kapacitu
     * 
     * 
     * @author Matus Ravas
     * @version 26-12-2020
     */
    public boolean isAvailableCapacity() {
        return (bagContent.size() < CAPACITY);
    }

    /**
     * Prepíšeme metódu toString, aby vrátila názvy všetkych položiek Treesetu vo forme jedného reťazca.
     * Toto je možné vďaka tomu, že sme taktiež prepísali metódu toString v Item.
     * <p>
     * 
     * @return list - reťazec, ktorý bude obsahovať názvy jednotlivých vecí
     * 
     * 
     * @author Matus Ravas
     * @version 26-12-2020
     */
    @Override
    public String toString(){
        String list=""; //vytvorí prázdny reťazec
        for(Item i :bagContent){ //cyklus prechádza položkami treesetu

            list = list + i; //alebo skrateny tvar list+=i. pridáva názvy jednotlivých položiek do reťazca
        }
        return list;

    }

    /** !!!!?????
     * Metóda, ktorá nám vráti konkrétny obsah bagu.
     * <p>
     * 
     * @return bagContent - TreeSet, ktorý obsahuje jednotlivé veci
     * 
     * 
     * @author Matus Ravas
     * @version 26-12-2020
     */
    public TreeSet<Item> getTreeset(){
        return bagContent;
    }

}