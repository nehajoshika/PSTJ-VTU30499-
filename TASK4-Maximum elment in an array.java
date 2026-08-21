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
        int max=arr[0];
        for(int i=0;i<n;i++){
            if(arr[i]>max){
                max=arr[i];
            }
        }
        System.out.println("maximum element is"+max);
        sc.close();
    }
}
    
output:
enter the no of elements:
5
1
2
3
4
5
maximum element is:5