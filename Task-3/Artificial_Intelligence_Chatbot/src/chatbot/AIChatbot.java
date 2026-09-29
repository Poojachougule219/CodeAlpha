package chatbot;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AIChatbot extends JFrame {

    private JTextArea chatArea;
    private JTextField inputField;
    private JButton sendButton;


    public AIChatbot() {

        setTitle("AI Chatbot");
        setSize(600, 500);

        setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
        );

        setLocationRelativeTo(null);

        createInterface();
    }


    private void createInterface() {

        // Chat display
        chatArea = new JTextArea();

        chatArea.setEditable(false);

        chatArea.setLineWrap(true);

        chatArea.setWrapStyleWord(true);

        chatArea.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        16
                )
        );


        JScrollPane scrollPane =
                new JScrollPane(chatArea);


        // Input field
        inputField = new JTextField();

        inputField.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        16
                )
        );


        // Send button
        sendButton = new JButton("Send");

        sendButton.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        14
                )
        );


        JPanel bottomPanel =
                new JPanel(new BorderLayout());

        bottomPanel.add(
                inputField,
                BorderLayout.CENTER
        );

        bottomPanel.add(
                sendButton,
                BorderLayout.EAST
        );


        add(
                scrollPane,
                BorderLayout.CENTER
        );

        add(
                bottomPanel,
                BorderLayout.SOUTH
        );


        // Welcome message
        chatArea.append(
                "Bot: Hello! Welcome to AI Chatbot.\n"
        );

        chatArea.append(
                "Bot: You can ask me about Java, "
                + "your studies, or general questions.\n\n"
        );


        // Button event
        sendButton.addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(
                            ActionEvent e) {

                        sendMessage();
                    }
                }
        );


        // Enter key event
        inputField.addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(
                            ActionEvent e) {

                        sendMessage();
                    }
                }
        );
    }


    private void sendMessage() {

        String userMessage =
                inputField.getText().trim();


        if (userMessage.isEmpty()) {
            return;
        }


        chatArea.append(
                "You: " + userMessage + "\n"
        );


        String response =
                generateResponse(userMessage);


        chatArea.append(
                "Bot: " + response + "\n\n"
        );


        inputField.setText("");


        if (userMessage
                .toLowerCase()
                .contains("bye")) {

            inputField.setEnabled(false);

            sendButton.setEnabled(false);
        }
    }


    // Rule-based NLP logic
    private String generateResponse(
            String message) {

        String text =
                message.toLowerCase().trim();


        // Greeting
        if (containsAny(
                text,
                "hello",
                "hi",
                "hey"
        )) {

            return "Hello! How can I help you?";
        }


        // Name
        if (text.contains("your name")) {

            return "My name is Java AI Chatbot.";
        }


        // Java
        if (text.contains("java")) {

            return "Java is an object-oriented, "
                    + "platform-independent programming language.";
        }


        // OOP
        if (text.contains("oop")
                || text.contains("object oriented")) {

            return "The four main OOP concepts are "
                    + "Encapsulation, Inheritance, "
                    + "Polymorphism and Abstraction.";
        }


        // ArrayList
        if (text.contains("arraylist")) {

            return "ArrayList is a resizable array "
                    + "implementation of the List interface in Java.";
        }


        // Spring Boot
        if (text.contains("spring boot")) {

            return "Spring Boot is a Java framework "
                    + "used to create production-ready applications "
                    + "quickly.";
        }


        // SQL
        if (text.contains("sql")
                || text.contains("database")) {

            return "SQL is used to store, retrieve, "
                    + "update and manage data in relational databases.";
        }


        // Study
        if (text.contains("study")
                || text.contains("learn")) {

            return "A good approach is to study concepts "
                    + "first and then practice MCQs and coding problems.";
        }


        // Help
        if (text.contains("help")) {

            return "Sure! You can ask me about Java, OOP, "
                    + "ArrayList, SQL, Spring Boot or programming.";
        }


        // Thank you
        if (text.contains("thank")
                || text.contains("thanks")) {

            return "You're welcome! Happy to help.";
        }


        // Goodbye
        if (text.contains("bye")
                || text.contains("goodbye")) {

            return "Goodbye! Have a great day.";
        }


        // Default response
        return "I'm still learning. "
                + "Please ask me a question about "
                + "Java or programming.";
    }


    private boolean containsAny(
            String text,
            String... words) {

        for (String word : words) {

            if (text.contains(word)) {
                return true;
            }
        }

        return false;
    }


    public static void main(String[] args) {

        SwingUtilities.invokeLater(
                new Runnable() {

                    @Override
                    public void run() {

                        AIChatbot chatbot =
                                new AIChatbot();

                        chatbot.setVisible(true);
                    }
                }
        );
    }
}
