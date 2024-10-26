import java.util.Scanner;

public class UniversityAdmission {

    public static void main(String[] args) { 			
        Scanner scanner = new Scanner(System.in);

        // Ввод фамилии и имени
        System.out.println("Введите ваше имя:");
        String firstName = scanner.nextLine();

        System.out.println("Введите вашу фамилию:");
        String lastName = scanner.nextLine();

        // Ввод информации о наличии аттестата
        System.out.println("Есть ли у вас аттестат? (1 - Да, 0 - Нет)");
        boolean hasCertificate = scanner.nextInt() == 1;

        if (!hasCertificate) {
            clearScreen();
            System.out.println("К сожалению, вы не можете поступить без аттестата.");
            return;  // Прекращаем выполнение программы
        }

        // Ввод уровня владения английским
        System.out.println("Выберите ваш уровень владения английским языком:");
        System.out.println("1. Beginner\n2. Elementary\n3. Pre-Intermediate\n4. Intermediate\n5. Upper-Intermediate\n6. Advanced");
        int englishLevel = scanner.nextInt();

        // Ввод баллов ОРТ
        System.out.println("Введите ваш балл ОРТ:");
        int ortScore = scanner.nextInt();

        clearScreen();

        // Проверка на соответствие минимальным требованиям
        if (ortScore < 110) {
            System.out.println("К сожалению, ваш балл ОРТ ниже 110. Вы не можете быть зачислены.");
            return;  // Прекращаем выполнение программы
        }

        if (englishLevel < 4) {  // Если уровень ниже Intermediate (B1)
            System.out.println("Вам необходимо пройти подготовительный курс английского языка (HAZR).");
            return;  // Прекращаем выполнение программы
        }

        // Если все условия выполнены, предлагаем выбрать специальность
        System.out.println("Поздравляем! Вы можете быть зачислены в университет.");
        System.out.println("Выберите специальность:");
        System.out.println("1. Компьютерная инженерия (2500$)");
        System.out.println("2. Искусственный интеллект (2200$)");
        System.out.println("3. Психология (1900$)");
        System.out.println("4. Журналистика (1700$)");
        System.out.println("5. Международные отношения (2200$)");
        System.out.println("6. Право (1800$)");
        System.out.println("7. Менеджмент (2200$)");
        System.out.println("8. Медицина (3300$)");

        int specialtyChoice = scanner.nextInt();
        double tuitionFee = 0;
        String specialty = "";

        switch (specialtyChoice) {
            case 1:
                specialty = "Компьютерная инженерия";
                tuitionFee = 2500;
                break;
            case 2:
                specialty = "Искусственный интеллект";
                tuitionFee = 2200;
                break;
            case 3:
                specialty = "Психология";
                tuitionFee = 1900;
                break;
            case 4:
                specialty = "Журналистика";
                tuitionFee = 1700;
                break;
            case 5:
                specialty = "Международные отношения";
                tuitionFee = 2200;
                break;
            case 6:
                specialty = "Право";
                tuitionFee = 1800;
                break;
            case 7:
                specialty = "Менеджмент";
                tuitionFee = 2200;
                break;
            case 8:
                specialty = "Медицина";
                tuitionFee = 3300;
                break;
            default:
                System.out.println("Неверный выбор специальности.");
                return;  // Прекращаем выполнение программы
        }

        clearScreen();

        // Рассчитываем скидку на основе баллов ОРТ
        double discount = calculateDiscount(ortScore);
        double discountedFee = tuitionFee * (1 - discount);

        // Финальное сообщение
        System.out.printf("Dear %s %s, we congratulate you!%n", firstName, lastName);
        System.out.printf("You have been admitted to the %s program at Ala-Too International University.%n", specialty);

        if (discount > 0) {
            System.out.printf("The cost of your tuition with a %.0f%% discount will be %.2f$ per year.%n", discount * 100, discountedFee);
        } else {
            System.out.printf("The cost of your tuition will be %.2f$ per year.%n", tuitionFee);
        }
    }

    // Метод очистки экрана (симуляция)
    public static void clearScreen() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    // Метод для расчета скидки на основе баллов ОРТ
    public static double calculateDiscount(int ortScore) {
        if (ortScore >= 219) return 1.0;
        if (ortScore >= 210) return 0.75;
        if (ortScore >= 200) return 0.50;
        if (ortScore >= 175) return 0.25;
        if (ortScore >= 156) return 0.10;
        if (ortScore >= 140) return 0.05;
        return 0.0;
    }
}
