import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * produces a play list sorted by song run time. It also produces an average  song runtime for
 * the play list, as well as indicates which song is the closest to 4 minutes long, 
 *  also formats the out put in an easy to read way
 * @author maxhartel
 *
 */

public class PlayList {
	public static void main(String args[]) {
		String title;
		String artist;
		String album;
		String playTime;
		Scanner scan = new Scanner(System.in);
		int colonIndex;
		int playMinutes;
		int playSeconds;
		final int FOUR_MINUTES = 260;
		int song1Diff;
		int song2Diff;
		int song3Diff;
		int tempSmallest;
		Song song1;
		Song song2;
		Song song3;
		Double averagePlayTime;
		DecimalFormat fmt = new DecimalFormat("0.##");
		
		//Fetches user data for the first song
		System.out.print("Enter title");
		title = scan.nextLine();
		System.out.print("Enter artist");
		artist = scan.nextLine();
		System.out.print("Enter Album");
		album = scan.nextLine();
		System.out.print("Enter play time (mm:ss)");
		playTime = scan.nextLine();
		
		//Converts the input time from (mm:ss) to just seconds
		colonIndex = playTime.indexOf(':');
		playSeconds = Integer.parseInt(playTime.substring(colonIndex + 1));
		playMinutes = Integer.parseInt(playTime.substring(0,colonIndex));
		playSeconds = (playMinutes*60) + playSeconds;
		
		//initializes the first Song object
		song1 = new Song(title,artist,album, playSeconds);
		
		//repeats the earlier  process for songs 2 and 3
		System.out.print("Enter title");
		title = scan.nextLine();
		System.out.print("Enter artist");
		artist = scan.nextLine();
		System.out.print("Enter Album");
		album = scan.nextLine();
		System.out.print("Enter play time (mm:ss)");
		playTime = scan.nextLine();
		
		colonIndex = playTime.indexOf(':');
		playSeconds = Integer.parseInt(playTime.substring(colonIndex + 1));
		playMinutes = Integer.parseInt(playTime.substring(0,colonIndex));
		playSeconds = (playMinutes*60) + playSeconds;
		
		song2 = new Song(title,artist,album, playSeconds);
		
		System.out.print("Enter title");
		title = scan.nextLine();
		System.out.print("Enter artist");
		artist = scan.nextLine();
		System.out.print("Enter Album");
		album = scan.nextLine();
		System.out.print("Enter play time (mm:ss)");
		playTime = scan.nextLine();
		
		colonIndex = playTime.indexOf(':');
		playSeconds = Integer.parseInt(playTime.substring(colonIndex + 1));
		playMinutes = Integer.parseInt(playTime.substring(0,colonIndex));
		playSeconds = (playMinutes*60) + playSeconds;
		
		song3 = new Song(title,artist,album, playSeconds);
		
		//Calculates the average play time of all three songs and stores it as a double
		averagePlayTime = ( song1.getPlayTime() + song2.getPlayTime() + song3.getPlayTime()) / 3.00;
		
		//Displays the average play time formated to be accurate to 2 decimal places
		System.out.println("Average play time: "+fmt.format(averagePlayTime) + "\n");
		
		//determines the distance from 4 minutes that each song is using temp variables
		song1Diff = Math.abs(FOUR_MINUTES - song1.getPlayTime());
		song2Diff = Math.abs(FOUR_MINUTES - song2.getPlayTime());
		song3Diff = Math.abs(FOUR_MINUTES - song3.getPlayTime());

		//Determines which song is closest to 4 minutes using the temp variables  above
		tempSmallest = song1Diff;
		if(song2Diff <= tempSmallest) {
			tempSmallest = song2Diff;
		}
		if(song3Diff <= tempSmallest) {
			tempSmallest = song3Diff;
		}
		
		//Displays the closest song to 4 minutes in play time
		if(song1Diff == tempSmallest) {
			System.out.println("Song with play time closest to 240 secs is: " + song1.getTitle()+ "\n");
		}else if(song2Diff == tempSmallest) {
			System.out.println("Song with play time closest to 240 secs is: " + song2.getTitle()+ "\n");
		}else if(song3Diff == tempSmallest) {
			System.out.println("Song with play time closest to 240 secs is: " + song3.getTitle()+ "\n");
		}
		
		//Prints a easy to read display for the play list
		System.out.println("========================================================================================");
		System.out.println("Title                   Artist                     Album                            Time");
		System.out.println("========================================================================================");
		
		//Determines an order of songs from shortest to longest play times and then displays them
		if(song1.getPlayTime()<=song2.getPlayTime() && song1.getPlayTime()<=song3.getPlayTime()) {
			System.out.println(song1);
		}else if(song2.getPlayTime()<=song1.getPlayTime() && song1.getPlayTime()<=song3.getPlayTime()) {
			System.out.println(song2);
		}else  if(song3.getPlayTime()<=song2.getPlayTime() && song3.getPlayTime()<=song1.getPlayTime()) {
			System.out.println(song3);
		}
		
		if(song1.getPlayTime()<=song2.getPlayTime() && song1.getPlayTime()>=song3.getPlayTime()) {
			System.out.println(song1);
		}else if(song1.getPlayTime()>=song2.getPlayTime() && song1.getPlayTime()<=song3.getPlayTime()) {
			System.out.println(song1);
		}else if(song2.getPlayTime()<=song1.getPlayTime() && song2.getPlayTime()>=song3.getPlayTime()) {
			System.out.println(song2);
		}else if(song2.getPlayTime()>=song1.getPlayTime() && song2.getPlayTime()<=song3.getPlayTime()) {
			System.out.println(song2);
		}else  if(song3.getPlayTime()<=song2.getPlayTime() && song3.getPlayTime()>=song1.getPlayTime()) {
			System.out.println(song3);
		}else if(song3.getPlayTime()>=song2.getPlayTime() && song3.getPlayTime()<=song1.getPlayTime()) {
			System.out.println(song3);
		}
		
		if(song1.getPlayTime()>=song2.getPlayTime() && song1.getPlayTime()>=song3.getPlayTime()) {
			System.out.println(song1);
		}else if(song2.getPlayTime()>=song1.getPlayTime() && song2.getPlayTime()>=song3.getPlayTime()) {
			System.out.println(song2);
		}else  if(song3.getPlayTime()>=song2.getPlayTime() && song3.getPlayTime()>=song1.getPlayTime()) {
			System.out.println(song3);
		}
		System.out.println("========================================================================================");
		scan.close();
	}

}
