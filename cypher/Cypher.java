package cypher;

abstract class Cryptography{
    abstract String encode(String text);
    abstract String decode(String code);
}

class CaesarCypher extends Cryptography{
    int shift;
    CaesarCypher(int shift){
        this.shift = shift;
    }
    @Override
    String encode(String text){
        char[] msg = text.toCharArray();
        String code = "";

        for (char character : msg) {
            int ascii = (int)character;
            if(Character.isLowerCase(character)){
                int index = ascii - 97;
                index = ((index + shift) + 26) % 26;
                ascii = index + 97;
            }
            else if(Character.isUpperCase(character)){
                int index = ascii - 65;
                index = ((index + shift) + 26) % 26;
                ascii = index + 65;
            }
            code = code + (char)ascii;
        }

        return code;
    }
    @Override
    String decode(String code){
        char[] msg = code.toCharArray();
        String text = "";

        for (char character : msg) {
            int ascii = (int)character;
            if(Character.isLowerCase(character)){
                int index = ascii - 97;
                index = ((index - shift) + 26) % 26;
                ascii = index + 97;
            }
            else if(Character.isUpperCase(character)){
                int index = ascii - 65;
                index = ((index - shift) + 26) % 26;
                ascii = index + 65;
            }
            text = text + (char)ascii;
        }

        return text;       
    }
}

class TranspositionCypher extends Cryptography{
    int key;
    TranspositionCypher(int key){
        this.key = key;
    }
    @Override
    String encode(String text){
        char[] msg = text.toCharArray();

        for(int i = 0; i < msg.length % String.valueOf(key).length(); i++){
            text = text + "_";
        }

        String code = "";

        for(int turn = 0; turn < String.valueOf(text).length() / String.valueOf(key).length(); turn++){
            for(int i = 0; i < (String.valueOf(key)).length(); i++){
                char ch = (String.valueOf(key)).charAt(i);
                int index = Integer.parseInt(String.valueOf(ch)) - 1;
                code = code + text.charAt(index + turn*4);
            }
        }
        return code;
    }
    @Override
    String decode(String code){
        String text = "";
        char array[] = new char[(String.valueOf(code)).length()];

        for(int turn = 0; turn < String.valueOf(code).length() / String.valueOf(key).length(); turn++){
            for(int i = 0; i < (String.valueOf(key)).length(); i++){
                char ch = (String.valueOf(key)).charAt(i);
                int index = Integer.parseInt(String.valueOf(ch)) - 1;
                char ele = code.charAt(i + turn*4);
                array[index + turn *4] = ele;
            }
        }
        for(char e: array){
            if(e != '_') text = text + e;
        }
        return text; 
    }
}

class Cypher {
    public static void main(String[] args) {
        Cryptography caesar = new CaesarCypher(2);
        String code1 = caesar.encode("abcdyz");
        String text1 = caesar.decode(code1);
        System.out.println("The text was = " + text1 + " and the code was = " + code1 + " in caesar cypher.");
        
        Cryptography transposition = new TranspositionCypher(2413);
        String code2 = transposition.encode("mygoal");
        String text2 = transposition.decode(code2);
        System.out.println("The text was = " + text2 + " and the code was = " + code2 + " in transposition cypher.");
    }
}