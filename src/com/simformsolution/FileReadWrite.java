package com.simformsolution;

import java.io.*;

/**
 * @BufferWriter : The BufferedWriter class works by storing a chunk of data in an internal buffer before writing it to the underlying output stream.
 * This reduces the number of system calls to the underlying stream, making the writing process more efficient.
 */

public class FileReadWrite {

  public static void main(String[] args) {
    String fileName = "demoFile.txt";
    String content = "This is the content that will be written to the file.";

    // Writing content to file using an output stream
    try (FileOutputStream fileOutputStream = new FileOutputStream(fileName);
         //a bridge from character streams to byte streams:
         OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
         //efficiently write characters to a character-output stream
         BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter)) {
      bufferedWriter.write(content);
    } catch (IOException e) {
      System.out.println("An error occurred while writing to the file.");
      e.printStackTrace();
    }

    // Reading content from file using an input stream
    try (FileInputStream fileInputStream = new FileInputStream(fileName);
         //a bridge from byte streams to character streams
         InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
         //
         BufferedReader reader = new BufferedReader(inputStreamReader)) {
      String line;
      while ((line = reader.readLine()) != null) {
        System.out.println(line);
      }
    } catch (IOException e) {
      System.out.println("An error occurred while reading the file.");
      e.printStackTrace();
    }
  }
}
