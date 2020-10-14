import java.util.Observable;

public class Sequencer extends Observable {
    private int index = 0;
    private char[] charList;
    private String[] stringList;
    public Sequencer(String s) {
        int listSize = s.length();
        stringListDecleartion(s);
        stringList = new String[factorial(listSize)];
        System.out.println(stringList.length);
        heapPermutation(charList,listSize,listSize);
    }

    int factorial(int i){
        int factorial = 1;
        for(int j = 1; j <= i; j++){
            factorial *=j;
        }
        return factorial;
    }

    void heapPermutation(char[] s, int size, int n)
    {
        // if size becomes 1 then prints the obtained
        // permutation

        if (size == 1){
            //arrayPrint(charList);
            String string = new String(charList);
            stringList[index] = string;
            index++;

        }


        for (int i = 0; i < size; i++) {
            heapPermutation(s, size - 1, n);

            // if size is odd, swap 0th i.e (first) and
            // (size-1)th i.e (last) element
            if (size % 2 == 1) {
                char temp = s[0];
                s[0] = s[size - 1];
                s[size - 1] = temp;
            }

            // If size is even, swap ith
            // and (size-1)th i.e last element
            else {
                char temp = s[i];
                s[i] = s[size - 1];
                s[size - 1] = temp;
            }
        }
    }

    private void stringListDecleartion(String s) {
        charList = new char[s.length()];
        for(int i = 0;i<s.length();i++){
            charList[i]= s.charAt(i);
        }
    }

    public String[] getArray(){
        return stringList;
    }



}
