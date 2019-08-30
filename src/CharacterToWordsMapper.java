import java.util.*;

public class CharacterToWordsMapper {
    private final Map<Character, List<String>> characterToWordsMap;

    public CharacterToWordsMapper(List<Character> mappingCharacters) {
        characterToWordsMap = new HashMap<>();
        mappingCharacters.forEach(character -> {
                    characterToWordsMap.put(character, new ArrayList<>());
                }
        );
    }

    public String mapSentence(String sentence) {
        String[] words = sentence.replaceAll("[,.]", "").toLowerCase().split(" ");
        Arrays.sort(words);

        for (String word : words) {
            characterToWordsMap.forEach((character, strings) -> {
                        if (wordContainsCharacter(word, character) && resultNotContainsWord(word, strings)) {
                            strings.add(word);
                        }
                    }

            );
        }
        return getResultString();
    }

    private boolean resultNotContainsWord(String word, List<String> strings) {
        return !strings.contains(word);
    }

    private boolean wordContainsCharacter(String word, Character character) {
        return word.indexOf(character) >= 0;
    }

    private String getResultString() {
        StringBuilder result = new StringBuilder();
        characterToWordsMap.forEach((character, strings) -> {
                    if (strings.size() > 0) {
                        result.append(character).append(": ").append(String.join(", ", strings)).append("\n");
                    }
                }
        );
        return result.toString();
    }
}
