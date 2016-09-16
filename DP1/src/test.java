
public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][]ar = new int[1][3];
		ar[0][0]= 1;
		ar[0][1]= 3;
		ar[0][2]= 5;
		Solution sol = new Solution();
		System.out.println(sol.searchMatrix(ar, 1));

	}

}
class Solution {
    int target;
    public boolean searchMatrix(int[][] matrix, int target) {
        this.target = target;
        int row = matrix.length;
        int col = matrix[0].length;
        int i = 0;
        int j = 0;
        while(i < row && j < col){
            int index = binary_search(j , col-1 , i , matrix);
            if(matrix[i][index] == target){
                return true;
            }
            if(matrix[i][index] > target){
                col = index;
            }
            i++;
            if(i >= row || j >= col){
                break;
            }
            index = binary_search_col(i , row-1 , j , matrix);
            if(matrix[index][j] == target){
                return true;
            }
            if(matrix[index][j] > target){
                row = index;
            }
            j++;
        }
        return false;
        
    }
    public int binary_search(int start , int end , int row , int[][] matrix){
        int first = start;
        int last = end;
        while(first < last){
            int mid = (first+last)/2;
            if(matrix[row][mid] < target){
                first = mid+1;
            }else{
                last = mid;
            }
        }
        return first;
    }
    public int binary_search_col(int start , int end , int col,int[][] matrix){
        int first = start;
        int last = end;
        while(first < last){
            int mid = (first+last)/2;
            if(matrix[mid][col] < target){
                first = mid+1;
            }else{
                last = mid;
            }
        }
        return first;
    }
}
