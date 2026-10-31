class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {

        Set<String> set = new HashSet<>(wordDict);

        Map<Integer, List<String>> memo = new HashMap<>();

        return solve(s, 0, set, memo);
    }

    public List<String> solve(String s, int start,
                              Set<String> set,
                              Map<Integer, List<String>> memo) {

        if (memo.containsKey(start)) {
            return memo.get(start);
        }

        List<String> ans = new ArrayList<>();

        if (start == s.length()) {
            ans.add("");
            return ans;
        }

        for (int end = start + 1; end <= s.length(); end++) {

            String word = s.substring(start, end);

            if (set.contains(word)) {

                List<String> result = solve(s, end, set, memo);

                for (String next : result) {

                    if (next.isEmpty()) {
                        ans.add(word);
                    } else {
                        ans.add(word + " " + next);
                    }
                }
            }
        }

        memo.put(start, ans);

        return ans;
    }
}