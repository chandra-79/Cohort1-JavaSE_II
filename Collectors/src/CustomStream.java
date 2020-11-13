
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class CustomStream {

 public static void main(String[] args) {

  // Step 01 - Start

  String[] stringArray = new String[100];

  // Let’s fill this Array by some Strings, for the sack of putting different
  // String Objects 
  // I am putting Basics on even location and Strong on odd locations of the
  // Arrays

  for (int i = 0; i < stringArray.length; i++) {
   if (i % 2 == 0) {
    stringArray[i] = "Basics";
   } else {
    stringArray[i] = "Strong";
   }
  }

  // Step 01 Ends
  // Step 02 Starts

  // Here we are defining our own splitrator
  Spliterator<String> mySpliterator = new arraySpliterator(stringArray);

  // Here we are Defining our own stream using stream support
  // and passing the Splitiratir above.

  Stream<String> myStream = StreamSupport.stream(mySpliterator, false);

  // Step 02 Ends
  // Step 04 Starts
  // Let’s try calling some classic stream methods one by one
  // Try only one method at a time as stream goes through only once and then
  // closed.
  //myStream.forEach(System.out::println);
  
  //myStream.filter(st -> st.startsWith("B")).forEach(System.out::println);
  
   //System.out.println(myStream.count());
   //System.out.println(myStream.distinct().count());

  // Step 04 Ends

 }

}

//Step 03 Starts
// creating arraySpliterator from an Array Implementing Spliterator Interface 

class arraySpliterator implements Spliterator<String> {

 private String[] arrayToSplit;
 int count = 0;
 // Constructor to access Array this is the source

 public arraySpliterator(String[] arrayToSplit) {
  this.arrayToSplit = arrayToSplit;
 }

 @Override
 public boolean tryAdvance(Consumer<? super String> action) {

  if (count <= arrayToSplit.length - 1) {
   action.accept(arrayToSplit[count]);
   count++;
   return true;
  } else {
   return false;
  }

 }

 @Override
 public Spliterator<String> trySplit() {
  return null;
 }

 @Override
 public long estimateSize() {
  return arrayToSplit.length;
 }

 @Override
 public int characteristics() {
  // For Simplicity lets use the characteristics of a List as base
  return Arrays.asList(arrayToSplit).stream().spliterator().characteristics();
 }

}

// Step 03 Ends