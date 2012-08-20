package parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import beans.Attribute;
import beans.Clazz;

public class CustomParser {
	
	public void parse( String fileName ) throws IOException{
		//FileInputStream inputStream = new FileInputStream( new File(fileName) );
		//File arquivo = new File(fileName);
		//int tamanho = arquivo.length();
		
		BufferedReader reader = new BufferedReader( new FileReader(new File(fileName)) );
		
		StringBuffer arq = new StringBuffer();
		String line;
		while( (line = reader.readLine()) != null ){
			arq.append(line);
		}
		
		
		
		String fileContents = arq.toString();
		int currentPosition = 0;
		
		//StringReader stringReader = new StringReader(fileContents);
		//skipWhiteSpaces(stringReader);
		
		currentPosition = skipWhiteSpaces(currentPosition, fileContents);
		
		List<Clazz> classes = parseClassesList( currentPosition, fileContents );
	}

	private List<Clazz> parseClassesList(int currentPosition, String fileContents) {
		List<Clazz> classes = new ArrayList<Clazz>();
		if( compareString( fileContents, currentPosition, "classes" ) ){
			currentPosition += "classes".length();
			
			currentPosition = skipWhiteSpaces(currentPosition, fileContents);
			if( fileContents.charAt(currentPosition) != '{'){
				return null;
			}
			
			currentPosition = parseClasses( currentPosition, fileContents, classes );
			
			if( currentPosition == -1 ) return null;
			
			if( fileContents.charAt(currentPosition) != '}'){
				return null;
			}
			
			currentPosition = skipWhiteSpaces(currentPosition, fileContents);
			
		} else return null;
		
		return classes;
	}

	private int parseClasses(int currentPosition, String fileContents,
			List<Clazz> classes) {
		currentPosition = skipWhiteSpaces(currentPosition, fileContents);
		
		while( compareString(fileContents, currentPosition, "class") ){
			currentPosition += "class".length();
			
			if( fileContents.charAt(currentPosition) != '{'){
				return -1;
			}
			
			currentPosition = parseClass( currentPosition, fileContents, classes );
			
			if( fileContents.charAt(currentPosition) != '}'){
				return -1;
			}
		}
		
		return skipWhiteSpaces(currentPosition, fileContents);
	}

	private int parseClass(int currentPosition, String fileContents,
			List<Clazz> classes) {
		
		Clazz clazz = new Clazz();
		
		currentPosition = skipWhiteSpaces(currentPosition, fileContents);
		
		List<Attribute> attributes = new ArrayList<Attribute>();
		
		currentPosition = parseAttributesList( currentPosition, fileContents, attributes );
		
		if( currentPosition == -1 ) return -1;
		
		return skipWhiteSpaces(currentPosition, fileContents);
	}

	private int parseAttributesList(int currentPosition, String fileContents,
			List<Attribute> attributes) {
		if( compareString( fileContents, currentPosition, "attributes" ) ){
			currentPosition += "attributes".length();
			
			currentPosition = skipWhiteSpaces(currentPosition, fileContents);
			if( fileContents.charAt(currentPosition) != '{'){
				return -1;
			}
			
			currentPosition = parseAttributes( currentPosition, fileContents, attributes );
			
			if( currentPosition == -1 ) return -1;
			
			if( fileContents.charAt(currentPosition) != '}'){
				return -1;
			}
			
			currentPosition = skipWhiteSpaces(currentPosition, fileContents);
			
		} else return -1;
		
		return currentPosition;
	}

	private int parseAttributes(int currentPosition, String fileContents,
			List<Attribute> attributes) {
		currentPosition = skipWhiteSpaces(currentPosition, fileContents);
		
		while( compareString(fileContents, currentPosition, "attribute") ){
			currentPosition += "attribute".length();
			
			if( fileContents.charAt(currentPosition) != '{'){
				return -1;
			}
			
			currentPosition = parseAttribute( currentPosition, fileContents, attributes );
			
			if( fileContents.charAt(currentPosition) != '}'){
				return -1;
			}
		}
		
		return skipWhiteSpaces(currentPosition, fileContents);
	}

	private int parseAttribute(int currentPosition, String fileContents,
			List<Attribute> attributes) {
		// TODO Auto-generated method stub
		return 0;
	}

	private boolean compareString(String fileContents, int currentPosition,
			String string) {
		if( fileContents.length() < currentPosition + string.length()){
			return false;
		}
		
		return( fileContents.substring(currentPosition, string.length()).equals(string) );
	}

	private int skipWhiteSpaces(int currentPosition, String fileContents) {
		while( Character.isWhitespace( fileContents.charAt(currentPosition) ) ){
			currentPosition++;
		}
		
		return currentPosition;
	}

	
}
