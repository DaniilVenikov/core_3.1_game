import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Date;

import static java.nio.charset.StandardCharsets.UTF_16;
import static java.nio.charset.StandardCharsets.UTF_8;

public class Main {

    public static void main(String[] args) {

        StringBuilder stringBuilder = new StringBuilder();
        Date date = new Date();

        File dir1 = new File("res");
        File dir2 = new File("savegames");
        File dir3 = new File("temp");
        File dir_1 = new File("src/main");
        File dir_2 = new File("src/test");
        File dir1_1 = new File("res/drawables");
        File dir1_2 = new File("res/vectors");
        File dir1_3 = new File("res/icons");

        stringBuilder.append(createDirectory(dir1, date));
        stringBuilder.append(createDirectory(dir2, date));
        stringBuilder.append(createDirectory(dir3, date));
        stringBuilder.append(createDirectory(dir_1, date));
        stringBuilder.append(createDirectory(dir_2, date));
        stringBuilder.append(createDirectory(dir1_1, date));
        stringBuilder.append(createDirectory(dir1_2, date));
        stringBuilder.append(createDirectory(dir1_3, date));


        File file1 = new File(dir_1, "Main.java");
        File file2 = new File(dir_1, "Utils.java");
        File file3 = new File(dir3, "temp.txt");


        stringBuilder.append(createFile(file1, date));
        stringBuilder.append(createFile(file2, date));
        stringBuilder.append(createFile(file3, date));


        String log = stringBuilder.toString();

        writeInFile(file3.getPath(), log);



    }

    public static void writeInFile(String fileName, String text){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, UTF_16))){
            writer.write(text);
            writer.flush();
        } catch (IOException exception){
            System.out.println(exception.getMessage());
        }
    }

    public static String createDirectory(File file, Date date) {
        if (file.mkdir()) {
            return String.format("%s был создан каталог %s \n", date, file.getName());
        } else {
            return String.format("Не получилось создать каталог %s \n", file.getName());
        }
    }


    public static String createFile(File file, Date date) {
        try {
            if (file.createNewFile()) {
                return String.format("%s был создан файл %s в директории %s \n", date, file.getName(), file.getParent());
            } else {
                return String.format("Не получилось создать файл %s \n", file.getName());
            }
        } catch (IOException exception) {
            return exception.getMessage();
        }
    }

}
