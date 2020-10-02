package tr1plef.dfap.automatons;

import java.util.List;
import java.util.Map;

public abstract class FiniteAutomaton {

    protected String name;
    protected List<String> inputAlphabet;
    protected List<String> stateList;
    protected Map<String, Map<String, String>> stateMap;
    protected String startState;

    public FiniteAutomaton(String name, List<String> inputAlphabet, List<String> stateList, Map<String, Map<String, String>> stateMap, String startState) {
        this.name = name;
        this.inputAlphabet = inputAlphabet;
        this.stateList = stateList;
        this.stateMap = stateMap;
        this.startState = startState;
    }

    protected abstract void process(String[] a);

    protected abstract FiniteAutomaton construct(Map<String, String> variableMap);

}
