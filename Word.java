package ahorcado;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Word {
	private String word;
	private boolean[] guess;
	private int attempt;
	private final int max_attempt = 6;
	
	public Word() {
		ArrayList <String> all_words = new ArrayList <>();
		try (
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("/usr/share/dict/spanish")));
			) {
				String word;
				while ((word=br.readLine()) != null) {
					if (word.length()>7) {
						all_words.add(word);
					}
				}
				br.close();
		} catch (IOException e) {
			all_words.add("ornitorrinco");
		}
		word = all_words.get((int)(Math.random()*all_words.size())).toUpperCase();
		
		guess = new boolean[word.length()];
		for(int i=0; i < word.length(); i++) {
			guess[i] = false;
		}
	}
	
	public int getAttemnt() {
		return attempt;
	}
	
	public String getWordvisible() {
		return word;
	}
	
	public boolean isLoser() {
		return attempt >= max_attempt;
	}
	
	public void insert_char(char c){
		boolean update = true;
		String word_clean = word.replace('Á','A').replace('É','E').replace('Í','I').replace('Ó','O').replace('Ú','U').replace('Ü','U');
		for(int i=0; i < word_clean.length(); i++) {
			if (word_clean.charAt(i) == c) {
				guess[i] = true;
				update = false;
			}
		}
		if(update) {
			attempt++;
		}
	}

	public boolean isWin() {
		boolean win = true;
		for(int i=0; i < word.length(); i++) {
			if (!guess[i]) {
				win=false;
				break;
			}
		}
		return win;
	}
	
	public String getWord() {
		char[] show_word = new char[word.length()];
		for(int i=0; i < word.length(); i++) {
			if (guess[i]) {
				show_word[i] = word.charAt(i);
			} else {
				show_word[i] = '-';
			}
		}
		return String.valueOf(show_word);
	}
}
