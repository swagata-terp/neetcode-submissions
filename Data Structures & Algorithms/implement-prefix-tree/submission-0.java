class PrefixNode {

    PrefixNode[] nodes;
    Boolean endOfWord;

    public PrefixNode() {
        nodes = new PrefixNode[26];
        // char[] nodes = new char[26]; this is what we were doing. Don't have to as the index
                                      // represents the char character already
        endOfWord = false; 
    }
}

class PrefixTree {

    PrefixNode root;

    public PrefixTree() {
        root = new PrefixNode(); 
    }

    public void insert(String word) {
        PrefixNode node = root;
        for (char character : word.toCharArray()) {
            int charIndex = character - 'a';
            if (node.nodes[charIndex] != null) {
                node = node.nodes[charIndex];
            } else {
                node.nodes[charIndex] = new PrefixNode();
                node = node.nodes[charIndex];
            }
        }
        node.endOfWord = true;
    }

    public boolean search(String word) {
        PrefixNode node = root;
        for (char character : word.toCharArray()) {
            int charIndex = character - 'a';
            if (node.nodes[charIndex] != null) {
                node = node.nodes[charIndex];
            } else {
                return false;
            }
        }
        if (node.endOfWord) {
            return true;
        }
        return false;
    }

    public boolean startsWith(String prefix) {
        PrefixNode node = root;
        for (char character : prefix.toCharArray()) {
            int charIndex = character - 'a';
            if (node.nodes[charIndex] != null) {
                node = node.nodes[charIndex];
            } else {
                return false;
            }
        }
        return true;
    }
}
