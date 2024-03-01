package src;

import java.util.Iterator;

public class TextStatement extends Statement{

    @Override
    public String getSituationEntete(Client client) {
        
		String result = getSituationEnteteCommon(client) + "\n";	
		return result;
    }

    @Override
    public String getSituationLocation(Client client) {
        String result = "";
        Iterator<Location> forEach = client.getLocations().iterator();
		while (forEach.hasNext()) {
			Location each = (Location) forEach.next();
			result += "\t" + each.getFilm().getTitre() + "\t" + String.valueOf(each.getmontant()) + "\n";
		}
        return result;
    }

    @Override
    public String getSituationRecap(Client client) {
		return getSituationRecapCommon(client);	
    }
    
}
