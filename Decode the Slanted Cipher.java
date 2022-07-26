class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        if(rows == 1) return encodedText;
        String[] st = encodedText.split(" ");
        int col = encodedText.length() / rows;
       // System.out.println(col);
        char[][] mat = new char[rows][col];
        
        for(int i = 0; i<rows ; i++){
            mat[i] = encodedText.substring(i*col , (i+1)*col).toCharArray();
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<col; i++){
            int k = i;
            for(int j = 0; j<rows ; j++){
                if(k < col){
                    sb.append(mat[j][k++]);
                }
            }
        }
        return sb.toString().replaceAll("\\s+$", "");
        
    }
}