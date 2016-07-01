package toplevel;


import java.util.*;

/**
 * Class used to store Tree datatypes.
 * @param <T> Type to be stored in this tree.
 */
public class Tree<T> {

    /**
     * Data stored in this tree.
     */
    private T data;
    /**
     * Child trees of this tree.
     */
    private List<Tree<T>> children = new LinkedList<>();
    /**
     * Parent tree of this tree.
     */
    private Tree parent;

    /**
     * Creates a new Tree, and sets its data.
     * @param data Data in the tree.
     */
    public Tree(T data) {
        this.data = data;
    }

    /**
     * Creates a new Tree.
     */
    public Tree() {
        this.data = null;
    }

    /**
     * Set the parent of a tree.
     * @param parent The new parent.
     */
    private void setParent(Tree parent) {
        this.parent = parent;
    }

    /**
     * Returns the parent of this tree.
     * @return The parent.
     */
    public Tree<T> getParent() {
        return parent;
    }

    /**
     * Adds a tree as child of this tree.
     * @param child The new child.
     */
    public void addChild(Tree child) {
        children.add(child);
        child.setParent(this);
    }

    /**
     * Adds a new tree as child of this tree.
     * @param child Data in the new tree.
     */
    public void addChild(T child) {
        Tree<T> newchild = new Tree<>(child);
        children.add(newchild);
        newchild.setParent(this);
    }

    /**
     * Adds a collection of children to this tree.
     * @param children The collection.
     */
    public void addChildren(Collection<Tree<T>> children) {
        this.children.addAll(children);
        for (Tree<T> i : children) {
            i.setParent(this);
        }
    }

    /**
     * Returns the child at the specified index.
     * @param index The index.
     * @return The child tree at that index.
     */
    public Tree<T> getChild(int index) {
        return children.get(index);
    }

    /**
     * Returns all child trees.
     * @return The trees.
     */
    public List<Tree<T>> getChildren() {
        return children;
    }

    /**
     * Set the data in this tree to a new value.
     * @param newvalue The new value.
     */
    public void set(T newvalue) {
        data = newvalue;
    }

    /**
     * Returns a set of all Datas in this tree.
     * @return That set.
     */
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

    /**
     * Returns a set of all Datas of this tree's child trees.
     * @return That set.
     */
    public Set<T> toSetChildren() {
        Set<T> res;
        if (children.isEmpty()) {
            res = new HashSet<>();
        } else {
            res = children.get(0).toSet();
            for (int i = 1; i<children.size(); i++) {
                res.addAll(children.get(i).toSet());
            }
        }
        return res;
    }

    /**
     * Returns all Datas in this tree sorted by depth in this tree.
     * @return A list of Datasets, where the index of the list denotes the depth.
     */
    public List<Set<T>> getLevels() {
        Set<T> thisset = new HashSet<>();
        thisset.add(this.data);
        List<Set<T>> res = new LinkedList<>();
        res.add(thisset);
        for (Tree<T> child : this.children) {
            List<Set<T>> get = child.getLevels();
            for (int i = 0;i<get.size(); i++) {
                if (i+1>=res.size()) {
                    res.add(new HashSet<>());
                }
                res.get(i+1).addAll(get.get(i));
            }
        }
        return res;
    }

    /**
     * Attempts to find a tree inside this tree with the specified data.
     * @param query The data to find.
     * @return The tree containing that data.
     */
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

    /**
     * Returns the data of this tree.
     * @return The data.
     */
    public T get() {
        return data;
    }

    /**
     * Returns the total size of this tree.
     * @return The total size.
     */
    public int size() {
        int res = 1;
        for (Tree<T> child : children) {
            res += child.size();
        }
        return res;
    }
}
