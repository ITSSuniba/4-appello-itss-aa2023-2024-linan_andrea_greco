package org.example;

public class Credenziali {


    public boolean validaPassword(String password, String nome) {
        if (password == null || nome == null){
            return false;
        } else{
            if (password.length() < nome.length()) {
                return false;
            }
        }
        // Controlla se la password contiene almeno un numero
        boolean checkNumInPw = false;
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                checkNumInPw = true;
                break;
            }
        }
        // Controlla se la password contiene almeno una lettera dell'alfabeto
        boolean checkAlphabetInPW = false;
        for(char c : password.toCharArray()){
            if (Character.isAlphabetic(c)){
                checkAlphabetInPW = true;
                break;
            }
        }
        // Restituisce true se la password ha almeno un numero e una lettera
        return checkNumInPw && checkAlphabetInPW;

    }
}
