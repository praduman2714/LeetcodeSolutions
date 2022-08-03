class MyCalendar {
    ArrayList<Pair> al;
    public MyCalendar() {
        al = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        for(Pair val : al){
            if(start < val.end && end > val.st){
                return false;
            }
        }
        al.add(new Pair(start, end));
        return true;
    }
    
    public class Pair{
        int st;
        int end;
        Pair(int st , int end){
            this.st = st;
            this.end = end;
        }
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */