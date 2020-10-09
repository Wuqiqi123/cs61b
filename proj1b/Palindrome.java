public class Palindrome {
    public Deque<Character> wordToDeque(String word){
        ArrayDeque<Character> deque = new ArrayDeque<>();
        for (int i=0; i<word.length();i++) {
            deque.addLast(word.charAt(i));
        }
        return deque;
    }

//    public boolean isPalindrome(String word) {
//        Deque<Character> deque = wordToDeque(word);
//        boolean is_palindrome = true;
//        for(int i=0; i<deque.size()/2; i++) {
//            if (deque.get(i) != deque.get(deque.size() - 1 - i)){
//                is_palindrome = false;
//                break;
//            }
//        }
//        return is_palindrome;
//    }
    public boolean isPalindrome(String word) {
        Deque<Character> deque = wordToDeque(word);
        return isPalindrome(deque);
    }

    private boolean isPalindrome(Deque<Character> deque) {
        if (deque.size() == 0 || deque.size() == 1) {
            return true;
        }
        if (deque.removeFirst() != deque.removeLast()){
            return false;
        }
        else {
            return isPalindrome(deque);
        }
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> deque = wordToDeque(word);
        return isPalindrome(deque, cc);
    }

    private boolean isPalindrome(Deque<Character> deque, CharacterComparator cc) {
        if (deque.size() == 0 || deque.size() == 1) {
            return true;
        }
        if (!cc.equalChars(deque.removeFirst(), deque.removeLast())){
            return false;
        }
        else {
            return isPalindrome(deque);
        }
    }

}