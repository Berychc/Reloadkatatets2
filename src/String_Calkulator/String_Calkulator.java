package String_Calkulator;

import java.util.Scanner;

// Работу начал выполнять Егор Веселов - 19.08.23 - 14:50 MSK

public class String_Calkulator {
    public static void main(String[] args) throws IllegalArgumentException {
        String StartMesseage = "Строковый Калькулятор";
        System.out.println(StartMesseage);
        Scanner sc = new Scanner(System.in);
        String ro = "";
        do {
            System.out.print("Введите выражение: ");
            ro = sc.nextLine();
            String[] exp = ro.split(" ");
            if (exp.length != 3) {
                throw new IllegalArgumentException("Недопустимая операция");
                // IllegalArgumentException - это исключение, которое генерируется при передаче некорректных аргументов методу.
            }
            // Метод split() разбивает объект String на массив строк путём разделения строки указанной подстрокой.
            String ft = exp[0];
            String op = exp[1];
            String st = exp[2];
            if (!isv(ft) && !isv(st)) {
                throw new IllegalArgumentException("Недопустимая операция!");
            }
            if (op.equals("+")) {
                System.out.println("Результат: " + CS(ft, st));
            } else if (op.equals("-")) {
                String res = SB(st,st);
                System.out.println("Результат: " + SB(ft,st));
            } else if (op.equals("*") || op.equals("/")) {
                int num = Integer.parseInt(st);
                if (num >= 1 && num <= 10) {
                    String res;
                    if (op.equals("*")) {
                        res = MS(ft, st);
                    } else {
                        res = DS(ft, st);
                    }
                    res = res.substring(0, Math.min(res.length(), 40)) + (res.length() > 40 ? "..." : "");
                    System.out.println("Результат" + res);
                } else {
                    throw new IllegalArgumentException("Недопустимая операция!");
                    // Integer. parseInt это класс-обертка примитивного типа int. Внутри данного класса содержится единственное поле типа int.
                }
            }
        } while (!ro.equals("exit"));
    }
    static boolean isv(String input) {
        return input.startsWith("\"") && input.endsWith("\"");
    }
    static String CS(String f, String s) {
        return "\"" + f.substring(1, f.length() - 1) + s.substring(1, s.length() - 1) + "\"";
    }
    static String SB(String f, String s) {
        String fs = f.substring(1, f.length() - 1);
        String ss = s.substring(1, s.length() - 1);
        return "\"" + fs.replaceFirst(ss, "") + "\"";
    }
    private
    static String MS(String text, String num) {
        String str = text.substring(1, text.length() - 1);
        StringBuilder sb = new StringBuilder();
        if (num.matches("\\d+")) {
            int c = Integer.parseInt(num);
            for (int i = 0; i < c; i++) {
                sb.append(str);
            }
        } else {
            throw new IllegalArgumentException("Недопустимая операция");
        }
        return "\"" + sb.toString()+ "\"";
    }
    static String DS(String text, String num) {
        String str = text.substring(1, text.length() - 1);
        if (num.matches("\\d+")) {
            int Ml = Integer.parseInt(num);
            if (Ml > 0 && str.length() > Ml) {
                str = str.substring(0, str.length() / Ml) + " ";
            }
            return "\"" + str + "\"";
        } else {
            throw new IllegalArgumentException("Недопустимая операция");
        }
    }

}
// Переделанное альтернативное задание 25.08.23 14:23
