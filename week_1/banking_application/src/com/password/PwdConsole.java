package com.password;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PwdConsole {
 public static void main(String[] args) throws Exception {
  Thread consoleEraser = new Thread(new ConsoleEraser());
  System.out.print("Password?  ");
  BufferedReader stdin = new BufferedReader(new
       InputStreamReader(System.in));
   consoleEraser.start();                       
  String pass = stdin.readLine();
  System.out.print("\b");
  System.out.println("Password: '" + pass + "'");
  }
 }

class ConsoleEraser implements Runnable{
 private boolean running = true;
 public void run() {
  while (running) {
   System.out.print("\b ");
   }
 }

 public synchronized void halt() {
  running = false;
 }
}
