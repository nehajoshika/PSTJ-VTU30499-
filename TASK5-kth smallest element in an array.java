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
        System.out.println("enter the kth element to find:");
        int k=sc.nextInt();
        Arrays.sort(arr);
        if(k>0&&k<n){
            System.out.println(arr[k-1]);
        }
        else{
            System.out.println("invalid kth element");
        }
        sc.close();
        
    }
}
    
output:
enter the no of elements:
5
12 34 56 78 91
enter the kth element to find:
4
78