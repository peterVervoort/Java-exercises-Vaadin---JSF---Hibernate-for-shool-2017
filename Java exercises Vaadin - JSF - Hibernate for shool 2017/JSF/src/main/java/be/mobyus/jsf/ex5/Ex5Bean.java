package be.mobyus.jsf.ex5;

import org.apache.commons.lang3.StringUtils;
import org.primefaces.event.SelectEvent;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by java on 31.10.16.
 */
@ManagedBean
@SessionScoped
public class Ex5Bean {

    private boolean selected;

    private String municipality;

    private String[] municipalities = {"Aalst", "Aalter", "Aarschot", "Aartselaar", "Affligem", "Alken", "Alveringem",
            "Antwerpen", "Anzegem", "Ardooie", "Arendonk", "As", "Asse", "Assenede", "Avelgem", "Baarle-Hertog", "Balen",
            "Beernem", "Beerse", "Beersel", "Begijnendijk", "Bekkevoort", "Beringen", "Berlaar", "Berlare", "Bertem", "Bever",
            "Beveren", "Bierbeek", "Bilzen", "Blankenberge", "Bocholt", "Boechout", "Bonheiden", "Boom", "Boortmeerbeek",
            "Borgloon", "Bornem", "Borsbeek", "Boutersem", "Brakel", "Brasschaat", "Brecht", "Bredene", "Bree", "Brugge",
            "Buggenhout", "Damme", "De Haan", "De Panne", "De Pinte", "Deerlijk", "Deinze", "Denderleeuw", "Dendermonde",
            "Dentergem", "Dessel", "Destelbergen", "Diepenbeek", "Diest", "Diksmuide", "Dilbeek", "Dilsen-Stokkem", "Drogenbos",
            "Duffel", "Edegem", "Eeklo", "Erpe-Mere", "Essen", "Evergem", "Galmaarden", "Gavere", "Geel", "Geetbets", "Genk",
            "Gent", "Geraardsbergen", "Gingelom", "Gistel", "Glabbeek", "Gooik", "Grimbergen", "Grobbendonk", "Haacht",
            "Haaltert", "Halen", "Halle", "Ham", "Hamme", "Hamont-Achel", "Harelbeke", "Hasselt", "Hechtel-Eksel", "Heers",
            "Heist-op-den-Berg", "Hemiksem", "Herent", "Herentals", "Herenthout", "Herk-de-Stad", "Herne", "Herselt",
            "Herstappe", "Herzele", "Heusden-Zolder", "Heuvelland", "Hoegaarden", "Hoeilaart", "Hoeselt", "Holsbeek", "Hooglede",
            "Hoogstraten", "Horebeke", "Houthalen-Helchteren", "Houthulst", "Hove", "Huldenberg", "Hulshout", "Ichtegem",
            "Ieper", "Ingelmunster", "Izegem", "Jabbeke", "Kalmthout", "Kampenhout", "Kapellen", "Kapelle-op-den-Bos",
            "Kaprijke", "Kasterlee", "Keerbergen", "Kinrooi", "Kluisbergen", "Knesselare", "Knokke-Heist", "Koekelare",
            "Koksijde", "Kontich", "Kortemark", "Kortenaken", "Kortenberg", "Kortessem", "Kortrijk", "Kraainem", "Kruibeke",
            "Kruishoutem", "Kuurne", "Laakdal", "Laarne", "Lanaken", "Landen", "Langemark-Poelkapelle", "Lebbeke", "Lede",
            "Ledegem", "Lendelede", "Lennik", "Leopoldsburg", "Leuven", "Lichtervelde", "Liedekerke", "Lier", "Lierde", "Lille",
            "Linkebeek", "Lint", "Linter", "Lochristi", "Lokeren", "Lommel", "Londerzeel", "Lo-Reninge", "Lovendegem", "Lubbeek",
            "Lummen", "Maarkedal", "Maaseik", "Maasmechelen", "Machelen", "Maldegem", "Malle", "Mechelen", "Meerhout",
            "Meeuwen-Gruitrode", "Meise", "Melle", "Menen", "Merchtem", "Merelbeke", "Merksplas", "Mesen", "Meulebeke",
            "Middelkerke", "Moerbeke", "Mol", "Moorslede", "Mortsel", "Nazareth", "Neerpelt", "Nevele", "Niel", "Nieuwerkerken",
            "Nieuwpoort", "Nijlen", "Ninove", "Olen", "Oostende", "Oosterzele", "Oostkamp", "Oostrozebeke", "Opglabbeek",
            "Opwijk", "Oudenaarde", "Oudenburg", "Oud-Heverlee", "Oud-Turnhout", "Overijse", "Overpelt", "Peer", "Pepingen",
            "Pittem", "Poperinge", "Putte", "Puurs", "Ranst", "Ravels", "Retie", "Riemst", "Rijkevorsel", "Roeselare", "Ronse",
            "Roosdaal", "Rotselaar", "Ruiselede", "Rumst", "Schelle", "Scherpenheuvel-Zichem", "Schilde", "Schoten",
            "Sint-Amands", "Sint-Genesius-Rode", "Sint-Gillis-Waas", "Sint-Katelijne-Waver", "Sint-Laureins",
            "Sint-Lievens-Houtem", "Sint-Martens-Latem", "Sint-Niklaas", "Sint-Pieters-Leeuw", "Sint-Truiden", "Spiere-Helkijn",
            "Stabroek", "Staden", "Steenokkerzeel", "Stekene", "Temse", "Ternat", "Tervuren", "Tessenderlo", "Tielt",
            "Tielt-Winge", "Tienen", "Tongeren", "Torhout", "Tremelo", "Turnhout", "Veurne", "Vilvoorde", "Vleteren", "Voeren",
            "Vorselaar", "Vosselaar", "Waarschoot", "Waasmunster", "Wachtebeke", "Waregem", "Wellen", "Wemmel", "Wervik",
            "Westerlo", "Wetteren", "Wevelgem", "Wezembeek-Oppem", "Wichelen", "Wielsbeke", "Wijnegem", "Willebroek", "Wingene",
            "Wommelgem", "Wortegem-Petegem", "Wuustwezel", "Zandhoven", "Zaventem", "Zedelgem", "Zele", "Zelzate", "Zemst",
            "Zingem", "Zoersel", "Zomergem", "Zonhoven", "Zonnebeke", "Zottegem", "Zoutleeuw", "Zuienkerke", "Zulte",
            "Zutendaal", "Zwalm", "Zwevegem", "Zwijndrecht"};

    public String getMunicipality() {return municipality;}

    public void setMunicipality (String municipality){ this.municipality = municipality;}

    public boolean isSelected (){return  selected;}

    public void setSelected(boolean selected){this.selected = selected;}

    public List<String> complete (String query) {
        selected = false;
        municipality = null;
        List<String> results = new ArrayList<String>();

        if (StringUtils.isNoneBlank(query) && query.length() > 1) {
            for (int i = 0; i < municipalities.length; i++)
            {
                if (municipalities[i].toLowerCase().startsWith(query.toLowerCase())){
                    results.add(municipalities[i]);
                }
            }
        }
        return results;
    }

    public void handleSelected(SelectEvent selectEvent){
        this.municipality = selectEvent.getObject().toString();
        selected = true;
    }
}
