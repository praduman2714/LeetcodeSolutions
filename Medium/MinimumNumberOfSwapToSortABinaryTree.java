{
    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int sum = 0;
        while(!q.isEmpty()){
            List<Integer> al = new ArrayList<>();
            int len = q.size();
            for(int i = 0; i<len ; i++){
                TreeNode curr = q.poll();
                //System.out.println(curr.val);
                al.add(curr.val);
                if(curr.left != null) {
                    q.add(curr.left);
                    //al.add(curr.left.val);
                }
                if(curr.right != null) {
                    q.add(curr.right);
                    //al.add(curr.right.val);
                }
            }
            //for(int val : al) System.out.print(val + " ");
            //System.out.println();
            sum+=count(al);
        }
        return sum;
    }
    
    public int count(List<Integer> list){
       int swaps = 0;
        int[] sorted = new int[list.size()];
        for(int i=0; i<sorted.length; i++) sorted[i] = list.get(i);
        Arrays.sort(sorted);
        Map<Integer, Integer> ind = new HashMap<>();
        for(int i=0; i<list.size(); i++) ind.put(list.get(i), i);
        
        for(int i=0; i<list.size(); i++) {
            if(list.get(i) != sorted[i]) {
                swaps++;
                ind.put(list.get(i), ind.get(sorted[i]));
                list.set(ind.get(sorted[i]), list.get(i));
            }
        }
        return swaps;
    }
    
    
    
}