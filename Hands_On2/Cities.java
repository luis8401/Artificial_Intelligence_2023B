package Hands_On2;

import java.util.ArrayList;
public class Cities {
	//cities existentes
    public static final ArrayList<String> cities = new ArrayList<String>() {{
        add("A");
        add("B");
        add("C");
        add("D");
        add("Y");
        add("X");
    }};

    // Conexiones entre cities
    public static final ArrayList<String[]> connections = new ArrayList<String[]>() {{
    	add(new String[]{"A", "B"});
        add(new String[]{"A", "C"});
        add(new String[]{"A", "D"});
        add(new String[]{"B", "Y"});
        add(new String[]{"C", "Y"});
        add(new String[]{"Y", "X"});
        //add(new String[]{"DEN", "HOU"}); REPETIDO
    }};
}