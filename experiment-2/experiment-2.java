import java.util.*;

class Node {
    char ch;
    int freq;
    Node left, right;

    Node(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
        left = right = null;
    }
}

public class HuffmanCoding {
    static void generateCodes(Node root, String code, Map<Character, String> huffmanCode) {
        if (root == null) return;

        if (root.left == null && root.right == null) {
            huffmanCode.put(root.ch, code);
        }

        generateCodes(root.left, code + "0", huffmanCode);
        generateCodes(root.right, code + "1", huffmanCode);
    }

    static String decode(String encoded, Node root) {
        StringBuilder decoded = new StringBuilder();
        Node curr = root;

        for (int i = 0; i < encoded.length(); i++) {
            curr = (encoded.charAt(i) == '0') ? curr.left : curr.right;

            if (curr.left == null && curr.right == null) {
                decoded.append(curr.ch);
                curr = root;
            }
        }
        return decoded.toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter input string: ");
        String input = sc.nextLine();

        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : input.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.freq));

        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            pq.add(new Node(entry.getKey(), entry.getValue()));
        }

        while (pq.size() > 1) {
            Node left = pq.poll();
            Node right = pq.poll();

            Node parent = new Node('\0', left.freq + right.freq);
            parent.left = left;
            parent.right = right;

            pq.add(parent);
        }

        Node root = pq.poll();

        Map<Character, String> huffmanCode = new HashMap<>();
        generateCodes(root, "", huffmanCode);

        System.out.println("\n Character Huffman Codes:");
        for (Map.Entry<Character, String> entry : huffmanCode.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        StringBuilder encodedString = new StringBuilder();
        for (char c : input.toCharArray()) {
            encodedString.append(huffmanCode.get(c));
        }

        String decodedString = decode(encodedString.toString(), root);

        System.out.println("\nOriginal String : " + input);
        System.out.println("Encoded String  : " + encodedString);
        System.out.println("Decoded String  : " + decodedString);
    }
}


