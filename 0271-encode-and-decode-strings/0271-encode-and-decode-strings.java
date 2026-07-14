public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        // use number and # as concatenation combination
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.size(); i++) {
            String s = strs.get(i);
            int len = s.length();
            sb.append(len + "#" + s);  // use " " so Java treat it as string concatenation

        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        char[] arr = s.toCharArray();
        List<String> str = new ArrayList<>();
        int i = 0;
        
        while(i < s.length()) {
            // find the index of the next '#' starting from i
            int hashIndex = s.indexOf("#", i);  // 2#Hi, find the # at index 1
            String strLen = s.substring(i, hashIndex); 
            int len = Integer.parseInt(strLen);  // len parse as 2.
            i = hashIndex+1; // i = 2  2 to 4
            str.add(s.substring(i, i +len));  // [incluseve, exclusive)
            i+= len;
        }

        return str;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));