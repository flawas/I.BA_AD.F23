package sw04.e4;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class HashTableBuckets implements HashTableBucketsInterface {

    private int INITIAL_CAPACITY = 10;

    private List<Node> storage = new ArrayList<>(INITIAL_CAPACITY);
    private static final Logger Log = LogManager.getLogger();

    public HashTableBuckets() {
        for(int i = 0; i < INITIAL_CAPACITY; i++) {
            storage.add(new Node(""));
        }
    }

    private int calculateIndex(Node node) {
        return Math.abs(node.hashCode() % INITIAL_CAPACITY);
    }

    @Override
    public boolean addNode(Node node) {
        int index = calculateIndex(node);
        if(!storage.get(index).equals(new Node(""))) {
            Node searchNode = storage.get(index);
            while(searchNode.getNextElement() != null) {
                searchNode = searchNode.getNextElement();
            }
            searchNode.setNextElement(node);
            return true;
        } else {
            storage.set(index, node);
            return true;
        }
    }

    @Override
    public boolean removeNode(Node node) {
        int index = calculateIndex(node);
        if(!storage.get(index).equals(new Node(""))){
            if(storage.get(index).equals(node)) {
                Node tempNode = storage.get(index).getNextElement();
                storage.set(index, tempNode);
                return true;
            }

            if(!storage.get(index).equals(node)){
                Node tempNode = storage.get(index);
                while(tempNode.getNextElement() != null && !tempNode.getNextElement().equals(node)) {
                    tempNode = tempNode.getNextElement();
                }
                if(tempNode.getNextElement().getNextElement() != null) {
                    tempNode.setNextElement(tempNode.getNextElement().getNextElement());
                    return true;
                } else {
                    tempNode.setNextElement(null);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean seachNode(Node node) {
        int index = calculateIndex(node);
        if(!storage.get(index).equals(new Node(""))){
            if(storage.get(index).equals(node)){
                return true;
            } else {
                Node tempNode = storage.get(index);
                while(tempNode.getNextElement() != null) {
                    if(tempNode.equals(node)) {
                        return true;
                    } else {
                        tempNode = tempNode.getNextElement();
                    }
                }
                return false;
            }
        }
        return false;
    }
}
