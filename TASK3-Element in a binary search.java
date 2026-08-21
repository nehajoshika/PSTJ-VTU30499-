import java.util.*;
class Main{
    public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    System.out.println("enter the no of elements:");
    int n = sc.nextInt();
    int[] arr=new int[n];
    for(int i=0;i<n;i++){
        arr[i]=sc.nextInt();
    }
    System.out.println("enter the value to be found:");
    int key=sc.nextInt();
    int low=0;
    int high=n-1;
    int index=-1;
    while(low<=high){
        int mid=low+(high-low)/2;
        if(arr[mid]==key){
            index=mid;
            break;
        }
        else if(arr[mid]<key){
            low=mid+1;
        }
        else{
            high=mid-1;
        }
    }
    if(index!=-1){
        System.out.println("Elemnet found at index"+index);
    }
    else{
        System.out.println("element not found");
    }
    sc.close();
    }
}
    
output:
enter the no of elements:
4
4 5 6 7
enter the value to be found:
5
Element found at index:1

