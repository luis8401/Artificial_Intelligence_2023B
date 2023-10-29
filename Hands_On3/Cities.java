package Hands_On3;

import java.util.ArrayList;
public class Cities {
	//cities existentes
    public static final ArrayList<String> cities = new ArrayList<String>() {{
        add("NY");
        add("CHI");
        add("TOR");
        add("DEN");
        add("CAL");
        add("LA");
        add("HOU");
        add("URB");
    }};

    // Conexiones entre cities
    public static final ArrayList<String[]> connections = new ArrayList<String[]>() {{
    	add(new String[]{"NY", "CHI"});
        add(new String[]{"NY", "TOR"});
        add(new String[]{"NY", "DEN"});
        add(new String[]{"CHI", "DEN"});
        add(new String[]{"TOR", "CAL"});
        add(new String[]{"TOR", "LA"});
        //add(new String[]{"DEN", "HOU"}); REPETIDO
        add(new String[]{"DEN", "LA"});
        add(new String[]{"DEN", "HOU"});
        add(new String[]{"HOU", "LA"});
        add(new String[]{"DEN", "URB"});
    }};
}