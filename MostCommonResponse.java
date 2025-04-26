class Solution {
    public String findCommonResponse(List<List<String>> responses) {
        Map<String, Integer> freqMap = new HashMap<>();

        for (List<String> day : responses) {
            Set<String> uniqueResponses = new HashSet<>(day); 
            for (String response : uniqueResponses) {
                freqMap.put(response, freqMap.getOrDefault(response, 0) + 1);
            }
        }

        int maxFreq = 0;
        String result = "";

        for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
            String response = entry.getKey();
            int count = entry.getValue();

            if (count > maxFreq || (count == maxFreq && response.compareTo(result) < 0)) {
                maxFreq = count;
                result = response;
            }
        }

        return result;
    }
}