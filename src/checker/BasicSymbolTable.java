package checker;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BasicSymbolTable<R> implements SymbolTable {

    /**
     * Stack of scopes.
     */
    private Stack<Map<String, R>> stack = new Stack<>();
    /**
     * The scope currently in.
     */
    private Map<String, R> currentScope = new HashMap<>();


    /**
     * Creates a new BasicSymboltable.
     */
    public BasicSymbolTable() {
        init();
    }

    /**
     * Initializes the BasicSymbolTable.
     */
    private void init() {
        Stack<Map<String,R>> returnStack = new Stack<>();
        returnStack.push(new HashMap());
    }

    /**
     * Opens the scope of this symboltable.
     */
    @Override
    public void openScope() {
        stack.push(currentScope);
        currentScope = new HashMap<>();
    }

    /**
     * Closes the scope of this symboltable.
     */
    @Override
    public void closeScope() {
        currentScope = stack.pop();
    }

    /**
     * Declare a variable to this symboltable
     * @param id The variable to be added.
     * @param rec Property of this variable.
     * @return <code>True</code> if succeeded or <code>False</code> if not allowed.
     */
    @Override
    public boolean add(String id, Object rec) {
        if(!currentScope.containsKey(id)){
            currentScope.put(id,(R) rec);
            return true;
        } else {
            return false;
        }
    }


    /**
     * Returns whether a variable is accessible in the current scope.
     * @param id The variable.
     * @return Whether the variable is accessible.
     */
    @Override
    public boolean contains(String id) {
        Stack<Map<String, R>> stackcopy = (Stack<Map<String, R>>) stack.clone();
        if(currentScope.containsKey(id)){
            return true;
        } else {
            while (!stackcopy.empty()){
                if(stackcopy.pop().containsKey(id)){
                    return true;
                }
            }
            return false;
        }
    }

    /**
     * Gets the property from a variable.
     * @param id The variable.
     * @return The property of this variable.
     */
    @Override
    public R get(String id) {
        Stack<Map<String, R>> stackcopy = (Stack<Map<String, R>>) stack.clone();
        if(currentScope.containsKey(id)){
            return currentScope.get(id);
        } else {
            while (!stackcopy.empty()){
                Map<String, R> get = stackcopy.pop();
                if(get.containsKey(id)){
                    return get.get(id);
                }
            }
            return null;
        }
    }
}
