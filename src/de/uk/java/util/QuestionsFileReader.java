/**
 * 
 */
package de.uk.java.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import de.uk.java.questions.BoolQuestion;
import de.uk.java.questions.Question;
import de.uk.java.questions.SingleChoiceQuestion;

/**
 * @author Théo Bouveyron
 *
 */
public class QuestionsFileReader {
	public static ArrayList<Question> readQuestions(String path) {
		ArrayList<Question> questions = new ArrayList<Question>();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			JSONTokener jt = new JSONTokener(br);
			JSONArray ja = new JSONArray(jt);
			
			for (Object object : ja) {
				if (object instanceof JSONObject) {
					JSONObject jobj = (JSONObject) object;
						questions.add(questionFromJson(jobj));
						
				}
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	private static Question questionFromJson(JSONObject jobj) {
		switch(jobj.getString("type")) {
		case "bool":
			return new BoolQuestion(jobj.getString("prompt"), jobj.getString("correct_answer"), jobj.getString("category"));
		case "single choice":
			return new SingleChoiceQuestion(jobj.getString("prompt"), jobj.getString("category"), translateArray(jobj.getJSONArray("answer_array")), jobj.getString("correct_answer"));
		default:
			return null;
		}
	}

	/**
	 * @param jsonArray
	 * @return
	 */
	private static List<String> translateArray(JSONArray jsonArray) {
		List<String> answerList = new ArrayList<String>();
		for (Object object : jsonArray) {
			if (object instanceof String) {
				answerList.add((String) object);
			}
		}
		return answerList;
	}
}
