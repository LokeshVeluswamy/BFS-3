//Time Complexity: o(2^n)
//Space Complexity: o(n)
//Expln: First add the string to queue and perform bfs ny maintaing a set to avoid adding duplicate strings.
//So add all the children of the string to queue and process it until we find a valid one. After finding a valid string
//we stop adding to the queue since we found the min paranthesis to remove to form a valid string process that queue and return the result.
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        if(s.length() == 0 ) return res;
        Set<String> set= new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.add(s);
        set.add(s);
        boolean flag = false;
        while(!q.isEmpty())
        {
            String curr = q.poll();
            if(isvalid(curr))
            {
                flag = true;
                res.add(curr);
            }
            if(!flag)
            {
              for(int i =0; i < curr.length(); i++)
              {
                if(Character.isLetter(s.charAt(i))) continue;
                String str = curr.substring(0, i) + curr.substring(i+1);
                if(!set.contains(str)) {
                    q.add(str); set.add(str);

                }
              }
            }
        }

        return res;
    }
    private boolean isvalid(String str)
    {
        int count = 0;
        for(int i = 0; i < str.length(); i++)
        {
            char c = str.charAt(i);
            if(c == '(')
            {
                count++;
            }
            else if(c == ')')
            {
                if(count == 0) return false;
                count--;
            }
        }
        return (count == 0);
    }
}