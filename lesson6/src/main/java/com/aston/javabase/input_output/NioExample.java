package com.aston.javabase.input_output;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioExample {

    public static void main(String[] args) throws IOException {
        // инициализируем класс RandomAccessFile, в параметры передаем путь к файлу
        // и модификатор, который говорит, что файл откроется для чтения и записи
        try (RandomAccessFile randomAccessFile = new RandomAccessFile("text.txt", "rw");
             // получаем экземпляр класса FileChannel
             FileChannel channel = randomAccessFile.getChannel();
        ) {
            // создаем буфер необходимого размера на основании размера нашего канала
            ByteBuffer byteBuffer = ByteBuffer.allocate((int) channel.size());

            // прочитанные данные будем помещать в StringBuilder
            StringBuilder builder = new StringBuilder();

            // записываем данные из канала в буфер
            channel.read(byteBuffer);

            // переключаем буфер с режима записи на режим чтения
            byteBuffer.flip();

            // в цикле записываем данные из буфера в StringBuilder
            while (byteBuffer.hasRemaining()) {
                builder.append((char) byteBuffer.get());
            }
            // выводим содержимое StringBuilder в консоли
            System.out.println(builder);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
