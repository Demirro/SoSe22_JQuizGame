/**
 * 
 */
package de.uk.java.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import de.uk.java.questions.*;

/**
 * @author Théo Bouveyron
 *
 */
public class QuestionFileReader {

	/**
	 * Methode zum Auslesen einer JSON-Datei basierend auf org.json
	 * @param f
	 * @return
	 */
	public static ArrayList<Question> readQuestions(String path) {
		ArrayList<Question> questions = new ArrayList<Question>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(new File(path)))){
			JSONTokener jt = new JSONTokener(br);
			JSONArray array = new JSONArray(jt);
			
			for (Object object : array) {
				if (object instanceof JSONObject) {
					JSONObject jobj = (JSONObject) object;
						questions.add(questionFromJson(jobj));
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return questions;
	}
	
	/**
	 * Ausgelagerte Methode zum Erstellen eines neuen Fragenobjektes.
	 * Typ der Frage aus der JSON wird ausgelesen und entsprechend eine Frage des Types erstellt
	 * @param jobj
	 * @return
	 */
	private static Question questionFromJson(JSONObject jobj) {
		switch (jobj.getString("type")) {
		case ("bool"):
			return new BoolQuestion(jobj.getString("prompt"), 
					Boolean.toString(jobj.getBoolean("correct_answer")), 
					jobj.getString("category"));
		case ("single choice"):
			return new SingleChoiceQuestion(jobj.getString("prompt"), jobj.getString("category"), translateArray(jobj.getJSONArray("answer_array")), 
					jobj.getString("correct_answer"));
		// ADD CASES FOR NEW QUESTION TYPES
		default:
			System.err.println("Question Type was not recognized. Question Type: " + jobj.getString("type"));
			return null;
		}
	}

	/**
	 * @param jsonArray
	 * @return
	 */
	private static List<String> translateArray(JSONArray jsonArray) {
		List<String> answerList = new ArrayList<String>();
		for (Object o : jsonArray.toList()) {
			if (o instanceof String) {
				answerList.add((String) o);
			}
		}
		return answerList;
	}
}
