import java.net.*;

import java.io.*;


class ServerChat

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

System.out.println("\t\t------- Server Side --------\n");

//creating Sockets and necessary objects

ServerSocket server = new ServerSocket(3428);

Socket socket = server.accept();

DataInputStream input = new DataInputStream(System.in);

DataOutputStream send = new DataOutputStream(socket.getOutputStream());

DataInputStream receive = new DataInputStream(socket.getInputStream());

String message,receivedMsg;

do

{

System.out.println("Waiting for Client's Message...");

receivedMsg = receive.readUTF();

System.out.println("Client says...\n"+receivedMsg);

System.out.print("Enter Message : ");

message = input.readLine();

send.writeUTF(message);

}while(!message.toLowerCase().equals("bye") || !receivedMsg.toLowerCase().equals("bye"));

//close the connection

server.close();

socket.close();

receive.close();

}

}