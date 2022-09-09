class Solution {
    public int numberOfWeakCharacters(int[][] pro) {
        Arrays.sort(pro, (a,b) -> (a[0] == b[0]) ? Integer.compare(b[1], a[1]) : Integer.compare(a[0], b[0]));
        int c = 0;
        int max = pro[pro.length - 1][1];
        for(int i = pro.length -2; i>=0; i--){
            if(pro[i][1] < max){
                c++;
            }else{
                max = pro[i][1];   
            }
             
        }
        return c;
    }
}