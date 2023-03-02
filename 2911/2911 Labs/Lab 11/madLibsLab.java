/**
 * @Author: Levi Kuhaulua
 * @Date: 11/18/2022
 * 
 * Assignment: Mad Libs Labs 
 * Alogrithm: 
 * Create a text file called MadLib that contains blank spaces with categories in a text file
 * Create methods that randomly returns one of several (6-10 words) parts of speech: 
 * - exclamation() returns one of several Strings like Gosh! Yikes!
 * - verb() returns one of several verbs like run, crawl, jump
 * - adverb() returns one of several adverbs like quickly, harshly, eagerly
 * - adjective() returns one of several Strings like nice, horrid, magnificient
 * - noun() - returns one of several strings like house, pen,  book 
 * - animal() - returns one of seveeral Strings like dog, giraffe, bird
 * Loop through the array of words
 * - if word does not start with an underscore '_' then print the word
 * - if it does start with an underscore like '_noun_' then use the respective methods to print out a word
 * output the story 
 * - each mad lib should be a random word, no two outputs should be the same. 
 */

import java.util.*; 
import java.io.*;
import java.util.regex.*;
public class madLibsLab {
    public static void main(String[] args) throws IOException{
        // Create a file to read from called madLibs
        File story = new File("madLibs.txt");
        // checks to see if file exists or not
        if (!story.exists()) {
            System.out.println("The file does not exist"); System.exit(0);
        }
        
        // to read the file
        Scanner readStory = new Scanner(story); 
       
        String storyTime; // for each word in the sentence
        String[] arrayOfStory = {}; // add each word to the sentence 
        
        // keeps reading from the file and add the words to the array
        while(readStory.hasNext()) {
            storyTime = readStory.nextLine();
            arrayOfStory = storyTime.split("[ _]+");
        }

        for (int i = 0; i < arrayOfStory.length; i++) {
            // if the word is any one of these types change to that word. 
            if (arrayOfStory[i].equals("adjective")) {
                arrayOfStory[i] = adjective(); 
            } else if (arrayOfStory[i].equals("noun")) {
                arrayOfStory[i] = noun(); 
            } else if (arrayOfStory[i].equals("exclamation")) {
                arrayOfStory[i] = exclamation();
            } else if (arrayOfStory[i].equals("verb")) {
                arrayOfStory[i] = verb(); 
            } else if (arrayOfStory[i].equals("adverb")) {
                arrayOfStory[i] = adverb(); 
            } else if (arrayOfStory[i].equals("animal")) {
                arrayOfStory[i] = animal(); 
            } 
            // if it is a punctuation mark like a period or comma, then join it to the last element in the array
            if (Pattern.matches("\\p{Punct}", arrayOfStory[i])) {
                arrayOfStory[i-1] += arrayOfStory[i];
                arrayOfStory[i] = "\b"; // backspace
            }
         }

        // print the story
         for (String words : arrayOfStory) {
            System.out.print(words + " ");
         }
        
        // close the file
        readStory.close();
    } 


    /**
     * exclamation() - return a randomly selected exclamation word
     * @return random word that is exclamated. 
     */
    public static String exclamation() {
        String[] exclamation = {"Yikes!", "Gosh!", "Jinkies!", "Jesus!", "Ay Soos Mariosa!", "Huch!", "What!", "Zoinks!", "Huh!"};
        Random randNum = new Random(); 
        int randWord = randNum.nextInt(exclamation.length);
        return exclamation[randWord];
    }

    /**
     * verb() - returns a randomly selected verb
     * @return random word that is a verb
     */
    public static String verb() {
        String[] verb = {"run", "jump", "hide", "holo holo", "hele", "reden", "drive"};
        Random randNum = new Random(); 
        int randWord = randNum.nextInt(verb.length);
        return verb[randWord]; 
    }
    /**
     * adverb() - returns a randomly selected adverb
     * @return random adverb
     */
    public static String adverb() {
        String[] adverb = {"quickly", "eagerly", "quietly", "slowly", "calmly", "sneakily"};
        Random randNum = new Random(); 
        int randWord = randNum.nextInt(adverb.length);
        return adverb[randWord]; 
    }
   
    /**
     * adjective() - returns a randomly selected adjective 
     * @return a random adjective
     */
    public static String adjective() {
        String[] adjective = {"nice", "horrid", "scary", "feroucious", "big", "mad"};
        Random randNum = new Random(); 
        int randWord = randNum.nextInt(adjective.length);
        return adjective[randWord]; 
    }

    /**
     * noun() - will return a randomly selected noun
     * @return a random noun
     */
    public static String noun() {
        String[] noun = {"house", "monster", "thing", "pen", "mouse", "computer"};
        Random randNum = new Random(); 
        int randWord = randNum.nextInt(noun.length);
        return noun[randWord]; 
    }

    /**
     * animal() - returns a randomly selected animal. 
     * @return a random animal
     */
    public static String animal() {
        String[] animal = {"dog", "cat", "dragon", "wyvern", "snake", "troll"}; 
        Random randNum = new Random(); 
        int randWord = randNum.nextInt(animal.length);
        return animal[randWord]; 
    }
}
