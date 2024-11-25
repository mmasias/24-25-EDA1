public class TreeElement {
    String id;
    String[] content;
    TreeElement parentElement;
    DynamicArray subVersions;
    
    public TreeElement(String id, String[] content, TreeElement parentElement) {
        this.id = id;
        this.content = content;
        this.parentElement = parentElement;
        this.subVersions = new DynamicArray();
    }
    
    public TreeElement createChild(String[] additionalContent) {
        String childId = this.id + "." + (this.subVersions.getCount() + 1);
        String[] mergedContent = new String[this.content.length + additionalContent.length];
        System.arraycopy(this.content, 0, mergedContent, 0, this.content.length);
        System.arraycopy(additionalContent, 0, mergedContent, this.content.length, 
            additionalContent.length);
        TreeElement childElement = new TreeElement(childId, mergedContent, this);
        this.subVersions.add(childElement);
        return childElement;
    }
}