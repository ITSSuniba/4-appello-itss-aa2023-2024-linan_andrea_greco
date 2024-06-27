import org.example.Credenziali;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import net.jqwik.api.*;
import net.jqwik.api.statistics.Histogram;
import net.jqwik.api.statistics.Statistics;
import net.jqwik.api.statistics.StatisticsReport;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

//-----------------------------------------------------HOMEWORK 2 -----------------------------------

public class CredenzialiTest {
    private Credenziali credenziali = new Credenziali();


    @Property
    @Report(Reporting.GENERATED)
    @StatisticsReport(format = Histogram.class)
    void fail(
            @ForAll ("stringaMista")  String password,
            @ForAll ("soloLettere") String nome){
        String risultato;
        if (password.matches("[a-zA-Z]+")){
            risultato = "pw con sole lettere";
        } else if (password.matches("\\d+")) {
            risultato = "pw solo numeri";
        } else {
            risultato = "pw mista";
        }
        assertFalse(credenziali.validaPassword(password,nome));
        Statistics.label("risultati").collect(risultato);
    }


    @Provide
    Arbitrary<String> stringaMista() {
        return Arbitraries.strings()
                .withChars("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890!@#$%^&*(£)-_=+[]{}|;:'\",.<>?/`~\\")
                .ofMaxLength(3)
                .ofMinLength(0);
    }

    @Provide
    Arbitrary<String> soloLettere() {
        return Arbitraries.strings()
                .withChars("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz'")
                .ofMinLength(4)
                .ofMaxLength(20);
    }



    @Property
    @StatisticsReport(format = Histogram.class)
    void valid(
            @ForAll ("stringaMista1k") String password,
            @ForAll ("soloLettere1")String nome){
        String risultato;
        if (password.matches("[a-zA-Z]+")){
            risultato = "pw con sole lettere";
        } else if (password.matches("\\d+")) {
            risultato = "pw solo numeri";
        } else {
            risultato = "pw mista";
        }
        assertTrue(credenziali.validaPassword(password,nome));
        Statistics.collect(risultato);
    }


    @Provide
    Arbitrary<String> stringaMista1k() {
        Arbitrary<Character> letter = Arbitraries.of('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
                'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z');
        Arbitrary<Character> digit = Arbitraries.of('0', '1', '2', '3', '4', '5', '6', '7', '8', '9');

        Arbitrary<String> randomPart = Arbitraries.strings()
                .withChars("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890!@#$%^&*(£)-_=+[]{}|;:'\",.<>?/`~\\")
                .ofMinLength(18); // Minimum length 18, as we add 2 more characters manually

        // combina per creare la stringa finale
        return Combinators.combine(letter, digit, randomPart)
                .as((l, d, r) -> shuffle("" + l + d + r))
                .filter(s -> s.length() >= 20); // assicura che la lunghezza finale sia almeno 20
    }
    private String shuffle(String input) {
        List<Character> characters = input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList());
        Collections.shuffle(characters);
        StringBuilder result = new StringBuilder(characters.size());
        for (char c : characters) {
            result.append(c);
        }
        return result.toString();
    }



    @Provide
    Arbitrary<String> soloLettere1() {
        return Arbitraries.strings()
                .withChars("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz'")
                .ofMinLength(4)
                .ofMaxLength(20);
    }

    @Property
    @Report(Reporting.GENERATED)
    @StatisticsReport(format = Histogram.class)
    void fail2(
            @ForAll ("stringaMista2")  String password,
            @ForAll ("soloLettere2") String nome){
        String risultato;
        if (password.matches("[a-zA-Z]+")){
            risultato = "pw con sole lettere";
        } else if (password.matches("\\d+")) {
            risultato = "pw solo numeri";
        } else if (password.matches("[^a-zA-Z0-9]*")){
            risultato = "pw senza lettere e numeri";
        } else{
            risultato = "stringa mista";
        }

            assertFalse(credenziali.validaPassword(password,nome));
        Statistics.label("risultati").collect(risultato);
    }


    @Provide
    Arbitrary<String> stringaMista2() {
        return Arbitraries.strings()
                .withChars("!@#$%^&*(£)-_=+[]{}|;:'\",.<>?/`~\\")
                .ofMinLength(20);
    }

    @Provide
    Arbitrary<String> soloLettere2() {
        return Arbitraries.strings()
                .withChars("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz'")
                .ofMinLength(4)
                .ofMaxLength(20);
    }

}
