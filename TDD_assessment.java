import java.util.*;
// Please edit the file name of class name accordingly before run.
public class Main {
    public static void main(String[]  args) {
        String numbers = "1,\n10-1";
        try{
            int sum = add(numbers);
            System.out.println(sum);
        }catch (InvalidDigit ex ) {
            System.out.println("You string have negative number which is not allowed!!");
        } catch (NumberFormatException ex) {
            System.out.println("You String don't have suitable digit");
        }
    }

    static int add(String s) throws InvalidDigit {
        if(s.isEmpty()){
            return 0;
        }
        String str = s + " ";
        String a = str.replaceAll("[^0-9-]"," ");
        char[] c = a.toCharArray();
        List<String> lis = new ArrayList<>();
        StringBuilder tempString = new StringBuilder();
        int i = 0;
        int res = 0;
        while(i < c.length){
            if(c[i] != ' '){
                tempString.append(c[i]);
            }else{
                lis.add(String.valueOf(tempString));
                tempString.delete(0,tempString.length());
            }
            i++;
        }
        for(String j : lis){
            if(j != "" && 0 > Integer.parseInt(j)){
                throw new InvalidDigit("You string have negative number which is not allowed!!");
            }else {
                if(j != "" && 1000 >= Integer.parseInt(j)) {
                    res += Integer.parseInt(j);
                }
            }
        }
        return res;
    }

    static class InvalidDigit extends Exception {
        public InvalidDigit(String str){
            super(str);
        }
    }


}
