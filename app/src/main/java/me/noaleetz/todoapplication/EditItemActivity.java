package me.noaleetz.todoapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import static me.noaleetz.todoapplication.MainActivity.ITEM_POSITION;
import static me.noaleetz.todoapplication.MainActivity.ITEM_TEXT;

public class EditItemActivity extends AppCompatActivity {

    EditText etItemText;
    int position;

    public void onSaveItem(View v) {
        Intent data = new Intent();
        data.putExtra(ITEM_TEXT, etItemText.getText().toString());
        data.putExtra(ITEM_POSITION, position); // ints work too
        setResult(RESULT_OK, data); // set result code and bundle data for response
        finish();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        etItemText = (EditText) findViewById(R.id.etItemText);
        etItemText.setText(getIntent().getStringExtra(ITEM_TEXT));
        position = getIntent().getIntExtra(ITEM_POSITION, 0);
        getSupportActionBar().setTitle("Edit Item");
    }
}