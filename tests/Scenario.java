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
    new String[] { "kvetinarstvo","trafika","tram_olšanská" },
    new String[] { "klíče", "peňaženka", "bunda" },
    new String[] { },
    new String[] { }
    ),

    new ScenarioStep("seber klíče",
    "Sebral(a) jsi předmět 'klíče' a uložil(a) ho do inventáře.",

    "bar",
    new String[] { "kvetinarstvo","trafika","tram_olšanská" },
    new String[] { "peňaženka", "bunda" },
    new String[] { "klíče" },
    new String[] { }
    ),

    new ScenarioStep("seber peňaženka",
    "Sebral(a) jsi předmět 'peňaženka' a uložil(a) ho do inventáře.",

    "bar",
    new String[] { "kvetinarstvo","trafika","tram_olšanská" },
    new String[] { "bunda"},
    new String[] { "klíče","peňaženka" },
    new String[] { }
    ),

    new ScenarioStep("jdi kvetinarstvo",
    "Jsi v prostoru 'kvetinarstvo'.\n"
    + "Kvetinárstvo, kde sa predávajú kvety non-stop.\n\n"
    + "Východy: bar trafika tram_olšanská\n"
    + "Předměty: hnojivo kvety\n"
    + "Ľudia: predavač upratovač",

    "kvetinarstvo",
    new String[] { "bar","trafika", "tram_olšanská" },
    new String[] { "hnojivo", "kvety" },
    new String[] { "klíče","peňaženka" },
    new String[] { "predavač", "upratovač"}
    ),
    
    new ScenarioStep("kup kvety predavač",
    "Kúpil(a) jsi předmět 'kvety' a uložil(a) ho do inventáře.",

    "kvetinarstvo",
    new String[] { "bar","trafika", "tram_olšanská" },
    new String[] { "hnojivo"},
    new String[] { "klíče","peňaženka","kvety" },
    new String[] { "predavač", "upratovač"}
    ),
    
     new ScenarioStep("jdi trafika",
    "Jsi v prostoru 'trafika'.\n"
    + "Obyčajná trafika pri centre Prahy, otvorená non-stop.\n\n"
    + "Východy: bar kvetinarstvo tram_olšanská\n"
    + "Předměty: jízdenka noviny\n"
    + "Ľudia: predavač zákazník",

    "trafika",
    new String[] { "bar", "kvetinarstvo", "tram_olšanská" },
    new String[] {"jízdenka", "noviny"},
    new String[] { "klíče","peňaženka","kvety" },
    new String[] { "predavač", "zákazník"}
    ),
    
     new ScenarioStep("kup jízdenka predavač",
    "Kúpil(a) jsi předmět 'jízdenka' a uložil(a) ho do inventáře.",

    "trafika",
    new String[] { "bar","kvetinarstvo", "tram_olšanská" },
    new String[] { "noviny"},
    new String[] { "jízdenka","klíče","peňaženka","kvety" },
    new String[] { "predavač", "zákazník"}
    ),
    
    
    new ScenarioStep("jdi tram_olšanská",
    "Jsi v prostoru 'tram_olšanská'.\n"
    + "Tramvajová zastávka Olšanská, na ktorej čakáš na tramvaj na zastávku Štepánska.\n\n"
    + "Východy: bar kvetinarstvo trafika tramvaj\n"
    + "Předměty: vodka\n"
    + "Ľudia:",

    "tram_olšanská",
    new String[] { "bar", "kvetinarstvo","trafika", "tramvaj" },
    new String[] {"vodka"},
    new String[] { "jízdenka","klíče","peňaženka","kvety" },
    new String[] {}
    ),

    new ScenarioStep("jdi tramvaj",
    "Jsi v prostoru 'tramvaj'.\n"
    + "Obyčajná nočná tramvaj, ktorou sa chceš odviezť domov.\n\n"
    + "Východy: tram_olšanská tram_štepánska\n"
    + "Předměty: sedačka\n"
    + "Ľudia:",

    "tramvaj",
    new String[] { "tram_olšanská","tram_štepánska" },
    new String[] { "sedačka" },
    new String[] { "jízdenka","klíče","peňaženka","kvety" },
    new String[] {}
    ),
    
     new ScenarioStep("jdi tram_štepánska",
    "Jsi v prostoru 'tram_štepánska'.\n"
    + "Tramvajová zastávka Štepánska, odkiaľ sa potrebuješ dostať domov\n\n"
    + "Východy: tramvaj vchod_domov(zamknuto)\n"
    + "Předměty: skriňa\n"
    + "Ľudia:",

    "tram_štepánska",
    new String[] { "tramvaj","vchod_domov" },
    new String[] { "skriňa" },
    new String[] { "klíče","peňaženka","jízdenka","kvety" },
    new String[] {}
    ),

    new ScenarioStep("odemkni vchod_domov",
    "Miestnost vchod_domov bola odomknuta.",

    "tram_štepánska",
    null,
    null,
    null,
    null
    ),
    
    new ScenarioStep("jdi vchod_domov",
    "Jsi v prostoru 'vchod_domov'.\n"
    + "Vchod do domu, cez ktorý musíš prejsť.\n\n"
    + "Východy: domov tram_štepánska\n"
    + "Předměty:\n"
    + "Ľudia:",

    "vchod_domov",
    new String[] { "domov","tram_štepánska" },
    new String[] { },
    new String[] { "klíče","peňaženka","jízdenka","kvety" },
    new String[] {}
    
    ),
    
       new ScenarioStep("jdi domov",
    "Jsi v prostoru 'domov'.\n"
    + "Toto je tvoj domov, kde bývaš so svojou priateľkou. Je na teba nahnevaná, musíš si ju udobriť.\n\n"
    + "Východy: vchod_domov\n"
    + "Předměty:\n"
    + "Ľudia: priateľka",

    "domov",
    new String[] { "vchod_domov" },
    new String[] { },
    new String[] { "klíče","peňaženka","jízdenka","kvety" },
    new String[] {"priateľka"}
    ),

    new ScenarioStep("poloz kvety",
    "Polozil(a) jsi předmět 'kvety' do mistnosti.\n\n"
    +"Vyhrál(a) jsi, dorazil(a) si domov a dal(a) priateľke kvety.",

    "domov",
    new String[] { "vchod_domov" },
    new String[] { "kvety"},
    new String[] { "klíče","jízdenka","peňaženka" },
    new String[] {"priateľka"}
    )
    ),

    ACTION_START(
    new 

    ScenarioStep(0, "konec",  // Zkusíme použít nějaký příkaz před zahájením hry
    "Hra aktuálně neběží, pro její zahájení stiskni klávesu 'Enter'.",

    null,
    null,
    null,
    null,
    null
    ),

    new ScenarioStep("",  // Zkusíme zahájit hru zadáním prázdného příkazu
    "Vitajte!\n"
    + "Ste v bare, trošku ste dezorientovaný a potrebujete sa dostať domov.\n"
    + "Nevíte-li, jak pokračovat, zadejte příkaz 'nápověda'.",
    null,
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
    null,
    null
    ),

    new ScenarioStep("konec",  // Zkusíme ukončit rozehranou hru
    "Hra byla ukončena příkazem KONEC.",

    null,
    null,
    null,
    null,
    null
    ),

    new ScenarioStep("",  // Zkusíme zahájit novou hru zadáním prázdného příkazu
    "Vitajte!\n"
    + "Ste v bare, trošku ste dezorientovaný a potrebujete sa dostať domov.\n"
    + "Nevíte-li, jak pokračovat, zadejte příkaz 'nápověda'.",
    null,
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
    null,
    null
    ),

    new ScenarioStep("jdi",  // Použijeme příkaz 'jdi' bez parametru
    "Tomu nerozumím, musíš zadat nějaký cíl, kam mám jít.",

    "bar",
    new String[] { "kvetinarstvo","trafika","tram_olšanská" },
    null,
    null,
    null
    ),

    new ScenarioStep("jdi abc xyz",  // Použijeme příkaz 'jdi' s více parametry
    "Tomu nerozumím, neumím se 'rozdvojit' a jít na více míst současně.",

    "bar",
    new String[] { "kvetinarstvo","trafika","tram_olšanská" },
    null,
    null,
    null
    ),

    new ScenarioStep("jdi ugh",  // Použijeme příkaz 'jdi' s názvem prostoru, který s aktuálním nesousedí
    "Do prostoru 'ugh' se odsud jít nedá.",

    "bar",
    new String[] { "kvetinarstvo","trafika","tram_olšanská" },
    null,
    null,
    null
    ),

    new ScenarioStep("jdi kvetinarstvo",  // Použijeme příkaz 'jdi' s názvem prostoru, který sousedí s aktuálním
    null,

    "kvetinarstvo",
    new String[] { "bar","trafika","tram_olšanská" },
    null,
    null,
    null
    )
    ),
    
    
    
    LOCKED_DOORS ( //test v prípade zamknutých dverí. Pokus o prejdenie bez odomknutia, pokus o odomknutie bez klúča. Zobratie klúča, odomknutie
    new 

    ScenarioStep(0, "",
    "Vitajte!\n"
    + "Ste v bare, trošku ste dezorientovaný a potrebujete sa dostať domov.\n"
    + "Nevíte-li, jak pokračovat, zadejte příkaz 'nápověda'.",

    "bar",
    new String[] { "kvetinarstvo","trafika","tram_olšanská" },
    new String[] { "klíče", "peňaženka", "bunda" },
    new String[] { },
    new String[] { }
    ),

  
    new ScenarioStep("seber peňaženka", //nakoľko je vstup do tramvaje povinný s jízdenkou, je potrebné ju zakúpiť
    "Sebral(a) jsi předmět 'peňaženka' a uložil(a) ho do inventáře.",

    "bar",
    new String[] { "kvetinarstvo","trafika","tram_olšanská" },
    new String[] { "bunda","klíče"},
    new String[] {"peňaženka" },
    new String[] { }
    ),

  
    
     new ScenarioStep("jdi trafika",  //nakoľko je vstup do tramvaje povinný s jízdenkou, je potrebné ju zakúpiť
    "Jsi v prostoru 'trafika'.\n"
    + "Obyčajná trafika pri centre Prahy, otvorená non-stop.\n\n"
    + "Východy: bar kvetinarstvo tram_olšanská\n"
    + "Předměty: jízdenka noviny\n"
    + "Ľudia: predavač zákazník",

    "trafika",
    new String[] { "bar", "kvetinarstvo", "tram_olšanská" },
    new String[] {"jízdenka", "noviny"},
    new String[] {"peňaženka" },
    new String[] { "predavač", "zákazník"}
    ),
    
     new ScenarioStep("kup jízdenka predavač",  //nakoľko je vstup do tramvaje povinný s jízdenkou, je potrebné ju zakúpiť
    "Kúpil(a) jsi předmět 'jízdenka' a uložil(a) ho do inventáře.",

    "trafika",
    new String[] { "bar","kvetinarstvo", "tram_olšanská" },
    new String[] { "noviny"},
    new String[] { "jízdenka","peňaženka" },
    new String[] { "predavač", "zákazník"}
    ),
    
    
    new ScenarioStep("jdi tram_olšanská",
    "Jsi v prostoru 'tram_olšanská'.\n"
    + "Tramvajová zastávka Olšanská, na ktorej čakáš na tramvaj na zastávku Štepánska.\n\n"
    + "Východy: bar kvetinarstvo trafika tramvaj\n"
    + "Předměty: vodka\n"
    + "Ľudia:",

    "tram_olšanská",
    new String[] { "bar", "kvetinarstvo","trafika", "tramvaj" },
    new String[] {"vodka"},
    new String[] { "jízdenka","peňaženka" },
    new String[] {}
    ),

    new ScenarioStep("jdi tramvaj",
    "Jsi v prostoru 'tramvaj'.\n"
    + "Obyčajná nočná tramvaj, ktorou sa chceš odviezť domov.\n\n"
    + "Východy: tram_olšanská tram_štepánska\n"
    + "Předměty: sedačka\n"
    + "Ľudia:",

    "tramvaj",
    new String[] { "tram_olšanská","tram_štepánska" },
    new String[] { "sedačka" },
    new String[] { "jízdenka","peňaženka" },
    new String[] {}
    ),
    
     new ScenarioStep("jdi tram_štepánska",
    "Jsi v prostoru 'tram_štepánska'.\n"
    + "Tramvajová zastávka Štepánska, odkiaľ sa potrebuješ dostať domov\n\n"
    + "Východy: tramvaj vchod_domov(zamknuto)\n"
    + "Předměty: skriňa\n"
    + "Ľudia:",

    "tram_štepánska",
    new String[] { "tramvaj","vchod_domov" },
    new String[] { "skriňa" },
    new String[] { "jízdenka","peňaženka"},
    new String[] {}
    ),

    
    new ScenarioStep("jdi vchod_domov", //vyskúšame zadať príkaz jdi, keď je mietnosť zamknutá
    "Miestnost vchod_domovje uzamknuta.",
    

    "tram_štepánska",
    new String[] { "tramvaj","vchod_domov" },
    null,
    null,
    null
    
    ),
    
    new ScenarioStep("odemkni vchod_domov", //vyskúšame zadať príkaz odemkni, keď nemáme kľúče
    "Miestnost vchod_domov nemozes odomknut, pretoze ti chyba predmet klíče",
    

    "tram_štepánska",
    new String[] { "tramvaj","vchod_domov" },
    null,
    new String[] { "jízdenka","peňaženka" },
    null
    
    ),
    
    new ScenarioStep("jdi tramvaj", //vrátime sa pre kľúče
    "Jsi v prostoru 'tramvaj'.\n"
    + "Obyčajná nočná tramvaj, ktorou sa chceš odviezť domov.\n\n"
    + "Východy: tram_olšanská tram_štepánska\n"
    + "Předměty: sedačka\n"
    + "Ľudia:",

    "tramvaj",
    new String[] { "tram_olšanská","tram_štepánska" },
    new String[] { "sedačka" },
    new String[] { "jízdenka","peňaženka" },
    new String[] {}
    ),
    
     new ScenarioStep("jdi tram_olšanská",
    "Jsi v prostoru 'tram_olšanská'.\n"
    + "Tramvajová zastávka Olšanská, na ktorej čakáš na tramvaj na zastávku Štepánska.\n\n"
    + "Východy: bar kvetinarstvo trafika tramvaj\n"
    + "Předměty: vodka\n"
    + "Ľudia:",

    "tram_olšanská",
    new String[] { "bar", "kvetinarstvo","trafika", "tramvaj" },
    new String[] {"vodka"},
    new String[] { "jízdenka","peňaženka" },
    new String[] {}
    ),
    
     new ScenarioStep("jdi bar",
    "Jsi v prostoru 'bar'.\n"
    + "Toto je bar, v ktorom si mal párty\n\n"
    + "Východy: kvetinarstvo trafika tram_olšanská\n"
    + "Předměty: bunda klíče\n"
    + "Ľudia:",

    "bar",
    new String[] {"kvetinarstvo","trafika", "tram_olšanská" },
    new String[] {"bunda","klíče"},
    new String[] { "jízdenka","peňaženka" },
    new String[] {}
    ),
    
     new ScenarioStep("seber klíče",
    "Sebral(a) jsi předmět 'klíče' a uložil(a) ho do inventáře.",

    "bar",
    new String[] { "kvetinarstvo","trafika","tram_olšanská" },
    new String[] { "bunda" },
    new String[] { "jízdenka","klíče","peňaženka" },
    new String[] { }
    ),
    
    new ScenarioStep("jdi tram_olšanská",
    "Jsi v prostoru 'tram_olšanská'.\n"
    + "Tramvajová zastávka Olšanská, na ktorej čakáš na tramvaj na zastávku Štepánska.\n\n"
    + "Východy: bar kvetinarstvo trafika tramvaj\n"
    + "Předměty: vodka\n"
    + "Ľudia:",

    "tram_olšanská",
    new String[] { "bar", "kvetinarstvo","trafika", "tramvaj" },
    new String[] {"vodka"},
    new String[] { "jízdenka","klíče","peňaženka"},
    new String[] {}
    ),

    new ScenarioStep("jdi tramvaj",
    "Jsi v prostoru 'tramvaj'.\n"
    + "Obyčajná nočná tramvaj, ktorou sa chceš odviezť domov.\n\n"
    + "Východy: tram_olšanská tram_štepánska\n"
    + "Předměty: sedačka\n"
    + "Ľudia:",

    "tramvaj",
    new String[] { "tram_olšanská","tram_štepánska" },
    new String[] { "sedačka" },
    new String[] { "jízdenka","klíče","peňaženka" },
    new String[] {}
    ),
    
     new ScenarioStep("jdi tram_štepánska",
    "Jsi v prostoru 'tram_štepánska'.\n"
    + "Tramvajová zastávka Štepánska, odkiaľ sa potrebuješ dostať domov\n\n"
    + "Východy: tramvaj vchod_domov(zamknuto)\n"
    + "Předměty: skriňa\n"
    + "Ľudia:",

    "tram_štepánska",
    new String[] { "tramvaj","vchod_domov" },
    new String[] { "skriňa" },
    new String[] { "klíče","peňaženka","jízdenka"},
    new String[] {}
    ),

    new ScenarioStep("odemkni vchod_domov", //odomknutie úspešné
    "Miestnost vchod_domov bola odomknuta.",

    "tram_štepánska",
    null,
    null,
    null,
    null
    ),
    
    new ScenarioStep("jdi vchod_domov", //vchod úspešný
    "Jsi v prostoru 'vchod_domov'.\n"
    + "Vchod do domu, cez ktorý musíš prejsť.\n\n"
    + "Východy: domov tram_štepánska\n"
    + "Předměty:\n"
    + "Ľudia:",

    "vchod_domov",
    new String[] { "domov","tram_štepánska" },
    new String[] { },
    new String[] { "klíče","peňaženka","jízdenka", },
    new String[] {}
    
    )
    ),
    
    UNLOCKED_DOORS ( //test odomknutia miestností, ktoré už sú odomknuté
    new 

    ScenarioStep(0, "",
    "Vitajte!\n"
    + "Ste v bare, trošku ste dezorientovaný a potrebujete sa dostať domov.\n"
    + "Nevíte-li, jak pokračovat, zadejte příkaz 'nápověda'.",

    "bar",
    new String[] { "kvetinarstvo","trafika","tram_olšanská" },
    new String[] { "klíče", "peňaženka", "bunda" },
    new String[] { },
    new String[] { }
    ),
    
    new ScenarioStep("odemkni kvetinarstvo",
    "Miestnost kvetinarstvo uz bola odokmnuta!",

    "bar",
    null,
    null,
    null,
    null
    )
   
    
    ),
    
    BUY_MISUSE ( //test neúspešného použitia príkazu buy. Úspešné použitie otestované v scenári HAPPY
    new 

    ScenarioStep(0, "",
    "Vitajte!\n"
    + "Ste v bare, trošku ste dezorientovaný a potrebujete sa dostať domov.\n"
    + "Nevíte-li, jak pokračovat, zadejte příkaz 'nápověda'.",

    "bar",
    new String[] { "kvetinarstvo","trafika","tram_olšanská" },
    new String[] { "klíče", "peňaženka", "bunda" },
    new String[] { },
    new String[] { }
    ),
    
     new ScenarioStep("jdi kvetinarstvo",
    "Jsi v prostoru 'kvetinarstvo'.\n"
    + "Kvetinárstvo, kde sa predávajú kvety non-stop.\n\n"
    + "Východy: bar trafika tram_olšanská\n"
    + "Předměty: hnojivo kvety\n"
    + "Ľudia: predavač upratovač",

    "kvetinarstvo",
    new String[] { "bar","trafika", "tram_olšanská" },
    new String[] { "hnojivo", "kvety" },
    new String[] { },
    new String[] { "predavač", "upratovač"}
    ),
    
        new ScenarioStep("kup kvety", //príkaz len s jedným parametrom
    "Tomu nerozumiem, musis mi povedat, od koho si to mam kupit.",

    "kvetinarstvo",
    null,
    new String[] { "hnojivo", "kvety" },
    new String[] { },
    new String[] { "predavač", "upratovač"}
    ),
    
       new ScenarioStep("kup kvety predavač", //príkaz s 2 bezproblémovými parametrami, ale bez peňaženky v bagu
    "Předmět 'kvety' sa kupit nemozes, chyba ti penazenka!",

    "kvetinarstvo",
    null,
    new String[] { "hnojivo", "kvety" },
    new String[] { },
  new String[] { "predavač", "upratovač"}
    ),
    
       new ScenarioStep("kup kvety upratovač", //vyskúšame kúpiť tovar od niekoho, kto nemá atribút saleperson
    "Predmet kvety si nemôžeš kúpiť od upratovač. Skús to u niekoho iného.",

    "kvetinarstvo",
    null,
    new String[] { "hnojivo", "kvety" },
    new String[] { },
    new String[] { "predavač", "upratovač"}
    ),
    
       new ScenarioStep("kup bla bla bla", //vyskúšame použiť 3 parametre
    "Tomu nerozumiem, potrebujem len 2 parametre.",

    "kvetinarstvo",
    null,
    new String[] { "hnojivo", "kvety" },
    new String[] { },
    new String[] { "predavač", "upratovač"}
    ),
    
         new ScenarioStep("kup", //bez parametru
    "Nerozumiem, musis napisat co mam kupit",

    "kvetinarstvo",
    null,
    new String[] { "hnojivo", "kvety" },
    new String[] { },
    new String[] { "predavač", "upratovač"}
    ),
    
    
    
     new ScenarioStep("jdi bar",
    "Jsi v prostoru 'bar'.\n"
    + "Toto je bar, v ktorom si mal párty\n\n"
    + "Východy: kvetinarstvo trafika tram_olšanská\n"
    + "Předměty: bunda klíče peňaženka\n"
    + "Ľudia:",

    "bar",
    new String[] {"kvetinarstvo","trafika", "tram_olšanská" },
    new String[] {"bunda","klíče", "peňaženka"},
    new String[] {},
    new String[] {}
    ),
    
       new ScenarioStep("seber peňaženka", //zoberieme si peňaženku
    "Sebral(a) jsi předmět 'peňaženka' a uložil(a) ho do inventáře.",

    "bar",
    new String[] { "kvetinarstvo","trafika","tram_olšanská" },
    new String[] { "bunda","klíče"},
    new String[] {"peňaženka" },
    new String[] { }
    ),
    
      new ScenarioStep("jdi kvetinarstvo",
    "Jsi v prostoru 'kvetinarstvo'.\n"
    + "Kvetinárstvo, kde sa predávajú kvety non-stop.\n\n"
    + "Východy: bar trafika tram_olšanská\n"
    + "Předměty: hnojivo kvety\n"
    + "Ľudia: predavač upratovač",

    "kvetinarstvo",
    new String[] { "bar","trafika", "tram_olšanská" },
    new String[] { "hnojivo", "kvety" },
    new String[] { "peňaženka" },
    new String[] { "predavač", "upratovač"}
    ),
    
     new ScenarioStep("kup kvety", //znova vyskúšame zadať len jeden parameter
    "Tomu nerozumiem, musis mi povedat, od koho si to mam kupit.",

    "kvetinarstvo",
    null,
    new String[] { "hnojivo", "kvety" },
    new String[] { "peňaženka" },
    new String[] { "predavač", "upratovač"}
    ),
    
     new ScenarioStep("kup kvety upratovač", //vyskúšame kúpiť od niekoho, kto nemá atribút saleperson
    "Predmet kvety si nemôžeš kúpiť od upratovač. Skús to u niekoho iného.",

    "kvetinarstvo",
    null,
    new String[] { "hnojivo", "kvety" },
    new String[] { "peňaženka" },
    new String[] { "predavač", "upratovač"}
    ),
    
    new ScenarioStep("kup blabla", //zadáme jeden parameter, pričom neoznačuje žiadnu položku
    "Tomu nerozumiem, musis mi povedat, od koho si to mam kupit.",

    "kvetinarstvo",
    null,
    new String[] { "hnojivo", "kvety" },
    new String[] { "peňaženka" },
    new String[] { "predavač", "upratovač"}
    ),
    
    new ScenarioStep("kup dada dada", //obidva nezmyselné parametre
    "Předmět 'dada' tady není.",

    "kvetinarstvo",
    null,
    new String[] { "hnojivo", "kvety" },
    new String[] { "peňaženka" },
    new String[] { "predavač", "upratovač"}
    ),
    
     new ScenarioStep("kup dada predavač", //predmet neexistuje, no osoba sa už v lokácii nachádza
    "Předmět 'dada' tady není.",

    "kvetinarstvo",
    null,
    new String[] { "hnojivo", "kvety" },
    new String[] { "peňaženka" },
    new String[] { "predavač", "upratovač"}
    ),
    
       new ScenarioStep("kup dada upratovač", //predmet neexistuje, no osoba sa už v lokácii nachádza
    "Předmět 'dada' tady není.",

    "kvetinarstvo",
    null,
    new String[] { "hnojivo", "kvety" },
    new String[] { "peňaženka" },
    new String[] { "predavač", "upratovač"}
    ),
    
      new ScenarioStep("kup kvety fda", //predmet existuje, človek neexistuje
    "Človek fda tu nie je.",

    "kvetinarstvo",
    null,
    new String[] { "hnojivo", "kvety" },
    new String[] { "peňaženka" },
    new String[] { "predavač", "upratovač"}
    ),
    
    new ScenarioStep("jdi tram_olšanská",
    "Jsi v prostoru 'tram_olšanská'.\n"
    + "Tramvajová zastávka Olšanská, na ktorej čakáš na tramvaj na zastávku Štepánska.\n\n"
    + "Východy: bar kvetinarstvo trafika tramvaj\n"
    + "Předměty: vodka\n"
    + "Ľudia:",

    "tram_olšanská",
    new String[] { "bar", "kvetinarstvo","trafika", "tramvaj" },
    new String[] {"vodka"},
    new String[] { "peňaženka"},
    new String[] {}
    ),
    
       new ScenarioStep("kup vodka", //vyskúšame kúpiť niečo, čo nie je potrebné kúpiť
    "Tomu nerozumiem, musis mi povedat, od koho si to mam kupit.",

    "tram_olšanská",
    null,
    new String[] { "vodka" },
    new String[] { "peňaženka" },
    new String[] {}
    ),
    
       new ScenarioStep("kup vodka blabla", //vyskúšame kúpiť niečo, čo nie je potrebné kúpiť
    "Předmět 'vodka' sa kupit neda. Mozes si ho zobrat.",

    "tram_olšanská",
    null,
    new String[] { "vodka" },
    new String[] { "peňaženka" },
    new String[] {}
    )
    ),
    
    ACTION_PICK ( //test príkazu zober
    new 

    ScenarioStep(0, "",
    "Vitajte!\n"
    + "Ste v bare, trošku ste dezorientovaný a potrebujete sa dostať domov.\n"
    + "Nevíte-li, jak pokračovat, zadejte příkaz 'nápověda'.",

    "bar",
    new String[] { "kvetinarstvo","trafika","tram_olšanská" },
    new String[] { "klíče", "peňaženka", "bunda" },
    new String[] { },
    new String[] { }
    ),
    
     new ScenarioStep("seber bla bla", //použijem 2 parametre
    "Tomu nerozumím, neumím sebrat více předmětů současně.",

    "bar",
    new String[] { "kvetinarstvo","trafika","tram_olšanská" },
    new String[] { "klíče", "peňaženka", "bunda"},
    new String[] { },
    new String[] { }
    ),
    
     new ScenarioStep("seber bla", //použijem predmet, ktorý v danej lokácii nie je
    "Předmět 'bla' tady není.",

    "bar",
    new String[] { "kvetinarstvo","trafika","tram_olšanská" },
    new String[] { "klíče", "peňaženka", "bunda"},
    new String[] { },
    new String[] { }
    ),
    
      new ScenarioStep("seber", //bez parametru
    "Tomu nerozumím, musíš mi říct, co mám sebrat.",

    "bar",
    new String[] { "kvetinarstvo","trafika","tram_olšanská" },
    new String[] { "klíče", "peňaženka", "bunda"},
    new String[] { },
    new String[] { }
    ),
    
    new ScenarioStep("seber peňaženka",
    "Sebral(a) jsi předmět 'peňaženka' a uložil(a) ho do inventáře.",

    "bar",
    new String[] { "kvetinarstvo","trafika","tram_olšanská" },
    new String[] { "bunda","klíče"},
    new String[] { "peňaženka" },
    new String[] { }
    ),
    
     new ScenarioStep("jdi trafika",  //nakoľko je vstup do tramvaje povinný s jízdenkou, je potrebné ju zakúpiť
    "Jsi v prostoru 'trafika'.\n"
    + "Obyčajná trafika pri centre Prahy, otvorená non-stop.\n\n"
    + "Východy: bar kvetinarstvo tram_olšanská\n"
    + "Předměty: jízdenka noviny\n"
    + "Ľudia: predavač zákazník",

    "trafika",
    new String[] { "bar", "kvetinarstvo", "tram_olšanská" },
    new String[] {"jízdenka", "noviny"},
    new String[] {"peňaženka" },
    new String[] { "predavač", "zákazník"}
    ),
    
     new ScenarioStep("kup jízdenka predavač",  //nakoľko je vstup do tramvaje povinný s jízdenkou, je potrebné ju zakúpiť
    "Kúpil(a) jsi předmět 'jízdenka' a uložil(a) ho do inventáře.",

    "trafika",
    new String[] { "bar","kvetinarstvo", "tram_olšanská" },
    new String[] { "noviny"},
    new String[] { "jízdenka","peňaženka" },
    new String[] { "predavač", "zákazník"}
    ),
    
    new ScenarioStep("jdi tram_olšanská",
    "Jsi v prostoru 'tram_olšanská'.\n"
    + "Tramvajová zastávka Olšanská, na ktorej čakáš na tramvaj na zastávku Štepánska.\n\n"
    + "Východy: bar kvetinarstvo trafika tramvaj\n"
    + "Předměty: vodka\n"
    + "Ľudia:",

    "tram_olšanská",
    new String[] { "bar", "kvetinarstvo","trafika", "tramvaj" },
    new String[] {"vodka"},
    new String[] { "jízdenka","peňaženka" },
    new String[] {}
    ),
    
    
    new ScenarioStep("jdi tramvaj",
    "Jsi v prostoru 'tramvaj'.\n"
    + "Obyčajná nočná tramvaj, ktorou sa chceš odviezť domov.\n\n"
    + "Východy: tram_olšanská tram_štepánska\n"
    + "Předměty: sedačka\n"
    + "Ľudia:",

    "tramvaj",
    new String[] { "tram_olšanská","tram_štepánska" },
    new String[] { "sedačka" },
    new String[] { "jízdenka","peňaženka" },
    new String[] {}
    ),
    
    new ScenarioStep("seber sedačka", //neprenositeľný predmet
    "Předmět 'sedačka' fakt neuneseš.",

    "tramvaj",
    new String[] { "tram_olšanská","tram_štepánska" },
    new String[] { "sedačka" },
    new String[] { "jízdenka","peňaženka" },
    new String[] {}
    )
    ),
    
    ACTION_SEE_ITEMS ( //test príkazu, ktorý zobrazí položky v daných miestach
    new 

    ScenarioStep(0, "",
    "Vitajte!\n"
    + "Ste v bare, trošku ste dezorientovaný a potrebujete sa dostať domov.\n"
    + "Nevíte-li, jak pokračovat, zadejte příkaz 'nápověda'.",

    "bar",
    new String[] { "kvetinarstvo","trafika","tram_olšanská" },
    new String[] { "klíče", "peňaženka", "bunda" },
    new String[] { },
    new String[] { }
    ),
    
    new ScenarioStep("ukaz_predmety", //najskôr skontrolujeme predmety na základnom stanovišti
    "V miestnosti su: peňaženka  bunda  klíče ", 

    "bar",
    new String[] { "kvetinarstvo","trafika","tram_olšanská" },
    new String[] { "klíče", "peňaženka", "bunda" },
    new String[] { },
    new String[] { }
    ),

   new ScenarioStep("seber peňaženka",
    "Sebral(a) jsi předmět 'peňaženka' a uložil(a) ho do inventáře.", 

    "bar",
    new String[] { "kvetinarstvo","trafika","tram_olšanská" },
    new String[] { "klíče", "bunda" },
    new String[] {  "peňaženka" },
    new String[] { }
    ),
    
      new ScenarioStep("ukaz_predmety", //ukážeme predmety po zobratí peňaženky
    "V miestnosti su: bunda  klíče ", 

    "bar",
    new String[] { "kvetinarstvo","trafika","tram_olšanská" },
    new String[] { "klíče", "bunda" },
    new String[] { "peňaženka"},
    new String[] { }
    ),
    
      new ScenarioStep("poloz peňaženka", //ukážeme predmety po zobratí peňaženky
    "Polozil(a) jsi předmět 'peňaženka' do mistnosti.", 

    "bar",
    new String[] { "kvetinarstvo","trafika","tram_olšanská" },
    new String[] { "klíče", "bunda","peňaženka" },
    new String[] { },
    new String[] { }
    ),
    
    new ScenarioStep("ukaz_predmety", //najskôr skontrolujeme predmety na základnom stanovišti
    "V miestnosti su: peňaženka  bunda  klíče ", 

    "bar",
    new String[] { "kvetinarstvo","trafika","tram_olšanská" },
    new String[] { "klíče", "peňaženka", "bunda" },
    new String[] { },
    new String[] { }
    )
    
    ),
    
    
    ACTION_SEE_CONTENT ( //test príkazu, ktorý zobrazí položky v bagu
    new 

    ScenarioStep(0, "",
    "Vitajte!\n"
    + "Ste v bare, trošku ste dezorientovaný a potrebujete sa dostať domov.\n"
    + "Nevíte-li, jak pokračovat, zadejte příkaz 'nápověda'.",

    "bar",
    new String[] { "kvetinarstvo","trafika","tram_olšanská" },
    new String[] { "klíče", "peňaženka", "bunda" },
    new String[] { },
    new String[] { }
    ),
    

    new ScenarioStep("seber peňaženka",
    "Sebral(a) jsi předmět 'peňaženka' a uložil(a) ho do inventáře.", 

    "bar",
    new String[] { "kvetinarstvo","trafika","tram_olšanská" },
    new String[] { "klíče", "bunda" },
    new String[] {  "peňaženka" },
    new String[] { }
    ),
    
      new ScenarioStep("zobraz_obsah", //ukážeme predmety po zobratí peňaženky
    "peňaženka ", 

    "bar",
    new String[] { "kvetinarstvo","trafika","tram_olšanská" },
    new String[] { "klíče", "bunda" },
    new String[] { "peňaženka"},
    new String[] { }
    ),
    new ScenarioStep("jdi kvetinarstvo",
    "Jsi v prostoru 'kvetinarstvo'.\n"
    + "Kvetinárstvo, kde sa predávajú kvety non-stop.\n\n"
    + "Východy: bar trafika tram_olšanská\n"
    + "Předměty: hnojivo kvety\n"
    + "Ľudia: predavač upratovač",

    "kvetinarstvo",
    new String[] { "bar","trafika", "tram_olšanská" },
    new String[] { "hnojivo", "kvety" },
    new String[] {"peňaženka" },
    new String[] { "predavač", "upratovač"}
    ),
    
    new ScenarioStep("kup kvety predavač",
    "Kúpil(a) jsi předmět 'kvety' a uložil(a) ho do inventáře.",

    "kvetinarstvo",
    new String[] { "bar","trafika", "tram_olšanská" },
    new String[] { "hnojivo"},
    new String[] {"peňaženka","kvety" },
    new String[] { "predavač", "upratovač"}
    ),
    
       new ScenarioStep("zobraz_obsah", //ukážeme predmety po kúpe kvetov
    "kvety peňaženka ", 

    "kvetinarstvo",
    new String[] { "bar","trafika", "tram_olšanská"},
    new String[] { "hnojivo"},
    new String[] { "peňaženka","kvety"},
    new String[] {"predavač", "upratovač" }
    ),
    
     new ScenarioStep("seber hnojivo", //pokúsim sa zobrať predmet, ktorý je potrbné kúpiť
    "Pokúsil si sa predmet 'hnojivo' zobrať bez zaplatenia. Personál na teba zavolal políciu. Prehral si.", 

    "kvetinarstvo",
    new String[] { "bar","trafika", "tram_olšanská" },
    new String[] { "hnojivo"},
    new String[] {  "peňaženka","kvety" },
    new String[] { "predavač", "upratovač" }
    )
  
    ),
    
    ACTION_PUT ( //test príkazu, ktorý položí položky z bagu späť na určené miesto
    new 

    ScenarioStep(0, "",
    "Vitajte!\n"
    + "Ste v bare, trošku ste dezorientovaný a potrebujete sa dostať domov.\n"
    + "Nevíte-li, jak pokračovat, zadejte příkaz 'nápověda'.",

    "bar",
    new String[] { "kvetinarstvo","trafika","tram_olšanská" },
    new String[] { "klíče", "peňaženka", "bunda" },
    new String[] { },
    new String[] { }
    ),
    

    new ScenarioStep("seber peňaženka",
    "Sebral(a) jsi předmět 'peňaženka' a uložil(a) ho do inventáře.", 

    "bar",
    new String[] { "kvetinarstvo","trafika","tram_olšanská" },
    new String[] { "klíče", "bunda" },
    new String[] {  "peňaženka" },
    new String[] { }
    ),
    
      new ScenarioStep("poloz peňaženka",
    "Polozil(a) jsi předmět 'peňaženka' do mistnosti.", 

    "bar",
    new String[] { "kvetinarstvo","trafika","tram_olšanská" },
    new String[] { "klíče", "bunda","peňaženka" },
    new String[] { },
    new String[] { }
    ),
    new ScenarioStep("poloz ugh", //neexistujuci predmet
    "Předmět 'ugh' není v taske.",

    "bar",
    new String[] { "kvetinarstvo","trafika","tram_olšanská" },
    new String[] { "klíče", "bunda","peňaženka" },
    new String[] { },
    new String[] { }
    ),
    
     new ScenarioStep("poloz",
    "Tomu nerozumím, musíš mi říct, co mám položit.", //neexistujuci predmet

    "bar",
    new String[] { "kvetinarstvo","trafika","tram_olšanská" },
    new String[] { "klíče", "bunda","peňaženka" },
    new String[] { },
    new String[] { }
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
