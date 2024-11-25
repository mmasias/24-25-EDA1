public class RepositoryManager {
    TreeElement mainNode;
    TreeElement activeNode;
    
    public RepositoryManager(String mainId, String[] initialData) {
        this.mainNode = new TreeElement(mainId, initialData, null);
        this.activeNode = mainNode;
    }
    
    public TreeElement newVersion(String[] newData) {
        return activeNode.createChild(newData);
    }
    
    public boolean moveToVersion(String versionId) {
        TreeElement targetVersion = searchElement(mainNode, versionId);
        if (targetVersion != null) {
            activeNode = targetVersion;
            return true;
        }
        return false;
    }
    
    public void displayVersions(TreeElement element, int depth) {
        if (element == null) return;
        for (int i = 0; i < depth; i++) {
            System.out.print(" ");
        }
        String currentIndicator = (element == activeNode) ? " (CURRENT)" : "";
        System.out.println("Version: " + element.id + ", Content: " + 
            String.join(", ", element.content) + currentIndicator);
        
        for (int i = 0; i < element.subVersions.getCount(); i++) {
            displayVersions(element.subVersions.get(i), depth + 1);
        }
    }
    
    public TreeElement searchElement(TreeElement element, String id) {
        if (element.id.equals(id)) {
            return element;
        }
        for (int i = 0; i < element.subVersions.getCount(); i++) {
            TreeElement found = searchElement(element.subVersions.get(i), id);
            if (found != null) {
                return found;
            }
        }
        return null;
    }
}