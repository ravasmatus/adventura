package game;

import java.util.*;

/**
 * Třída představující inventář hráče. Její implementaci musíte připravit
 * Vy. Inventář musí mít omezenou kapacitu <i>(maximální počet předmětů,
 * váha předmětů, kombinace obou podmínek apod.)</i>. Ve hře nesmí být
 * možné sbírat předměty do nekonečna - hráč by se měl dostat do situace,
 * že bude mít k dispozici více předmětů, než kolik se jich do inventáře
 * vejde, a bude muset volit, které předměty nechá v prostoru a které si
 * vezme s sebou.
 *
 * @author Matus Ravas
 * @version 26-12-2020
 */
public class Bag {
    private TreeSet<Item> bagContent; //vytvoríme treeset - aby boli predmety usporiadené
    private static final int CAPACITY = 6; //atribút, s max kapacitou 6

    public Bag() {
        bagContent = new TreeSet<Item>(); //konštruktor, ktorým vytvoríme už daný obsah bagu
    }

    public boolean putItem(Item item) {
        if (isAvailableCapacity() == true && item.isMoveable() == true) {
            bagContent.add(item);
            return true;
        }
        return false; //metóda, pomocou ktorej pridáme do bagu nejaký predmet, pričom musí mať bag dostatočnú kapacitu a predmetu musí byť prenositeľný
    }

    public boolean deleteItem(Item item) {

        return bagContent.remove(item);
        //metóda na odstránenie predmetu z bagu
    }

    public boolean containsItemName(String name){

        for(Item i : bagContent){
            if(i.getName().equals(name)){
                return true;
            }
        }
        return false;
        //metóda, ktorá zistí, či je v danom bagu názov nejakého predmetu, a vráti true/false
    } 

    public Item getItemByName(String name){
        Item tmp=null;
        for(Item i : bagContent){
            if(i.getName().equals(name)){
                tmp=i;
                return i;
            }
        }
        return tmp;
        //metóda, ktorá vráti len meno daného predmetu
    }

    private boolean containsItem(Item item) {
        return bagContent.contains(item);
        //metóda, ktorá vráti info, či sa v bagu nachádza nejaký predmet
    }

    public boolean isAvailableCapacity() {
        return (bagContent.size() < CAPACITY);
        //metóda, ktorá zistí či má daný bag ešte dostatočnú kapacitu
    }

    //prepíšeme metódu toString aby vrátila názvy všetkych položiek Treesetu vo forme jedného reťazca
    //môžme to spraviť pomocou prepísania toString v Item - vypíše len názov Itemu
    @Override
    public String toString(){
        String list=""; //vytvorí prázdny reťazec
        for(Item i :bagContent){ //cyklus prechádza položkami treesetu

            list = list + i; //alebo skrateny tvar list+=i. pridáva názvy jednotlivých položiek do reťazca
        }
        return list;

    }

}