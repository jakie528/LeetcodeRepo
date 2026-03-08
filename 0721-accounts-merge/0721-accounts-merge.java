class Solution {

    Map<String, List<String>> adjacent = new HashMap<String, List<String>>();
    HashSet<String> visited = new HashSet<>();

    private void DFS(List<String> mergedAccount, String email) {
        visited.add(email);
        mergedAccount.add(email);

        //only one email, no edges were built, just add it and return immediately
        if(!adjacent.containsKey(email)) {
            return;
        }

        // prevent going in circles.
        for(String neighbor : adjacent.get(email)) {
            if(!visited.contains(neighbor)) {
                DFS(mergedAccount, neighbor);
            }
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int accountsSize = accounts.size();

        for(List<String> account : accounts) {
            int accountSize = account.size();

            String accountFirstEmail = account.get(1);
            for(int i = 2; i < accountSize; i++) {
                String accountEmail = account.get(i);

                if(!adjacent.containsKey(accountFirstEmail)) {
                    adjacent.put(accountFirstEmail, new ArrayList<String>());;
                }
                adjacent.get(accountFirstEmail).add(accountEmail);

                if(!adjacent.containsKey(accountEmail)) {
                    adjacent.put(accountEmail, new ArrayList<String>());
                }
                adjacent.get(accountEmail).add(accountFirstEmail);
            }
        }

        List<List<String>> mergedAccounts = new ArrayList<>();
        for(List<String> account : accounts) {
            String accountName = account.get(0);
            String accountFirstEmail = account.get(1);

            if(!visited.contains(accountFirstEmail)) {
                List<String> mergedAccount = new ArrayList<>();
                mergedAccount.add(accountName);

                DFS(mergedAccount, accountFirstEmail);
                Collections.sort(mergedAccount.subList(1, mergedAccount.size()));
                mergedAccounts.add(mergedAccount);
            }
        }
        return mergedAccounts;
    }
}