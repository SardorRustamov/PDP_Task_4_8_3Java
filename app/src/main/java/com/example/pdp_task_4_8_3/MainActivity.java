package com.example.pdp_task_4_8_3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.pdp_task_4_8_3.fragment.ContactRvFragment;
import com.example.pdp_task_4_8_3.fragment.ContactViewFragment;
import com.example.pdp_task_4_8_3.model.ContactList;

public class MainActivity extends AppCompatActivity implements ContactRvFragment.FirstFragmentListener{
    private ContactRvFragment contactRvFragment;
    private ContactViewFragment contactViewFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }


    void initViews(){
        contactRvFragment = new ContactRvFragment();
        contactViewFragment = new ContactViewFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame_first, contactRvFragment)
                .replace(R.id.frame_second, contactViewFragment)
                .commit();
    }

    @Override
    public void onSendContact(ContactList contactList) {
        contactViewFragment.updateContactFragment(contactList);
    }
}