package com.andrewzhang.projects.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.andrewzhang.projects.domain.Output;

public class OutputDisplay {
    private JTextArea outputArea;
    private JPanel containerPanel;

    public OutputDisplay(){
        // create the output text area, and set it to be uneditable
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setLineWrap(true);  // enable line wrapping
        outputArea.setWrapStyleWord(true);  // wrap at word boundaries
        outputArea.setFont(new Font("Arial", Font.PLAIN, 16));
        
        // create a JScrollPane to contain the output area, and add to frame
        JScrollPane scrollPane = new JScrollPane(outputArea);
        scrollPane.setPreferredSize(new Dimension(400,400));

        // create the containerPanel
        containerPanel = new JPanel();
        containerPanel.add(scrollPane, BorderLayout.CENTER);
    }
    
    public void writeLine(String string){
        if (!string.isEmpty()){
            outputArea.append(string + System.lineSeparator());
        } else {
            outputArea.append("Silence..." + System.lineSeparator());
        }
    }

    public void writeOutput(Output output){
        String message = output.getMessage();
        if (output.isSuccess()){
            if (!message.isEmpty()){
                outputArea.append(message + System.lineSeparator());
            } else {
                outputArea.append("It's quiet..." + System.lineSeparator());
            }
        } else {
            outputArea.append("..." + System.lineSeparator());
        }
        

    }


    public JPanel getContainerPanel(){
        return containerPanel;
    }
}
