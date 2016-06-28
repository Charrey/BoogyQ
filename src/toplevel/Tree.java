package toplevel;

import sprocl.model.Program;

import java.util.*;

public class Tree<T> {

    private T data;
    private List<Tree<T>> children = new LinkedList<>();
    private Tree parent;

    public Tree(T data) {
        this.data = data;
    }

    public Tree() {
        this.data = null;
    }

    private void setParent(Tree parent) {
        this.parent = parent;
    }

    public Tree<T> getParent() {
        return parent;
    }

    public void addChild(Tree child) {
        children.add(child);
        child.setParent(this);
    }

    public void addChild(T child) {
        Tree<T> newchild = new Tree<>(child);
        children.add(newchild);
        newchild.setParent(this);
    }

    public void addChildren(Collection<Tree<T>> children) {
        this.children.addAll(children);
        for (Tree<T> i : children) {
            i.setParent(this);
        }
    }

    public Tree<T> getChild(int index) {
        return children.get(index);
    }

    public List<Tree<T>> getChildren() {
        return children;
    }

    public void set(T newvalue) {
        data = newvalue;
    }

    public Set<T> toSet() {
        Set<T> res;
        if (children.isEmpty()) {
            res = new HashSet<>();
            res.add(data);
        } else {
            res = children.get(0).toSet();
            for (int i = 1; i<children.size(); i++) {
                res.addAll(children.get(i).toSet());
            }
            res.add(data);
        }
        return res;
    }

    public Tree find(T query) {
        if (query.equals(data)) {
            return this;
        }
        for (Tree i : children) {
            Tree get = i.find(query);
            if (get!=null) {
                return get;
            }
        }
        return null;
    }

    public String toString() {
        if (data == null) {
            return "(nulldata)";
        }
        return "(" + data.toString()+ ", " + children.toString() + ")";
    }

    public T get() {
        return data;
    }
}
