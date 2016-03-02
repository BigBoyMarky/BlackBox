package blackbox.blackbox;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    boolean isSettingsOpen = false; // flag to toggle the settings menu

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("Creating main activity");

        // settings menu
        FloatingActionButton settingsFAB = (FloatingActionButton) findViewById(R.id.settingsFAB);
        settingsFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("settingsFAB is clicked");
                // settings is open so need to close it
                if (isSettingsOpen) {
                    View settingsQuitView = findViewById(R.id.settingsQuit);
                    RelativeLayout.MarginLayoutParams params = (RelativeLayout.MarginLayoutParams) settingsQuitView.getLayoutParams();
                    params.setMargins(0, 0, 0, 0);
                    v.requestLayout();
                    isSettingsOpen = !isSettingsOpen;
                    //System.out.println("isSettingsOpen");
                }
                // settings is closed so need to open it
                else {
                    View settingsQuitView = findViewById(R.id.settingsQuit);
                    RelativeLayout.MarginLayoutParams params = (RelativeLayout.MarginLayoutParams) settingsQuitView.getLayoutParams();
                    params.setMargins(0, 0, 230, 0);
                    v.requestLayout();
                    isSettingsOpen = !isSettingsOpen;
                    //System.out.println("!isSettingsOpen");
                }
            }
        });

        // quit button within settings menu
        FloatingActionButton settingsQuit = (FloatingActionButton) findViewById(R.id.settingsQuit);
        settingsQuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Quitting application");
                finish();
            }
        });
    }
}
