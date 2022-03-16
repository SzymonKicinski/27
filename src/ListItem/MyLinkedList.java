package ListItem;

public class MyLinkedList implements NodeList {

    private ListItem root = null;

    public MyLinkedList(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(ListItem newItem) {
        if (this.root == null) {
            // The list was empty, so this item becomes the head of the list
            this.root = newItem;
            return true;
        }
        ListItem currentItem = this.root;
        while (currentItem != null ) {
            int comparison = (currentItem.compareTo(newItem));
            if (comparison < 0) {
                // newItem is greater, move right if possible
                if(currentItem.next() != null ){
                    currentItem = currentItem.next();
                } else {
                    currentItem.setNext(newItem).setPrevious(currentItem);
                    return true;
                }
            }
            if (comparison > 0) {
                // newItem is less, insert before
                if (currentItem.previous() != null) {
                    currentItem.previous().setPrevious(newItem).setPrevious(currentItem.previous());
                    newItem.setNext(currentItem).setPrevious(newItem);
                } else {
                    // the node with a previous is the root
                    newItem.setNext(this.root).setPrevious(newItem);
                    this.root = newItem;
                }
                return true;
            } else {
                // equal
                System.out.println(newItem.getValue() + " is already present, not added EQUAL");
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean removeItem(ListItem item) {
        if (item != null) {
            System.out.println("Deleting item " + item.getValue());
        }
        ListItem currentitem = this.root;
        while (currentitem != null) {
            int comparison = currentitem.compareTo(item);
            if (comparison == 0) {
                // found the item to delete
                if (currentitem == this.root) {
                    this.root = currentitem.next();
                } else {
                    currentitem.previous().setNext(currentitem.next());
                    if (currentitem.next() != null) {
                        currentitem.setPrevious(currentitem.previous());
                    }
                }
                return true;
            } else if (comparison < 0) {
                currentitem = currentitem.next();
            } else {
                // comparision is > 0
                // we pass the point which we wanted to deleted
                // so the item is not in the list
                return false;
            }
        }
        // The end of the list
        return false;
    }

    @Override
    public void traverse(ListItem root) {
        if (root == null) {
            System.out.println("The list is empty");

        } else {
            while (root != null) {
                System.out.println("Root " + root.getValue());
                root = root.next();
            }
        }

    }
}
