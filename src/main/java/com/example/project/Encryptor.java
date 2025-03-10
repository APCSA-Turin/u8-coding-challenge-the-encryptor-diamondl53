package com.example.project;
import java.util.ArrayList;
import java.util.Arrays;

public class Encryptor {
    
    public static int determineColumns(int messageLen, int rows){
        int columns;
        if(messageLen < rows){
            columns = 1;
        }else{
            if(messageLen % rows != 0){
            columns = (messageLen/rows) + 1;
            }else{
            columns = messageLen/rows;
            }
        }
        return columns;
    }
    public static void main(String[] args) {
        System.out.println(determineColumns(10, 5));
        System.out.println("nm y lhn .=e hb.l e,e=e,c eoteyo=mytrohe nm= naet l,e =,icg e oe,=ym ieh,gmy=n ,th s  n=e,e tfrm,i=Eyoa Ieiym=".length());
    }
    
    public static String[][] generateEncryptArray(String message, int rows) {
        int columns = determineColumns(message.length(), rows);
        int remainder = -1;
        int index = 0;
        String[][] arrayMessage = new String[rows][columns];
        remainder = (rows * columns) - message.length();
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                if(index >= message.length()){
                    arrayMessage[i][j] = "=";
                }else{
                    arrayMessage[i][j] = message.substring(index, index+1);
                    index++;
                }
            }
        }
        return arrayMessage;
    }

    public static String encryptMessage(String message, int rows){
        String[][] arrayMessage = generateEncryptArray(message, rows);
        String encryptMessage = "";
        for(int i = arrayMessage[0].length - 1; i > -1; i--){
           for(int j = 0; j < arrayMessage.length; j++){
                encryptMessage += arrayMessage[j][i];
            }
        }
        return encryptMessage;
    }

    public static String decryptMessage(String encryptedMessage, int rows) {
        if (rows * determineColumns(encryptedMessage.length(), rows) != encryptedMessage.length()) {
            return ""; 
        }
        String[][] decryptArray = new String[rows][determineColumns(encryptedMessage.length(), rows)];
        int index = 0;
        String decryptMessage = "";
        while(index < encryptedMessage.length()){
            for(int i = decryptArray[0].length - 1; i > -1; i--){
                for(int j = 0; j < decryptArray.length; j++){
                    decryptArray[j][i] = encryptedMessage.substring(index, index+1);
                    index++;
                }
            }
        }
        for(int i = 0; i < decryptArray.length; i++){
            for(int j = 0; j < decryptArray[0].length; j++){
                if(!decryptArray[i][j].equals("=")){
                    decryptMessage += decryptArray[i][j];
                }
            }
        }
        return decryptMessage;
    }
}
