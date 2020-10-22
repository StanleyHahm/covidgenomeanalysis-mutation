/*
NAME: Stanley Hahm
ID: A14609365
EMAIL: sthahm@ucsd.edu

In this code below, we are receiving a DNA strand and a chunk value.
This code will be able to output a DNA strand that inverts the nucleotides
every chunk value. It will also be able to account for any remainding
values that go over the chunk values.
*/
import java.util.Scanner;
/*
This class can receive input from a text file and then can
output the DNA strand that has inverted nucleotides every
chunk value.
*/
public class CovidMutation{
  /*
  Scan the text file. Find the DNA strand and the k-chunk value.
  Then invert the DNA strand every chunk value.
  Special cases include where the total length of the string
  divided by the chunk value has a remainder of more than zero.
  This is accounted (and noted) in the first if statement.

  @param og_DNA original DNA strand

  @return new_DNA complementary DNA strand
  */
  public static void main(String[] args) {
    //using Scanner to scan the text files
    //and using Character Arrays to store the new DNA into
    Scanner scnr = new Scanner(System.in);
    String og_DNA;

    //scans the original DNA and changes it to Character Array
    og_DNA = scnr.nextLine();
    char charArray[] = og_DNA.toCharArray();

    //scans the k chunk value and converts it to an integer
    String k_string = scnr.nextLine();
    int chunkSize = Integer.parseInt(k_string);

    //takes the length of the original DNA to determine the
    //length of the new Character Array
    int num = charArray.length;
    char new_DNA[] = new char[num];

    int y = 0;
    int x = 0;
    int extra;

    //below has 2 scenarios. One is to analyze and invert the first full
    //sets of chunks. And the second scenario is to check for any
    //remainders after the last k chunk value and then to invert those.
    for (int i = 0; i < chunkSize; i++){
      int count = 1;
      x += 1;

      //this evaluates and inverts any remainder
      extra = (num%chunkSize);
      if ((x*chunkSize) > num) {
        for (int j = 0; j < extra; j++){
          new_DNA[num-count] = charArray[y];
          count += 1;
          y += 1;
        }
        if (y == og_DNA.length()){
          break;
        }
      }
      //this inverts the full chunk value sets of nucleotides
      else {
        for (int m = 0; m < chunkSize; m++){
          new_DNA[(x*chunkSize)-count] = charArray[y];
          count += 1;
          y += 1;
        }
      }

    }
    //this accounts for if the chunksize is zero or below zero
    //it just gives back the unreverse genome sequence
    if (chunkSize <= 0){
      for (int q = 0; q < og_DNA.length(); q++){
        new_DNA[q] = charArray[q];
      }
    }
    //this account for if the chunksize is greater than the
    //length of the genome sequence. It reverses the entire
    //genome sequence.
    if (chunkSize > og_DNA.length()){
      int count = 1;
      for (int n = 0; n < og_DNA.length(); n++){
        new_DNA[num-count] = charArray[n];
        count += 1;
      }
    }
    //this accounts for if the chunksize is 1. The new DNA
    //strand doesn't invert.
    if (chunkSize == 1){
      new_DNA[0] = charArray[0];
    }
    System.out.println(new_DNA);

  }
}
