class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if(n % groupSize != 0) {
            return false;
        }
        HashMap<Integer, Integer> cardCount = new HashMap<>();
        for(int card : hand) {
            int count = cardCount.getOrDefault(card, 0);
            cardCount.put(card, count+1);
        }

        for(int card : hand) {
            int startCard = card;
 // Find the start of the potential straight sequence
            while(cardCount.getOrDefault(startCard-1, 0)>0) {
                startCard--;
            }

            while(startCard <= card) {
                while(cardCount.getOrDefault(startCard, 0) > 0) {
                    for(int nextCard = startCard; nextCard < startCard + groupSize; nextCard++) {
                        if(cardCount.getOrDefault(nextCard, 0)==0) {
                            return false;
                        }
                        cardCount.put(nextCard, cardCount.get(nextCard) - 1);
                    }
                }
                startCard++;
            }
        }
        return true;
    }
}