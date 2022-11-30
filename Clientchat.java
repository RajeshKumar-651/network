//import necessary packages

import java.net.*;

import java.io.*;

class Clientchat

{

static void print_info()

{

System.out.println("*".repeat(56)+"\n\t IT1580 - Computer Networks Laboratory\n");

System.out.println("\tRoll Number : 20UIT051"+"\n\tName \t : RAJESHKUMAR B");

System.out.println("\tEx. No\t : 9.2");

System.out.println("\tEx. Name : Chat Application using TCP Sockets");

System.out.println("\tDate\t : 10.08.2022");

System.out.println("*".repeat(56));

}

public static void main(String a[]) throws Exception

{

print_info();

System.out.println("\t\t------- Client Side --------\n");

//create socket and necessary objects

Socket client = new Socket("localhost",3428);

DataInputStream input = new DataInputStream(System.in);

DataOutputStream send = new DataOutputStream(client.getOutputStream());

DataInputStream receive = new DataInputStream(client.getInputStream());

String inp,receivedMsg;

do

{

System.out.println("Enter message : ");

inp = input.readLine();

send.writeUTF(inp);

System.out.println("Waiting for Server's message...:)");

receivedMsg = receive.readUTF();

System.out.println("Server Says..."+receivedMsg);

}while(!inp.toLowerCase().equals("bye") || !receivedMsg.toLowerCase().equals("bye"));

client.close();

send.close();

receive.close();

}

}