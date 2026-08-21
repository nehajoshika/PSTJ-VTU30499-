import java.util.*;
class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the no of elements:");
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                System.out.println("("+arr[i]+","+arr[j]+")");
            }
        }
        sc.close();
        
    }
}
    
output:
enter the no of elements:
5
1 34 52 45 34
(1,34)
(1,52)
(1,45)
(1,34)
(34,52)
(34,45)
(34,34)
(52,45)
(52,34)
(45,34)
