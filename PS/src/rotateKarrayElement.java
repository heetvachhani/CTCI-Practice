import java.util.Arrays;

public class rotateKarrayElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[]={1,2,3,4,5,6,7,8};
		int n=arr.length;
		int k=3;
		//brute force O(n) space and O(n)time
		int index=0;
		int res[]= new int[n];
		for(int i=0;i<k;i++){
			res[i]=arr[n-k+i];
			index++;
		}
		for(int j=0;j<=n-k-1;j++){
			res[index]=arr[j];
			index++;
		}
		System.out.println(Arrays.toString(res));

		// best way time O(k) and Space O(1)
		int temp=0;
		for(int i=0;i<k;i++){
			temp=arr[i];
			arr[i]=arr[(n-k)+i];
			arr[n-k+i]=temp;
		} 
		System.out.println(Arrays.toString(res));
		
		//system.arraycopy() and Arrays.copyOf()  --> check it

		
		
	}

}
