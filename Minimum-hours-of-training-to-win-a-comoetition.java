class Solution {
    public int minNumberOfHours(int e, int iex, int[] energy, int[] experience) {
        int time = 0;
        for(int i = 0; i<energy.length; i++){
            if(e <= energy[i]){
                
                time+=energy[i]- e + 1;
                e+=energy[i] - e+1;
                //System.out.println("heelo" + " " +time);
            }
            if(iex <= experience[i]){
                
                time+= experience[i] - iex + 1;
                iex+= experience[i] - iex + 1;
                //System.out.println("Experience" + " " + time);
            }
            if(e > energy[i] && iex > experience[i]){
                //System.out.println("Both");
                e-=energy[i];
                iex+= experience[i];
            }
        }
        return time;
    }
}