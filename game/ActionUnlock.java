package game;

public class ActionUnlock implements IAction {
    private Game game;

    public ActionUnlock(Game game) {
        this.game = game;
    }

    @Override
    public String getName() {
        return "odemkni";
    }

    @Override
    public String execute(String... parameters) {
        if (parameters.length == 0) {  // pokial hrac nezada, co ma odomknut
            return "Nerozumiem, musis napisat co mam odomknut";
        }

        if (parameters.length > 1) {  // pokiaľ hráč zadá viac parametrov
            return "Tomu nerozumím, odomknut vies len jednu miestnost.";
        }

        String targetPlaceNameForUnlock = parameters[0];
        Bag bag = game.getBag();

        
        for (Place place : game.getWorld().getCurrentPlace().getNeighbors()) {

            if (targetPlaceNameForUnlock.equals(place.getName()) && place.isLocked() && bag.containsItemName(place.getKey().getName())) {
                place.setLocked(false);
                return "Miestnost " + place.getName() + " bola odomknuta.";
            }// najskôr skontroluje, či je zadané miesto v susedstve, potom či je zamknuté a či máme potrebný predmet
            //ak sú podmienky splnené, odomkne miestnosť

            if (targetPlaceNameForUnlock.equals(place.getName()) && place.isLocked() && !bag.containsItemName(place.getKey().getName())) {

                return "Miestnost " + place.getName() + " nemozes odomknut, pretoze ti chyba predmet " + place.getKey().getName() ;
            }
            //ak nemáme potrebný predmet
            if (targetPlaceNameForUnlock.equals(place.getName()) && !place.isLocked()) {
                return "Miestnost " + targetPlaceNameForUnlock + " uz bola odokmnuta!";

            }
            //ak sa pokúsime odomknúť už odomknutú miestnosť
        }

        return "Miestnost " + targetPlaceNameForUnlock + " nemozes odomknut, pretoze je daleko od teba!";

    }

}
