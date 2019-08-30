import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class CharacterToWordsMapperTest {
    private List<Character> characters;

    @Before
    public void init() {
        characters = Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
                'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z');
    }

    @Test
    public void shouldMapSingleWord() {
        // given
        CharacterToWordsMapper characterToWordsMapper = new CharacterToWordsMapper(characters);

        // when
        String result = characterToWordsMapper.mapSentence("test");

        // then
        Assert.assertEquals("e: test\ns: test\nt: test\n", result);
    }

    @Test
    public void shouldRemoveCommasAndDotsFromSentence() {
        // given
        CharacterToWordsMapper characterToWordsMapper = new CharacterToWordsMapper(characters);

        // when
        String result = characterToWordsMapper.mapSentence("jeden, dwa.");

        // then
        Assert.assertEquals("a: dwa\nd: dwa, jeden\ne: jeden\nj: jeden\nn: jeden\nw: dwa\n", result);

    }

    @Test
    public void shouldMapMultipleWords() {
        // given
        CharacterToWordsMapper characterToWordsMapper = new CharacterToWordsMapper(characters);

        // when
        String result = characterToWordsMapper.mapSentence("ala ma kota, kot koduje w Javie kota");

        // then
        Assert.assertEquals("a: ala, javie, kota, ma\n" +
                "d: koduje\n" +
                "e: javie, koduje\n" +
                "i: javie\n" +
                "j: javie, koduje\n" +
                "k: koduje, kot, kota\n" +
                "l: ala\n" +
                "m: ma\n" +
                "o: koduje, kot, kota\n" +
                "t: kot, kota\n" +
                "u: koduje\n" +
                "v: javie\n" +
                "w: w\n", result);
    }
}