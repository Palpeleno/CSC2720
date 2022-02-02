package labs.lab3;


public class main {
    public static void main(String args[]) {
        // create a new string
        StringBuffer s = new StringBuffer("Kush Darji");

        // call reverse method
        reverse(s);

        // print the reversed string
        System.out.println("Reversed string is " + s);
    }

    public static void reverse(StringBuffer str) {
        // Create a stack of capacity
        // equal to length of string
        int n = str.length();
        myStack obj = new myStack(n);

        // Push all characters of string
        // to stack
        int i;
        for (i = 0; i < n; i++)
            obj.push(str.charAt(i));

        // Pop all characters of string
        // and put them back to str
        for (i = 0; i < n; i++) {
            char ch = obj.pop();
            str.setCharAt(i, ch);
        }
    }

}
