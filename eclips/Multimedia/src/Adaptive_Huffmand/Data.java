package Adaptive_Huffmand;

import java.util.*;
import  java.io.*;

public class Data {
private int counter =0  , number = 0 , shortcode = 0;
private String  code = null   ;
private Character Char = null ;
private boolean isparent = false  , isroot = false  ;


public int getCounter(){
	return counter;
}
public void setCounter(int counter) {
	this.counter = counter;
}
public int getNumber() {
	return number;
}
public void setNumber(int number) {
	this.number = number;
}
public String getCode() {
	return code;
}
public void setCode(String  code) {
	this.code = code;
}
public Character getChar() {
	return Char;
}
public void setChar(Character c) {
	Char = c;
}
public boolean isIsparent() {
	return isparent;
}
public void setIsparent(boolean isparent) {
	this.isparent = isparent;
}
public boolean isIsroot() {
	return isroot;
}
public void setIsroot(boolean isroot) {
	this.isroot = isroot;
}



}
