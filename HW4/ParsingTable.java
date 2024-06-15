import java.util.HashMap;

public class ParsingTable {


    private static HashMap<Integer, HashMap<String , Integer>> shiftTable = new HashMap<>();
    private static HashMap<Integer, HashMap<String , Integer>> reduceTable = new HashMap<>();
    private static HashMap<Integer, HashMap<String , Integer>> gotoTable = new HashMap<>();
    

    public static void addShiftTable (Integer currentState, String lookAhead, Integer nextState) {

        if ( shiftTable.containsKey(currentState) ) {
            shiftTable.get(currentState).put(lookAhead, nextState);
        } else {
            HashMap<String, Integer> temp = new HashMap<>();
            temp.put(lookAhead, nextState);
            
            shiftTable.put(currentState, temp);    
        }
    }

    public static Integer getShiftNextToken(Integer currentState, String lookAhead) {

        if (!shiftTable.containsKey(currentState))
            return -1;

        HashMap<String, Integer> temp = shiftTable.get(currentState);

        if (temp.containsKey(lookAhead)) {
            Integer nextToken = temp.get(lookAhead);
            return nextToken;
        }

        return -1;
    }

    public static void addReduceTable (Integer currentState, String lookAhead, Integer nextState) {
        
        if ( reduceTable.containsKey(currentState) ) {
            reduceTable.get(currentState).put(lookAhead, nextState);
        } else {
            HashMap<String, Integer> temp = new HashMap<>();
            temp.put(lookAhead, nextState);
            
            reduceTable.put(currentState, temp);
        }
    }

    public static Integer getReduceToken(Integer currentState, String lookAhead) {

        if (!reduceTable.containsKey(currentState))
            return -1;

        HashMap<String, Integer> temp = reduceTable.get(currentState);

        if (temp.containsKey(lookAhead)) {
            Integer nextToken = temp.get(lookAhead);
            return nextToken;
        }

        return -1;
    }

    public static void addGotoTable (Integer currentState, String lookAhead, Integer nextState) {

        if ( gotoTable.containsKey(currentState) ) {
            gotoTable.get(currentState).put(lookAhead, nextState);
        } else {   
            HashMap<String, Integer> temp = new HashMap<>();
            temp.put(lookAhead, nextState);
            
            gotoTable.put(currentState, temp);
        }

    }

    public static Integer getGotoTableToken(Integer currentState, String lookAhead) {

        if (!gotoTable.containsKey(currentState))
            return -1;

        HashMap<String, Integer> temp = gotoTable.get(currentState);

        if (temp.containsKey(lookAhead)) {
            Integer nextToken = temp.get(lookAhead);
            return nextToken;
        }

        return -1;
    }
    
}
