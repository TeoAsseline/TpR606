package src;

import java.util.Iterator;

public class HtmlStatement extends Statement{

    @Override
    public String getSituationEntete(Client client) {
		String result = "<h1>" + getSituationEnteteCommon(client) + "</h1>\n<ul>";		
		return result;
    }

    @Override
    public String getSituationLocation(Client client) {
        String result = "";
        Iterator<Location> forEach = client.getLocations().iterator();
        while (forEach.hasNext()) {
			Location each = (Location) forEach.next();
			result += "<li>\t" + each.getFilm().getTitre() + "\t" + String.valueOf(each.getmontant()) + "</li>\n";
		}
        return result;
    }

    @Override
    public String getSituationRecap(Client client) {
        String result = "</ul><h3>" + getSituationRecapCommon(client) + "</h3>";
        return result;
    }
    
}
