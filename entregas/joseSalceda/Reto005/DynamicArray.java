public class DynamicArray {
    TreeElement[] elements;
    int count;
    
    public DynamicArray() {
        this.elements = new TreeElement[10];
        this.count = 0;
    }
    
    public void add(TreeElement element) {
        if (count == elements.length) {
            TreeElement[] expandedArray = new TreeElement[elements.length * 2];
            System.arraycopy(elements, 0, expandedArray, 0, elements.length);
            elements = expandedArray;
        }
        elements[count++] = element;
    }
    
    public TreeElement get(int index) {
        if (index >= 0 && index < count) {
            return elements[index];
        }
        return null;
    }
    
    public int getCount() {
        return count;
    }
}