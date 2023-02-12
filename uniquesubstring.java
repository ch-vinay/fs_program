Mr. Dhanush has provided the string NUM, which solely contains digits.
He is looking for substrings that are numbers and have an equal number of 
distinct digits in each of them. It follows the rule if the number is 123123, 
but not if the number is 12312.

Your task is to assist Mr. Dhanush in determining the number of distinct 
substrings (numbers) of NUM that adhere to the mentioned rule.


Input Format:
-------------
A string NUM, consist of diits [0-9]

Output Format:
--------------
Print an integer result.


Sample Input-1:
---------------
6767

Sample Output-1:
----------------
5

Explanation: 
------------
The list of words are: 6,7,67,76,6767


Sample Input-2:
---------------
2345432

Sample Output-2:
----------------
16

Explnation:
-----------
The list of words are: 2,3,4,5,23,34,45,54,43,32,234,345,543,432,2345,5432


import java.util.*;
public class uniquestr{
    private static int ck(String s){
        HashSet<String>al=new HashSet<>();
        
        for(int i=0;i<s.length();i++){
            for(int j=i+1;j<=s.length();j++){
                al.add(s.substring(i,j));
            }
        }
        int c=0;
        for(String x:al){
            if(x.length()==1){
                c++;
            }
            else{
                if(ck1(x)){
                    // System.out.println(x);
                    c++;
                }
            }
        }
        // System.out.println(al);
        return c;
    }
    private static boolean ck1(String s){
        char[]arr=s.toCharArray();
        HashMap<Character,Integer>hm=new HashMap<>();
        ArrayList<Integer>al=new ArrayList<>();
        for(char x:arr){
            hm.put(x,hm.getOrDefault(x,0)+1);
        }
        int g=0;
        for(char t:hm.keySet()){
            int j=hm.get(t);
            if(!al.contains(j)){
                al.add(j);
            }
            
        }
        if(al.size()>1){
            return false;
        }
        
        return true;
        
    }
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        System.out.println(ck(s));
    }
}
