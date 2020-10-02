package tr1plef.dfap.automatons;

import java.util.List;
import java.util.Map;

public class Acceptor extends FiniteAutomaton {

    private String endState;

    public Acceptor(String name, List<String> inputAlphabet, List<String> stateList, Map<String, Map<String, String>> stateMap, String startState, String endState) {
        super(name, inputAlphabet, stateList, stateMap, startState);
        this.endState = endState;
    }

    @Override
    protected void process(String[] a) {

    }

    @Override
    protected Acceptor construct(Map<String, String> variableMap) {
        return null;
    }
}
