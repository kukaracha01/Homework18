import exception.WrongLoginException;
import exception.WrongPasswordException;

public class Main {
    private static final String VALID_SYMBOLS = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM1234567890_";
    public static void main(String[] args) {
        try {
            authenticationUser("lsdjf", "1234", "1234");
            System.out.println("Хорошая работа");
        } catch (WrongLoginException login) {
            System.out.println(login.getMessage());
        } catch (WrongPasswordException password) {
            System.out.println(password.getMessage());
        }

    }
    private static void authenticationUser(String login, String password, String confirmPassword) {
        for (int i = 0; i < login.length(); i++) {
            if (!VALID_SYMBOLS.contains(Character.toString(login.charAt(i))) || login.length() > 20) {
                throw new WrongLoginException();
            }
        }
        for (int i = 0; i < password.length(); i++) {
            if (!VALID_SYMBOLS.contains(Character.toString(password.charAt(i))) || password.length() > 20) {
                throw new WrongPasswordException();
            }
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException();
        }
    }

}