public class EncodeDecode {

    public static void main(String[] args) {
        String input1 = "<encode>abcd";
        String input2 = "<decode>cdef";

        System.out.println("Output encode "  +  prosesInput(input1));
        System.out.println("Output decode "  +  prosesInput(input2));
    }

    public static String prosesInput(String input){
        if (input.startsWith("<encode>")){
            return shiftString(input.substring(8), 2);
        } else if (input.startsWith("<decode>")){
            return shiftString(input.substring(8),-2);
        } else {
            throw new IllegalArgumentException("Invalid input format");
        }
    }

    private static String shiftString(String str, int shift) {
        StringBuilder result = new StringBuilder();
        for (char c : str.toCharArray()) {
            char shiftedChar = (char) (c + shift);
            if (c >= 'a' && c <= 'z') {
                if (shiftedChar > 'z') shiftedChar -= 26;
                if (shiftedChar < 'a') shiftedChar += 26;
            } else if (c >= 'A' && c <= 'Z') {
                if (shiftedChar > 'Z') shiftedChar -= 26;
                if (shiftedChar < 'A') shiftedChar += 26;
            }
            result.append(shiftedChar);
        }
        return result.toString();
    }



}














