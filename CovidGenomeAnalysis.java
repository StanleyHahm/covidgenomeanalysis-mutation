/*
NAME: Stanley Hahm
ID: A14609365
EMAIL: sthahm@ucsd.edu

In this code below, we are receiving DNA strands and the nucleotide
layout of each of them. Using this code, we will be output the
complementary DNA strand. In addition, it will also read and output
how many A's (or Adenines) there are in the given DNA strand.
*/

import java.util.Scanner;
import java.lang.*;

/*
This class can receive input from a text file and then can
output the correct digit and string that includes the complementary
DNA.
*/
public class CovidGenomeAnalysis{
  /*
  Scan the text file. Find the amount of A's and create the
  complementary DNA.

  @param og_DNA original DNA strand

  @return new_DNA complementary DNA strand
  @return count_A counts of Adenine in original DNA strand
  */
  public static void main(String[] args) {
    //using Scanner to scan the text files
    //and using Stringbuilder to start a new string for new DNA
    Scanner scnr = new Scanner(System.in);
    StringBuilder new_DNA = new StringBuilder();
    String og_DNA;
    int count_A = 0; //count of A starting at 0

    //scans the text file for the DNA strand
    og_DNA = scnr.nextLine();

    //below analyzes each nucleotide one at a time and adds
    //the complementary nucleotide to the new DNA strand
    for (int i = 0; i < og_DNA.length(); i++){
      if (og_DNA.charAt(i) == 'A'){
        count_A += 1; //keeps track of Adenine in DNA strand
        new_DNA.append('T');
      }
      else if (og_DNA.charAt(i) == 'T'){
        new_DNA.append('A');
      }
      else if (og_DNA.charAt(i) == 'C'){
        new_DNA.append('G');
      }
      else if (og_DNA.charAt(i) == 'G'){
        new_DNA.append('C');
      }
    }
    System.out.println(count_A + " " + new_DNA);
  }
}
