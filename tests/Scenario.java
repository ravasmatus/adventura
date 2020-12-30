package tests;

/**
 * Instance interfejsu {@code Scenario} představují scénáře, podle kterých
 * je možno hrát hru, pro kterou jsou určeny. Aby bylo možno jednotlivé
 * scénáře od sebe odlišit, je každý pojmenován.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2020-Winter
 */
public enum Scenario implements IScenario
{
    HAPPY (
    new 

    ScenarioStep(0, "",
    "Vitajte!\n"
    + "Ste v bare, trošku ste dezorientovaný a potrebujete sa dostať domov.\n"
    + "Nevíte-li, jak pokračovat, zadejte příkaz 'nápověda'.",

    "bar",
    new String[] { "kvetinarstvo","tram_olšanská" },
    new String[] { "klíče", "peňaženka", "bunda" },
    new String[] { }
    ),

    new ScenarioStep("seber klíče",
    "Sebral(a) jsi předmět 'klíče' a uložil(a) ho do inventáře.",

    "bar",
    new String[] { "kvetinarstvo","tram_olšanská" },
    new String[] { "peňaženka", "bunda" },
    new String[] { "klíče" }
    ),

    new ScenarioStep("seber peňaženka",
    "Sebral(a) jsi předmět 'peňaženka' a uložil(a) ho do inventáře.",

    "bar",
    new String[] { "kvetinarstvo","tram_olšanská" },
    new String[] { "bunda"},
    new String[] { "klíče","peňaženka" }
    ),

    new ScenarioStep("jdi kvetinarstvo",
    "Jsi v prostoru 'kvetinarstvo'.\n"
    + "Kvetinárstvo, kde sa predávajú kvety non-stop.\n\n"
    + "Východy: bar tram_olšanská\n"
    + "Předměty: hnojivo kvety",

    "kvetinarstvo",
    new String[] { "bar", "tram_olšanská" },
    new String[] { "hnojivo", "kvety" },
    new String[] { "klíče","peňaženka" }
    ),
    
    new ScenarioStep("seber kvety",
    "Sebral(a) jsi předmět 'kvety' a uložil(a) ho do inventáře.",

    "kvetinarstvo",
    new String[] { "bar", "tram_olšanská" },
    new String[] { "hnojivo"},
    new String[] { "klíče","peňaženka","kvety" }
    ),
    
    new ScenarioStep("jdi tram_olšanská",
    "Jsi v prostoru 'tram_olšanská'.\n"
    + "Tramvajová zastávka Olšanská, na ktorej čakáš na tramvaj na zastávku Štepánska.\n\n"
    + "Východy: bar kvetinarstvo tramvaj\n"
    + "Předměty: vodka",

    "tram_olšanská",
    new String[] { "bar", "kvetinarstvo", "tramvaj" },
    new String[] {"vodka"},
    new String[] { "klíče","peňaženka","kvety" }
    ),

    new ScenarioStep("jdi tramvaj",
    "Jsi v prostoru 'tramvaj'.\n"
    + "Obyčajná nočná tramvaj, ktorou sa chceš odviezť domov.\n\n"
    + "Východy: tram_olšanská tram_štepánska\n"
    + "Předměty: sedačka",

    "tramvaj",
    new String[] { "tram_olšanská","tram_štepánska" },
    new String[] { "sedačka" },
    new String[] { "klíče","peňaženka","kvety" }
    ),
    
     new ScenarioStep("jdi tram_štepánska",
    "Jsi v prostoru 'tram_štepánska'.\n"
    + "Tramvajová zastávka Štepánska, odkiaľ sa potrebuješ dostať domov\n\n"
    + "Východy: tramvaj vchod_domov(zamknuto)\n"
    + "Předměty: skriňa",

    "tram_štepánska",
    new String[] { "tramvaj","vchod_domov" },
    new String[] { "skriňa" },
    new String[] { "klíče","peňaženka","kvety" }
    ),

    new ScenarioStep("odemkni vchod_domov",
    "Miestnost vchod_domov bola odomknuta.",

    "tram_štepánska",
    null,
    null,
    null
    ),
    
    new ScenarioStep("jdi vchod_domov",
    "Jsi v prostoru 'vchod_domov'.\n"
    + "Vchod do domu, cez ktorý musíš prejsť.\n\n"
    + "Východy: domov tram_štepánska\n"
    + "Předměty:",

    "vchod_domov",
    new String[] { "domov","tram_štepánska" },
    new String[] { },
    new String[] { "klíče","peňaženka","kvety" }
    ),
    
       new ScenarioStep("jdi domov",
    "Jsi v prostoru 'domov'.\n"
    + "Toto je tvoj domov, kde bývaš so svojou priateľkou. Je na teba nahnevaná, musíš si ju udobriť.\n\n"
    + "Východy: vchod_domov\n"
    + "Předměty:",

    "domov",
    new String[] { "vchod_domov" },
    new String[] { },
    new String[] { "klíče","peňaženka","kvety" }
    ),

    new ScenarioStep("poloz kvety",
    "Polozil(a) jsi předmět 'kvety' do mistnosti.\n\n"
    +"Vyhrál(a) jsi, dorazil(a) si domov a dal(a) priateľke kvety.",

    "domov",
    new String[] { "vchod_domov" },
    new String[] { "kvety"},
    new String[] { "klíče","peňaženka" }
    )
    ),

    ACTION_START(
    new 

    ScenarioStep(0, "konec",  // Zkusíme použít nějaký příkaz před zahájením hry
    "Hra aktuálně neběží, pro její zahájení stiskni klávesu 'Enter'.",

    null,
    null,
    null,
    null
    ),

    new ScenarioStep("",  // Zkusíme zahájit hru zadáním prázdného příkazu
    "Vítejte!\n"
    + "Toto je příběh o Červené Karkulce, babičce a vlkovi.\n"
    + "Nevíte-li, jak pokračovat, zadejte příkaz 'nápověda'.",

    null,
    null,
    null,
    null
    ),

    new ScenarioStep("",  // Zkusíme znovu použít prázdný příkaz po zahájení hry
    "Tomu nerozumím, příkaz '' neznám.",

    null,
    null,
    null,
    null
    ),

    new ScenarioStep("konec",  // Zkusíme ukončit rozehranou hru
    "Hra byla ukončena příkazem KONEC.",

    null,
    null,
    null,
    null
    ),

    new ScenarioStep("",  // Zkusíme zahájit novou hru zadáním prázdného příkazu
    "Vítejte!\n"
    + "Toto je příběh o Červené Karkulce, babičce a vlkovi.\n"
    + "Nevíte-li, jak pokračovat, zadejte příkaz 'nápověda'.",

    null,
    null,
    null,
    null
    )
    ),

    ACTION_MOVE(
    new 

    ScenarioStep(0, "",  // Spustíme hru, aby bylo možné používat příkazy
    null,

    null,
    null,
    null,
    null
    ),

    new ScenarioStep("jdi",  // Použijeme příkaz 'jdi' bez parametru
    "Tomu nerozumím, musíš zadat nějaký cíl, kam mám jít.",

    "domeček",
    new String[] { "les" },
    null,
    null
    ),

    new ScenarioStep("jdi abc xyz",  // Použijeme příkaz 'jdi' s více parametry
    "Tomu nerozumím, neumím se 'rozdvojit' a jít na více míst současně.",

    "domeček",
    new String[] { "les" },
    null,
    null
    ),

    new ScenarioStep("jdi ugh",  // Použijeme příkaz 'jdi' s názvem prostoru, který s aktuálním nesousedí
    "Do prostoru 'ugh' se odsud jít nedá.",

    "domeček",
    new String[] { "les" },
    null,
    null
    ),

    new ScenarioStep("jdi les",  // Použijeme příkaz 'jdi' s názvem prostoru, který sousedí s aktuálním
    null,

    "les",
    new String[] { "domeček", "temný_les" },
    null,
    null
    )
    );

    /** Jednotlivé kroky daného scénáře. */
    private final ScenarioStep[] steps;

    /**
     * Vytvoří nový scénář zadaného názvu určený pro zadanou hru. Konstruktor prověří,
     * jestli kroky scénáře alespoň formálně vyhovují požadavkům.
     *
     * @param steps jednotlivé kroky realizující daný scénář, příkaz v prvním <i>(přesněji
     *              nultém)</i> kroku musí být definována jako prázdný řetězec
     */
    Scenario(ScenarioStep... steps)
    {
        this.steps = steps;
    }

    /**
     * Vrátí vektor (jednorozměrné pole) kroků  daného scénáře.
     *
     * @return vektor kroků daného scénáře
     */
    public ScenarioStep[] steps()
    {
        return steps.clone();
    }
}
