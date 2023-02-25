import java.util.Optional;

import static java.lang.System.out;
public class main {
    public static void main(String[] args) {
        int sqrt_x = 2655; // число из которого нужно извлечь корень
        int amount_sqrt_x = (int)(Math.ceil(Math.log10(sqrt_x))); // количество цифр в числе из которого нужно извлечь корень
        int x = 0; // вспомогательная переменная для количества разрядов
        int y = 1; // переменная для определения на сколько нужно делить число, чтобы получить число первого разряда
        if(amount_sqrt_x%2 != 0) // определение количества разрядов
        {
            x = (amount_sqrt_x/2)+1;
        }
        else {
            x = amount_sqrt_x/2;
        }
        for(int i = 1; i < x; i++) // определение число первого разряда
        {
            y *= 100;
        }
        int firstrank = sqrt_x/y; // число первого разряда
        // а число sqrt(firstrank) - первое число ответа
        int z = firstrank - (sqrt(firstrank)*sqrt(firstrank)); // составляющее цифра к которой добавятся 2 цифры из другого разряда
        out.println("Первое число ответа: " + sqrt(firstrank))
    }
    public static int sqrt(int n){ // вычисляет корень не превышающий число
        if(n == 1) // если импортированное число 1, то возвращаем 1
        {
            return 1;
        }
        else
        {
            int left_border = 0; // левая граница
            int right_border = n; // правая граница
            int temporarily = (left_border + right_border) / 2; // среднее между границ
            int t = n; // вспомогательная перменная
            for (;;) { // бесконечный цикл вычисляющий корень не превосходящий корня разрядов
                temporarily = (right_border + left_border) / 2;
                if (temporarily == t || temporarily * temporarily == n) {
                    break;
                }
                if (temporarily * temporarily < n) {
                    left_border = temporarily;
                } else {
                    right_border = temporarily;
                }
                t = temporarily;
            }
            return temporarily; // возврат корня не превосходящего корня разрядов
        }
    }
}