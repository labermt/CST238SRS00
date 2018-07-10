/*************************************************************
 * Author:          Silverio Reyes
 * Filename:        MainActivity.java
 * Date Created:    6/26/18 - Mitch Besser-Laber Created .gitignore,
 *                            README.md, and REPORT.md files
 *
 * Date Modified:   6/28/18 - Commit 022486a: Created project and
 *                            added dependencies
 *
 *                  6/29/18 - Created UI layout and function
 *                            to get user input so that it
 *                            can be passed as an intent
 *
 *                            Input validation also added so
 *                            that a user knows that they must
 *                            enter some text for a message to
 *                            be displayed
 **************************************************************/
package com.sreyesnoxgraphics.myfirstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // variable to check if profile needs to be updated
    private boolean NeedsUpdating = false;
    public static final String EXTRA_MESSAGE = "com.sreyesnoxgraphics.myfirstapp.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**********************************************************************
     * Purpose: This function gets the users input and sends it to display
     *          on another screen (activity)
     *
     * Pre-condition: Text message not filled (Send button never handled).
     *
     * Post-condition: Displays msg to user (Send button handled).
     ************************************************************************/
    public void sendMessage(View view){
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText)findViewById(R.id.editText);
        String message = editText.getText().toString();
        if (!message.isEmpty())
        {
            intent.putExtra(EXTRA_MESSAGE, message);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(this, "To display your message, please enter some text...", Toast.LENGTH_SHORT).show();
        }
    }
}
